import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class CartServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
	out.println("<title>Smart Portables</title>");
	out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
  out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");

	out.println("</head>");
	out.println("<body>");
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	if(fname!=null)
			{
				out.println("<h3 align='right' color:'black'>Hello  "+fname+"</h3>");
				out.println("<div align='right'>");
				out.println("<a href='SignOut'>Sign out</a>");
				out.println("</div>");
			}
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Watches</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=ExternalStorage'>ExternalStorage</a></li>");
	
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	}
	
	
	out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");
	
	double totalamount=0;
	System.out.println(Cart.cartlist.size());
	if(Cart.cartlist.size()!=0)
	{
		
		out.println("<table style='width:75%'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Price</th>");
		out.println("<th>Edit</th>");
		out.println("</tr>");
		for(Object objincart: Cart.cartlist)
		{
			 
			out.println("<tr>");
			if(objincart instanceof Product)
			{
				totalamount=totalamount;
				out.println("<td>"+((Product)objincart).getName()+"</td>");
				out.println("<td>");
				out.println("<form id='removefromcart' action='RemoveFromCartServlet'>");
				out.println("<input type='hidden' name='object' value="+objincart+"></input>");
				out.println("<button type='submit' name='button'>Remove</button>");
				out.println("</form>");
				out.println("</td>");
				
			}
			else if(objincart instanceof Accessory)
			{
				totalamount=totalamount;
				out.println("<td>"+((Accessory)objincart).getName()+"</td>");
				out.println("<td>");
				out.println("<form id='removefromcart' action='RemoveFromCartServlet'>");
				out.println("<input type='hidden' name='object' value="+objincart+"></input>");
				out.println("<button type='submit' name='button'>Remove</button>");
				out.println("</form>");
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("<td colspan='3'>Total: $ "+totalamount+"</td>");
		out.println("</table>");
		out.println("<form id='checkout' action='CheckoutServlet'>");
		out.println("<button type='submit' name='button'>Checkout</button>");
		out.println("</form>");
	}
	Object lastincart = null;
	for(int i=Cart.cartlist.size()-1;i>=0;i--)
	{
		
		if(Cart.cartlist.get(i) instanceof Product)
		{
			if(((Product)Cart.cartlist.get(i)).getAccessories().size()!=0)
			{
				lastincart= Cart.cartlist.get(i);
				break;
			}
			
		}
	}
     
	
    if(lastincart!=null) 
    {
    	ArrayList<Accessory> acclist = ((Product)lastincart).getAccessories();
		if(acclist.size()!=0)
			out.println("<h2>Accessories</h2>");
		
		
		if(acclist.size()!=0){
		out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
		 
			out.println("<ol class='carousel-indicators'>");
			out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
			out.println("</ol>");
			
		out.println("<div class='carousel-inner'>");
			
			out.println("<div class='item active'>");
			out.println("<img src =images/"+acclist.get(0).getImage()+" width='20%' height='20%' align='center'>");
			out.println("<h5 align='center'> Name: "+acclist.get(0).getName()+"</h5>");
			out.println("<h5 align='center'> Price: $"+acclist.get(0).getPrice()+"</h5>");
			out.println("<form id='accaddtocart' action='AddToCartServlet'>");
			out.println("<input type='hidden' name='pagename' value='cartservlet'></input>");
			out.println("<p align='center'>");
			out.println("<button type='submit' name='button' value="+acclist.get(0)+" >Add to cart</button>");
			out.println("</p>");
			out.println("</form>");
			out.println("</div>");
			
			
			for(int i=1;i<acclist.size();i++)
			{
				out.println("<div class='item'>");
				out.println("<img src =images/"+acclist.get(i).getImage()+" width='20%' height='20%' align='center'>");
				out.println("<h5 align='center'> Name: "+acclist.get(i).getName()+"</h5>");
				out.println("<h5 align='center'> Price: $"+acclist.get(i).getPrice()+"</h5>");
				out.println("<form id='accaddtocart' action='AddToCartServlet'>");
				out.println("<input type='hidden' name='pagename' value='cartservlet'></input>");
				out.println("<p align='center'>");
				out.println("<button type='submit' name='button' value="+acclist.get(i)+" >Add to cart</button>");
				out.println("</p>");
				out.println("</form>");
				out.println("</div>");
			}
			
		out.println("</div>");	
		
		out.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
		out.println("<span class='glyphicon glyphicon-chevron-left'></span>");
		out.println("<span class='sr-only'>Previous</span>");
		out.println("</a>");
		out.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
		out.println("<span class='glyphicon glyphicon-chevron-right'></span>");
		out.println("<span class='sr-only'>Next</span>");
		out.println("</a>");
		out.println("</div>");
		}
    }
	

	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Phones</a></li>");
	out.println("<li><a href='ProductServlet'>Laptop</a></li>");
	out.println("<li><a href='ProductServlet'>External Storage</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");	
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Smart Portables - Enterprise Web Application </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
			
	out.println("</body>");
	out.println("</html>");
			
	 }
	 
	 
	 public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
   
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
	out.println("<title>Smart Portables</title>");
	out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
  out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");

	out.println("</head>");
	out.println("<body>");
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	if(fname!=null)
			{
				out.println("<h3 align='right' color:'black'>Hello  "+fname+"</h3>");
				out.println("<div align='right'>");
				out.println("<a href='SignOut'>Sign out</a>");
				out.println("</div>");
			}
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Watches</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=ExternalStorage'>ExternalStorage</a></li>");
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	}

	
	out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");

	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Phones</a></li>");
	out.println("<li><a href='ProductServlet'>Laptop</a></li>");
	out.println("<li><a href='ProductServlet'>External Storage</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");	
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Smart Portables - Enterprise Web Application </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
			
	out.println("</body>");
	out.println("</html>");

	
		
  }
}

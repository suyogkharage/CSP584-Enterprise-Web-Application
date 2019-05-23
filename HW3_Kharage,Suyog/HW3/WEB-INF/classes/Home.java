import java.io.*; 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/Home")


public class Home extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  {
		  
	SmartPortablesSerializedDataStore obj1=new SmartPortablesSerializedDataStore();
	obj1.populateSerializedDataStore();
    PrintWriter out = response.getWriter();
	
    response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	
	String customertype = "Customer";
	String managertype = "StoreManager";
	
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

if(fname == null) 
{
	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li  class=''><a href='Trending'>Trending</a></li>");
	out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
}
else {
	if(type.equals(customertype)) 
	{
		out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
		out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
		out.println("<li  class=''><a href='Trending'>Trending</a></li>");
		out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
		
		out.println("<div align='right'>");
		out.println("<form action='Viewcart'>");
		out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
		out.println("</form>");
		out.println("</div>");	
	}
	
	if(type.equals(managertype))
	{
		out.println("<li class=''><a href='addProductToDB'>Add Product</a></li>");
		out.println("<li class=''><a href=''>Update Product</a></li>");
		out.println("<li class=''><a href=''>Delete Product</a></li>");
		out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
		out.println("<li class=''><a href='SalesReport'>Sales Report</a></li>");
	}
}



	out.println("</ul>");
	out.println("</nav>");

	
	
	out.println("<div align='center'>");
	out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
  
	out.println("<ol class='carousel-indicators'>");
    out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='3'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='4'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='5'></li>");
	out.println("</ol>");

  
	out.println("<div class='carousel-inner'>");
    out.println("<div class='item active'>");
      out.println("<img src='images/5.jpg' width = '45%' height = '30%' alt='Smart Portables'>");
    out.println("</div>");

    out.println("<div class='item'>");
      out.println("<img src='images/2.jpg' width = '45%' height = '30%' alt='Lappy'>");
	 out.println("</div>");

   out.println("<div class='item'>");
      out.println("<img src='images/4.jpg' width = '45%' height = '30%' alt='Main speaker'>");
	     out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/iphone8.jpg' width = '45%' height = '30%' alt='Main Watch'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/headphone.jfif' width = '45%' height = '30%' alt='Mobile5'>");
    out.println("</div>");
	
	out.println("<div class='item'>");
      out.println("<img src='images/MainExternalStorage.png' width = '45%' height = '30%' alt='Main External Storage'>");
    out.println("</div>");
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
//out.println("</div>");//

	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offers variety of Smart Accessories and Supplements</p>");
	out.println("<p>Shop at the best market rate</p>");
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Smart Accessoris Available</h2>");
	out.println("<p>Waterproof Case</p>");
	out.println("<p>Mobiles Covers</p>");
	out.println("<p>Laptops bags</p>");
	out.println("<p>Speakers stands</p>");
	out.println("<p>Earphones cover</p>");
	out.println("<h2>Laptops Available</h2>");
	out.println("<p>HP Pavilion</p>");
	out.println("<p>Apple Macbook Pro</p>");
	out.println("<p>Dell Inspiration</p>");
	out.println("</article>");
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=Pettrackers'>Pet Tracker</a></li>");
	out.println("<li><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");
	out.println("<li><a href='ProductServlet?param1=FitnessWatches'>Fitness Watches</a></li>");
	out.println("<li><a href='Trending'>Trending</a></li>");
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
		  PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
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
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	if(fname == null) {
		out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
		out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
		out.println("<li  class=''><a href='Trending'>Trending</a></li>");
		out.println("<li class=''><a href='Register'>Register</a></li>");
		out.println("<li class='' ><a href='Login'>Login</a></li>");

	}
	else 
	{
		if(type=="Customer")
		{
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
			out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
		}
		if(type=="StoreManager") 
		{
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Add Product</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Update Product</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Delete Product</a></li>");			
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
	
		}
	}
		
	
	
	if(type!="StoreManager")
	{
		out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
	}
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");
	
	out.println("<div align='center'>");
	out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
  
	out.println("<ol class='carousel-indicators'>");
    out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='3'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='4'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='5'></li>");
	out.println("</ol>");

  
	out.println("<div class='carousel-inner'>");
    out.println("<div class='item active'>");
      out.println("<img src='images/Mainicon.png' width = '45%' height = '30%' alt='Smart Portables'>");
    out.println("</div>");

    out.println("<div class='item'>");
      out.println("<img src='images/Lappy2.png' width = '45%' height = '30%' alt='Lappy'>");
    out.println("</div>");

   out.println("<div class='item'>");
      out.println("<img src='images/Speaker4.png' width = '45%' height = '30%' alt='Main speaker'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/Mainwatch.png' width = '45%' height = '30%' alt='Main Watch'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/Mobile5.png' width = '45%' height = '30%' alt='Mobile5'>");
    out.println("</div>");
	
	out.println("<div class='item'>");
      out.println("<img src='images/MainExternalStorage.png' width = '45%' height = '30%' alt='Main External Storage'>");
    out.println("</div>");
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


	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offers variety of Smart Accessories and Supplements</p>");
	out.println("<p>Shop at the best market rate</p>");
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Smart Accessoris Available</h2>");
	out.println("<p>Waterproof Case</p>");
	out.println("<p>Mobiles Covers</p>");
	out.println("<p>Laptops bags</p>");
	out.println("<p>Speakers stands</p>");
	out.println("<p>Earphones cover</p>");
	out.println("<h2>Laptops Available</h2>");
	out.println("<p>HP pavilion</p>");
	out.println("<p>Apple Macbook Pro</p>");
	out.println("<p>Dell Inspiration</p>");
	out.println("</article>");
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=Pettrackers'>Pet Tracker</a></li>");
	out.println("<li><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");
	out.println("<li><a href='ProductServlet?param1=Fitnessatches'>Fitness Watches</a></li>");
	out.println("<li><a href='Trending'>Trending</a></li>");
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
	
	
	
	
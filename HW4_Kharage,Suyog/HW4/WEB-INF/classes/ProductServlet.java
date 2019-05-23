import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ProductServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    HttpSession session = request.getSession();
    
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	
	String customertype = "Customer";
	String managertype = "StoreManager";
	
	
    out.println("<html>");
	out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
		out.println("<title>Smart Portables</title>");
		out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
		out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'> ");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		out.println("<script src='script.js'></script>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='container'>");
		out.println("<header>");
		
		out.println("<body onload='init()'>");
		out.println("<script type='text/javascript' src='javascript.js'></script>");
		out.println("<div name='autofillform' align='left'>");
		out.println("<h4>Search Product</h4>");
		out.println("<input type='text' name='searchId' value='' class='searchform' id='searchId' onkeyup='doCompletion()' placeholder='search here..' style='padding:5px;font-size:16px;' />");
		out.println("<div id='auto-row'>");			
		out.println("<table id='complete-table' style='position:absolute;width:315px;background-color:black'></table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		
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
			
	
			out.println("<div id='body'>");

			out.println("<section id='content'>");
			
			out.println("<table class='table table-bordered'>");
			out.println("<tr>");
			
			SmartPortablesSerializedDataStore obj1=(SmartPortablesSerializedDataStore) request.getAttribute("obj1");
			String product_type=request.getParameter("param1");

			HashMap<String,Product> map = new HashMap<String,Product>();
			
			if(product_type.equalsIgnoreCase("Watches")){
				map=obj1.Hm_Watches;
				out.println("<h1> WATCHES </h1>");
			}
			else if(product_type.equalsIgnoreCase("Mobiles")){
				map=obj1.Hm_Mobiles;
				out.println("<h1> MOBILES </h1>");
			}
			else if(product_type.equalsIgnoreCase("Laptops")){
				map=obj1.Hm_Laptops;
				out.println("<h1> LAPTOPS </h1>");
			}
			else if(product_type.equalsIgnoreCase("Speakers")){
				map=obj1.Hm_Speakers;
				out.println("<h1> SPEAKERS </h1>");
			}
			else if(product_type.equalsIgnoreCase("Earphones")){
				map=obj1.Hm_Earphones;
				out.println("<h1> EARPHONES </h1>");
			}
			else if(product_type.equalsIgnoreCase("Pettrackers")){
				map=obj1.Hm_Pettrackers;
				out.println("<h1> Pet Trackers </h1>");
			}
			else if(product_type.equalsIgnoreCase("VirtualReality")){
				map=obj1.Hm_VirtualReality;
				out.println("<h1> Virtual Reality </h1>");
			}
			else if(product_type.equalsIgnoreCase("FitnessWatches")){
				map=obj1.Hm_Fitnesswatches;
				out.println("<h1> Fitness Watches </h1>");
			}

				
			List<Product> list = null;
				
			try {
				list = MySqlDataStoreUtilities.getInventoryTable();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			for(int i=0;i<list.size();i++) 
			{
				if(product_type.equalsIgnoreCase(list.get(i).getCategory())) 
				{
					out.println("<div id='container'>");
					out.println("<h5> Name: "+list.get(i).getName()+"</h5>");
					out.println("<img src =images/"+list.get(i).getImage()+" width='25%' height='25%'>");
					out.println("<h5> Price: "+list.get(i).getPrice()+"</h5>");
					out.println("<h5> Retailer: "+list.get(i).getRetailer()+"</h5>");
					
					out.println("<form id='addtocart' method='get' action='Addtocart'>");
					out.println("<input class = 'submit-button' type = 'submit' value = 'Add to Cart' style='background-color:transparent'>");
					out.println("<input type='hidden' name='name' value='"+list.get(i).getName()+"'>");
					out.println("<input type='hidden' name='price' value='"+list.get(i).getPrice()+"'>");
					out.println("</form>");
					
					out.println("<form id='WriteReview' method='get' action='WriteReview'>");
					out.println("<input class = 'submit-button' type = 'submit' value = 'Write Review' style='background-color:transparent'>");
					out.println("<input type='hidden' name='name' value='"+list.get(i).getName()+"'>");
					out.println("<input type='hidden' name='price' value='"+list.get(i).getPrice()+"'>");
					out.println("<input type='hidden' name='retailer' value='"+list.get(i).getRetailer()+"'>");
					out.println("<input type='hidden' name='producttype' value='"+product_type+"'>");
					out.println("</form>");
					
					out.println("<form id='ViewReview' method='post' action='ViewReview'>");
					out.println("<input class = 'submit-button' type = 'submit' value = 'View Review' style='background-color:transparent'>");
					out.println("<input type='hidden' name='name' value='"+list.get(i).getName()+"'>");
					out.println("</form>");

					for(String key:map.keySet())
					{
						if(map.get(key).getName().equals(list.get(i).getName())) {
							ArrayList<Accessory> acclist = map.get(key).getAccessories();
							if(acclist.size()!=0)
								out.println("<h2>Accessories</h2>");
							if(acclist.size()!=0){
							out.println("<div align='center'>");
							out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
							 
								out.println("<ol class='carousel-indicators'>");
								out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
								out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
								out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
								out.println("</ol>");
								
							out.println("<div class='carousel-inner'>");
								
							out.println("<div class='item active'>");
							out.println("<img src =images/"+acclist.get(0).getImage()+" width='30%' height='30%'>");
							out.println("<form id='addtocart' method='get' action='Addtocart'>");
							out.println("<div class='carousel-caption'>");
	   			            out.println("<input class = 'submit-button' type='submit' value='AddToCart' style='background-color:black'/>");
	   			            out.println("<input type='hidden' name='name' value='"+acclist.get(0).getName()+"'>");
	 					    out.println("<input type='hidden' name='price' value='"+acclist.get(0).getPrice()+"'>");
	   			            out.println("</div>");
				            out.println("</form>");
						    out.println("</div>");
								
								
							for(int j=1;j<acclist.size();j++)
							{
								out.println("<div class='item'>");
								out.println("<img src =images/"+acclist.get(j).getImage()+" width='30%' height='30%'>");
								out.println("<form id='addtocart' method='get' action='Addtocart'>");
								out.println("<div class='carousel-caption'>");
		   			            out.println("<input class = 'submit-button' type='submit' value='AddToCart' style='background-color:black'/>");
		   			            out.println("<input type='hidden' name='name' value='"+acclist.get(j).getName()+"'>");
		 					    out.println("<input type='hidden' name='price' value='"+acclist.get(j).getPrice()+"'>");
		 					    out.println("</div>");
								out.println("</div>");
							}
								
							out.println("</div>");	
							
							out.println("</div>");
							out.println("</div>");
							}//end if
							
							
							out.println("</div>");

						}
					}	// end hash map for

				}
			} // end mysql for


			
			out.println("</tr>");
			out.println("</table>");	
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
			out.println("</ul></li></ul>");
			out.println("</aside>");
			

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
	 
	 
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		  
   
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
	
	
    out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			out.println("<title>Smart Portables</title>");
			out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
			
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'> ");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
			out.println("<script src='script.js'></script>");
			
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
			out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");

			
				HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	}
	else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='Logout'>Logout</a></li>");
	}

	
	out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</ul>");
	out.println("</nav>");
	out.println("</div>");
			
	
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	
	SmartPortablesSerializedDataStore obj1=(SmartPortablesSerializedDataStore) request.getAttribute("obj1");
	String product_type=request.getParameter("param1");

	HashMap<String,Product> map = new HashMap<String,Product>();
	
	if(product_type.equalsIgnoreCase("Watches")){
		map=obj1.Hm_Watches;
		out.println("<h1> WATCHES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Mobiles")){
		map=obj1.Hm_Mobiles;
		out.println("<h1> MOBILES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Laptops")){
		map=obj1.Hm_Laptops;
		out.println("<h1> LAPTOPS </h1>");
	}
	else if(product_type.equalsIgnoreCase("Speakers")){
		map=obj1.Hm_Speakers;
		out.println("<h1> SPEAKERS </h1>");
	}
	else if(product_type.equalsIgnoreCase("Earphones")){
		map=obj1.Hm_Earphones;
		out.println("<h1> EARPHONES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Pettrackers")){
		map=obj1.Hm_Pettrackers;
		out.println("<h1> Pet trackers </h1>");
	}
	else if(product_type.equalsIgnoreCase("VirtualReality")){
		map=obj1.Hm_VirtualReality;
		out.println("<h1> Virtual Reality </h1>");
	}
	else if(product_type.equalsIgnoreCase("FitnessWatches")){
		map=obj1.Hm_Fitnesswatches;
		out.println("<h1> Fitness Watches </h1>");
	}
	
	for(String key:map.keySet())
	{	
		out.println("<div id='container'>");
		out.println("<h5> Name: "+map.get(key).getName()+"</h5>");
		out.println("<img src =images/"+map.get(key).getImage()+" width='25%' height='25%'>");
		out.println("<h5> Price: "+map.get(key).getPrice()+"</h5>");
		out.println("<h5> Retailer: "+map.get(key).getRetailer()+"</h5>");
		
		out.println("<button onclick=AddToCart("+map.get(key)+")>Add to cart</button>");
		
	ArrayList<Accessory> acclist = map.get(key).getAccessories();
		if(acclist.size()!=0)
			out.println("<h2>Accessories</h2>");

		if(acclist.size()!=0){
		out.println("<div align='center'>");
		out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
		 
			out.println("<ol class='carousel-indicators'>");
			out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
			out.println("</ol>");
			
		out.println("<div class='carousel-inner'>");
			
			out.println("<div class='item active'>");
			out.println("<img src =images/"+acclist.get(0).getImage()+" width='30%' height='30%'>");
			out.println("<div class='carousel-caption'>");
          out.println("<input type='button' value='AddToCart' button style='background-color:black'/>");
          out.println("</div>");
			out.println("</div>");
			
			
			for(int i=1;i<acclist.size();i++)
			{
				out.println("<div class='item'>");
				out.println("<img src =images/"+acclist.get(i).getImage()+" width='30%' height='30%'>");
				out.println("<div class='carousel-caption'>");
          
          out.println("<input type='button' value='AddToCart' button style='background-color:black'/>");
          out.println("</div>");
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
		out.println("</div>");
		}
		
		
		out.println("</div>");
	}
	
	
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
	out.println("<li><a href='ProductServlet?param1=Fitnesswatches'>Fitness Watches</a></li>");	out.println("</ul>");
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

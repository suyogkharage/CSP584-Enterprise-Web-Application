import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LookupProduct extends HttpServlet{
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
				out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
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
		
		Product p = null;
		String action=(String) request.getAttribute("action");
		String searchId =(String) request.getAttribute("searchId");
		
		try 
		{
			p = MySqlDataStoreUtilities.getSpecificProduct(searchId);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out.println("<div id='container'>");
		out.println("<h5> Name: "+p.getName()+"</h5>");
		out.println("<img src =images/"+p.getImage()+" width='25%' height='25%'>");
		out.println("<h5> Price: "+p.getPrice()+"</h5>");
		out.println("<h5> Retailer: "+p.getRetailer()+"</h5>");
		
		out.println("<form id='addtocart' method='get' action='Addtocart'>");
		out.println("<input class = 'submit-button' type = 'submit' value = 'Add to Cart' style='background-color:transparent'>");
		out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
		out.println("<input type='hidden' name='price' value='"+p.getPrice()+"'>");
		out.println("</form>");
		
		out.println("<form id='WriteReview' method='get' action='WriteReview'>");
		out.println("<input class = 'submit-button' type = 'submit' value = 'Write Review' style='background-color:transparent'>");
		out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
		out.println("<input type='hidden' name='price' value='"+p.getPrice()+"'>");
		out.println("<input type='hidden' name='retailer' value='"+p.getRetailer()+"'>");
		out.println("</form>");
		
		out.println("<form id='ViewReview' method='post' action='ViewReview'>");
		out.println("<input class = 'submit-button' type = 'submit' value = 'View Review' style='background-color:transparent'>");
		out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
		out.println("</form>");
		
		out.println("</section>");
		out.println("<aside class='sidebar'>");
		out.println("<ul>");	
		out.println("<li>");
		out.println("<h4>Products</h4>");
		out.println("<ul>");
		out.println("<li><a href='Watches'>Watches</a></li>");
		out.println("<li><a href='Mobiles'>Mobiles</a></li>");
		out.println("<li><a href='Laptops'>Laptops</a></li>");
		out.println("<li><a href='Speakers'>Speakers</a></li>");
		out.println("<li><a href='Earphones'>Earphones</a></li>");
		out.println("<li><a href='ExternalStorage'>External Storage</a></li>");
		out.println("<li><a href='Reviewsform'>Add Reviews</a></li>");
		
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

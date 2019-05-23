import java.io.IOException;
import java.io.PrintWriter;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class Trending extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html;charset=UTF-8");


			PrintWriter out = response.getWriter();
		       
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
				out.println("<li class=''><a href='updateProd'>Update Product</a></li>");
				out.println("<li class=''><a href='DeleteProd'>Delete Product</a></li>");
				out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
				out.println("<li class=''><a href='SalesReport'>Sales Report</a></li>");
			}
		}



			out.println("</ul>");
			out.println("</nav>");
			
			
			String productName=request.getParameter("name");		 
				
	        
	        out.println("<div id='content'><div class='post'><h2 class='title meta'>");
			out.println("<a style='font-size: 24px;'></a>");
			out.println("</h2><div class='entry'>");
				
			ArrayList <String> mostsold = new ArrayList <String> ();
		    ArrayList <Integer> mostsoldzip = new ArrayList <Integer> ();
			ArrayList <Bestrating> bestrated = new ArrayList <Bestrating> ();
			
			
					
			bestrated = MongoDBDataStoreUtilities.topProducts();
			out.println("<a style='font-size: 24px;'>Best Products</a>");
			out.println("</h2><div class='entry'><table id='bestseller'>");
			Iterator itr2 = bestrated.iterator();
	        while(itr2.hasNext()) {
	         Bestrating best = (Bestrating)itr2.next();
	 		out.println("<tr>");
			out.println("<td>");
			out.println(best.getProductname());
			out.println("</td>");
			out.println("<td>");
			out.println(best.getRating());
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr><td></td><td></td></tr>");
	        }
			out.println("</table></div>");	
			
			
			mostsoldzip = MySqlDataStoreUtilities.mostsoldZip();
			out.print("<a style='font-size: 24px;'>Top Five Zipcode</a>");
			out.print("</h2><div class='entry'><table id='bestseller'>");
			
			for(int i=0; i<mostsoldzip.size();i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(mostsoldzip.get(i));
				out.println("</td>");
				out.println("</tr>");
				
				out.println("<tr><td></td></tr>");
			}
			out.print("</table></div>");	
			

			mostsold = MySqlDataStoreUtilities.mostsoldProducts();
			out.print("<a style='font-size: 24px;'>Top Five Most Sold Products</a>");
			out.print("</h2><div class='entry'><table id='bestseller'>");
			
			for(int i=0; i<mostsold.size();i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(mostsold.get(i));
				out.println("</td>");
				out.println("</tr>");
				
				out.println("<tr><td></td></tr>");
			}
			out.print("</table></div></div></div>");	
			
			
			out.println("</div></div></div>");		
		                     	
	      }
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}

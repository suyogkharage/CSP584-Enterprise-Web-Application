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

public class ViewReview extends HttpServlet{
		
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		HashMap<String, ArrayList<Review>> hm= MongoDBDataStoreUtilities.selectReview();
		
		String userName = "";
		String reviewRating = "";
		String reviewText = "";	
		String price = "";
		
			
        
        out.println("<br><div id='content'><div class='post'><h2 class='title meta'>");
		out.println("<a style='font-size: 24px;'>Review</a>");
		out.println("</h2><div class='entry'>");
			
			//if there are no reviews for product print no review else iterate over all the reviews using cursor and print the reviews in a table
		if(hm==null)
		{
		out.println("<h2>Mongo Db server is not up and running</h2>");
		}
		else
		{
                if(!hm.containsKey(productName)){
				out.println("<h2>There are no reviews for this product.</h2>");
			}else{
		for (Review r : hm.get(productName)) 
				 {		
		out.println("<table class='gridtable' style='border-color:black'>");
				out.println("<tr>");
				out.println("<td> Product Name: </td>");
				productName = r.getProductName();
				out.println("<td>" +productName+ "</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td> userName: </td>");
				userName = r.getUserName();
				out.println("<td>" +userName+ "</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td> price: </td>");
				price = r.getPrice();
				out.println("<td>" +price+ "</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td> Review Rating: </td>");
				reviewRating = r.getReviewRating().toString();
				out.println("<td>" +reviewRating+ "</td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<td> Review Text: </td>");
				reviewText = r.getReviewText();
				out.println("<td>" +reviewText+ "</td>");
				out.println("</tr>");
				
				out.println("<tr><td>");
				out.println("</td></tr>");
				
				out.println("</table>");
				}					
							
		}
		}	       
                out.println("</div></div></div>");		
	                     	
                    }
     	
       

	
	
}

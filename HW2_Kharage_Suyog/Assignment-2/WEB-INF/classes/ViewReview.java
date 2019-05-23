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
			
			out.println("<h1><a href='Home'>SMART PORTABLES</a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
			out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
			out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
			out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
			out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
			
			
				HttpSession session = request.getSession();
				String fname1=(String)session.getAttribute("fname");
	
	if (fname1 == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	
	}
	  else if (fname1.equals("StoreManager")){
		  out.println("<li class=''><a href='Register'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+fname1+"</a></li>");
		  
		  
	  } else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname1+"</a></li>");
		out.println("<li class='' ><a href='SignOut'>Sign Out</a></li>");
	}

	
	out.println("<li class='' ><a href='ViewOrders'>View Orders</a></li>");
			
			out.println("<div align='right'>");
			out.println("<form action='ViewCart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			out.println("</div>");
		
		String productName=request.getParameter("name");		 
		HashMap<String, ArrayList<Review>> hm= MongoDBDataStoreUtilities.selectReview();
		
		String userName = "";
		String reviewRating = "";
		String reviewText = "";	
		String price = "";
		
			
        
        out.println("<div id='content'><div class='post'><h2 class='title meta'>");
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

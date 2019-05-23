import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SubmitReview extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
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
        
        
        
        String userName = (String)session.getAttribute("fname");
        
        String productname=request.getParameter("productname");		
       	String productprice=request.getParameter("productprice");
       	String productType=request.getParameter("producttype");
        String productmaker=request.getParameter("productmaker");
        String reviewrating=request.getParameter("reviewrating");
        String reviewtext=request.getParameter("reviewtext");
        
        String message= MongoDBDataStoreUtilities.insertReview(productname,productType,userName,productmaker,reviewrating,reviewtext,productprice);
		
        out.println("<div id='content'><div class='post'><h2 class='title meta'>");
		out.println("<a style='font-size: 24px;'>Review</a>");
		out.println("</h2><div class='entry'>");
		
		out.println("<h2>Review for " +productname+ "stored</h2>");
	}
	
}

import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.*;





public class WriteReview extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	out.println("<title>Smart Portables</title>");
	out.println("<link rel='shortcut icon' href='cart/Cart.png'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li  class='start selected'><a href='Home'>Home</a></li>");
	out.println("<li class=''><a href='Watches'>Smart Watches</a></li>");
	out.println("<li class=''><a href='Mobiles'>Mobiles</a></li>");
	out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='Speakers'>Speakers</a></li>");
	out.println("<li class=''><a href='Earphones'>Earphones</a></li>");
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class=''><a href='Login'>Login</a></li>");
	out.println("</ul>");
	out.println("</nav>");
	out.println("</div>");
	
	HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");
	
	
	if(fname==null) {
		out.println("<h2>You are not logged in. Please log-in first</h2>");
	}
	else {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String retailer = request.getParameter("retailer");
		String productType = request.getParameter("producttype");
		
		out.println("<form name ='WriteReview' action='SubmitReview' method='post'>");
	    out.println("<div id='content'><div class='post'><h2 class='title meta'>");
		out.println("<a style='font-size: 24px;'>Review</a>");
		out.println("</h2><div class='entry'>");
	    out.println("<table class='gridtable'>");
		out.println("<tr><td> Product Name: </td><td>");
		
		out.println(name);
		out.println("<input type='hidden' name='productname' value='"+name+"'>");
		out.println("</td></tr>");
		
		out.println("<tr><td> Product type: </td><td>");
		out.println(productType);
		out.println("<input type='hidden' name='producttype' value='"+productType+"'>");
		out.println("</td></tr>");
			
		out.println("<tr><td> Product Price:</td><td>");
	    out.println(price);
	    out.println("<input type='hidden' name='productprice' value='"+price+"'>");
		out.println("</td></tr>");		
	    
		out.println("<tr><td> Product Maker: </td><td>");
	    out.println(retailer);
		out.println("<input type='hidden' name='productmaker' value='"+retailer+"'>");
	    out.println("</td></tr><table>");
		
		
	            out.println("<table><tr></tr><tr></tr><tr><td> Review Rating: </td>");
					out.println("<td>");
						out.println("<select name='reviewrating'>");
						out.println("<option value='1' selected>1</option>");
						out.println("<option value='2'>2</option>");
						out.println("<option value='3'>3</option>");
						out.println("<option value='4'>4</option>");
						out.println("<option value='5'>5</option>");  
					out.println("</td></tr>");

					out.println("<tr>");
					out.println("<td> Review Text: </td>");
					out.println("<td><textarea name='reviewtext' rows='4' cols='50'> </textarea></td></tr>");
				out.println("<tr><td colspan='2'><input type='submit' class='btnbuy' name='SubmitReview' value='SubmitReview'></td></tr></table>");

	            out.println("</div></div></form>");	
	}
		

	
	
		
	out.println("</body>");
	out.println("</html>");
	
	}
	
	
	}
	
	





	

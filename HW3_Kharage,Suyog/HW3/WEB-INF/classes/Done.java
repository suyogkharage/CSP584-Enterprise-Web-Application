import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Done extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
			out.println("<li><a href='addProductToDB'>Add Product</a></li>");
			out.println("<li><a href=''>Update Product</a></li>");
			out.println("<li><a href=''>Delete Product</a></li>");			
			out.println("<li><a href=''>Inventory</a></li>");
			out.println("<li><a href=''>Sales Report</a></li>");
			
			out.println("</ul>");
			out.println("</nav>");
			
			HttpSession session = request.getSession();
			String fname1=(String)session.getAttribute("fname");
	    
			
			out.println("<div id='content'><div class='post'><h2 class='title meta'>");
			out.println("<br><a style='font-size: 24px;'></a>");
			out.println("</h2><div class='entry'>");
			
			int code = (int) session.getAttribute("Code");
			if(code==1) {
				out.println("<h2>Product is out of stock.</h2>");
			}
			if(code==2) {
				out.println("<h2>Product Added.</h2>");
			}			
			out.println("</div></div></div>");	
			
					
	}
}

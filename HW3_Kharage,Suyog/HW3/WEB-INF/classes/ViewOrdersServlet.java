import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewOrdersServlet extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		   
		String fname=(String)session.getAttribute("fname");
		String type = (String)session.getAttribute("type");
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
			out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
			out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
			out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
			out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
			out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
			
			
				
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	
	}
	  else if (fname.equals("StoreManager")){
		  out.println("<li class=''><a href='Register'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		  
		  
	  } else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
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
			
			
			
			
            out.println("<div id='content'><div class='post'><h2 class='title meta'>");
			out.println("<a style='font-size: 24px;'>Orders</a>");
			out.println("</h2><div class='entry'>");
			
			int oid=0;
			String firstName="";
			String productname="";
			Double totalAmount=null;
			String orderDate="";
			String deliveryDate="";
			String address="";
			
			if(fname==null)
			{
			out.println("<h2>You are not logged in. Please Log-in.</h2>");
			}
			else
			{
				ArrayList<Orders> list = new ArrayList<Orders>();
				list = MySqlDataStoreUtilities.getOrderDetails(fname);	
				
				
				out.println("<a style='font-size: 24px;'></a>");
				out.println("</h2><div class='entry'><table id='bestseller'>");
				Iterator itr2 = list.iterator();
		        while(itr2.hasNext()) {
		        	Orders order = (Orders)itr2.next();
		 		out.println("<tr><td>");
				out.println("Order ID:");
				out.println("</td><td>");
				out.println(order.getoid());
				out.println("</td></tr>");
				
		 		out.println("<tr><td>");
				out.println("User Name:");
				out.println("</td><td>");
				out.println(fname);
				out.println("</td></tr>");
				
		 		out.println("<tr><td>");
				out.println("Product Name:");
				out.println("</td><td>");
				out.println(order.getProductName());
				out.println("</td></tr>");

		 		out.println("<tr><td>");
				out.println("Price:");
				out.println("</td><td>");
				out.println(order.getTotalamount());
				out.println("</td></tr>");
				
		 		out.println("<tr><td>");
				out.println("Order Date:");
				out.println("</td><td>");
				out.println(order.getOrderdate());
				out.println("</td></tr>");

		 		out.println("<tr><td>");
				out.println("Delivery Date:");
				out.println("</td><td>");
				out.println(order.getDeliverydate());
				out.println("</td></tr>");

		 		out.println("<tr><td>");
				out.println("Address:");
				out.println("</td><td>");
				out.println(order.getAddress());
				out.println("</td></tr>");
				
				out.println("<tr><td>");
				out.println("</td><td>");
				out.println("</td></tr>");
				
				

		        }
				
			}
				
				
				 out.println("</div></div></div>");	
	}
	
}
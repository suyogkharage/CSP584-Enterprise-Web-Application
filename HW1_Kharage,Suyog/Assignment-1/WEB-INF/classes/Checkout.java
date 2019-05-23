import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Checkout extends HttpServlet {
	
	
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
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
	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Watches</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");
	//HttpSession session = request.getSession();
	//String fname=(String)session.getAttribute("fname");
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	}
	/*else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='Logout'>Logout</a></li>");
	}*/

	
	out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");
	
	out.println("<table><tr></tr><tr></tr>");	
	out.print("<tr><td>");
 	out.print("Credit/accountNo</td>");
	out.print("<td><input type='text' name='creditCardNo'>");
	out.print("</td></tr>");
	out.print("<tr><td>");
    out.print("Customer Address</td>");
	out.print("<td><input type='text' name='userAddress'>");
    out.print("</td></tr>");
	out.print("<tr><td colspan='2'>");
	out.print("<a href='Checkout1'>Checkout</a>");
    out.print("</td></tr></table>");		
	}
	
}

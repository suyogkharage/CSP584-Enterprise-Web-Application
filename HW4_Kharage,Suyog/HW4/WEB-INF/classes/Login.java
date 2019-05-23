import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.*;





public class Login extends HttpServlet {
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
	
	
	
	
	out.println("<form action='ValidateUser'>");
	out.println("<table>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Customer Type :");
	out.println("<input type='radio' name='category' value='Customer' required/> Customer");
	out.println("<input type='radio' name='category' value='Retailer' required/> Retailer");
	out.println("<input type='radio' name='category' value='StoreManager' required/> Store Manager");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("User ID  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:");
	out.println("<input type='text' name='uid' required/></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Password &nbsp&nbsp:");
	out.println("<input type='password' name='password' required/></td>");
	out.println("</tr>");
	out.println("<tr><td ><input type='submit' value='Login'></td></tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	
	}
	
	
	}
	
	
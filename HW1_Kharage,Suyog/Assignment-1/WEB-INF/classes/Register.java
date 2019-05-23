import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;




public class Register extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	 PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	out.println("<title>Smart Portables</title>");
	out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li  class=''><a href='Home'>Home</a></li>");
	out.println("<li class=''><a href='Watches'>Watches</a></li>");
	out.println("<li class=''><a href='Mobiles'>Mobiles</a></li>");
	out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='Speakers'>Speakers</a></li>");
	out.println("<li class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li class=''><a href='External Storage'>External Storage</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	
	
	out.println("</ul>");
	out.println("</nav>");
	out.println("</div>");
	
	
	
	out.println("<h3>Please fill below form to Register for membership:</h3>");
	
	out.println("<form action='RegisterUserServlet'>");
	out.println("<table>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Customer Type :");
	out.println("<input type='radio' name='type' value='Customer' required/> Customer");
	out.println("<input type='radio' name='type' value='Retailer' required/> Retailer");
	out.println("<input type='radio' name='type' value='StoreManager' required/> Store Manager");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("First Name :");
	out.println("<input type='text' placeholder ='First name'  name='fname' required/></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Last Name  :");
	out.println("<input type='text' placeholder='Last name'  name='lname' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("User ID  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:");
	out.println("<input type='text' name='uid' required/></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Email Id &nbsp&nbsp&nbsp&nbsp&nbsp :");
	out.println("<input type='text' name='emailid' required/></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Password &nbsp&nbsp:");
	out.println("<input type='password' name='password' required/></td>");
	out.println("</tr>");
	out.println("<tr><td ><input type='submit' value='Register'></td></tr>");
	out.println("</table>");
	out.println("</form>");
	
	out.println("</body>");
	out.println("</html>");
	
	
}
}

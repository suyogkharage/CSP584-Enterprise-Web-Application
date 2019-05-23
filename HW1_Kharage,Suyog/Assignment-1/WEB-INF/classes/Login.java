import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;





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
	out.println("<li class=''><a href='Watches'>Watches</a></li>");
	out.println("<li class=''><a href='Mobiles'>Mobiles</a></li>");
	out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='Speakers'>Speakers</a></li>");
	out.println("<li class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li class=''><a href='VirtualReality'>Virtual Reality</a></li>");
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class=''><a href='Login'>Login</a></li>");
	out.println("</ul>");
	out.println("</nav>");
	out.println("</div>");
	
	
	/*out.println("<div style='float:center;'><form action='ValidateUser'>");
	out.println("<lable>User Type</lable>");
	out.println("<label class='radio-inline'>");
	out.println("<input type='radio' name='optradio' value='Customer' checked>Customer</label>");
	
	out.println("<label class='radio-inline'>");
	out.println("<input type='radio' name='optradio' value='Retailer'>Retailer</label>");
  
	out.println("<label class='radio-inline'>");
	out.println("<input type='radio' name='optradio' value='StoreManager'>StoreManager</label>");


	out.println("<div class='form-group'>");
	out.println("<label for='text'>User ID</label>");
    out.println("<input type='text' class='form-control' id='text' placeholder='Enter User ID' name='uid'>");  
    out.println("</div>");
    
    out.println("<div class='form-group'>");
	out.println("<label for='pwd'>Password:</label>");
    out.println("<input type='password' class='form-control' id='pwd' placeholder='Enter Password' name='password'>");  
    out.println("</div>");
    
    out.println("<button type='submit' value='Login' class='btn btn-default'>Login</button></form></div>");
   */
    
	out.println("<form action='ValidateUser'>");
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
	
	out.println("</body>");
	out.println("</html>");
	
	}
	
	
	}
	
	
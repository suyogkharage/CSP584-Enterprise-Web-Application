import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;
//mayur



public class Credentials extends HttpServlet {
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
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li  class=''><a href='Home'>Home</a></li>");
	out.println("<li class=''><a href='Watches'>Smart Watches</a></li>");
	out.println("<li class=''><a href='Mobiles'>Mobiles</a></li>");
	out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='Speakers'>Speakers</a></li>");
	out.println("<li class=''><a href='Earphones'>Earphones</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	
	
	out.println("</ul>");
	out.println("</nav>");
	out.println("</div>");
	
	HttpSession session = request.getSession();
	Cart ekart;
	ekart = (Cart) session.getAttribute("cart");
	HashMap<String, Integer> items = ekart.getCartItems();
		
	
	
	out.println("<h3>Fill the credentials:</h3>");
	
	out.println("<form action='Checkout'>");//checkout
	
	for(Map.Entry<String, Integer> entry : items.entrySet()) {
		Integer values = entry.getValue();
		String key = entry.getKey();
		out.println("<input type='hidden' name='price' value='"+values+"'/>");
	}
	Double total = Double.parseDouble(request.getParameter("total"));
	out.println("<table>");
	out.println("<tr>");
	out.println("<td>");
	out.println("First Name :");
	out.println("<input type='text' placeholder ='First name'  name='firstname' required/><input type='hidden' name='total' value='"+total+"'/>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Address  :");
	out.println("<input type='text' placeholder='address'  name='address' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Zipcode  :");
	out.println("<input type='text' placeholder='Zipcode'  name='zipcode' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Credit card number  :");
	out.println("<input type='text' placeholder='credit card number'  name='credit card number' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Email Id &nbsp&nbsp&nbsp&nbsp&nbsp :");
	out.println("<input type='text' name='email' required/></td>");
	out.println("</tr>");
	
	out.println("<tr><td ><input type='submit' value='Submit'></td></tr>");
	out.println("</table>");
	out.println("</form>");
	
	out.println("</body>");
	out.println("</html>");
	
	
}
}

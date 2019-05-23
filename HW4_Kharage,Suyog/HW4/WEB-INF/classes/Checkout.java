import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Login</a></li>");
	}
	

	
	out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");
	
	
	String s="";
	Random r = new Random();
	int Low = 1;
	int High = 622653;
	int R = r.nextInt(High-Low) + Low;
	String order = "A#"+R;
	Calendar cal = Calendar.getInstance();
	Date oDate = cal.getTime();
	cal.add(Calendar.DAY_OF_MONTH, 14);
	Date date = cal.getTime();
	String DATE_FORMAT = "MM/dd/yyyy"; 
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);				
	String deliverydate = sdf.format(date);
	String orderDate = sdf.format(oDate);
	
	Long cardNumber = Long.parseLong(request.getParameter("credit card number"));
	String firstName = request.getParameter("firstname");
    String address = request.getParameter("address");  
    int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	Double total = Double.parseDouble(request.getParameter("total"));
	int currentCount = (int) session.getAttribute("currentCount");
	
	Cart ekart;
        ekart = (Cart) session.getAttribute("cart");
		HashMap<String, Integer> items = ekart.getCartItems();
		String userid=(String)session.getAttribute("userid");
		//int size=0;
		
		for(Map.Entry<String, Integer> entry : items.entrySet()) {
			
			Integer values = entry.getValue();
			String key = entry.getKey();
			Random random = new Random();
			R = random.nextInt(High-Low) + Low;
			
			MySqlDataStoreUtilities.insertOrder(R,firstName,key,values,address,cardNumber,orderDate,deliverydate,zipcode);
			MySqlDataStoreUtilities.setproductCount(key,currentCount-1);
			
		}
		
		
		
	
				session.removeAttribute("cart");
				out.println("<h3><br><br>Your  Order  No "+order+" has been placed succesfully. The order will be delivered by " + deliverydate + " !!!</h3><br><br>");	
		
	}
	
}

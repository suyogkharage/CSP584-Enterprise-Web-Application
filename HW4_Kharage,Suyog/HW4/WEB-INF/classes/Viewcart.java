import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Map;



public class Viewcart extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
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
			
			
				HttpSession session = request.getSession();
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
			
			Cart ekart;
			ekart = (Cart) session.getAttribute("cart");
			int total=0;
			
			if(ekart==null )
				
				{
			out.println("<h1>Cart is Empty </h1>");
			out.println("<tr>");
			out.println("<td>");
			out.println("</td>");
			out.println("</tr>");
					
				}
					
else
{
        
                   
            HashMap<String, Integer> items = ekart.getCartItems();
			
						if(items.isEmpty())
						{
							
							out.println("<h1>Cart is Empty </h1>");
							out.println("<tr>");
							out.println("<td>");
							out.println("</td>");
							out.println("</tr>");
							
						}
			else
				{
            
			
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Items Currently in  cart </h1>");
            out.println("<hr>");
			out.println("<table  frame='box' rules='rows'>");
            out.println("<tr><td></td><td><h2>Products</h3></td><td><h2>Price&nbsp&nbsp&nbsp&nbsp</h2></td><td><h2>Quantity</h2></td><td></td></tr>");
           for(Map.Entry<String, Integer> entry : items.entrySet()){
		  
			String key = entry.getKey();
			
			
				int values = entry.getValue();
				
				out.println("<form action='Credentials'><input type='hidden' name='name' value='"+key+"'><input type='hidden' name='price' value='"+values+"'");//action='Checkout'
                out.println("<tr><td><img src ='images/"+key+".jpg' width = '100' height = '100'></td><td><h3>"+key+"</h3></td><td><h3>"+"$ "+values+"</h3></td>");
				out.println("<td><select name='"+key+"'><option value='1' selected>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td></tr>");
				
				total=total + values;
			}
				out.println("<tr><td><h3>Cart Total = $ "+total+"</h3></td></tr>");
				out.println("<tr><h2><td align='center' colspan='5'><input type='hidden' name='total' value='"+total+"'><input type='submit' name='action1' value='Checkout'></h2></td></tr></form>");				  
			
			
			
			
			
			out.println("</table>");
			out.println("</div>");
			
			
            out.println("</body>");
            out.println("</html>");
			

}
			
			
	 }
	  
	  }

}

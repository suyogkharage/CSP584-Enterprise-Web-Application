import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SubmitReview extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        PrintWriter out = response.getWriter();
	       
      
        
    	String fname=(String)session.getAttribute("fname");
    	String type = (String)session.getAttribute("type");
    	
    	String customertype = "Customer";
    	String managertype = "StoreManager";
    	
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

    if(fname == null) 
    {
    	out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
    	out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
    	out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
    	out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
    	out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
    	out.println("<li  class=''><a href='Trending'>Trending</a></li>");
    	out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
    	out.println("<li class=''><a href='Register'>Register</a></li>");
    	out.println("<li class='' ><a href='Login'>Login</a></li>");
    }
    else {
    	if(type.equals(customertype)) 
    	{
    		out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
    		out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
    		out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
    		out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
    		out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
    		out.println("<li  class=''><a href='Trending'>Trending</a></li>");
    		out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
    		
    		out.println("<div align='right'>");
    		out.println("<form action='Viewcart'>");
    		out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
    		out.println("</form>");
    		out.println("</div>");	
    	}
    	
    	if(type.equals(managertype))
    	{
    		out.println("<li class=''><a href='addProductToDB'>Add Product</a></li>");
    		out.println("<li class=''><a href='updateProd'>Update Product</a></li>");
    		out.println("<li class=''><a href='DeleteProd'>Delete Product</a></li>");
    		out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
    		out.println("<li class=''><a href='SalesReport'>Sales Report</a></li>");
    	}
    }



    	out.println("</ul>");
    	out.println("</nav>");

        
        
        String userName = (String)session.getAttribute("fname");
        
        String productname=request.getParameter("productname");		
       	String productprice=request.getParameter("productprice");
       	//String productType=request.getParameter("producttype");
        String productmaker=request.getParameter("productmaker");
        String reviewrating=request.getParameter("reviewrating");
        String reviewtext=request.getParameter("reviewtext");
        
        String message= MongoDBDataStoreUtilities.insertReview(productname,"",userName,productmaker,reviewrating,reviewtext,productprice);
		
        out.println("<div id='content'><div class='post'><h2 class='title meta'>");
		out.println("<a style='font-size: 24px;'>Review</a>");
		out.println("</h2><div class='entry'>");
		
		out.println("<h2>Review for " +productname+ " stored</h2>");
	}
	
}

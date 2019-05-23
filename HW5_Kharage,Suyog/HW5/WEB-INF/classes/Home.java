import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/Home")


public class Home extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  {
		  
	SmartPortablesSerializedDataStore obj1=new SmartPortablesSerializedDataStore();
	obj1.populateSerializedDataStore();
    PrintWriter out = response.getWriter();
	
    response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
   
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

	
	
	out.println("<div align='center'>");
	out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
  
	out.println("<ol class='carousel-indicators'>");
    out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='3'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='4'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='5'></li>");
	out.println("</ol>");

  
	out.println("<div class='carousel-inner'>");
    out.println("<div class='item active'>");
      out.println("<img src='images/5.jpg' width = '45%' height = '30%' alt='Smart Portables'>");
    out.println("</div>");

    out.println("<div class='item'>");
      out.println("<img src='images/2.jpg' width = '45%' height = '30%' alt='Lappy'>");
	 out.println("</div>");

   out.println("<div class='item'>");
      out.println("<img src='images/4.jpg' width = '45%' height = '30%' alt='Main speaker'>");
	     out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/iphone8.jpg' width = '45%' height = '30%' alt='Main Watch'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/headphone.jfif' width = '45%' height = '30%' alt='Mobile5'>");
    out.println("</div>");
	
	out.println("<div class='item'>");
      out.println("<img src='images/MainExternalStorage.png' width = '45%' height = '30%' alt='Main External Storage'>");
    out.println("</div>");
  out.println("</div>");

  
  out.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
    out.println("<span class='glyphicon glyphicon-chevron-left'></span>");
    out.println("<span class='sr-only'>Previous</span>");
  out.println("</a>");
  out.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
	out.println("<span class='glyphicon glyphicon-chevron-right'></span>");
    out.println("<span class='sr-only'>Next</span>");
  out.println("</a>");
out.println("</div>");
//out.println("</div>");//

	HashMap<String,Product> selectedproducts=new HashMap<String,Product>();



	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offers variety of Smart Accessories and Supplements</p>");
	out.println("<p>Shop at the best market rate</p>");
	
	// code for displaying twitts
	
	try
	{
		String line=null;
		String key = null;
		Boolean flag = false;
		HashMap<String,Product> productmap=MySqlDataStoreUtilities.getData();
		
		for(Map.Entry<String, Product> entry : productmap.entrySet())
		{
			flag = true;
			key = entry.getKey().toLowerCase();
			key = key.replaceAll("\\s+","");

		if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
		{		
			
		BufferedReader reader = new BufferedReader(new FileReader (new File("C:\\apache-tomcat-7.0.34\\webapps\\HW5\\DealMatches.txt")));
		line=reader.readLine().toLowerCase();
		//System.out.println("Before: line is: "+line);
		line = line.replaceAll("\\s+", "");
		//System.out.println("After: line is: "+line);

		if(line==null)
		{	
			System.out.println("line is null");
			out.println("<p align='center'>No Offers Found</p>");
			break;
		}	
		else
		{	
			int res = isSubstring(key,line);
			do {	
			

			
			if(res!= -1)
			{
				System.out.println("line is: "+line);
				System.out.println("key is: "+entry.getKey());
				out.println("<p>"+line+"</p>");
				
				out.println("<br>");
				selectedproducts.put(entry.getKey(),entry.getValue());
				break;
			  }
			  
		    }while((line = reader.readLine()) != null);
		
		 }
		 }
		}
	}
	catch(Exception e) {
		out.println("<p align='center'>No Offers Found</p>");
	}

	
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Deal Matches</h2>");
	
	// code to display products from twitts
	if(selectedproducts.size()==0)
	{
		out.print("<p align='center'>No Deals Found</p>");	
	}
	else
	{
		out.print("<table id='bestseller'>");
		out.print("<tr>");
		for(Map.Entry<String, Product> entry : selectedproducts.entrySet())
		{
			out.print("<td><div id='shop_item'><h3>"+entry.getValue().getName()+"</h3>");
			out.print("<strong>"+entry.getValue().getPrice()+"$</strong>");
			out.print("<ul>");
			out.print("<li id='item'><img src='images/"+entry.getValue().getImage()+"' alt='' />");
			out.print("</li><li>");
			
			out.print("<form action='Addtocart' method='get'><input type='submit' class='btnbuy' value='Add to Cart'>");
			out.print("<input type='hidden' name='name' value='"+entry.getKey()+"'>");
			out.print("<input type='hidden' name='price' value='"+entry.getValue().getPrice()+"'>");
			out.print("<input type='hidden' name='access' value=''>");
			out.print("</form></li><li>");
			
			out.print("<form action='WriteReview' method='get'><input type='submit' class='btnreview' value='Write Review'>");
			out.print("<input type='hidden' name='name' value='"+entry.getKey()+"'>");
			out.print("<input type='hidden' name='producttype' value='"+entry.getValue().getCategory()+"'>");
			out.print("<input type='hidden' name='retailer' value='"+entry.getValue().getRetailer()+"'>");
			out.print("<input type='hidden' name='price' value='"+entry.getValue().getPrice()+"'>");
			out.print("</form></li>");
			out.print("<li>");
			
			out.print("<form action='ViewReview' method='post'><input type='submit' class='btnreview' value='View Review'>");
			out.print("<input type='hidden' name='name' value='"+entry.getKey()+"'>");
			//out.print("<input type='hidden' name='type' value='"+entry.getValue().getType()+"'>");
			out.print("</form></li></ul></div></td>");
		
		}
		out.print("</tr></table>");
		
	}
	
	
	out.println("</article>");
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=Pettrackers'>Pet Tracker</a></li>");
	out.println("<li><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");
	out.println("<li><a href='ProductServlet?param1=FitnessWatches'>Fitness Watches</a></li>");
	out.println("<li><a href='Trending'>Trending</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Smart Portables - Enterprise Web Application </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
	out.println("</body>");	
	out.println("</html>");	

}	
private int isSubstring(String key, String line) {
	
	int M = key.length(); 
    int N = line.length(); 
  
    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++) { 
        int j; 
  
        /* For current index i, check for 
        pattern match */
        for (j = 0; j < M; j++) 
            if (line.charAt(i + j) != key.charAt(j)) 
                break; 
  
        if (j == M) 
            return i; 
    } 
  
    return -1; 
	
}
public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
	out.println("<title>Smart Portables</title>");
	out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
  out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");

	out.println("</head>");
	out.println("<body onload='init()'>");
	//out.println("<script type='text/javascript' src='javascript.js'></script>");
	out.println("<div name='autofillform'>");
	out.println("<input type='text' name='searchId' value='' class='input' id='searchId' onkeyup='doCompletion()' placeholder='search here..' style='padding:5px;font-size:16px;'/>");
	out.println("<div id='auto-row'>");
	out.println("<table id='complete-table' class='gridtable' style='position:absolute; width:315px;'></table>");
	out.println("</div>");
	out.println("</div>");
	
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	if(fname == null) {
		out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
		out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
		out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
		out.println("<li  class=''><a href='Trending'>Trending</a></li>");
		out.println("<li class=''><a href='Register'>Register</a></li>");
		out.println("<li class='' ><a href='Login'>Login</a></li>");

	}
	else 
	{
		if(type=="Customer")
		{
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");			
			out.println("<li  class=''><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
		}
		if(type=="StoreManager") 
		{
			out.println("<li  class='start selected'><a id='Home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Watches'>Add Product</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Mobiles'>Update Product</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=Laptops'>Delete Product</a></li>");			
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
	
		}
	}
		
	
	
	if(type!="StoreManager")
	{
		out.println("<li class=''><a href='ViewOrdersServlet'>View Orders</a></li>");
	}
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/Cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</nav>");
	out.println("</ul>");
	
	out.println("<div align='center'>");
	out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
  
	out.println("<ol class='carousel-indicators'>");
    out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
    out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='3'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='4'></li>");
	out.println("<li data-target='#myCarousel' data-slide-to='5'></li>");
	out.println("</ol>");

  
	out.println("<div class='carousel-inner'>");
    out.println("<div class='item active'>");
      out.println("<img src='images/Mainicon.png' width = '45%' height = '30%' alt='Smart Portables'>");
    out.println("</div>");

    out.println("<div class='item'>");
      out.println("<img src='images/Lappy2.png' width = '45%' height = '30%' alt='Lappy'>");
    out.println("</div>");

   out.println("<div class='item'>");
      out.println("<img src='images/Speaker4.png' width = '45%' height = '30%' alt='Main speaker'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/Mainwatch.png' width = '45%' height = '30%' alt='Main Watch'>");
    out.println("</div>");
	
	 out.println("<div class='item'>");
      out.println("<img src='images/Mobile5.png' width = '45%' height = '30%' alt='Mobile5'>");
    out.println("</div>");
	
	out.println("<div class='item'>");
      out.println("<img src='images/MainExternalStorage.png' width = '45%' height = '30%' alt='Main External Storage'>");
    out.println("</div>");
  out.println("</div>");

  
  out.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
    out.println("<span class='glyphicon glyphicon-chevron-left'></span>");
    out.println("<span class='sr-only'>Previous</span>");
  out.println("</a>");
  out.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
	out.println("<span class='glyphicon glyphicon-chevron-right'></span>");
    out.println("<span class='sr-only'>Next</span>");
  out.println("</a>");
out.println("</div>");


	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offers variety of Smart Accessories and Supplements</p>");
	out.println("<p>Shop at the best market rate</p>");
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Smart Accessoris Available</h2>");
	out.println("<p>Waterproof Case</p>");
	out.println("<p>Mobiles Covers</p>");
	out.println("<p>Laptops bags</p>");
	out.println("<p>Speakers stands</p>");
	out.println("<p>Earphones cover</p>");
	out.println("<h2>Laptops Available</h2>");
	out.println("<p>HP pavilion</p>");
	out.println("<p>Apple Macbook Pro</p>");
	out.println("<p>Dell Inspiration</p>");
	out.println("</article>");
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=Watches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=Mobiles'>Mobiles</a></li>");
	out.println("<li><a href='ProductServlet?param1=Laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=Speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=Earphones'>Earphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=Pettrackers'>Pet Tracker</a></li>");
	out.println("<li><a href='ProductServlet?param1=VirtualReality'>Virtual Reality</a></li>");
	out.println("<li><a href='ProductServlet?param1=Fitnessatches'>Fitness Watches</a></li>");
	out.println("<li><a href='Trending'>Trending</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Smart Portables - Enterprise Web Application </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
	out.println("</body>");	
	out.println("</html>");	

	  
    
}	

}
	
	
	
	
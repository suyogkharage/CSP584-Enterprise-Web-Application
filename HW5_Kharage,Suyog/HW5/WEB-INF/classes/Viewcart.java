import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Viewcart extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      Carousel carousel = new Carousel();
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
			
			
				//System.out.println("Before calling Carousel class");
			//out.println(carousel.carouselfeature(fname1));
			
			//System.out.println("Inside Carousel class");
		    String userName = fname1;
		    //System.out.println("Inside Carousel class: Username is: "+userName);
		    ProductRecommenderUtility prodRecUtility = new ProductRecommenderUtility();
			
			HashMap<String, Product> hm = new HashMap<String, Product>();
			StringBuilder sb = new StringBuilder();
			String myCarousel = null;
				
			String name = null;
			String CategoryName = null;
			if(CategoryName==null){
				try{
				hm=MySqlDataStoreUtilities.getData();
				name = "";
				}catch(Exception e)
				{
					
				}
				
			}
			HashMap<String,String> prodRecmMap = new HashMap<String,String>();
			prodRecmMap = prodRecUtility.readOutputFile();
			
			
			
					String products = prodRecmMap.get(fname1);
					products=products.replace("[","");
					products=products.replace("]","");
					products=products.replace("\"", " ");
					ArrayList<String> productsList = new ArrayList<String>(Arrays.asList(products.split(",")));

					System.out.println("Size of productsList: "+productsList.size());
						
					//out.println("<div id='content'><div class='post'><h2 class='title meta'>");
					//out.println("<a style='font-size: 24px;'>"+""+" Recommended Products</a></h2></div></div>");
					String pname=null;							
					Product p = new Product();
					/*pname = productsList.get(1);
					pname = pname.replace("'","");
					p = ProductRecommenderUtility.getProduct(pname.trim());*/
					System.out.println("Product name: "+p.getName());
					/////////////////////////////////////////////////////////////////////////////////////////////////

					out.println("<!DOCTYPE html><html lang=\"en\"><head>\r\n" + 
							"					  <title>Bootstrap Example</title>\r\n" + 
							"					  <meta charset=\"utf-8\">");
					

					  out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					  		+ "					  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
					  		"					  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
					  		"					  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
					  		"");
					out.println("</head>\r\n" + 
							"					<body>\r\n" + 
							"");
					out.println("<div class=\"container\">");
					out.println("<h2>Recommended Products</h2>");  
					out.println("					<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n" + 
							"					    <!-- Indicators -->\r\n" + 
							"					    <ol class=\"carousel-indicators\">\r\n" + 
							"					      <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n" + 
							"					      <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n" + 
							"					      <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\r\n" + 
							"					    </ol>\r\n" + 
							"\r\n" + 
							"					    <!-- Wrapper for slides -->\r\n" + 
							"					    <div class=\"carousel-inner\">\r\n");  
					
						for(int i =0; i<productsList.size();i++)
						{
							pname = productsList.get(i);
							pname = pname.replace("'","");
							p = ProductRecommenderUtility.getProduct(pname.trim());
							
							if(i==0)
								{out.println("<div class='item active'>");}
							else
							{out.println("<div class='item'>");}
								out.println("<img src=images/"+p.getImage()+" alt=\"Los Angeles\" width='30%' height='30%' align='center'>");  
								
								out.println("<div class='carousel-caption'>");
		   			            
								out.println("<form id='addtocart' method='get' action='Addtocart'>");
								out.println("<input class = 'submit-button' type='submit' value='AddToCart' style='background-color:black'/>");
		   			            out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
		 					    out.println("<input type='hidden' name='price' value='"+p.getPrice()+"'>");
		   			            out.println("</form>");
								
								out.println("<form id='WriteReview' method='get' action='WriteReview'>");
								out.println("<input class = 'submit-button' type = 'submit' value = 'Write Review' style='background-color:transparent'>");
								out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
								out.println("<input type='hidden' name='price' value='"+p.getPrice()+"'>");
								out.println("<input type='hidden' name='retailer' value='"+p.getRetailer()+"'>");
								out.println("<input type='hidden' name='producttype' value='"+p.getCategory()+"'>");
								out.println("</form>");
								
								out.println("<form id='ViewReview' method='post' action='ViewReview'>");
								out.println("<input class = 'submit-button' type = 'submit' value = 'View Review' style='background-color:transparent'>");
								out.println("<input type='hidden' name='name' value='"+p.getName()+"'>");
								out.println("</form>");
								
								out.println("</div>");
								out.println("<br><br><br><br><br><br><br><h3 align='left'>"+p.getName()+"</h3>");
								out.println("<h3 align='left'>Price: $"+p.getPrice()+"</h3>");
								
							out.println("</div>");
							
						}
							
	/*						out.println("<div class=\"item\">" + 
							"		       <img src=images/"+p.getImage()+" alt=\"Chicago\" width='20%' height='20%' align='center'>" + 
							"		      </div>");
							
							out.println("<div class=\"item\">" + 
							"		        <img src=images/"+p.getImage()+" alt=\"New york\" width='20%' height='20%' align='center'>" + 
							"		     </div>");
		*/					
							out.println("  </div>" +"");  

					    //<!-- Left and right controls -->
					    out.println("<a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">\r\n" + 
					    		"					      <span class=\"glyphicon glyphicon-chevron-left\"></span>\r\n" + 
					    		"					      <span class=\"sr-only\">Previous</span>\r\n" + 
					    		"					    </a>\r\n" + 
					    		"					    <a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">\r\n" + 
					    		"					      <span class=\"glyphicon glyphicon-chevron-right\"></span>\r\n" + 
					    		"					      <span class=\"sr-only\">Next</span>\r\n" + 
					    		"					    </a>\r\n" + 
					    		"					  </div>\r\n" + 
					    		"					</div>\r\n" + 
					    		"\r\n" + 
					    		"					</body>\r\n" + 
					    		"					</html>\r\n" + 
					    		"");
					    
					
					
					/////////////////////////////////////////////////////////////////////////////////////////////////
					
					    out.println("<br><br><br>");  
				
				
			
			
			System.out.println("After calling Carousel class");
			out.println("</div>");
            out.println("</body>");
            out.println("</html>");
			

}
			
			
	 }
	  
	  }

}

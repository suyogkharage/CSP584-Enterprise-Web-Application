import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Inventory extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();	
	    HttpSession session = request.getSession();
	    
		String fname=(String)session.getAttribute("fname");
		
	     out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			out.println("<title>Smart Portables</title>");
			out.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
			
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
			out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
			
			
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
			out.println("<li><a href='addProductToDB'>Add Product</a></li>");
			out.println("<li><a href='updateProd'>Update Product</a></li>");
			out.println("<li><a href='DeleteProd'>Delete Product</a></li>");			
			out.println("<li><a href='Inventory'>Inventory</a></li>");
			out.println("<li><a href='SalesReport'>Sales Report</a></li>");
			
			
			out.println("</ul>");
			out.println("</nav>");
			
			
			
			// get data from mysql to display in table and bar chart	

			List<Product> list = null;
			//List<productDetail> rebateList = null;
				try {
					list = MySqlDataStoreUtilities.getInventoryTable();
					//rebateList = MySqlDataStoreUtilities.getRebateList();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	
				out.println("<br>");
				
				out.println("<div class='row'>");
				
				out.println("<div class='col-sm-3'>");				
				out.println("</div>"); 
				
				out.println("<div class='col-sm-6'>"); 
				out.println("<br><a style='font-size: 24px;'>Table of All Products and Number of Items Currently Available</a><br>");
				out.println("</div>");
				
				out.println("<div class='col-sm-3'>");				
				out.println("</div>");
				
				out.println("</div>");
				
				out.println("<div class='row'>");
				
				out.println("<div class='col-sm-3'>");				
				out.println("</div>");
				
				out.println("<div class='col-sm-6'>"); 

				out.println("<div class='table-responsive'>");
				out.println("<table class='table table-bordered'>");

				out.println("<tr><td>Product Name</td>");
				
				out.println("<td>Product Price</td>");
			
				out.println("<td>Current Count</td>");
			
				out.println("</tr>");

				for(int i=0; i < list.size(); i++)
				{
					Product pd = list.get(i);
					out.println("<tr>");
					
					out.println("<td>");
						out.println(pd.getName());
					out.println("</td>");
					
					out.println("<td>");
						out.println(pd.getPrice());
					out.println("</td>");
					
					out.println("<td>");
						out.println(pd.getQuantity());
					out.println("</td>");
					
					out.println("</tr>");
				}
				out.println("</table>");	

				out.println("</div>");
				out.println("</div>");
				out.println("<div class='col-sm-3'> </div></div>");
				
				out.println("<br><br>");
	//////////////////////////////////////////////////////////////////////////////////////////////////////			
				out.println("<div class='row'>");
					out.println("<div class='col-sm-12'>");
						out.println("<br><a style='font-size: 24px;'>Bar Chart Showing Product Name and Total Number of Items Available for that Product.</a>");
					out.println("</div>");
				out.println("</div>");
				
				out.println("<div class='row'>");
				
					out.println("<div class='col-sm-12'>");
					
					out.println("<div id=product-bar-chart></div>");
					out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>"+"<script type='text/javascript' src='https://www.google.com/jsapi'></script>");
					out.println("<script type='text/javascript' src='DataVisualization.js'></script>");					
					
					out.println("</div>");
								
				out.println("</div>");
				
				out.println("<br><br>");
/////////////////////////////////////////////////////////////////////////////////////////////////////				
				out.println("<div class='row'>");
				
					out.println("<div class='col-sm-3'>");
					out.println("</div>");
						
					out.println("<div class='col-sm-9'>");
					out.println("<br><a style='font-size: 24px;'>Table of All Products On Sale.</a>");
					out.println("</div>");
						
					out.println("<div class='col-sm-3'>");
					out.println("</div>");
				
				out.println("</div>");

				out.println("<div class='row'>");

					out.println("<div class='col-sm-3'>");
					out.println("</div>");
		
					out.println("<div class='col-sm-6'>");
					
						out.println("<div class='table-responsive'>");
						out.println("<table class='table table-bordered'>");
	
						out.println("<tr><td>Product Name</td>");
						
						out.println("<td>Product Price</td>");
					
						out.println("</tr>");
	
						for(int i=0; i < list.size(); i++)
						{
							Product pd = list.get(i);
							out.println("<tr>");
							
							out.println("<td>");
								out.println(pd.getName());
							out.println("</td>");
							
							out.println("<td>");
								out.println(pd.getPrice());
							out.println("</td>");
							
							out.println("</tr>");
						}
						out.println("</table>");	
	
						out.println("</div>");

					
					out.println("</div>");

					out.println("<div class='col-sm-3'>");
					out.println("</div>");

				out.println("</div>");
/////////////////////////////////////////////////////////////////////////////////////////////////////


			out.println("<div class='row'>");

				out.println("<div class='col-sm-3'>");
				out.println("</div>");
	
				out.println("<div class='col-sm-6'>");
				out.println("<br><a style='font-size: 24px;'>Table of All Products with Manufacturer Rebates.</a>");
				
					out.println("<div class='table-responsive'>");
					out.println("<table class='table table-bordered'>");

					out.println("<tr><td>Product Name</td>");
					
					out.println("<td>Product Price</td>");
					out.println("<td>Rebate</td>");
					out.println("</tr>");

					for(int i=0; i < list.size(); i++)
					{
						Product pd = list.get(i);
						out.println("<tr>");
						
						out.println("<td>");
							out.println(pd.getName());
						out.println("</td>");
						
						out.println("<td>");
							out.println(pd.getPrice());
						out.println("</td>");
						
						out.println("<td>");
							out.println(pd.getRebate());
						out.println("</td>");
						
						out.println("</tr>");
					}
					out.println("</table>");	

					out.println("</div>");

				
				out.println("</div>");

				out.println("<div class='col-sm-3'>");
				out.println("</div>");

			out.println("</div>");
		        
	}
}

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SalesReport extends HttpServlet{
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
			out.println("<li><a href=''>Update Product</a></li>");
			out.println("<li><a href=''>Delete Product</a></li>");			
			out.println("<li><a href='Inventory'>Inventory</a></li>");
			out.println("<li><a href='SalesReport'>Sales Report</a></li>");
			
			
			out.println("</ul>");
			out.println("</nav>");
			
			List<productDetail> list = null;
			HashMap<String,Integer> hash = new HashMap<String,Integer>(); 
			int soldCount = 0;
					
			try {
				list = MySqlDataStoreUtilities.getInventoryTable();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			for(int i=0; i < list.size(); i++)
			{
				productDetail pd = list.get(i);
				try {soldCount = MySqlDataStoreUtilities.getSoldCount(pd.getProductName());} 
				catch (SQLException e) {e.printStackTrace();}
				hash.put(pd.getProductName(),soldCount);
			}
			int j=0;
			
			out.println("<br>");
			
			out.println("<div class='row'>");
			
			out.println("<div class='col-sm-3'>");				
			out.println("</div>"); 
			
			out.println("<div class='col-sm-6'>"); 
			out.println("<br><a style='font-size: 24px;'>Table of All Products sold and Number of Items of Every Product sold</a><br>");
			
			out.println("<div class='table-responsive'>");
			out.println("<table class='table table-bordered'>");

			out.println("<tr><td>Product Name</td>");
			
			out.println("<td>Price</td>");
			out.println("<td>Items Sold</td>");
			out.println("<td>Total Sales</td>");
		
			out.println("</tr>");
			
			for(Map.Entry<String, Integer> entry : hash.entrySet()) {
				
				int value = entry.getValue();
				String key = entry.getKey();
				
				productDetail pd = list.get(j);
				
				out.println("<tr>");
				
				out.println("<td>");
					out.println(key);
				out.println("</td>");
				
				out.println("<td>");
					out.println(pd.getPrice());
				out.println("</td>");
				
				out.println("<td>");
					out.println(value);
				out.println("</td>");
								
				out.println("<td>");
					out.println(pd.getPrice()*value);
				out.println("</td>");
				
				out.println("</tr>");
				j++;
			}
			
			out.println("</table>");	

			out.println("</div>");
			out.println("</div>");
			
			out.println("<div class='col-sm-3'>");				
			out.println("</div>");
			
			out.println("</div>");
			
//////////////////////////////////////////////////////////////////////////////////////////////
			out.println("<div class='row'>");
			out.println("<div class='col-sm-12'>");
				out.println("<br><a style='font-size: 24px;'>Bar Chart Showing Product Name and Total Sale for that Product.</a>");
			out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='row'>");
		
			out.println("<div class='col-sm-12'>");
			
			out.println("<div id=sales-bar-chart></div>");
			out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>"+"<script type='text/javascript' src='https://www.google.com/jsapi'></script>");
			out.println("<script type='text/javascript' src='SalesBarChart.js'></script>");					
			
			out.println("</div>");
						
		out.println("</div>");
		
		out.println("<br><br>");
/////////////////////////////////////////////////////////////////////////////////////////////////////	
		List<String> dateList = null;
		try {
			dateList = MySqlDataStoreUtilities.getDistinctDate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HashMap<String,Integer> dailySaleList = new HashMap<String,Integer>();
		
		int totalSale = 0;
		for(String name:dateList)
		{
			try {totalSale = MySqlDataStoreUtilities.getTotalSaleForDate(name);} catch (SQLException e) {e.printStackTrace();}
			dailySaleList.put(name, totalSale);				
		}
		
		out.println("<br>");
		
		out.println("<div class='row'>");
		
		out.println("<div class='col-sm-3'>");				
		out.println("</div>"); 
		
		out.println("<div class='col-sm-6'>"); 
		out.println("<br><a style='font-size: 24px;'>Total Daily Sales Transactions</a><br>");
		
		out.println("<div class='table-responsive'>");
		out.println("<table class='table table-bordered'>");

		out.println("<tr><td>Order Date</td>");
		
		out.println("<td>Total Sale ($)</td>");
	
		out.println("</tr>");
		
		for(Map.Entry<String, Integer> entry : dailySaleList.entrySet()) {
			
			String key = entry.getKey();
			int value = entry.getValue();
			
			
			out.println("<tr>");
			
			out.println("<td>");
				out.println(key);
			out.println("</td>");
						
			out.println("<td>");
				out.println(value);
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

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateProd")
public class updateProd extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();	
	    HttpSession session = request.getSession();
		String fname=(String)session.getAttribute("fname");
	    List<Product> list = null;
	    List<String> uniqueCategoryList = null;
			try {
				list = MySqlDataStoreUtilities.getInventoryTable();
				//uniqueCategoryList = MySqlDataStoreUtilities.getUniqueCategoryList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	    
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
			out.println("</nav><br>");
			
			
	
			out.println("<div class='row'>");
			
			out.println("<div class='col-sm-6'>");

			out.println("<form class='form-horizontal' action='updateProduct' method='get'>");
			  
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='email'>Select Product Name to Update:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<select name='OriginalProductName'>");
			out.println("<option value=''></option>");
			for(int i=0; i < list.size(); i++)
			{
				Product p = list.get(i);
				out.println("<option value='"+p.getName()+"'>"+p.getName()+"</option>");
			}
			out.println("</select></div></div>");
			
	
			out.println("<div class='form-group'>");
			out.println("<div class='col-sm-offset-2 col-sm-10'>");
			out.println("<button type='submit' class='btn btn-default'>Update Product</button>");
			out.println("</div></div></form>");

			out.println("</div>"); 
			
			out.println("<div class='col-sm-6'>");
			out.println("</div>"); 
			
			out.println("</div>"); 
		
	}
}

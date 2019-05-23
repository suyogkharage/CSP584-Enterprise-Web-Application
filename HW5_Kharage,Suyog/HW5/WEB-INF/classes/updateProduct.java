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

@WebServlet("/updateProduct")
public class updateProduct extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();	
	    HttpSession session = request.getSession();
		String fname=(String)session.getAttribute("fname");
		String pname = request.getParameter("OriginalProductName");
	    
		
	
		
	    List<String> uniqueCategoryList = null;
	    uniqueCategoryList = MySqlDataStoreUtilities.getUniqueCategoryList();
		
	    
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
			out.println("<br><a style='font-size: 24px;'>Update details for: "+pname+"</a><br>");				

			out.println("<form class='form-horizontal' action='finalUpdate' method='post'>");
			  
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='email'>Category Name:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<select name='Category'>");
			out.println("<option value=''></option>");
			for(int i=0; i < uniqueCategoryList.size(); i++)
			{
				out.println("<option value='"+uniqueCategoryList.get(i)+"'>"+uniqueCategoryList.get(i)+"</option>");
			}
			out.println("</select></div></div>");
			
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='productCondition'>Product Condition</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='productCondition' 'id='productCondition'>");
			
			out.println("<input type='hidden' name='OriginalProductName' value='"+pname+"'>");
			out.println("</div></div>");

			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='retailer'>Retailer</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='retailer' 'id='retailer'>");
			out.println("</div></div>");
			
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='image'>Image Path:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='image' 'id='image' placeholder='Enter image path'>");
			out.println("</div></div>");
			
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='quantity'>Quantity:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='quantity' 'id='quantity' placeholder='Enter quantity'>");
			out.println("</div></div>");

			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='price'>Price:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='price' 'id='price' placeholder='Enter price'>");
			out.println("</div></div>");
			
						
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='onsale'>On Sale:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<select name='onsale'>");
			out.println("<option value=''></option>");
			out.println("<option value='Yes'>Yes</option>");
			out.println("<option value='No'>No</option>");
			out.println("</select>");
			out.println("</div></div>");

			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='rebate'>Rebate:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='text' class='form-control' name='rebate' 'id='rebate' placeholder='Enter rebate'>");
			out.println("</div></div>");
			
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

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
@WebServlet("/addProductToDB")
public class addProductToDB extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();	
	    HttpSession session = request.getSession();
		String fname=(String)session.getAttribute("fname");
	    List<productDetail> list = null;
			try {
				list = MySqlDataStoreUtilities.getProductNames();
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

			out.println("<form class='form-horizontal' action='getProductCount' method='post'>");
			  
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='email'>Product Name:</label>");
			out.println("<div class='col-sm-10'>");
				out.println("<select name='productName'>");
				out.println("<option value=''></option>");
				for(int i=0; i < list.size(); i++)
				{
					productDetail pd = list.get(i);
					out.println("<option value='"+pd.getProductName()+"'>"+pd.getProductName()+"</option>");
				}
			out.println("</select></div></div>");
			
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2' for='count'>Count:</label>");
			out.println("<div class='col-sm-10'>");
			out.println("<input type='password' class='form-control' name='count' 'id='count' placeholder='Enter Count'>");
			out.println("</div></div>");

			out.println("<div class='form-group'>");
			out.println("<div class='col-sm-offset-2 col-sm-10'>");
			out.println("<button type='submit' class='btn btn-default'>Add Product</button>");
			out.println("</div></div></form>");

			out.println("</div>"); 
			
			out.println("<div class='col-sm-6'>");
			out.println("</div>"); 
			
			out.println("</div>"); 
			
/*			out.println("<form action='getProductCount' method='post'>");
			out.println("<table>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Product Name :");
			out.println("<select name='productName'>");
			out.println("<option value=''></option>");
			for(int i=0; i < list.size(); i++)
			{
				productDetail pd = list.get(i);
				out.println("<option value='"+pd.getProductName()+"'>"+pd.getProductName()+"</option>");
			}
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Count  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:");
			out.println("<input type='text' name='count' required/></td>");
			out.println("</tr>");
			
			
			out.println("<tr><td ><input type='submit' value='Add Product'></td></tr>");
			out.println("</table>");
			out.println("</form>");
*/			
	}
}

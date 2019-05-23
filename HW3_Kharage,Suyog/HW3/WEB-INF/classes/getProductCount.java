import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getProductCount extends HttpServlet {
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		  response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
			
			HttpSession session = request.getSession();
			
			
		    int count = Integer.parseInt(request.getParameter("count"));
		    String name = request.getParameter("productName");
			
		    
		    
			int currentCount = MySqlDataStoreUtilities.getproductCount(name);
			
			/* if(MySqlDataStoreUtilities.validateUser(uid,password,category))
		        {
				
					HttpSession hs=request.getSession();
					hs.setAttribute("fname",fname);
					hs.setAttribute("type",category);
		            response.sendRedirect("Home");
					
		        }
		        else
		        {
		           out.println("<br><br><h2>Incorrect user id or password or category !</h2><br><br>");
				   out.println("<a href='Login'><h3>Click here to login again</h3>");
		        }*/
			int newCount = 0;
			newCount = count + currentCount;
			int code=2;	
        	session.setAttribute("Code", code);
			
			MySqlDataStoreUtilities.setproductCount(name,newCount);
			response.sendRedirect("Done");
			
		  
	  }
	  
}

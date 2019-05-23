import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderDetailsToDelete extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    
		    HttpSession session = request.getSession();
		    
			String fname=(String)session.getAttribute("fname");
			String type = (String)session.getAttribute("type");
			String orderName = request.getParameter("OrderNameToBeDeleted");
			
			
			
			MySqlDataStoreUtilities.DeleteOrder(fname,orderName);
				
			response.sendRedirect("ViewOrdersServlet");
							

	 }
}

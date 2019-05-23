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
			
			
		   
		    String name = request.getParameter("productName");
		    String category = request.getParameter("Category");
		    String condition = request.getParameter("condition");
		    String retailer = request.getParameter("retailer");
		    String image = request.getParameter("image");
		    int quantity = Integer.parseInt(request.getParameter("quantity"));
		    int price = Integer.parseInt(request.getParameter("price"));
		    String onsale = request.getParameter("onsale");
		    int rebate = Integer.parseInt(request.getParameter("rebate"));
		          
						
			Product p = new Product(name,category,price,image,retailer,condition,rebate,quantity,onsale);
			
		
			
			int code=2;	
        	session.setAttribute("Code", code);
			
			
        	Startup.hm.put(name, p);
        	System.out.println("Size of hm after add: "+Startup.hm.size());
        	MySqlDataStoreUtilities.insertNewProduct(p);
        	response.sendRedirect("Done");
			
		  
	  }
	  
}

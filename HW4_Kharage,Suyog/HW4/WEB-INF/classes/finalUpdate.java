import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class finalUpdate extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String productName = null;
		
		String pname = request.getParameter("OriginalProductName");
		System.out.println("Pname to be updated: "+pname);
		//String name = request.getParameter("productName");
	    String category = request.getParameter("Category");
	    String condition = request.getParameter("productCondition");
	    String retailer = request.getParameter("retailer");
	    String image = request.getParameter("image");
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    int price = Integer.parseInt(request.getParameter("price"));
	    String onsale = request.getParameter("onsale");
	    int rebate = Integer.parseInt(request.getParameter("rebate"));
	    
	    
	    Product p = new Product(pname,category,price,image,retailer,condition,rebate,quantity,onsale);
	    
	    int code=3;	
    	session.setAttribute("Code", code);
    	
    	for(Map.Entry<String, Product> entry: Startup.hm.entrySet()) {
    		productName = entry.getKey();
    		if(productName.equals(pname)) {
    			Startup.hm.put(productName, p);
    		}
    	}
    	System.out.println("Size of hm after update: "+Startup.hm.size());
    	MySqlDataStoreUtilities.updateProduct(p);
    	
    	response.sendRedirect("Done");
	  }
}

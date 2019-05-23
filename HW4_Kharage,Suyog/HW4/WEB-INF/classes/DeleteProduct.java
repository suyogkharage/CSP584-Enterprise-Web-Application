import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProduct extends HttpServlet{
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		 response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
			String productName= null;
			HttpSession session = request.getSession();
			
			
		   
		    String name = request.getParameter("ProdDelete");
		  
		          
						
			//Product p = new Product(name,category,price,image,retailer,condition,rebate,quantity,onsale);
			
		
			
			int code=4;	
			session.setAttribute("Code", code);
			
     	/*for(Map.Entry<String, Product> entry: Startup.hm.entrySet()) {
    		productName = entry.getKey();
    		if(productName.equals(name)) {
    			Startup.hm.remove(productName);
    		}
    	}*/
     	
     	Iterator<Map.Entry<String,Product>> iter = Startup.hm.entrySet().iterator();
     	while (iter.hasNext()) {
     	    Map.Entry<String,Product> entry = iter.next();
     	    if(name.equalsIgnoreCase(entry.getKey())){
     	        iter.remove();
     	    }
     	}
     	
    	System.out.println("Size of hm after delete: "+Startup.hm.size());	
     	
    	MySqlDataStoreUtilities.deleteProduct(name);
     	response.sendRedirect("Done");
	  }
}

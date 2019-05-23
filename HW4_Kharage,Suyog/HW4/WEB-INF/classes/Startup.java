import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Startup")
public class Startup extends HttpServlet{
	
	public static SaxParser4SmartPortablesXMLDataStore sxparseobj;
	public static List<Product> products;
	public static HashMap<String, Product> hm = new HashMap<String, Product>();
	
	public void init() throws ServletException
    {
		sxparseobj = new SaxParser4SmartPortablesXMLDataStore("C:/apache-tomcat-7.0.34/webapps/HW4/WEB-INF/productcatalog.xml");
		
		products = sxparseobj.products;
		
		for(int i=0;i<products.size();i++) {
			hm.put(products.get(i).getName(), products.get(i));
		}
    	
		MySqlDataStoreUtilities.insertProduct(hm);
		
		

    }
}
	
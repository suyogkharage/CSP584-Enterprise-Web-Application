import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.Serializable;
import java.util.*;
//CREATE ORDER
public class CreateOrder extends HttpServlet {
	
  public static HashMap<String,Orders> hm_order = new HashMap<String,Orders>();
  SmartPortableUser user=null;
  
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    HttpSession session = request.getSession();
    String fname = session.getAttribute("fname").toString();
    double totalamount = Double.parseDouble(request.getParameter("totalamount"));
    String prevpage = request.getParameter("prevpage");
    request.setAttribute("prevpage", prevpage);
    String address = request.getParameter("address");
    long creditcardnumber = Long.parseLong(request.getParameter("creditcardnumber"));
	String orderdate = request.getParameter("orderdate");
	String deliverydate = request.getParameter("deliverydate");
	String city=request.getParameter("city");
	String country=request.getParameter("country");
	int zipcode=Integer.parseInt("zipcode");
    
    
   
    user=MySqlDataStoreUtilities.getUserDetails(fname);
    
    Random rand = new Random();
    int oid = rand.nextInt(10000);
    Orders o = new Orders(oid,user,new ArrayList<Object>(),totalamount,address,creditcardnumber);
    
    ArrayList<String> productnames = new ArrayList<String>();
     
    for(String productname : productnames)
    {
    	MySqlDataStoreUtilities.insertProductOrder(productname,oid);
    }
     MySqlDataStoreUtilities.insertOrder(oid,fname,totalamount,address,creditcardnumber,orderdate,deliverydate);
    hm_order.put(user.getUid(), o);//u.getUid()
    session.setAttribute("oid",oid);
    session.setAttribute("orderobj",o);
    response.sendRedirect("ViewOrdersServlet");
    
  }
  
  
}
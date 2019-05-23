import java.io.*; 
import javax.servlet.*;
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MySqlDataStoreUtilities
{
	static Connection conn = null;
	static int count=0;
	
	
	public static void getConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");			
		}
		
		catch(Exception e)
		{
		}	
		
	}
	
	public static void insertUser(String fname,String lname,String email,String address,String city,String state,String country,String zipcode,String uid,String password,String category)
	{
		
	try{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	conn.setAutoCommit(false);
	String insertIntoCustomerRegisterQuery = "INSERT INTO RegistrationUser "+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
	
	pst.setString(1,fname);
	pst.setString(2,lname);
	pst.setString(3,email);
	pst.setString(4,address);
	pst.setString(5,city);
	pst.setString(6,state);
	pst.setString(7,country);
	pst.setString(8,zipcode);
	pst.setString(9,uid);
	pst.setString(10,password);
	pst.setString(11,category);
	pst.execute();
	conn.commit();
	pst.close();
	conn.close();
	}
	catch(Exception e){}
	}
	
	public static boolean validateUser(String uid,String password,String category) 
     {
      boolean flag = false;
      try{

	
         Class.forName("com.mysql.jdbc.Driver");

         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
		 Statement stmt = conn.createStatement();
		 String validateUserInfo = "SELECT userId,userPassword,userCategory FROM RegistrationUser;";
		 ResultSet rs=stmt.executeQuery(validateUserInfo);
			while(rs.next())
			{
				if(uid.equals(rs.getString("userId")) && password.equals(rs.getString("userPassword")) && category.equals(rs.getString("userCategory")))
					flag=true;
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			}
        
		
		
      catch(Exception e)
      {
          e.printStackTrace();
      }
         return flag;                 
  }  
  
	public static String ViewUsername(String uid)
     {
      String fname1=null;
	  
      try{

         Class.forName("com.mysql.jdbc.Driver");

         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
		 
		 PreparedStatement ps =conn.prepareStatement("select * from RegistrationUser where userId=?");
         ps.setString(1, uid);
     
		 ResultSet rs =ps.executeQuery();
        
		while(rs.next())
		{
		fname1=rs.getString("firstName");  
		}
		ps.close();
		conn.close();	
		
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return fname1;	   
	}
	
	public static void insertOrder(int oid, String fname, String pname, double totalamount, String address, long creditcardnumber,String orderdate,String deliverydate, int zipcode)
	{
		
	try{
	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String insertIntoCustomerOrdersQuery = "INSERT INTO CustomerOrders(oid,firstName,productName,totalamount,address,creditcardnumber,orderdate,deliverydate,zipcode)"+ "VALUES(?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrdersQuery);
			pst.setInt(1,oid);	
			pst.setString(2,fname);
			pst.setString(3,pname);
			pst.setDouble(4, totalamount);
			pst.setString(5,address);
			pst.setLong(6,creditcardnumber);
			pst.setString(7,orderdate);
			pst.setString(8,deliverydate);
			pst.setInt(9,zipcode);
			
			pst.execute();
			
			pst.close();
			conn.close();
						
	}
	catch(Exception e){}
	}
  
  
  public static void deleteOrder(int oid)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String deleteFromCustomerOrdersQuery = "DELETE FROM CustomerOrders WHERE oid=?;";
			
			PreparedStatement pst = conn.prepareStatement(deleteFromCustomerOrdersQuery);
			pst.setInt(1,oid);
			pst.execute();
			
			pst.close();
			conn.close();
			
			}
			catch(Exception e)
			{
			}
		}
		
		public static void insertProductOrder(String productname,int oid)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String insertIntoProductOrderQuery = "INSERT INTO ProductOrder(productname,oid)"+ "VALUES(?,?);";
			
			PreparedStatement pst = conn.prepareStatement(insertIntoProductOrderQuery);
			pst.setString(1,productname);
			pst.setInt(2,oid);			
			pst.execute();
			pst.close();
			conn.close();
			}
			catch(Exception e)
			{
			}
		}
		
		public static String getUserName(String uid)
	{
		String fname1=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getUser = "SELECT * FROM RegistrationUser WHERE userId='"+uid+"';";
			
			PreparedStatement pst = conn.prepareStatement(getUser);
			//pst.setString(1,uid);
			
			ResultSet rs=pst.executeQuery(getUser);
			while(rs.next())
			{
				
				 fname1=rs.getString("firstName");
				
			}
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();			
			}
		catch(Exception e)
		{
		}
		return fname1;		
	}
		
		public static int getproductCount(String pname)
		{
			int count=0;
			try 
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
				String getCount = "SELECT Quantity FROM product WHERE ProductName='"+pname+"';";
				
				PreparedStatement pst = conn.prepareStatement(getCount);
				ResultSet rs=pst.executeQuery(getCount);
				while(rs.next())
				{
					
					 count=rs.getInt("Quantity");
					
				}
				
				conn.commit();
				rs.close();
				pst.close();
				conn.close();
			}
			catch(Exception e) 
			{}
			
			return count;
		}
		
		public static void setproductCount(String pname,int count)
		{
			
			try 
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
				String setCount = "UPDATE product SET Quantity ='"+count+"' WHERE ProductName='"+pname+"';";
				
				PreparedStatement pst = conn.prepareStatement(setCount);
				
				pst.executeUpdate();
								
				conn.commit();
				
				pst.close();
				conn.close();
			}
			catch(Exception e) 
			{}
					
		}
  
  public static String getUserType(String uid)
		{
			String type1=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getUser = "SELECT * FROM RegistrationUser WHERE userId='"+uid+"';";
			
			PreparedStatement pst = conn.prepareStatement(getUser);
			//pst.setString(1,uid);
			
			ResultSet rs=pst.executeQuery(getUser);
			while(rs.next())
			{
				
				 type1=rs.getString("userCategory");//type
				
			}
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();			
			}
		catch(Exception e)
		{
		}
		return type1;		
		}
		
		public static SmartPortableUser getUserDetails(String fname)
		{
		SmartPortableUser spu=null;
		String uid1 = null, password1 = null,type1 = null,fname1 = null,lname1 = null,emailid1=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getUser = "SELECT * FROM RegistrationUser WHERE firstName='"+fname+"';";
			
			PreparedStatement pst = conn.prepareStatement(getUser);
			//pst.setString(1,uid);
			
			ResultSet rs=pst.executeQuery(getUser);
			while(rs.next())
			{
				 uid1=rs.getString("userId");
				 password1=rs.getString("userPassword");
				 type1=rs.getString("userCategory");//type
				 fname1=rs.getString("firstName");
				 lname1=rs.getString("lastName");
				 emailid1=rs.getString("email");
				 	
			}
			spu = new SmartPortableUser(fname1,lname1,uid1,emailid1,password1,type1);
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();			
			}
		catch(Exception e)
		{
		}
		return spu;		
		}
		
		public static ArrayList<Integer> mostsoldZip(){
			ArrayList<Integer> list = new ArrayList<Integer>();
			try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getOrders = "SELECT COUNT(*) AS Count, zipcode FROM CustomerOrders GROUP BY zipcode ORDER BY Count desc limit 5;";
			
			PreparedStatement pst = conn.prepareStatement(getOrders);
			
			ResultSet rs=pst.executeQuery(getOrders);
				while(rs.next())
				{
					int zip = rs.getInt("zipcode");	
					list.add(zip);
				}
			}
			catch(Exception e) {
				
			}
			return list;
		}
		
		public static ArrayList<String> mostsoldProducts(){

			ArrayList<String> list = new ArrayList<String>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
				String getOrders = "SELECT DISTINCT COUNT(*) AS Count, productName FROM CustomerOrders GROUP BY productName ORDER BY Count desc limit 5;";
				
				PreparedStatement pst = conn.prepareStatement(getOrders);
				
				ResultSet rs=pst.executeQuery(getOrders);
					while(rs.next())
					{
						String product = rs.getString("productName");
						
						list.add(product);
					}
				}
				catch(Exception e) {
					
				}
			
			return list;
			
		}
		
		public static ArrayList<String> getUniqueCategoryList(){

			ArrayList<String> list = new ArrayList<String>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
				String getDistCategory = "SELECT DISTINCT Category FROM product;";
				
				PreparedStatement pst = conn.prepareStatement(getDistCategory);
				
				ResultSet rs=pst.executeQuery(getDistCategory);
					while(rs.next())
					{
						list.add(rs.getString("Category"));
						
					}
				}
				catch(Exception e) {
					
				}
			
			return list;
			
		}
		
		
		public static ArrayList<Orders> getOrderDetails(String fname)
		{
		ArrayList<Orders> orders = new ArrayList<Orders>();
		//String uid1 = null, password1 = null,type1 = null,fname1 = null,lname1 = null,emailid1=null;
		int oid1; 
		String firstname=null;
		String productName=null;
		double totalamount;
		String address=null;
		long creditcardnumber; 
		String orderdate=null; 
		String deliverydate=null;
		
		int zipcode;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getOrders = "SELECT * FROM CustomerOrders WHERE firstName='"+fname+"';";
			
			PreparedStatement pst = conn.prepareStatement(getOrders);
			
			ResultSet rs=pst.executeQuery(getOrders);
			while(rs.next())
			{
				 oid1=rs.getInt("oid");
				 firstname=rs.getString("firstName");
				 productName=rs.getString("productName");
				 totalamount=rs.getDouble("totalamount");
				 address=rs.getString("address");
				 orderdate=rs.getString("orderdate");
				 deliverydate=rs.getString("deliverydate");
				 zipcode=rs.getInt("zipcode");
				 
				 Orders o = new Orders(oid1, firstname, productName,totalamount,orderdate,deliverydate,address);
				 orders.add(o);
				 	
			}
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();			
			}
		catch(Exception e)
		{
			
		}
		return orders;		
		}
		
		public static List<productDetail> getProductNames() throws SQLException {
	        List<productDetail> list = new ArrayList<>();
	         
	        String pname = null;
	        int price=0;
	        String retailer = null;
	        int currentCount=0;
	        int rebate = 0;
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	    			String getOrders = "SELECT * FROM productDetail ORDER BY productName";
	    			
	    			PreparedStatement pst = conn.prepareStatement(getOrders);
	    			
	    			ResultSet rs=pst.executeQuery(getOrders);
	    			while(rs.next())
	    			{
	    				pname = rs.getString("productName");	
	    				price = rs.getInt("productPrice");
	    				retailer = rs.getString("retailer");
	    				currentCount = rs.getInt("currentCount");
	    				rebate = rs.getInt("rebate");
	    				productDetail productdetail = new productDetail(pname,price,retailer,currentCount,rebate);
	    				list.add(productdetail);
	    			}
	    			
	    			conn.commit();
	    			rs.close();
	    			pst.close();
	    			conn.close();	        
	             
	        } catch (Exception ex) {
	           
	        }      
	         
	        return list;
	    }
		
		public static List<Product> getInventoryTable() throws SQLException {
	        
			List<Product> list = new ArrayList<>();
	         
	        String pname = null;
	        
	        String category=null;
	        String condition=null;
	        String image=null;
	        int price=0;
	        String onsale=null;
	        String retailer = null;
	        int currentCount=0;
	        int rebate=0;
	        
	        
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	    			String getOrders = "SELECT * FROM product";
	    			
	    			PreparedStatement pst = conn.prepareStatement(getOrders);
	    			
	    			ResultSet rs=pst.executeQuery(getOrders);
	    			while(rs.next())
	    			{
	    				pname = rs.getString("ProductName");
	    				category=rs.getString("Category");
	    				condition = rs.getString("ProductCondition");
	    				price = rs.getInt("Price");
	    				image= rs.getString("ProductImage");
	    				retailer = rs.getString("retailer");
	    				onsale = rs.getString("OnSale");
	    				currentCount = rs.getInt("Quantity");
	    				rebate = rs.getInt("Rebate");
	    				
	    				
	    				Product productdetail = new Product(pname,category,price,image,retailer,condition,rebate,currentCount,onsale);
	    				list.add(productdetail);
	    			}
	    			
	    			conn.commit();
	    			rs.close();
	    			pst.close();
	    			conn.close();	        
	             
	        } catch (Exception ex) {
	           
	        }      
	         
	        return list;
	    }
		
		public static int getSoldCount(String productName) throws SQLException {
	        
			
	        int count=0;
	           
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	    			String getsoldcount = "SELECT COUNT(*) AS count FROM CustomerOrders WHERE productName='"+productName+"';";
	    			
	    			PreparedStatement pst = conn.prepareStatement(getsoldcount);
	    			
	    			ResultSet rs=pst.executeQuery(getsoldcount);
	    	
	    			while(rs.next())
	    			{
	    				count = rs.getInt("count");
	    			}
	    			
	    			conn.commit();
	    			rs.close();
	    			pst.close();
	    			conn.close();	        
	             
	        } catch (Exception ex) {
	           
	        }      
	         
	        return count;
	    }
		
public static List<String> getDistinctDate() throws SQLException {
	        
			
	List<String> orderdateList = new ArrayList<String>();
	           
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	    			String getdate = "SELECT DISTINCT orderdate FROM CustomerOrders;";
	    			
	    			PreparedStatement pst = conn.prepareStatement(getdate);
	    			
	    			ResultSet rs=pst.executeQuery(getdate);
	    	
	    			while(rs.next())
	    			{
	    				orderdateList.add(rs.getString("orderdate"));
	    			}
	    			
	    			conn.commit();
	    			rs.close();
	    			pst.close();
	    			conn.close();	        
	             
	        } catch (Exception ex) {
	           
	        }      
	         
	        return orderdateList;
	    }

public static int getTotalSaleForDate(String orderDate) throws SQLException {
    
	
int sum = 0;
	           
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	    			String getdate = "SELECT totalamount FROM CustomerOrders WHERE orderdate='"+orderDate+"';";
	    			
	    			PreparedStatement pst = conn.prepareStatement(getdate);
	    			
	    			ResultSet rs=pst.executeQuery(getdate);
	    	
	    			while(rs.next())
	    			{
	    				sum = sum + Integer.parseInt(rs.getString("totalamount"));
	    			}
	    			
	    			conn.commit();
	    			rs.close();
	    			pst.close();
	    			conn.close();	        
	             
	        } catch (Exception ex) {
	           
	        }      
	         
	        return sum;
	    }

public static List<productDetail> getRebateList() throws SQLException {
    
	List<productDetail> rebateList = new ArrayList<>();
     
    String pname = null;
    int price=0;
    String retailer = null;
    int currentCount=0;
    int rebate=0;
    try {
    		Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getOrders = "SELECT * FROM product";
			
			PreparedStatement pst = conn.prepareStatement(getOrders);
			
			ResultSet rs=pst.executeQuery(getOrders);
			while(rs.next())
			{
				pname = rs.getString("productName");	
				price = rs.getInt("productPrice");
				retailer = rs.getString("retailer");
				currentCount = rs.getInt("currentCount");
				rebate = rs.getInt("rebate");
				productDetail productdetail = new productDetail(pname,price,retailer,currentCount,rebate);
				rebateList.add(productdetail);
			}
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();	        
         
    } catch (Exception ex) {
       
    }      
     
    return rebateList;
}

public static Product getSpecificProduct(String searchId)
{
	Product p = null;
	
	String pname = null;
    
    String category=null;
    String condition=null;
    String image=null;
    int price=0;
    String onsale=null;
    String retailer = null;
    int currentCount=0;
    int rebate=0;

try{
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
	String getProduct = "SELECT * FROM product WHERE ProductName='"+searchId+"';";
	
	PreparedStatement pst = conn.prepareStatement(getProduct);
	
	ResultSet rs=pst.executeQuery(getProduct);
	while(rs.next())
	{
		pname = rs.getString("ProductName");
		category=rs.getString("Category");
		condition = rs.getString("ProductCondition");
		price = rs.getInt("Price");
		image= rs.getString("ProductImage");
		retailer = rs.getString("retailer");
		onsale = rs.getString("OnSale");
		currentCount = rs.getInt("Quantity");
		rebate = rs.getInt("Rebate");
		
		 p = new Product(pname, category, price,image,retailer,condition,rebate,currentCount,onsale);
		 		 	
	}
	
	conn.commit();
	rs.close();
	pst.close();
	conn.close();			
	}
catch(Exception e)
{
	
}
return p;		
}

public static void insertProduct(HashMap<String,Product> hm) {
	System.out.println("inside insertProduct "+SaxParser4SmartPortablesXMLDataStore.hm.size());
	
	try{
		
		int quantity = 0;
		getConnection();
		truncateTable();
		String insertProductQurey = "INSERT INTO product(ProductName,Category,ProductCondition,retailer,"
		 		+ "ProductImage,Quantity,Price,OnSale,Rebate) VALUES(?,?,?,?,?,?,?,?,?);"; 
		
		for(Map.Entry<String, Product> entry: hm.entrySet()) {
			String selectOrderQuery = new String();
			Product product = entry.getValue();
			quantity = product.getQuantity();
			selectOrderQuery ="select Count(*) as q from CustomerOrders where productName='"+product.getName()+"'group by productName order by q desc;";
			PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
			ResultSet rs = pst.executeQuery();
			 if(rs.next())
			 {
				 quantity = quantity - rs.getInt("q");
			 }
                 PreparedStatement pst1 = conn.prepareStatement(insertProductQurey);
				 pst1.setString(1, product.getName());
				 pst1.setString(2, product.getId());
				 pst1.setString(3, product.getCondition());
				 pst1.setString(4, product.getRetailer());
				 pst1.setString(5,product.getImage() );
				 pst1.setInt(6,quantity);
				 pst1.setInt(7, product.getPrice());
				 pst1.setString(8,product.getOnsale());
				 pst1.setInt(9,product.getRebate());
				
				pst1.executeUpdate();

		}
			
		}catch(Exception e)
		{
	  		e.printStackTrace();
		}

	}
public static  void truncateTable() {
    try {
		getConnection();
		PreparedStatement  ps = conn.prepareStatement("truncate table product;");
         ps.execute();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void insertNewProduct(Product product) {
	System.out.println("inside insertProduct "+SaxParser4SmartPortablesXMLDataStore.hm.size());
	
	try{
		
		getConnection();
		String insertNewProductQurey = "INSERT INTO product(ProductName,Category,ProductCondition,retailer,"
		 		+ "ProductImage,Quantity,Price,OnSale,Rebate) VALUES(?,?,?,?,?,?,?,?,?);"; 
		
		
			
                 PreparedStatement pst1 = conn.prepareStatement(insertNewProductQurey);
				 pst1.setString(1, product.getName());
				 pst1.setString(2, product.getCategory());
				 pst1.setString(3, product.getCondition());
				 pst1.setString(4, product.getRetailer());
				 pst1.setString(5,product.getImage() );
				 pst1.setInt(6,product.getQuantity());
				 pst1.setInt(7, product.getPrice());
				 pst1.setString(8,product.getOnsale());
				 pst1.setInt(9,product.getRebate());
				
				pst1.executeUpdate();

	
			
		}catch(Exception e)
		{
	  		e.printStackTrace();
		}

	}

public static void updateProduct(Product product) {
	
	try{
		Product p = product;
		
		getConnection();
		
		
		String updateProd = "UPDATE product SET Category='"+p.getCategory()+"', ProductCondition='"+p.getCondition()+"',"
				+"retailer='"+p.getRetailer()+"',ProductImage='"+p.getImage()+"',Quantity='"+p.getQuantity()+"',"
				+"Price='"+p.getPrice()+"',OnSale='"+p.getOnsale()+"',Rebate='"+p.getRebate()+"' WHERE ProductName='"+p.getName()+"'";
		
                 PreparedStatement pst1 = conn.prepareStatement(updateProd);
				 
				
				pst1.executeUpdate();

		
			
		}catch(Exception e)
		{
	  		e.printStackTrace();
		}

	}

	public static void deleteProduct(String pname)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			String getProduct = "DELETE FROM product WHERE ProductName='"+pname+"';";
			
			PreparedStatement pst = conn.prepareStatement(getProduct);
			
			pst.execute();
			
			conn.commit();
			pst.close();
			conn.close();			
			}
		catch(Exception e)
		{
			
		}
	}
	
	public static List<String> getUserSpecificOrders(String userName)
	{
		List<String> list = new ArrayList<String>();
/*		Orders o =null;
		
		int oid;
		String firstName;
		String productName;
		double totalamount;
		String address;
		String orderdate;
		String deliverydate;
	*/	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
		String getProduct = "SELECT productName FROM CustomerOrders WHERE firstName='"+userName+"';";
		
		PreparedStatement pst = conn.prepareStatement(getProduct);
		
		ResultSet rs=pst.executeQuery(getProduct);
		while(rs.next())
		{
			list.add(rs.getString("productName"));
			
			/*oid = rs.getInt("oid");
			firstName = rs.getString("firstName");
			productName = rs.getString("productName");
			totalamount = rs.getDouble("totalamount");
			orderdate = rs.getString("orderdate");
			deliverydate = rs.getString("deliverydate");
			address = rs.getString("address");
			
			o = new Orders(oid,firstName,productName,totalamount,orderdate,deliverydate,address);
			list.add(o);*/
			
		}
		
//    	System.out.println("In SQL data store: Size of order list is: "+list.size());
		conn.commit();
		rs.close();
		pst.close();
		conn.close();			
		}
	catch(Exception e)
	{
		
	}
	return list;		
	}
	
	public static void UpdateOrder(String userName, String orderName, String address, String zipcode) {
		
	try{
		getConnection();

String updateProd = "UPDATE CustomerOrders SET address='"+address+"', zipcode='"+zipcode+"' WHERE firstName='"+userName+"' AND productName='"+orderName+"'";
			
            PreparedStatement pst1 = conn.prepareStatement(updateProd);
			pst1.executeUpdate();
				
			}catch(Exception e)
			{
		  		e.printStackTrace();
			}

		}
	
	public static void DeleteOrder(String userName, String orderName) {
		
		try{
			getConnection();

	String deleteProd = "DELETE FROM CustomerOrders WHERE firstName='"+userName+"' AND productName='"+orderName+"'";
				
	            PreparedStatement pst1 = conn.prepareStatement(deleteProd);
				pst1.executeUpdate();
					
				}catch(Exception e)
				{
			  		e.printStackTrace();
				}

			}
	
	public static HashMap<String,Product> getData() throws SQLException {
		HashMap<String,Product> hm=new HashMap<String,Product>();
         
        String pname = null;
        
        String category=null;
        String condition=null;
        String image=null;
        int price=0;
        String onsale=null;
        String retailer = null;
        int currentCount=0;
        int rebate=0;
        
        
        try {
        		Class.forName("com.mysql.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
    			String getOrders = "SELECT * FROM product";
    			
    			PreparedStatement pst = conn.prepareStatement(getOrders);
    			
    			ResultSet rs=pst.executeQuery(getOrders);
    			while(rs.next())
    			{
    				pname = rs.getString("ProductName");
    				category=rs.getString("Category");
    				condition = rs.getString("ProductCondition");
    				price = rs.getInt("Price");
    				image= rs.getString("ProductImage");
    				retailer = rs.getString("retailer");
    				onsale = rs.getString("OnSale");
    				currentCount = rs.getInt("Quantity");
    				rebate = rs.getInt("Rebate");
    				
    				
    				Product productdetail = new Product(pname,category,price,image,retailer,condition,rebate,currentCount,onsale);
    				hm.put(productdetail.getName(), productdetail);
    			}
    			
    			conn.commit();
    			rs.close();
    			pst.close();
    			conn.close();	        
             
        } catch (Exception ex) {
           
        }      
         
        return hm;
    }

		
}
	  

	

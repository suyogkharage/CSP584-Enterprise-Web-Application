import java.io.*; 
import javax.servlet.*;
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


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
			String getOrders = "SELECT * FROM CustomerOrders WHERE fname='"+fname+"';";
			
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
}
		//wait here
	  

	

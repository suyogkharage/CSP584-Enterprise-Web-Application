import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AjaxUtility {
	static Connection conn = null;
	public static void getConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}	
		
	}
	
	public static HashMap<String,Product> getData() throws SQLException
	{
		HashMap<String,Product> hm = new HashMap<String,Product>();
		getConnection();
		//Statement stmt=conn.createStatement();		
		//////////////////////
		String selectCustomerQuery="select * from productDetail"; 
		
		PreparedStatement pst = conn.prepareStatement(selectCustomerQuery);
		
		ResultSet rs=pst.executeQuery(selectCustomerQuery);
		while(rs.next())
		{
			Product p = new Product(rs.getString("productName"),rs.getString("productName"),rs.getInt("productPrice"),rs.getString("image"),rs.getString("retailer"),"",1,1,"",new ArrayList<Accessory>());
			
			hm.put(rs.getString("productName"), p);
		}
		return hm;
	}
	
	public StringBuffer readdata(String searchId) throws SQLException
	{
		StringBuffer sb = new StringBuffer();
		HashMap<String,Product> data;
		data=getData();
		Iterator it = data.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pi =(Map.Entry)it.next();
			Product p=(Product)pi.getValue();
			if(p.getName().toLowerCase().startsWith(searchId))
			{
				System.out.println(p.getName());
				sb.append("<product>");
				sb.append("<id>"+p.getId()+"</id>");
				sb.append("<productName>"+p.getName()+"</productName>");
				sb.append("</product>");
			}
			
		}
		System.out.println(sb);
		return sb;
	}

}

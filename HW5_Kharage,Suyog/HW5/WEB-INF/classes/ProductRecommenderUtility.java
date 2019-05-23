import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProductRecommenderUtility {
	static Connection conn = null;
    static String message;
    //BufferedReader br = null;	
	public static String getConnection()
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");							
			message="Successfull";
			return message;
		}
		catch(SQLException e)
		{
			 message="unsuccessful";
		     return message;
		}
		catch(Exception e)
		{
			 message="unsuccessful";
		     return message;
		}
	}

	public HashMap<String,String> readOutputFile(){

		String TOMCAT_HOME = System.getProperty("catalina.home");
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
		try {
			System.out.println("Inside readOutputFile");
			 br = new BufferedReader(new FileReader (new File("C:\\apache-tomcat-7.0.34\\webapps\\HW5\\matrixFactorizationBasedRecommendations.csv")));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] prod_recm = line.split(cvsSplitBy,2);
				prodRecmMap.put(prod_recm[0],prod_recm[1]);
            }
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		
		return prodRecmMap;
	}
	
	public static Product getProduct(String product){
		Product prodObj = new Product();
		try 
		{
			System.out.println("Inside getProduct");
			String msg = getConnection();
			String selectProd="select * from  product where ProductName=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(selectProd);
			pst.setString(1,product);
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{	
				prodObj = new Product(rs.getString("ProductName"),rs.getString("Category"),rs.getInt("Price"),rs.getString("ProductImage"),rs.getString("retailer"),rs.getString("ProductCondition"),rs.getInt("Rebate"),rs.getInt("Quantity"),rs.getString("OnSale"));
			}
			rs.close();
			pst.close();
			conn.close();
		}
		catch(Exception e)
		{
		}
		return prodObj;	
	}
}

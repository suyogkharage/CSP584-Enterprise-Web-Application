import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

public class SmartPortablesSerializedDataStore{


	public static SaxParser4SmartPortablesXMLDataStore sxparseobj;
	public static List<Product> products;
	public static List<Accessory> accessories;
	public static HashMap<String, Accessory> Hm_accessories=new HashMap<String, Accessory>();
	public static HashMap<String, Product> Hm_Watches = new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Mobiles = new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Laptops = new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Speakers= new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Earphones=new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Pettrackers=new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_VirtualReality= new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_ExternalStorage= new HashMap<String, Product>();
	public static HashMap<String, Product> Hm_Fitnesswatches= new HashMap<String, Product>();

    public static void populateSerializedDataStore(){
	sxparseobj = new SaxParser4SmartPortablesXMLDataStore("C:/apache-tomcat-7.0.34/webapps/Assignment-2/WEB-INF/productcatalog.xml");
	products = sxparseobj.products;
	accessories= sxparseobj.accessories;
	populateAccessoriesPlatform();
	populateWatchesPlatform();
	populateMobilesPlatform();
	populateLaptopsPlatform();
	populateSpeakersPlatform();
	populateEarphonesPlatform();
	populatePettrackersPlatform();
	//populateVirtualRealityPlatform();
	populateFitnessWatchesPlatform();
	populateExternalStoragePlatform();
	}
	public static void populateAccessoriesPlatform()
	{
		for(Accessory acc: accessories )
		{
			Hm_accessories.put(acc.getName(), acc);
		}
	}
	public static void populateWatchesPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Watches") )
			{
				Hm_Watches.put(prod.getName(),prod);
				}
		}
	}
	
	public static void populateMobilesPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Mobiles"))
			{
			Hm_Mobiles.put(prod.getName(),prod);
			}
		}
	}
	
	public static void populateLaptopsPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Laptops"))
			{
				Hm_Laptops.put(prod.getName(),prod);
			}
		}
	}
	
	public static void populateSpeakersPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Speakers"))
			{
				Hm_Speakers.put(prod.getName(),prod);
			}
		}
	}
	public static void populateEarphonesPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Earphones"))
			{
				Hm_Earphones.put(prod.getName(),prod);
			}
		}
	}
	public static void populatePettrackersPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Pettrackers"))
			{
				Hm_Pettrackers.put(prod.getName(),prod);
			}
		}
	}
	/*public static void 	populateVirtualRealityPlatform();
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Pettrackers"))
			{
				Hm_Pettrackers.put(prod.getName(),prod);
			}
		}
	}*/
	public static void populateFitnessWatchesPlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Fitnesswatches"))
			{
				Hm_Fitnesswatches.put(prod.getName(),prod);
			}
		}
	}
	public static void populateExternalStoragePlatform()
	{
		for(Product prod: products)
		{
			if(prod.getId().equals("Harddrive")||prod.getId().equals("Memorycard"))
			{
				Hm_ExternalStorage.put(prod.getName(),prod);
			}
		}
	}

     

    }
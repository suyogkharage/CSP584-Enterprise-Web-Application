import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

public class SmartPortablesSerializedDataStore{


	public static SaxParser4SmartPortablesXMLDataStore sxparseobj;
	public static List<Console> consoles;
	public static List<Accessory> accessories;
	public static HashMap<String, Accessory> Hm_accessories=new HashMap<String, Accessory>();
	public static HashMap<String, Console> Hm_Watches = new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Mobiles = new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Laptops = new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Speakers= new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Earphones=new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Pettrackers=new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_VirtualReality= new HashMap<String, Console>();
	public static HashMap<String, Console> Hm_Fitnesswatches= new HashMap<String, Console>();
	

    public static void populateSerializedDataStore(){
	sxparseobj = new SaxParser4SmartPortablesXMLDataStore("C:/apache-tomcat-7.0.34/webapps/Assignment-1/WEB-INF/ProductCatalog.xml");
	consoles = sxparseobj.consoles;
	accessories= sxparseobj.accessories;
	populateAccessoriesPlatform();
	populateWatchesPlatform();
	populateMobilesPlatform();
	populateLaptopsPlatform();
	populateSpeakersPlatform();
	populateEarphonesPlatform();
	populatePettrackersPlatform();
	populateVirtualRealityPlatform();
	populateFitnessWatchesPlatform();
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
		for(Console con: consoles)
		{
			if(con.getId().equals("Watches") )
			{
				Hm_Watches.put(con.getName(),con);
				}
		}
	}
	
	public static void populateMobilesPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Mobiles"))
			{
			Hm_Mobiles.put(con.getName(),con);
			}
		}
	}
	
	public static void populateLaptopsPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Laptops"))
			{
				Hm_Laptops.put(con.getName(),con);
			}
		}
	}
	
	public static void populateSpeakersPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Speakers"))
			{
				Hm_Speakers.put(con.getName(),con);
			}
		}
	}
	public static void populateEarphonesPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Earphones"))
			{
				Hm_Earphones.put(con.getName(),con);
			}
		}
	}
	public static void populatePettrackersPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Pettrackers"))
			{
				Hm_Pettrackers.put(con.getName(),con);
			}
		}
	}
	public static void populateFitnessWatchesPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Fitnesswatches"))
			{
				Hm_Fitnesswatches.put(con.getName(),con);
			}
		}
	}
	public static void populateVirtualRealityPlatform()
	{
		for(Console con: consoles)
		{
			if(con.getId().equals("Harddrive")||con.getId().equals("Memorycard"))
			{
				Hm_VirtualReality.put(con.getName(),con);
			}
		}
	}

     

    }
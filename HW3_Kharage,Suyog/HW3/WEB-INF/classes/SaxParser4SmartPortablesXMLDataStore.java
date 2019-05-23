

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




public class SaxParser4SmartPortablesXMLDataStore extends DefaultHandler {
    Product product;
	Accessory accessory;
    List<Product> products;
	List<Accessory> accessories;
    String productXmlFileName;
    String elementValueRead;
	String id;

    
    public SaxParser4SmartPortablesXMLDataStore(String productXmlFileName) {
        this.productXmlFileName = productXmlFileName;
        products = new ArrayList<Product>();
		accessories= new ArrayList<Accessory>();
        parseDocument();
        
    }


    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
			System.out.println(productXmlFileName);
            SAXParser parser = factory.newSAXParser();
            parser.parse(productXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }


    


    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException
	{
		if (elementName.equalsIgnoreCase("productcategory")) {
        	id=attributes.getValue("id");
        }
        if(elementName.equalsIgnoreCase("product")) {
        	product = new Product();
        	if(attributes.getValue("id")!=null)
        		id=attributes.getValue("id");
        	product.setId(id);
        }
        if(elementName.equalsIgnoreCase("a_accessory")) {
        	accessory = new Accessory();
        }
        if(elementName.equalsIgnoreCase("a_name")) {
        	accessory.setName(attributes.getValue("a_name"));
        }
        if(elementName.equalsIgnoreCase("a_price")) {
        	//System.out.println(attributes.getValue("a_price"));
        	//accessory.setPrice(Double.parseDouble(attributes.getValue("a_price")));
        }
        
        if(elementName.equalsIgnoreCase("a_retailer")) {
        	accessory.setRetailer(attributes.getValue("a_retailer"));
        }
                
        if(elementName.equalsIgnoreCase("name")) {
        	//System.out.println(attributes.getValue("name"));
        	product.setName(attributes.getValue("name"));
        }
        if(elementName.equalsIgnoreCase("price")) {
        	//console.setPrice(Double.parseDouble(attributes.getValue("price")));
        }
        
        if(elementName.equalsIgnoreCase("retailer")) {
        	product.setRetailer(attributes.getValue("retailer"));
        }
        
        if(elementName.equalsIgnoreCase("accessory")){
        	String acc_name=attributes.getValue("accessory");
        }
      
	}

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
 
        if (element.equals("product")) {
            products.add(product);
	    return;
        }
        if (element.equals("productcategory")) {
	    return;
        }
        if (element.equals("a_accessory")) {
        	accessories.add(accessory);
    	    return;
        }
        if (element.equals("a_accessories")) {
    	    return;
        }
        if (element.equalsIgnoreCase("a_image")) {
            accessory.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("a_name")) {
            accessory.setName(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("a_price")){
            accessory.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
        if(element.equalsIgnoreCase("a_retailer")){
            accessory.setRetailer(elementValueRead);
	    return;
        }
        
        if (element.equalsIgnoreCase("image")) {
            product.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("id")) {
            product.setId(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("name")) {
            product.setName(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("accessory")){
        	String acc_name=elementValueRead;
        	for(Accessory accessory: accessories)
        	{
        		if(accessory.getName().equals(acc_name))
        		{
        			product.accessories.add(accessory);
        		}
        	}	
	    return;
        }
        if(element.equalsIgnoreCase("price")){
        	//System.out.println(elementValueRead);
            product.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
        if(element.equalsIgnoreCase("retailer")){
            product.setRetailer(elementValueRead);
	    return;
        }


    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


  
}

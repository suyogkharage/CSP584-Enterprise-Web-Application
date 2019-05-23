
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

//mayur
	
	public class Cart {
		 
	
		HashMap<String, List<Integer>> cartItems;
				 
	    public Cart(){
	     cartItems = new HashMap<String, List<Integer>>();
	      
	    }
	    public HashMap getCartItems(){
	        return cartItems;
	    }
	   public void addToCart(String itemId, int price){
	    	List<Integer> a = new ArrayList<Integer>();
	    	a.add(price);
	    	//a.add(retailer);
	    	cartItems.put(itemId, a);
	    }
	     
	public void deleteFromCart(String itemId){
	        cartItems.remove(itemId);
	    }

	}



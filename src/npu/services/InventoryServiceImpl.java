package npu.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import npu.domain.Order;
import npu.domain.OrderItem;
import npu.domain.Product;

@Service("inventoryServiceImpl")
public class InventoryServiceImpl implements InventoryService{
	private static Map<Product, Integer> inventoryMap;

/*	public InventoryServiceImpl(){
		init();
	}*/
	
	@PostConstruct
	public void init(){
		inventoryMap = new HashMap<Product, Integer>();
		
		Product prod = new Product("coffee mug", 2.25, "CW-COMUG-12345");
		inventoryMap.put(prod, 500);
		
		prod = new Product("paper napkins", 1.99, "PP-WNAPK-32154");
		inventoryMap.put(prod, 670);
		
		prod = new Product("water bottle", 4.98, "SW-WBOT-54566");
		inventoryMap.put(prod, 132);
		
		prod = new Product("Lenovo lapotp T420i", 550.00, "EX-LLAP-45687");
		inventoryMap.put(prod, 55);
		
		prod = new Product("Microsoft Office Prof Ed", 325.50, "SW-MSO-64889");
		inventoryMap.put(prod, 57);
	}
	
	@Override
	public void adjustInventory(Order order) {
		List<OrderItem> orderItems = order.getOrderItems();
		OrderItem currentOrderItem;
		int numItems = orderItems.size();
		Product currentProduct;
		int currentQuantityOrdered;
		
		for(int i=0; i<numItems; i++){
			currentOrderItem = orderItems.get(i);
			currentProduct = currentOrderItem.getProduct();
			currentQuantityOrdered = currentOrderItem.getQuantity();
			
			subtractQuantInventoryMap(currentProduct, currentQuantityOrdered);
		}
		
	}
	
	@PreDestroy
	public void printCurrentInventory(){
		System.out.println("----------------------Current Inventory----------------------");
		//get KeySet
		Set<Product> keySet = inventoryMap.keySet();
		//get iterator for the keySet
		Iterator<Product> keyIter = keySet.iterator();
		//iterate through each and print
		Product currProd;
		while(keyIter.hasNext()){
			currProd = keyIter.next();
			System.out.println(currProd + "\t Quantity: " + inventoryMap.get(currProd));
		}
		System.out.println("-------------------------------------------------------------");
	}
	
	private void subtractQuantInventoryMap(Product prod, int quantityOrdered){
		Integer quantityAvlble = inventoryMap.get(prod);
		quantityAvlble = quantityAvlble - quantityOrdered;
		inventoryMap.put(prod, quantityAvlble);
	}

}

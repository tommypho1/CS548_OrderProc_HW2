package npu.client;
import npu.domain.*;
import npu.services.InventoryService;
import npu.services.InventoryServiceImpl;
import npu.services.OrderProcessor;

import org.springframework.context.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main(String args[]) {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		Order order;
		
		//instantiate objects to build an Order
		Customer customer = new Customer("John Smith", 7568, "CA");
		Product prod1 = new Product("paper napkins", 1.99, "PP-WNAPK-32154");
		Product prod2 = new Product("Lenovo lapotp T420i", 550.00, "EX-LLAP-45687");
		Product prod3 = new Product("water bottle", 4.98, "SW-WBOT-54566");
		OrderItem orderItem1 = new OrderItem(prod1, 10);
		OrderItem orderItem2 = new OrderItem(prod2, 2);
		OrderItem orderItem3 = new OrderItem(prod3, 4);
		
		//create order
		order = new Order("GSX-56789");
		order.setCustomer(customer);
		
		//add items
		order.addItem(orderItem1);
		order.addItem(orderItem2);
		order.addItem(orderItem3);
		//remove item
		order.removeProduct(prod2);
		//add more quantity of a product
		OrderItem orderItem4 = new OrderItem(prod1, 10);
		order.addItem(orderItem4);
		
		OrderProcessor orderProc = (OrderProcessor) container.getBean("orderProc");
		InventoryService invService = (InventoryService) container.getBean("inventoryServiceImpl");
		
		
		//still calling this printInventory() as this is before order is processed
		invService.printCurrentInventory();
		orderProc.newOrder(order);
		//shudown gracefully, call destroy methods
		container.close();
	}
}

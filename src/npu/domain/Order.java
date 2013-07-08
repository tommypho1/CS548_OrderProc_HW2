package npu.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private String code;
	private Customer customer;
	private List<OrderItem> orderItems;
	private double subTotal;
	private double tax;
	private double total;
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	public Order(String newOrderCode) {
		code = newOrderCode;
	}
	
	// add item to order
	public void addItem(OrderItem item){
		System.out.println(String.format("Adding item...  %-25s" + "  quantity: " + item.getQuantity(), item.getProduct().getName()));
		boolean found = false;
		
		if(orderItems == null){
			orderItems = new ArrayList<OrderItem>();
		}
		
		for(OrderItem currentItem: orderItems){
			//if item already exists
			if(currentItem.isSameProduct(item)){
				//then merge it
				currentItem.setQuantity(currentItem.getQuantity() + item.getQuantity());
				found = true;
			}
		}

		
		//if item does not exist, add it
		if(found == false){	
			orderItems.add(item);
		}
		//update subTotal
		subTotal = subTotal + (item.getItemTotalPrice());
	}
	
	public void removeProduct(Product prod){
		System.out.println(String.format("Removing product...  prod: %-25s" , prod));
		for(OrderItem currentItem: orderItems){
			if(currentItem.getProduct().equals(prod)){
				orderItems.remove(currentItem);
				//update subTotal
				subTotal = subTotal - (currentItem.getItemTotalPrice());
			}
		}
	}
	
	public void printTax(){
		String taxStr = formatter.format(tax);
		System.out.println("Current Tax for this order is: " + taxStr);
	}
	
	public void printSubTotal(){
		String subTotalStr = formatter.format(subTotal);
		System.out.println("Current SubTotal for this order is: " + subTotalStr);
	}
	
	public void printTotal(){
		String totalStr = formatter.format(total);
		System.out.println("Current total for this order is: " + totalStr);
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
}

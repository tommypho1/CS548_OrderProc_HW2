package npu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import npu.domain.*;

@Service("orderProc")
public class OrderProcessor {
	@Autowired
	@Qualifier("acctServiceIntlRules")
	private AccountingService acctService;
	@Autowired
	private InventoryService invService;
	
	public InventoryService getInvService() {
		return invService;
	}
	
	public void setInvService(InventoryService invService) {
		this.invService = invService;
	}
	
	public AccountingService getAcctService() {
		return acctService;
	}

	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}
	
	public OrderProcessor() {
	}
	
	public void newOrder(Order order) {
		//acctService.recordNewOrder(order);
		double tax = acctService.computeTax(order);
		order.setTax(tax);
		order.setTotal(tax + order.getSubTotal());
		invService.adjustInventory(order);
		order.printTax();
		order.printSubTotal();
		order.printTotal();
	}
}
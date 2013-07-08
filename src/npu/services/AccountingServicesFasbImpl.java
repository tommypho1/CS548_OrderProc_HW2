package npu.services;

import npu.domain.Order;

public class AccountingServicesFasbImpl implements AccountingService {
	private TaxService taxService;

	@Override
	public void recordNewOrder(Order order) {
		System.out.println("Applying FASB Accounting Rules");
		return;
	}
	
	@Override
	public double computeTax(Order order){
		return taxService.computeTax(order);
	}

}

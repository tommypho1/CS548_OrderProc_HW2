package npu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import npu.domain.Order;

@Service("acctServiceIntlRules")
public class AccountingServiceIntlRules implements AccountingService {
	@Autowired
	private TaxService taxService;
	
	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

	@Override
	public void recordNewOrder(Order order) {
		System.out.println("Applying International Accounting Rules");
		return;
	}

	@Override
	public double computeTax(Order order) {
		return taxService.computeTax(order);
	}
}

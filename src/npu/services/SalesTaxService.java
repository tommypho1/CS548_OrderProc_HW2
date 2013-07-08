package npu.services;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import npu.domain.Order;

@Service("salesTax")
public class SalesTaxService implements TaxService {
	@Resource(name="salesTaxMap")
	private Map<String, Double> salesTaxPercentageMap;
	
	public Map<String, Double> getSalesTaxPercentageMap() {
		return salesTaxPercentageMap;
	}

	public void setSalesTaxPercentageMap(Map<String, Double> salesTaxPercentageMap) {
		this.salesTaxPercentageMap = salesTaxPercentageMap;
	}

	@Override
	public double computeTax(Order order) {
		String state = order.getCustomer().getState();
		double stateTaxRate = salesTaxPercentageMap.get(state);
		double subTotal = order.getSubTotal();
		
		return (subTotal * stateTaxRate);
	}

}

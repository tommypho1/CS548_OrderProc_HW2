package npu.services;

import npu.domain.Order;

public interface TaxService {
	double computeTax(Order order);
}

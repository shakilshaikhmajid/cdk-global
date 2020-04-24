package com.cdkglobal.discount.service;

import java.util.List;

import com.cdkglobal.discount.dto.PurchaseInfo;
import com.cdkglobal.discount.exception.NoCustomerTypeFoundException;
import com.cdkglobal.discount.model.DiscountRange;

public interface DiscountService {

	PurchaseInfo calculateDiscount(PurchaseInfo purchaseInfo) throws NoCustomerTypeFoundException;

	public DiscountRange addDiscountRange(DiscountRange discountRange);

	public List<DiscountRange> addAllDiscountRange(List<DiscountRange> discountRanges);

	public List<DiscountRange> listDiscountRange(String customerType);
}

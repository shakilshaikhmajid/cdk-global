package com.cdkglobal.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkglobal.discount.DiscountRangeDAO;
import com.cdkglobal.discount.dto.PurchaseInfo;
import com.cdkglobal.discount.exception.NegativeOrZeroAmountException;
import com.cdkglobal.discount.exception.NoCustomerTypeFoundException;
import com.cdkglobal.discount.model.DiscountRange;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	DiscountRangeDAO discountRangeDAO;

	@Override
	public PurchaseInfo calculateDiscount(PurchaseInfo purchaseInfo){
		if(purchaseInfo.getPurchaseAmount()<=0)
		{
			throw new NegativeOrZeroAmountException("The Purchase Amount Should Not Be Zero Or Negative");
		}
		
		List<DiscountRange> discountRangeList = discountRangeDAO.findAllByCustomerType(purchaseInfo.getCustomerType());
		// TODO Auto-generated method stub
		if(discountRangeList.size()==0)
		{
			throw new NoCustomerTypeFoundException("Given customer type:"+purchaseInfo.getCustomerType()+" is not found");
		}
		System.out.println(discountRangeList);
		calculateDiscountAndFinalAmount(purchaseInfo, discountRangeList);
		return purchaseInfo;
	}

	private void calculateDiscountAndFinalAmount(PurchaseInfo purchaseInfo, List<DiscountRange> discountRangeList) {
		// TODO Auto-generated method stub
		double discount = 0;
		for (DiscountRange range : discountRangeList) {
			if (purchaseInfo.getPurchaseAmount() >= range.getMinRange()) {
				if (range.getIsMaxAmountSet().equalsIgnoreCase("Y")) {
					if (purchaseInfo.getPurchaseAmount() <= range.getMaxRange()) {
						discount = discount + (((purchaseInfo.getPurchaseAmount() - range.getMinRange())
								* range.getDiscountPercent()) / 100);

					} else {
						discount = discount
								+ (((range.getMaxRange() - range.getMinRange()) * range.getDiscountPercent())
										/ 100);

					}
				} else if (range.getIsMaxAmountSet().equalsIgnoreCase("N")) {
					discount = discount + (((purchaseInfo.getPurchaseAmount() - range.getMinRange() )
							* range.getDiscountPercent()) / 100);

				}
			}
		}
		purchaseInfo.setDiscountAmount(discount);

		purchaseInfo.setBillAmount(purchaseInfo.getPurchaseAmount() - discount);

	}

	@Override
	public DiscountRange addDiscountRange(DiscountRange discountRange) {
		// TODO Auto-generated method stub
		return discountRangeDAO.saveAndFlush(discountRange);

	}

	@Override
	public List<DiscountRange> listDiscountRange(String customerType) {
		// TODO Auto-generated method stub
		return discountRangeDAO.findAllByCustomerType(customerType);
		
		
	}

	@Override
	public List<DiscountRange>  addAllDiscountRange(List<DiscountRange> discountRanges) {
		// TODO Auto-generated method stub
		return discountRangeDAO.saveAll(discountRanges);
		//return null;
	}

}

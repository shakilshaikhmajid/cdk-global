package com.cdkglobal.discount.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountRange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discountRangeId;
	private String customerType;
	private double minRange;
	private double maxRange;
	private double discountPercent;
	private String isMaxAmountSet;
	public int getDiscountRangeId() {
		return discountRangeId;
	}
	public void setDiscountRangeId(int discountRangeId) {
		this.discountRangeId = discountRangeId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public double getMinRange() {
		return minRange;
	}
	public void setMinRange(double minRange) {
		this.minRange = minRange;
	}
	public double getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getIsMaxAmountSet() {
		return isMaxAmountSet;
	}
	public void setIsMaxAmountSet(String isMaxAmountSet) {
		this.isMaxAmountSet = isMaxAmountSet;
	}
	@Override
	public String toString() {
		return "DiscountRange [discountRangeId=" + discountRangeId + ", customerType=" + customerType + ", minRange="
				+ minRange + ", maxRange=" + maxRange + ", discountPercent=" + discountPercent + ", isMaxAmountSet="
				+ isMaxAmountSet + "]";
	}
	public DiscountRange(int discountRangeId, String customerType, double minRange, double maxRange,
			double discountPercent, String isMaxAmountSet) {
		super();
		this.discountRangeId = discountRangeId;
		this.customerType = customerType;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.discountPercent = discountPercent;
		this.isMaxAmountSet = isMaxAmountSet;
	}
	public DiscountRange() {
		super();
	}
	
}

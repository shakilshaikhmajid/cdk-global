package com.cdkglobal.discount.dto;

public class PurchaseInfo {
	
	private String customerType;
	private double purchaseAmount;
	private double discountAmount;
	private double billAmount;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "PurchaseInfo [customerType=" + customerType + ", purchaseAmount=" + purchaseAmount + ", discountAmount="
				+ discountAmount + ", billAmount=" + billAmount + "]";
	}
	public PurchaseInfo() {
		super();
	}
	

}

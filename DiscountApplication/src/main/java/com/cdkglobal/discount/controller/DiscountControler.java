package com.cdkglobal.discount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cdkglobal.discount.dto.PurchaseInfo;
import com.cdkglobal.discount.model.DiscountRange;
import com.cdkglobal.discount.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountControler {

	@Autowired
	DiscountService discountService;

//	@RequestMapping(value = "/demo", method = RequestMethod.GET)
//	public String message() {
//		return "Hello";
//	}

	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	public ResponseEntity<PurchaseInfo> calculateDiscount(@RequestBody PurchaseInfo purchaseInfo) {

		discountService.calculateDiscount(purchaseInfo);
		return new ResponseEntity<PurchaseInfo>(purchaseInfo, HttpStatus.OK);

	}

	@RequestMapping(value = "/discount-slabs", method = RequestMethod.GET)
	public List<DiscountRange> listRange(@RequestParam("customerType") String customerType) {
		
		return discountService.listDiscountRange(customerType);

	}

	
	@RequestMapping(value = "/discount-slab-range", method = RequestMethod.POST)
	public DiscountRange addRange(@RequestBody DiscountRange discountRange) {
		// return discountRange;
		return discountService.addDiscountRange(discountRange);
	}
	
	@RequestMapping(value = "/discount-slabs", method = RequestMethod.POST)
	public List<DiscountRange> addAllRange(@RequestBody List<DiscountRange>discountRanges) {
		// return discountRange;
		return discountService.addAllDiscountRange(discountRanges);
	}
}

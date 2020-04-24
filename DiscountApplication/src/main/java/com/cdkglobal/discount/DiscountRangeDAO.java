package com.cdkglobal.discount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdkglobal.discount.model.DiscountRange;

@Repository

public interface DiscountRangeDAO extends JpaRepository<DiscountRange, Integer> {

	List<DiscountRange> findAllByCustomerType(String customerType);
	
}

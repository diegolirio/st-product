package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection="products")
public class Product {

	@Id
	private String id;
	private String code;
	private String description;
	private double valueUnit;
	private ProductType productType;
	//private List<OrdersProducts> ordersProducts;
	private boolean active;

}

package com.diegolirio.st.domain.orm;

import org.hibernate.validator.constraints.NotBlank;
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
	@NotBlank
	private String code;
	@NotBlank
	private String description;
	private double valueUnit;
	private ProductType productType;
	//private List<OrdersProducts> ordersProducts;
	private boolean active;

}

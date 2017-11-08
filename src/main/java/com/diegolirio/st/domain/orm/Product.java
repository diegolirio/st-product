package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {

	@Id
	private String id;
	private String code;
	private String description;
	private double valueUnit;
	private ProductType productType;
	//private List<OrdersProducts> ordersProducts;
	private boolean active = true;

	public Product() {}
	
	public Product(String code, String description, double valueUnit, ProductType productType) {
		this.code = code;
		this.description = description;
		this.valueUnit = valueUnit;
		this.productType = productType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public double getValueUnit() {
		return valueUnit;
	}

	public ProductType getProductType() {
		return productType;
	}

	public boolean isActive() {
		return active;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setValueUnit(double valueUnit) {
		this.valueUnit = valueUnit;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}

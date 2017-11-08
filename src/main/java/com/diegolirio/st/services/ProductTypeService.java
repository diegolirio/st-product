package com.diegolirio.st.services;

import java.util.List;

import com.diegolirio.st.domain.orm.ProductType;

public interface ProductTypeService {

	ProductType save(ProductType productType);

	List<ProductType> findAll();

}

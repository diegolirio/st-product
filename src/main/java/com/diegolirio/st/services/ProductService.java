package com.diegolirio.st.services;

import java.util.List;

import com.diegolirio.st.domain.orm.Product;

public interface ProductService {

	Product findByCode(String code);

	List<Product> findAll();

	Product save(Product product);

}

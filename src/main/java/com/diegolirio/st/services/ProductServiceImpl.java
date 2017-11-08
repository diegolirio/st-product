package com.diegolirio.st.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByCode(String code) {
		return this.productRepository.findByCode(code);
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return this.productRepository.save(product);
	}

}

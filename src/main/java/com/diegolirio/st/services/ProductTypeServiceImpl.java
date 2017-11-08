package com.diegolirio.st.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.ProductType;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductType save(ProductType productType) {
		return this.productTypeRepository.save(productType);
	}

	@Override
	public List<ProductType> findAll() {
		return this.productTypeRepository.findAll();
	}

}

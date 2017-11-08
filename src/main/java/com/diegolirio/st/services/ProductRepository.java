package com.diegolirio.st.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.Product;

@Repository
interface ProductRepository extends MongoRepository<Product, String> {

	Product findByCode(String code);

}

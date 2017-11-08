package com.diegolirio.st.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.ProductType;

@Repository
interface ProductTypeRepository extends MongoRepository<ProductType, String> {

}

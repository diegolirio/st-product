package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.ProductType;
import com.diegolirio.st.services.ProductTypeService;

@RestController
@RequestMapping(value=ProductTypeApiRestController.URL)
public class ProductTypeApiRestController {

	public static final String URL = "/api/v1/product-type";
	
	@Autowired
	private ProductTypeService productTypeService;

	@PostMapping
	public ResponseEntity<ProductType> save(@RequestBody ProductType productType) {
		return new ResponseEntity<ProductType>(this.productTypeService.save(productType), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductType>> findAll() {
		return new ResponseEntity<List<ProductType>>(this.productTypeService.findAll(), HttpStatus.OK);
	}
}

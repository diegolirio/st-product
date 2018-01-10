package com.diegolirio.st.apis.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.st.domain.orm.Product;
import com.diegolirio.st.services.ProductService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(value="ProductApi")
@RequestMapping(ProductApiRestController.URL)
public class ProductApiRestController {

	public static final String URL = "/api/v1/product";
	
	@Autowired
	private ProductService productService;

	@GetMapping("/code/{code}") 
	public ResponseEntity<Product> findByCodigo(@PathVariable("code") String code) {
		return new ResponseEntity<Product>(this.productService.findByCode(code), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return new ResponseEntity<List<Product>>(this.productService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<Product>(this.productService.save(product), HttpStatus.OK);
	}
	
}

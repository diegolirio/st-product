package com.diegolirio.st.domain.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

/**
 * Caixa, Unidade, Peça
 * @author ddamaceno
 */
@Getter
@Builder
@Document(collection="productsTypes")
public class ProductType {

	@Id
	private String id;
	private String description;

}

package com.diegolirio.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages= {"com.diegolirio.st"})
//@EntityScan(basePackages={"com.diegolirio.dt.domain.orm"})
//@EnableTransactionManagement // Habilitado Gerenciamento de transações, para os metodo nas services como @Transation
public class StProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(StProductApplication.class, args);
	}
}

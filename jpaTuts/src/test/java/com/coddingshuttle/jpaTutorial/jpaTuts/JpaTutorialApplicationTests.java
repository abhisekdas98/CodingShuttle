package com.coddingshuttle.jpaTutorial.jpaTuts;

import com.coddingshuttle.jpaTutorial.jpaTuts.entities.Product;
import com.coddingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product productEntity = Product.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(124.872))
				.quantity(12)
				.build();
		Product savedProduct = productRepository.save(productEntity);
		System.out.println(savedProduct);
	}

}

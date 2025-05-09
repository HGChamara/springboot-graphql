package com.givantha.graphql;

import com.givantha.graphql.entity.Product;
import com.givantha.graphql.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphqlApplication {

	@Autowired
	private ProductRepository productRepository;

	//@PostConstruct
	public void initDB() {
		List<Product> products = Stream.of(
				new Product("Laptop", "Electronics", 75000.00F, 12),
				new Product("TV", "Electronics", 25000.00F, 6),
				new Product("Monitor", "Electronics", 65000.00F, 8)
		).toList();
		productRepository.saveAll(products);
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}

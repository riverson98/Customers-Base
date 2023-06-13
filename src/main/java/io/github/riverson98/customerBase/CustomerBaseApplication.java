package io.github.riverson98.customerBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class CustomerBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerBaseApplication.class, args);
	}

}

package com.example.demo;

import com.example.demo.web.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.demo.persistence")
@EntityScan("com.example.demo.persistence")
@ComponentScans({
		@ComponentScan(basePackages = "com.example.demo.web"),
		@ComponentScan(basePackages = "com.example.demo.service")
})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

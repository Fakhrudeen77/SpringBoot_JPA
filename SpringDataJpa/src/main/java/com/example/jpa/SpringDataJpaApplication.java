package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.example.jpa.entity.Product;

@SpringBootApplication
//@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
//@PropertySource(“product.properties”)
@PropertySource("classpath:product.properties")

public class SpringDataJpaApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		try {
			ApplicationContext applicationContext=SpringApplication.run(SpringDataJpaApplication.class, args);
			Product product= applicationContext.getBean("product", Product.class);
		    System.out.println(product);
			
		}
		catch(Exception e) {
			
		}
	}
	
	
	  @Override
	    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringDataJpaApplication.class);
	    }

}

package com.Dotsquares.EMPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class EmpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpsApplication.class);
	}
	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/jsp/");
		r.setSuffix(".jsp");
		return r;
	}
}

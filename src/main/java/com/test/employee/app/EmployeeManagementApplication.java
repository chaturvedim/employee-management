package com.test.employee.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.test.employee.web.EmployeeRestApi;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Import(EmployeeManagementApplication.Config.class)
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Configuration
	static class Config {

		@Bean
		public EmployeeRestApi employeeRestApi() {
			return new EmployeeRestApi();
		}
	}
}

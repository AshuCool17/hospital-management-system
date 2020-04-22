package com.services.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.services.model.Patient;

@Import({ ApplicationConfig.class })
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class} )
@ComponentScan(basePackages = { "com.services.service", "com.services.controller", "com.services.model", "com.services.repository"})
@EnableJpaRepositories("com.services.repository")
@EnableTransactionManagement
@EntityScan(basePackageClasses=Patient.class)
public class HospitalMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalMgmtApplication.class, args);
	}

}

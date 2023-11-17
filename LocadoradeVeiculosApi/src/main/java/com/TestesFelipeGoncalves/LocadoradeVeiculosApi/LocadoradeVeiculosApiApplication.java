package com.TestesFelipeGoncalves.LocadoradeVeiculosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.TestesFelipeGoncalves.Repository")
@ComponentScan(basePackages={"com.TestesFelipeGoncalves.Service","com.TestesFelipeGoncalves.Controller","\"com.TestesFelipeGoncalves.entity"})
@EntityScan(basePackages= "com.TestesFelipeGoncalves.entity")
@EnableJpaAuditing

public class LocadoradeVeiculosApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocadoradeVeiculosApiApplication.class, args);
	}

}
	
	
	


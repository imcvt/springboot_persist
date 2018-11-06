package com.imc.springboot_persist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.imc")
@EntityScan("com.imc.model")
@EnableJpaRepositories("com.imc.repository")
@MapperScan("com.imc.dao")
public class SpringbootPersistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPersistApplication.class, args);
	}
}

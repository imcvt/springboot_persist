package com.imc.springboot_persist;

import com.imc.mq.Msg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.core.JmsTemplate;

import javax.persistence.Entity;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.imc")
@EntityScan("com.imc.model")
@EnableJpaRepositories("com.imc.repository")
@MapperScan("com.imc.dao")
public class SpringbootPersistApplication{

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPersistApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		jmsTemplate.send("my-destination",new Msg());
//	}
}

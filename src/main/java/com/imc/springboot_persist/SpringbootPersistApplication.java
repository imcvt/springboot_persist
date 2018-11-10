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
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.imc")
@EntityScan("com.imc.model")
@EnableJpaRepositories("com.imc.repository")
@MapperScan("com.imc.dao")
public class SpringbootPersistApplication implements CommandLineRunner{

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		//正常启动
		SpringApplication.run(SpringbootPersistApplication.class, args);

		//自定义端口启动
//		SpringApplication application = new SpringApplication(SpringbootPersistApplication.class);
//		application.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
//		application.run(args);

		//其他启动方式还有1、portconfig包下自定义配置 2、application.properties设置server.port
		// 3、java -jar xxx.jar --server.port=9093 或者 java -jar -Dserver.port=9093 xxx.jar
	}

	/**
	 * 实现CommandLineRunner并重写此方法，方法会在springboot启动时执行
	 * 或者实现ApplicationRunner并重写run方法
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("springboot启动时执行："+sdf.format(new Date()));
//		jmsTemplate.send("my-destination",new Msg());
	}
}

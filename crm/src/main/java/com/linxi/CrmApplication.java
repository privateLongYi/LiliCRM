package com.linxi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@MapperScan("com.linxi.mapper")
@Slf4j
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class CrmApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext application = SpringApplication.run(CrmApplication.class, args);

		Environment env = application.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Login: \thttp://{}:{}/LiLiCRM/login.html\n\t" +
						"Doc: \thttp://{}:{}/LiLiCRM/doc.html\n" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));
	}

}

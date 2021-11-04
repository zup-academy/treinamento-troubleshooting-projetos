package br.com.zup.edu.pixkeymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PixKeyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixKeyManagerApplication.class, args);
	}

}

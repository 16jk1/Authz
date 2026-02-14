package com.example.auth;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		// Load .env into system properties so ${JWT_SECRET} etc. work in application.yaml
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		if (dotenv != null) {
			dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
		}
		SpringApplication.run(AuthApplication.class, args);
	}

}

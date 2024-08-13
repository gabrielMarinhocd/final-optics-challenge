package br.com.gabrielmsantos.optics;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication(scanBasePackages = "br.com.gabrielmsantos.optics")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

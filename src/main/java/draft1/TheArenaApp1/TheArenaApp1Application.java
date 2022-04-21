package draft1.TheArenaApp1;

import draft1.TheArenaApp1.config.SwaggerConfig;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.spring.web.plugins.Docket;



@SpringBootApplication

public class TheArenaApp1Application {

	public TheArenaApp1Application()  {
	}

	public static void main(String[] args) {
		SpringApplication.run(TheArenaApp1Application.class, args);
	}

	Docket swaggerConfig = new SwaggerConfig().api();

}
//http://localhost:8080/swagger-ui.html
//https://arenahalisaha.azurewebsites.net/swagger-ui.html#/pitches-controller
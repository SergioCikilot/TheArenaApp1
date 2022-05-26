package draft1.TheArenaApp1;

import draft1.TheArenaApp1.config.SwaggerConfig;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.spring.web.plugins.Docket;



@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "draft1.TheArenaApp1.repository.search")
//@EnableJpaRepositories(basePackages = "draft1.TheArenaApp1.repository.jparepository")
public class TheArenaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(TheArenaApp1Application.class, args);
	}

	Docket swaggerConfig = new SwaggerConfig().api();






}
//http://localhost:8080/swagger-ui.html
//https://arenahalisaha.azurewebsites.net/swagger-ui.html#/
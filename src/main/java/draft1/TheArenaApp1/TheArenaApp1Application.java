package draft1.TheArenaApp1;

import draft1.TheArenaApp1.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TheArenaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(TheArenaApp1Application.class, args);
	}

	Docket swaggerConfig = new SwaggerConfig().api();

}
//http://localhost:8080/swagger-ui.html
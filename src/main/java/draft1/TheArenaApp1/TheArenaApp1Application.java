package draft1.TheArenaApp1;

import draft1.TheArenaApp1.config.JdbcConfig;
import draft1.TheArenaApp1.config.SwaggerConfig;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import springfox.documentation.spring.web.plugins.Docket;

import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication

public class TheArenaApp1Application {

	public TheArenaApp1Application() throws SQLException {
	}

	public static void main(String[] args) {
		SpringApplication.run(TheArenaApp1Application.class, args);
	}

	//JdbcConfig jdbcConfig = new JdbcConfig();

	Docket swaggerConfig = new SwaggerConfig().api();

}
//http://localhost:8080/swagger-ui.html
//https://arenahalisaha.azurewebsites.net/swagger-ui.html#/pitches-controller
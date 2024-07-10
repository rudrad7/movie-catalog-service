package com.cg;

/*#Post gtes DB Indo
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
# Hibernate
#hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect
#hibernate.show_sql: true
#hibernate.hbm2ddl.auto: update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
 *  * 
 * */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieCatlogP2Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatlogP2Application.class, args);
		System.out.println(" Movie CatlogP2 started on 8082 ");
	}

}

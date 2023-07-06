package pl.isa.backendBoys.zgubaAppWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;

import java.sql.SQLException;

@SpringBootApplication
public class ZgubaAppApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		JsonService.importToSql();
		System.out.println("--------------------------------------------------");
		SpringApplication.run(ZgubaAppApplication.class, args);
	}

}

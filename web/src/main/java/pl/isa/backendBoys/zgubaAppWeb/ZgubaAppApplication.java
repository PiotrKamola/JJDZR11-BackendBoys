package pl.isa.backendBoys.zgubaAppWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import pl.isa.backendBoys.zgubaAppWeb.Repository.RequestRepository;
import pl.isa.backendBoys.zgubaAppWeb.Repository.UserRepository;
import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.sql.SQLException;

@SpringBootApplication
public class ZgubaAppApplication {
	public static void main(String[] args){

		SpringApplication.run(ZgubaAppApplication.class, args);
	}

}

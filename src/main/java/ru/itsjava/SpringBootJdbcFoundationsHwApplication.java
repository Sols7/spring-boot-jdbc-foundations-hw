package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.services.UserService;


import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsHwApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsHwApplication.class, args);
		context.getBean(UserService.class).insert(new User("newU", 25, new Pet(1L, "newPet")));

		Console.main(args);
	}

}

package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsHwApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsHwApplication.class, args);

		Console.main(args);
	}

}

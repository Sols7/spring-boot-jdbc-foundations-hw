package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.dao.UserDao;
import ru.itsjava.domain.User;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsHwApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsHwApplication.class, args);

		UserDao userDao = context.getBean(UserDao.class);
		System.out.println("userDao.count() = " + userDao.count());

		User user = new User("newU", 30);
		userDao.insert(user);
		System.out.println("userDao.count() = " + userDao.count());

		User updateUser = new User("updateU", 50);
		updateUser.setId(2L);
		userDao.update(updateUser);

		System.out.println("userDao.findById(2L) = " + userDao.findById(2L));

		userDao.delete(updateUser);
		System.out.println("userDao.count() = " + userDao.count());

		Console.main(args);
	}

}

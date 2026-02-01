package com.spring.store;

import com.spring.store.entities.User;
import com.spring.store.repositories.UserRepository;
import com.spring.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {
public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(StoreApplication.class, args);
	var repository = ctx.getBean(UserRepository.class);
	var userService = ctx.getBean(UserService.class);

	userService.manageProducts();


}
}

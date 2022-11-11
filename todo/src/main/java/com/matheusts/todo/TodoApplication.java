package com.matheusts.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// sempre que a app for reiniciada ela vai instanciar as linhas de "run"
public class TodoApplication  implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"net"})
public class Cst339ProjectApplication {

	/**
	 * Main method for Spring application to start 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Cst339ProjectApplication.class, args);
	}

}

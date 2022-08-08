package net.codejavaProducts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
//@EntityScan(basePackages = {"net.codejava"} )
//@EnableJpaRepositories(basePackages = {"net.codejava"})
@ComponentScan({ "net.codejava" })
class ProductApplicationTests {

	@Test
	void contextLoads() {
	}

}

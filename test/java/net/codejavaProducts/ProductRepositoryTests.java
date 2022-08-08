package net.codejavaProducts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.codejava.Product;
import net.codejava.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)   
public class ProductRepositoryTests {
	
	 @Autowired
	 private ProductRepository productRepo;	 
	 @Autowired
	 private TestEntityManager entityProductManager;
	 
	 @Test
	 public void testCreateProduct()
	 {
		 Product product = new Product();
		 product.setSku("V2R0L1");
		 product.setproductName("Soccer Ball");
		 product.setproductDescription("Athletic gear");
		 product.setproductPrice(23.00f);
		 
		 Product savedProduct = productRepo.save(product);
		 
		 Product existProduct= 
				 entityProductManager.find(Product.class, savedProduct.getId());
		 
		 assertThat(existProduct.getSku()).isEqualTo(product.getSku());
	 }

}

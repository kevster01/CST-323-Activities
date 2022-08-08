package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

//extends JpaRepo to be used with product class and any method requiring products
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}

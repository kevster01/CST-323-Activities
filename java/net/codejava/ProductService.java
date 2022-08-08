package net.codejava;

import java.util.List;


//calls methods that are used in product repo, methods are then implmented in app controller
public interface ProductService {

	List<Product> getAllProducts();
	void saveProduct(Product product);
	void getProductById(String Id);
	void deleteProductById(String Id);
}

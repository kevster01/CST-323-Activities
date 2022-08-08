package net.codejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	
	
	/**
	 * This is the initial web-interface that users view once running the application 
	 * @return index(start) 
	 */
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
	
	/**
	 * This web-interface is made for the registration of users
	 * @param model
	 * @return signUp form
	 */
	@GetMapping("/register")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("user", new User());
		
		return "signUp";
	}
	
	/**
	 * This web-interface is made for users to sign up of users
	 * @param user
	 * @return registration success form 
	 */
	@PostMapping("/process_register")
	public String processRegistration(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "index";
	}
	
	
	/**
	 * Welcome interface showing after logging in 
	 * @return Welcome site for successful login
	 */
	@GetMapping("/Welcome")
	public String openWelcomeView()
	{
		return "Welcome";
		
	}

	
	
	@RequestMapping("/users")
	public String viewAllUsers(Model model)
	{
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

//	@GetMapping(value = "/api/usersByRole/{userRole}")
//public List<User> getUser(@PathVariable Long Id, Pageable pageable){
//    return repo.findByRolesIn(Arrays.asList(Id), pageable);
//}

//	@GetMapping("C")
//	public String viewUsersList(Model model)
//	{
//		List<User> listUsers = repo.findAll();
//		model.addAttribute("listUsers", listUsers);
//		return "users";
//	}
	
	/******************   PRODUCT CONTROLLER  ****************/
	private ProductService ProductService;
	
	
	/**
	 * This web-interface is made for creation of products
	 * @param product
	 * @return new product
	 */
	@PostMapping("/process_ProductCreation")
	public String productCreation(Product product)
	{
		productRepo.save(product);
		
		return "Welcome";
	}
	
	/**
	 * Method is created to produce a form for 
	 * sending user back to the main page 
	 *
	 * @return product main page
	 */
	@RequestMapping("/productMainPage")
	public String goHome()
	{
		return "productMainPage";
	}
	
	
	//test
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
	
	
	/**
	 * Link to creation of showProductForm that enables creation of product
	 * @param model
	 * @return NewProduct interface for creation of product
	 */
	@RequestMapping("/showProductForm")
	public String showNewProductForm(Model model) {	
		model.addAttribute("product", new Product());
		return "NewProduct";
	}
	
	
	
	@RequestMapping("/Delete")
	public String showDeleteProductForm(Model model)
	{
		//this.ProductService.deleteProductById(Id);
		return "Delete";
	}
	
	@RequestMapping("/Update")
	public String showUpdateProductForm(Model model)
	{
		//this.ProductService.deleteProductById(Id);
		return "Update";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("Product") Product product) {
		// save employee to database
		ProductService.saveProduct(product);
		return "redirect:/";
	}
	

}

	


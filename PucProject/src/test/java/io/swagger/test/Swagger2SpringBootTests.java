package io.swagger.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ProductRepository;
import io.swagger.dao.UserRepository;
import io.swagger.exception.EcommerceException;
import io.swagger.model.Product;
import io.swagger.model.User;
import io.swagger.service.ProductService;
import io.swagger.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Swagger2SpringBootTests {

	User personDetails = new User("Rahul","Rahul123","Rahul@gmail.com", "patna",8787879090l,"user",20000.0);
	Optional<User> person = Optional.of(personDetails);
	Product product= new Product(12,"Tv",1211l,45777.0,4,4.5);
	
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private UserRepository personRepository;
	
	/*
	 * @Test public void getDetails() throws NotFoundException {
	 * 
	 * when(personRepository.findOne("Rahul")).thenReturn(personDetails);
	 * assertEquals(personDetails, service.getDetails("Rahul")); }
	 */

	@Test
	public void productsProductIdGet() throws NotFoundException {
		
		//ResponseEntity<Product> response = productService.productsProductIdGet(4);
		when(productRepository.findOne(4)).thenReturn(product);
	
		assertEquals(product, productService.productsProductIdGet(4));

	
	 
	 
	}
	
}

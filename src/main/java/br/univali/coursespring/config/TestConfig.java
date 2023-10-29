package br.univali.coursespring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.univali.coursespring.entities.Category;
import br.univali.coursespring.entities.Order;
import br.univali.coursespring.entities.OrderItem;
import br.univali.coursespring.entities.Product;
import br.univali.coursespring.entities.User;
import br.univali.coursespring.entities.unums.OrderStatus;
import br.univali.coursespring.repositories.CategoryRepository;
import br.univali.coursespring.repositories.OrderItemRepository;
import br.univali.coursespring.repositories.OrderRepository;
import br.univali.coursespring.repositories.ProductRepository;
import br.univali.coursespring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		p1.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
	
		
		User u1 = new User(null, "Piard Rithcy", "piard@gmail.com", "99999999999", "121314115");
		User u2 = new User(null, "steff kerry", "steff@gmail.com", "909099999999", "09090909");
		User u3 = new User(null, "Ted Akim", "ted@gmail.com", "99999999999", "121314115");
		
		Order o1 = new Order(null, Instant.parse("2000-09-03T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2002-10-31T19:53:07Z"), u2, OrderStatus.DELICERED);
		Order o3 = new Order(null, Instant.parse("2002-10-16T19:53:07Z"), u3, OrderStatus.WAINTING_PAYMENT);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}
	
	
	
}
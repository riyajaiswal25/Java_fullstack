package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import com.example.app.entities.Product;
import com.example.app.repository.productRepository;



@SpringBootApplication
public class Assignment2JpaSaveAllApplication implements CommandLineRunner{
	
	@Autowired
	private productRepository productrepository;

	public static void main(String[] args) {
		SpringApplication.run(Assignment2JpaSaveAllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Create a list of User objects to save
        List<Product> userListToSave = new ArrayList<>();
        userListToSave.add(createUser("John", 500d, "New York"));
        userListToSave.add(createUser("Alice", 600d, "London"));
        userListToSave.add(createUser("Bob", 700d, "Paris"));
        userListToSave.add(createUser("Emily", 550d, "Sydney"));
        userListToSave.add(createUser("Michael", 800d, "Los Angeles"));
        userListToSave.add(createUser("Sophia", 620d, "Tokyo"));
        userListToSave.add(createUser("Daniel", 530d, "Berlin"));
        userListToSave.add(createUser("Olivia", 720d, "Toronto"));
        userListToSave.add(createUser("William", 680d, "Moscow"));
        userListToSave.add(createUser("Ella", 590d, "Rome"));
        userListToSave.add(createUser("Alexander", 710d, "Madrid"));
        userListToSave.add(createUser("Grace", 640d, "Seoul"));

        
        // Call saveAll method to save all users
        saveAllUsers(userListToSave);
	}
	private void saveAllUsers(List<Product> userList) {
        productrepository.saveAll(userList);
    }

    // Utility method to create a User object
    private Product createUser(String name, Double price, String description) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        return p;
    }


}

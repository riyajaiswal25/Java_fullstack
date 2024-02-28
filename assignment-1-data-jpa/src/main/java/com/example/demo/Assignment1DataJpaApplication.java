package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Assignment1DataJpaApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Assignment1DataJpaApplication.class, args);
	}
	
	@PostConstruct
	public void m1() {
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//save();
		//fetchAllUsers();
		//fetchUser();
		//updateUser();
		//fetchUser();
		//deleteUser();
		//fetchAllUsers();
	}

	private void deleteUser() {
		userRepository.deleteById(2);
	}
	
	private void updateUser() {
		userRepository.findById(2).map(p -> {
			p.setName("Modified");
			userRepository.save(p);
			return p;
		}).orElseThrow(() -> new RuntimeException("User not exists is db"+2));
	}

	private void fetchUser() {
		var user = userRepository.findById(2).orElseThrow(() -> new RuntimeException("User not exists is db"+2));
		System.out.println(user);
	}

	private void fetchAllUsers() {
		List<User> userList = userRepository.findAll();
		userList.forEach(p -> System.out.println(p));
	}



	private void save() {
		User us1 = new User();
		us1.setName("abc");
		us1.setPrice(450d);
		us1.setDescription("Mumbai");
		
		userRepository.save(us1);
	}

}

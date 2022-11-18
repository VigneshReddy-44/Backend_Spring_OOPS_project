package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSpringApplication  {
@Autowired
	UserRepository ob;
	public static void main(String[] args) {

		SpringApplication.run(BackendSpringApplication.class, args);
	}


	public void run(String... args) throws Exception {
//		User u1=new User(1,"Vikram",83493,"vr","Customer","oidsjf");
//		ob.save(u1);
	}
}

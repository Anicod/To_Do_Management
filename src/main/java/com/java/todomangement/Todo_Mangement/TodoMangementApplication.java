package com.java.todomangement.Todo_Mangement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoMangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoMangementApplication.class, args);
	}
		public ModelMapper modelMapper(){
		return new ModelMapper();
		}

}

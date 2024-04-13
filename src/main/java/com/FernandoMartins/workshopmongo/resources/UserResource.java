package com.FernandoMartins.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FernandoMartins.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User bruce = new User("2", "Bruce", "bruce@gmail.com");
		
		List<User> l1 = new ArrayList<>();
		l1.addAll(Arrays.asList(maria, bruce));
		
		return ResponseEntity.ok().body(l1);
	}
}

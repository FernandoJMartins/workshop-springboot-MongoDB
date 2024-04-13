package com.FernandoMartins.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FernandoMartins.workshopmongo.domain.User;
import com.FernandoMartins.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService srv;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> l1 = srv.findAll();

		return ResponseEntity.ok().body(l1);
	}
}

package com.FernandoMartins.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FernandoMartins.workshopmongo.domain.User;
import com.FernandoMartins.workshopmongo.dto.UserDTO;
import com.FernandoMartins.workshopmongo.repository.UserRepository;
import com.FernandoMartins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDTO(UserDTO userdto) {
		 return new User(userdto.getId(), userdto.getName(), userdto.getEmail());
	} 
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}

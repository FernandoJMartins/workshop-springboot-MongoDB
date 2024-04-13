package com.FernandoMartins.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.FernandoMartins.workshopmongo.domain.Post;
import com.FernandoMartins.workshopmongo.domain.User;
import com.FernandoMartins.workshopmongo.dto.AuthorDTO;
import com.FernandoMartins.workshopmongo.repository.PostRepository;
import com.FernandoMartins.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository repo; 
	
	@Autowired
	private PostRepository post;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		repo.deleteAll();
		post.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repo.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("10/10/2023"),"Partiu voyage", "estou indo viajar", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("12/12/2022"),"Olá, boa tarde!", "Como vcs estão?", new AuthorDTO(maria));
		
		post.saveAll(Arrays.asList(p1,p2));
		
	}

}

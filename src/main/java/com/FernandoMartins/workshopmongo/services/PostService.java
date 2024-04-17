package com.FernandoMartins.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FernandoMartins.workshopmongo.domain.Post;
import com.FernandoMartins.workshopmongo.repository.PostRepository;
import com.FernandoMartins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}

	public List<Post> fullSearch(String text, Date min, Date max){
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, min, max);
	}
}

package com.FernandoMartins.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FernandoMartins.workshopmongo.domain.Post;
import com.FernandoMartins.workshopmongo.resources.util.URL;
import com.FernandoMartins.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService srv;

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = srv.findById(id);
		return ResponseEntity.ok().body(post);
	} 
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = srv.findByTitle(text);
		return ResponseEntity.ok().body(list);
	} 

}

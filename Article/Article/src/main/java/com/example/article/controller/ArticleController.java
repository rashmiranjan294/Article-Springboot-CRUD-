package com.example.article.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.article.model.Article;
import com.example.article.services.ArticleService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	ArticleService services;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> articleList(){
		//new ArrayList<Article>();
		List<Article> list=services.getAllArticles();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") long id){
		Article ar=services.getArticleById(id);
		return new ResponseEntity<>(ar,HttpStatus.OK);
		
	}
	@PostMapping("/create")
	public ResponseEntity<Article> createArticle(@RequestBody Article article){
		services.saveOrUpdate(article);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Article> deleteArticle(@PathVariable("id") long id){
		services.deleteArticle(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

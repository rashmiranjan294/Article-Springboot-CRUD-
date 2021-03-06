package com.example.article.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.article.model.Article;
import com.example.article.repository.ArticleRepository;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleRepository repository;

	@Override
	public List<Article> getAllArticles() {
		List<Article> list=repository.findAll();
		return list;
	}

	@Override
	public Article getArticleById(long id) {
		return repository.findById(id).get();
		
	}

	@Override
	public void saveArticle(Article article) {
		
		repository.save(article);
	}

	@Override
	public void deleteArticle(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void updateArticle(Article article,long id) {
		repository.save(article);
		 //return ar;
	}

}

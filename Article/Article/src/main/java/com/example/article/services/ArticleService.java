package com.example.article.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.article.model.Article;

@Repository
public interface ArticleService {
	public List<Article> getAllArticles();
	public Article getArticleById(long id);
	public void saveArticle(Article article);
	public void updateArticle(Article article,long id);
	public void deleteArticle(long id);

}

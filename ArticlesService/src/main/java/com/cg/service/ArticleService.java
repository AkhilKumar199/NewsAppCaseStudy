package com.cg.service;

import java.util.List;

import com.cg.exception.ArticleAlreadyExists;
import com.cg.exception.ArticleIdNotFound;
import com.cg.model.Article;


public interface ArticleService {
	public Article addArticle(Article article)throws ArticleAlreadyExists;
	public List<Article> getAllArticles();
	public void deleteArticleByid(String id)throws ArticleIdNotFound;
	Article updateArticle(Article article,String id)throws ArticleIdNotFound;
	
	

}
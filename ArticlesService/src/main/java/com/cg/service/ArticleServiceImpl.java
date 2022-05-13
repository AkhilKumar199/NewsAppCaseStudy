package com.cg.service;

//Importing required classes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ArticleAlreadyExists;
import com.cg.exception.ArticleIdNotFound;
import com.cg.model.Article;
import com.cg.repository.ArticleRepository;




//Annotation
@Service

//Class
public  class ArticleServiceImpl implements ArticleService{

  private ArticleRepository articleRepo;

  @Autowired
  public ArticleServiceImpl(ArticleRepository articleRepo) {
      super();
      this.articleRepo = articleRepo;
  }

  @Override
  public Article addArticle(Article article) throws ArticleAlreadyExists {
      // TODO Auto-generated method stub
      if(articleRepo.existsById(article.getId())) {
          throw new ArticleAlreadyExists();
      }
      Article savedArticle= articleRepo.save(article);
      return savedArticle;
  }
  
// Read operation

  @Override
  public List<Article> getAllArticles()  {
      // TODO Auto-generated method stub

      return (List<Article>) articleRepo.findAll();

  }
  
// Update operation

  @Override
  public Article updateArticle(Article article, String id) throws ArticleIdNotFound {
      // TODO Auto-generated method stub


      Optional<Article> newsDB =this.articleRepo.findById(article.getId());
      if(newsDB.isPresent()) {
    	  Article articleUpdate = newsDB.get();
    	  articleUpdate.setId(article.getId());
    	  articleUpdate.setName(article.getName());
    	  articleUpdate.setAuthor(article.getAuthor());
    	  articleUpdate.setTitle(article.getTitle());
    	  articleUpdate.setDescription(article.getDescription());
    	  articleRepo.save(article);
      return article;
  }
      else
      {
      throw new ArticleIdNotFound(); 
      }
  }
  
  // Delete operation

  @Override
  public void deleteArticleByid(String id) throws ArticleIdNotFound{
      // TODO Auto-generated method stub
  Optional<Article> newsDB = this.articleRepo.findById(id);
      if(newsDB.isPresent()) { 
          this.articleRepo.delete(newsDB.get());
      }
      else
      {
          throw new ArticleIdNotFound();

      }

  }

}
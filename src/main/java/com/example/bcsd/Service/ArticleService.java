package com.example.bcsd.Service;

import java.util.List;

import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.model.Article;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public Article createArticle(Article article) {
        articleRepository.save(article);
        return article;
    }
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Article article) {
        Article existingArticle = articleRepository.findById(article.getId());
        if (existingArticle == null) {
            return null;
        }
        existingArticle.setTitle(article.getTitle());
        existingArticle.setDescription(article.getDescription());
        existingArticle.setCreateDay(article.getCreateDay());
        existingArticle.setUpdateDay(article.getUpdateDay());
        existingArticle.setBoardID(article.getBoardID());
        return existingArticle;
    }

    public void deleteArticleById(Long id) {
        articleRepository.delete(id);
    }
}

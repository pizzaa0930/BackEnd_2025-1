package com.example.bcsd.Service;

import com.example.bcsd.model.Article;
import com.example.bcsd.Repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Transactional
    public void createArticle(Article article) {
        article.setCreatedDate(LocalDateTime.now());
        article.setModifiedDate(LocalDateTime.now());
        articleRepository.save(article);
    }

    @Transactional
    public void updateArticle(Article article) {
        article.setModifiedDate(LocalDateTime.now());
        articleRepository.update(article);
    }

    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.delete(id);
    }

    @Transactional
    public List<Article> getArticlesByBoardId(Long boardId) {
        return articleRepository.findByBoardId(boardId);
    }

}

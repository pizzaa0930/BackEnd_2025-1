package com.example.bcsd.Service;

import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(Long authorId, Long boardId, String title, String content) {
        Article article = new Article(authorId, boardId, title, content);
        articleRepository.save(article);
        return article;
    }

    public Article findArticle(Long id) {
        return articleRepository.findById(id);
    }

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Article updateArticle(Long id, String title, String content) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            throw new RuntimeException("게시물을 찾을 수 없습니다. id=" + id);
        }
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.update(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.delete(id);
    }

    public List<Article> getArticlesByBoardId(Long boardId) {
        return articleRepository.findByBoardId(boardId);
    }
}

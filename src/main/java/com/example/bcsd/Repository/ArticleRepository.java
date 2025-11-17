package com.example.bcsd.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.bcsd.model.Article;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(0);

    public List<Article> findAll() {
        return articles;
    }
    public Article findById(Long id) {
        for (Article article : articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }
    public Article findByTitle(String title) {
        for (Article article : articles) {
            if (article.getTitle().equals(title)) {
                return article;
            }
        }
        return null;
    }
    public void save(Article article) {
        if(article.getId() == null) {
            article.setId(counter.incrementAndGet());
        }
        articles.add(article);
    }
    public void update(Article article) {
        for(int i = 0; i<articles.size(); i++) {
            if(articles.get(i).getId().equals(article.getId())) {
                articles.set(i, article);
                return;
            }
        }
    }
    public void delete(Long id) {
        Article article = findById(id);
        if(article != null) {
            articles.remove(article);
        }
    }
}

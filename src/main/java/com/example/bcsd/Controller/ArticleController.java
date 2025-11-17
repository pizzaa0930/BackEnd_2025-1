package com.example.bcsd.Controller;

import com.example.bcsd.Service.ArticleService;
import com.example.bcsd.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleService.getArticleById(id);
    }
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable long id, @RequestBody Article article) {
        article.setId(id);
        return articleService.updateArticle(article);
    }
    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

}

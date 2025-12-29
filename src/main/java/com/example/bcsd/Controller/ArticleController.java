package com.example.bcsd.Controller;

import com.example.bcsd.Service.ArticleService;
import com.example.bcsd.model.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.findArticle(id));
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleCreateRequest request) {
        Article article = articleService.createArticle(
                request.getAuthorId(),
                request.getBoardId(),
                request.getTitle(),
                request.getContent()
        );
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable Long id,
            @RequestBody ArticleUpdateRequest request
    ) {
        Article updated = articleService.updateArticle(
                id,
                request.getTitle(),
                request.getContent()
        );
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }
}

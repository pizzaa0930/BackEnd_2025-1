package com.example.bcsd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class HelloController {

    @ResponseBody
    @GetMapping("/{id}")
    public Info json() {
        Info info = new Info(22,"김성은");
        return info;
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    private Map<Integer,Article> articleMap = new HashMap<>();
    private int newId = 1;

    @PostMapping
    public ResponseEntity<Article> postArticle(@RequestBody Article article) {
        article.setId(newId++);
        articleMap.put(article.getId(), article);

        return new ResponseEntity<>(article,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Article> putArticle(
            @PathVariable int id,
            @RequestBody Article updated
    ) {
        Article existing = articleMap.get(id);

        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existing.setDescription(updated.getDescription());
        return new ResponseEntity<>(existing, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int id) {
        Article removed = articleMap.remove(id);

        if(removed == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

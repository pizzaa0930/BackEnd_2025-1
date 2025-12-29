package com.example.bcsd.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Article> articles = new ArrayList<>();

    protected Board() {}

    public Board(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addArticle(Article article) {
        articles.add(article);
        article.setBoard(this);
    }

    public void removeArticle(Article article) {
        articles.remove(article);
        article.setBoard(null);
    }
}

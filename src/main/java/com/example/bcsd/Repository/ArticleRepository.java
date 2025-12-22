package com.example.bcsd.Repository;

import com.example.bcsd.model.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager em;

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a", Article.class)
                .getResultList();
    }

    public void save(Article article) {
        em.persist(article);
    }

    public Article update(Article article) {
        return em.merge(article);
    }

    public void delete(Long id) {
        Article article = em.find(Article.class, id);
        if (article != null) {
            em.remove(article);
        }
    }

    public List<Article> findByBoardId(Long boardId) {
        return em.createQuery("SELECT a FROM Article a WHERE a.boardId = :boardId", Article.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }
}

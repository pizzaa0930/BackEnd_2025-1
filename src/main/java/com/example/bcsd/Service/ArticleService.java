package com.example.bcsd.Service;

import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.Repository.MemberRepository;
import com.example.bcsd.model.Article;
import com.example.bcsd.Exception.ArticleNotFoundException;
import com.example.bcsd.Exception.ArticleUpdateException;
import com.example.bcsd.Exception.ArticleCreateException;
import com.example.bcsd.Exception.InvalidInputException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public ArticleService(ArticleRepository articleRepository,
                          MemberRepository memberRepository,
                          BoardRepository boardRepository) {
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        try {
            return articleRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ArticleNotFoundException(id);
        }
    }

    @Transactional
    public void createArticle(Article article) {
        if (article == null || article.getAuthorID() == null || article.getBoardID() == null
                || article.getTitle() == null || article.getContent() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        try {
            memberRepository.findById(article.getAuthorID());
        } catch (EmptyResultDataAccessException e) {
            throw new ArticleCreateException(article.getAuthorID(), article.getBoardID());
        }
        try {
            boardRepository.findById(article.getBoardID());
        } catch (EmptyResultDataAccessException e) {
            throw new ArticleCreateException(article.getAuthorID(), article.getBoardID());
        }
        article.setCreatedDate(LocalDateTime.now());
        article.setModifiedDate(LocalDateTime.now());
        articleRepository.save(article);
    }

    @Transactional
    public void updateArticle(Article article) {
        if (article == null || article.getId() == null || article.getAuthorID() == null
                || article.getBoardID() == null || article.getTitle() == null || article.getContent() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        try {
            memberRepository.findById(article.getAuthorID());
        } catch (EmptyResultDataAccessException e) {
            throw new ArticleUpdateException(article.getAuthorID(), article.getBoardID());
        }
        try {
            boardRepository.findById(article.getBoardID());
        } catch (EmptyResultDataAccessException e) {
            throw new ArticleUpdateException(article.getAuthorID(), article.getBoardID());
        }
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

package com.example.bcsd.Service;

import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.model.Article;
import com.example.bcsd.model.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    public ArticleService(ArticleRepository articleRepository, BoardRepository boardRepository) {
        this.articleRepository = articleRepository;
        this.boardRepository = boardRepository;
    }

    public Article createArticle(Long authorId, Long boardId, String title, String content) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시판을 찾을 수 없습니다. id=" + boardId));

        Article article = new Article(authorId, title, content);
        board.addArticle(article);

        return article;
    }

    @Transactional(readOnly = true)
    public Article findArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다. id=" + id));
    }

    @Transactional(readOnly = true)
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Article updateArticle(Long id, String title, String content) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다. id=" + id));

        article.changeTitle(title);
        article.changeContent(content);

        return article;
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Article> getArticlesByBoardId(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시판을 찾을 수 없습니다. id=" + boardId));

        return board.getArticles();
    }
}

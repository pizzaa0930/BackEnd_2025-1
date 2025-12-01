package com.example.bcsd.Service;

import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.model.Board;
import com.example.bcsd.Exception.BoardNotFoundException;
import com.example.bcsd.Exception.InvalidInputException;
import com.example.bcsd.Exception.BoardDeleteException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    public BoardService(BoardRepository boardRepository, ArticleRepository articleRepository) {
        this.boardRepository = boardRepository;
        this.articleRepository = articleRepository;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long id) {
        try {
            return boardRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BoardNotFoundException(id);
        }
    }

    @Transactional
    public void createBoard(Board board) {
        if (board == null || board.getName() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        boardRepository.save(board);
    }

    @Transactional
    public void updateBoard(Board board) {
        if (board == null || board.getId() == null || board.getName() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        boardRepository.update(board);
    }

    @Transactional
    public void deleteBoard(Long id) {
        List<?> articles = articleRepository.findByBoardId(id);
        if (!articles.isEmpty()) {
            throw new BoardDeleteException(id);
        }
        boardRepository.delete(id);
    }
}

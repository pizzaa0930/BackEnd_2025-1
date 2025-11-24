package com.example.bcsd.Service;

import com.example.bcsd.model.Board;
import com.example.bcsd.Repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id);
    }
    @Transactional
    public void createBoard(Board board) {
        boardRepository.save(board);
    }
    @Transactional
    public void updateBoard(Board board) {
        boardRepository.update(board);
    }
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.delete(id);
    }
}

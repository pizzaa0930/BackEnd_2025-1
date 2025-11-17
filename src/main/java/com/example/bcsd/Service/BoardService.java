package com.example.bcsd.Service;

import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.model.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(Board board) {
        boardRepository.save(board);
        return board;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public Board updateBoard(Board board) {
        Board existing = boardRepository.findById(board.getId());
        if (existing == null) {
            return null;
        }

        existing.setBoardTitle(board.getBoardTitle());
        boardRepository.update(existing);

        return existing;
    }

    public void deleteBoardById(Long id) {
        boardRepository.delete(id);
    }
}

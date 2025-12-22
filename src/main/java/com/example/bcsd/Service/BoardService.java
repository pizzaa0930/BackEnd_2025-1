package com.example.bcsd.Service;

import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.model.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(String name) {
        Board board = new Board(name);
        boardRepository.save(board);
        return board;
    }

    public Board findBoard(Long id) {
        return boardRepository.findById(id);
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Board updateBoard(Long id, String name) {
        Board board = boardRepository.findById(id);
        if (board == null) {
            throw new RuntimeException("게시판을 찾을 수 없습니다. id=" + id);
        }
        board.setName(name);
        return boardRepository.update(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.delete(id);
    }
}

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
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Board findBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시판을 찾을 수 없습니다. id=" + id));
    }

    @Transactional(readOnly = true)
    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Board updateBoard(Long id, String name) {
        Board board = findBoard(id);
        board.changeName(name);
        return board;
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}

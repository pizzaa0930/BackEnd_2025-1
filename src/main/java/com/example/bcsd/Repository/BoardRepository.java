package com.example.bcsd.Repository;

import com.example.bcsd.model.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepository {

    private final List<Board> boards = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<Board> findAll() {
        return boards;
    }

    public Board findById(Long id) {
        for (Board board : boards) {
            if (board.getId().equals(id)) {
                return board;
            }
        }
        return null;
    }

    public Board findByTitle(String title) {
        for (Board board : boards) {
            if (board.getBoardTitle().equals(title)) {
                return board;
            }
        }
        return null;
    }

    public void save(Board board) {

        if (board.getId() == null) {
            board.setId(counter.incrementAndGet());
        }
        boards.add(board);
    }

    public void update(Board board) {
        for (int i = 0; i < boards.size(); i++) {
            if (boards.get(i).getId().equals(board.getId())) {
                boards.set(i, board);
                return;
            }
        }
    }

    public void delete(Long id) {
        Board board = findById(id);
        if (board != null) {
            boards.remove(board);
        }
    }
}

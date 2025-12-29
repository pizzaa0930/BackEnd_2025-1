package com.example.bcsd.Controller;

import com.example.bcsd.Service.BoardService;
import com.example.bcsd.model.Board;
import com.example.bcsd.dto.BoardCreateRequest;
import com.example.bcsd.dto.BoardUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.findAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findBoard(id));
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody BoardCreateRequest request) {
        Board saved = boardService.createBoard(request.getName());
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(
            @PathVariable Long id,
            @RequestBody BoardUpdateRequest request
    ) {
        Board updated = boardService.updateBoard(id, request.getName());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok().build();
    }
}

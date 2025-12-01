package com.example.bcsd.Exception;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(Long id) {
        super("해당 게시판을 찾을 수 없습니다.");
    }
}

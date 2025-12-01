package com.example.bcsd.Exception;

public class BoardDeleteException extends RuntimeException {
    public BoardDeleteException(Long boardId) {
        super("게시판에 게시물이 존재하여 삭제할 수 없습니다.");
    }
}

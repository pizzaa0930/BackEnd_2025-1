package com.example.bcsd.Exception;

public class ArticleCreateException extends RuntimeException {
    public ArticleCreateException(Long authorId, Long boardId) {
        super("게시물 생성 중 잘못된 참조입니다.");
    }
}

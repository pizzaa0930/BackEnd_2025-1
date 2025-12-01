package com.example.bcsd.Exception;

public class ArticleUpdateException extends RuntimeException {
    public ArticleUpdateException(Long authorId, Long boardId) {
        super("참조가 불가능합니다");
    }
}

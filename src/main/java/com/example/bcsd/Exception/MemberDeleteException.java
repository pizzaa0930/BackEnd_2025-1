package com.example.bcsd.Exception;

public class MemberDeleteException extends RuntimeException {
    public MemberDeleteException(Long memberId) {
        super("사용자가 작성한 게시물이 존재하여 삭제할 수 없습니다.");
    }
}

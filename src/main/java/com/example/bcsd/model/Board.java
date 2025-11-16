package com.example.bcsd.model;

public class Board {
    private Long id;
    private String BoardTitle;

    public  Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBoardTitle() {
        return BoardTitle;
    }
    public void setBoardTitle(String boardTitle) {
        BoardTitle = boardTitle;
    }
}

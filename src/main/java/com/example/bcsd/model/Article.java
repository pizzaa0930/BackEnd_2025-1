package com.example.bcsd.model;
import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long authorID;
    private Long boardID;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Article() {}

    public Article(Long id, Long authorID, Long boardID, String title, String content) {
        this.id = id;
        this.authorID = authorID;
        this.boardID = boardID;
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAuthorID() { return authorID; }
    public void setAuthorID(Long authorID) { this.authorID = authorID; }

    public Long getBoardID() { return boardID; }
    public void setBoardID(Long boardID) { this.boardID = boardID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(LocalDateTime modifiedDate) { this.modifiedDate = modifiedDate; }
}

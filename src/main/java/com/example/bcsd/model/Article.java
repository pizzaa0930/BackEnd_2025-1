package com.example.bcsd.model;
import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long authorID;
    private Long boardID;
    private String title;
    private String description;
    private LocalDateTime createDay;
    private LocalDateTime updateDay;

    public Article(Long id, Long authorID, Long boardID, String title,
                   String description) {
        this.id = id;
        this.authorID = authorID;
        this.boardID = boardID;
        this.title = title;
        this.description = description;
        this.createDay = LocalDateTime.now();
        this.updateDay = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAuthorID() {
        return authorID;
    }
    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
}
public Long getBoardID() {
        return boardID;
}
public void setBoardID(Long boardID) {
        this.boardID = boardID;
}
public String getTitle() {
        return title;
}
public void setTitle(String title) {
        this.title = title;

}
public String getDescription() {
        return description;
}
public void setDescription(String description) {
        this.description = description;
}
public LocalDateTime getCreateDay() {
        return createDay;
}
public void setCreateDay(LocalDateTime createDay) {
        this.createDay = createDay;
}
public LocalDateTime getUpdateDay() {
        return updateDay;
}
public void setUpdateDay(LocalDateTime updateDay) {
        this.updateDay = updateDay;
}
}

package com.example.bcsd;

public class Article {
    private int id;
    private String description;

    public Article(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
}

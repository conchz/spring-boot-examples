package com.github.dolphineor.spring.model.entity;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
public class CommentEntity {

    private String id;

    private String author;

    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

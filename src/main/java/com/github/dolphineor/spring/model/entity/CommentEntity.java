package com.github.dolphineor.spring.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@Entity
@Table(name = "TBL_COMMENT")
public class CommentEntity extends AbstractId implements Serializable {

    private String author;

    private String content;


    public CommentEntity(String author, String content) {
        this.author = author;
        this.content = content;
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

package com.semtax.application.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long Id;

    private String title;
    private String content;

    private String writer;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() { return writer; }

    public void setWriter(String writer) { this.writer = writer; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(Id, post.Id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(writer, post.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, title, content, writer);
    }
}

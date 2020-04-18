package com.semtax.application.entity;


import javax.persistence.*;

@Entity
public class UploadFile {

    @Id @GeneratedValue
    @Column(name = "upload_file_id")
    private Long Id;

    @Column
    private String filename;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

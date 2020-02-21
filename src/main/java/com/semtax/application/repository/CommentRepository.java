package com.semtax.application.repository;

import com.semtax.application.entity.Comment;
import com.semtax.application.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findCommentsByPost(Post post);
}

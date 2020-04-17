package com.semtax.application.controller;


import com.semtax.application.entity.Comment;
import com.semtax.application.entity.Post;
import com.semtax.application.repository.CommentRepository;
import com.semtax.application.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/post/{id}/comment")
    public List<Comment> getPostComments(@PathVariable Long id){
        Post post = postRepository.findById(id).get();
        return commentRepository.findCommentsByPost(post);
    }

    // DTO 쓰세요 ㅠㅠ.., 아니면 N:1 매핑만 하던가..
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/post/{id}/comment")
    public Comment createComment(@PathVariable Long id, @RequestBody Comment comment){
        Optional<Post> postItem = postRepository.findById(id);
        comment.setPost(postItem.get());
        commentRepository.save(comment);
        return comment;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}/comment/{commentID}")
    public Comment updateComment(@PathVariable Long id,@PathVariable Long commentID, @RequestBody Comment comment){
        Optional<Post> postItem = postRepository.findById(id);
        comment.setPost(postItem.get());
        Comment newComment = commentRepository.findById(commentID).get();
        newComment.setTitle(comment.getTitle());
        newComment.setContent(comment.getContent());
        return newComment;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/post/{id}/comment/{commentID}")
    public String deleteComment(@PathVariable Long id, @PathVariable Long commentID){
        commentRepository.deleteById(commentID);
        return "Comment Delete Success!";
    }
}

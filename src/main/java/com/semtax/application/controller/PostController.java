package com.semtax.application.controller;

import com.semtax.application.controller.exception.NoItemError;
import com.semtax.application.controller.exception.PathFormatError;
import com.semtax.application.entity.Post;
import com.semtax.application.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String hello(){
        return "Main Page!";
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/post")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable String id){
        Long postID = Long.parseLong(id);

        Optional<Post> post = postRepository.findById(postID);

        return post.get();
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost){
        Long postID = Long.parseLong(id);

        Optional<Post> post = postRepository.findById(postID);

        post.get().setTitle(newPost.getTitle());
        post.get().setContent(newPost.getContent());

        postRepository.save(post.get());

        return post.get();
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/post")
    public Post createPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);

        return newPost;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        Long postID = Long.parseLong(id);
        postRepository.deleteById(postID);

        return "Delete Success!";
    }

    /*

    @ExceptionHandler(NoSuchElementException.class)
    public @ResponseBody
    NoItemError noItemErrorHandler(NoSuchElementException e){
        NoItemError noItem = new NoItemError();
        noItem.setMessage("Item Not Exists!");
        return noItem;
    }

    @ExceptionHandler(NumberFormatException.class)
    public @ResponseBody
    PathFormatError noItemErrorHandler(NumberFormatException e){
        PathFormatError formatError = new PathFormatError();
        formatError.setMessage("Invalid Path Variable!");
        return formatError;
    }

     */
}
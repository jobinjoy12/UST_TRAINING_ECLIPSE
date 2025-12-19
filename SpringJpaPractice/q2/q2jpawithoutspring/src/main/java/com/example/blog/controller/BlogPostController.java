package com.example.blog.controller;

import com.example.blog.model.BlogPost;
import com.example.blog.model.Comment;
import com.example.blog.service.BlogPostService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        // TODO: Implement the GET endpoint to retrieve all blog posts.
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        // TODO: Implement the GET endpoint to retrieve a single blog post by ID.
        return blogPostService.getBlogPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        // TODO: Implement the POST endpoint to create a new blog post.
        BlogPost createdPost = blogPostService.createBlogPost(blogPost);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        // TODO: Implement the PUT endpoint to update an existing blog post.
        return blogPostService.updateBlogPost(id, blogPost)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //localhost:8008/products/9
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        // TODO: Implement the DELETE endpoint to delete a blog post.
        if (blogPostService.deleteBlogPost(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> addCommentToBlogPost(@PathVariable Long postId, @RequestBody Comment comment) {
        // TODO: Implement the POST endpoint to add a comment to a specific blog post.
        // Ensure the request body for Comment doesn't specify a BlogPost, as it's set by the path variable.
        return blogPostService.addCommentToBlogPost(postId, comment)
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForBlogPost(@PathVariable Long postId) {
        // TODO: Implement the GET endpoint to retrieve all comments for a specific blog post.
        return blogPostService.getCommentsByBlogPostId(postId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        // TODO: Implement the DELETE endpoint to delete a specific comment.
        if (blogPostService.deleteComment(commentId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
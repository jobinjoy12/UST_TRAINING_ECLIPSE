package com.example.blog.service;

import com.example.blog.model.BlogPost;
import com.example.blog.model.Comment;
import com.example.blog.repository.BlogPostRepository;
import com.example.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private CommentRepository commentRepository;

    // Operations for BlogPosts
    public List<BlogPost> getAllBlogPosts() {
        // TODO: Implement logic to retrieve all blog posts

        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        // TODO: Implement logic to retrieve a single blog post by its ID
        return blogPostRepository.findById(id);
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        // TODO: Implement logic to save a new blog post
        return blogPostRepository.save(blogPost);
    }

    @Transactional
    public Optional<BlogPost> updateBlogPost(Long id, BlogPost updatedBlogPost) {
        // TODO: Implement logic to update an existing blog post. Ensure comments are handled correctly if needed.
        return blogPostRepository.findById(id).map(blogPost -> {
            blogPost.setTitle(updatedBlogPost.getTitle());
            blogPost.setContent(updatedBlogPost.getContent());
            return blogPostRepository.save(blogPost);
        });
    }

    public boolean deleteBlogPost(Long id) {
        // TODO: Implement logic to delete a blog post. Consider cascade operations from BlogPost entity.
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Operations for Comments related to BlogPosts
    @Transactional
    public Optional<Comment> addCommentToBlogPost(Long postId, Comment comment) {
        // TODO: Implement logic to add a new comment to a specific blog post.
        // Ensure the relationship is correctly established on both sides (BlogPost and Comment).
        return blogPostRepository.findById(postId).map(blogPost -> {
            blogPost.addComment(comment); // This also sets the blogPost on the comment
            commentRepository.save(comment); // Save the comment
            blogPostRepository.save(blogPost); // Persist the changes to BlogPost (cascade should handle this, but explicit save is safer for clarity)
            return comment;
        });
    }

    @Transactional(readOnly = true)
    public Optional<List<Comment>> getCommentsByBlogPostId(Long postId) {
        // TODO: Implement logic to retrieve all comments for a given blog post ID.
        // You can either fetch the BlogPost and then its comments, or use a custom repository method for comments.
        return blogPostRepository.findById(postId).map(BlogPost::getComments);
    }

    @Transactional
    public boolean deleteComment(Long commentId) {
        // TODO: Implement logic to delete a specific comment.
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
            return true;
        }
        return false;
    }
}
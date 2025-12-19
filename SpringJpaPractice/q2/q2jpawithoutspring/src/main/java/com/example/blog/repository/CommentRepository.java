package com.example.blog.repository;

import java.util.List;

import com.example.blog.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // TODO: Add a custom query method to find comments by BlogPost if needed, or rely on BlogPost's comments list
    List<Comment> findByBlogPostId(Long BlogPostId);
}
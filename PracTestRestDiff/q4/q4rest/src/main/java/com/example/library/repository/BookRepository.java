package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibraryId(Long libraryId);

    // JPQL query to list books published after a given year
    @Query("SELECT b FROM Book b WHERE b.publicationYear > :year")
    List<Book> findBooksPublishedAfter(@Param("year") int year);
}
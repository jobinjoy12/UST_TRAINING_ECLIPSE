package com.example.q232;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Your queries will go here
    @Query("from Book b where b.title LIKE CONCAT('%',?1,'%')")
    List<Book> findBooksByTitleContaining(String keyword);
    
    @Query("select b.title , b.author.name from Book b where b.genre = ?1")
    List<Object[]> findBookTitlesAndAuthorsByGenre(String genre);

    @Query("select COUNT(b) from Book b where b.publicationYear > ?1 ")
    long countBooksPublishedAfter(int year);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Book b SET b.price= ?2 where b.id = ?1")
    int updateBookPrice(Long bookId, double newPrice);

    @Query(value="select * from Book",nativeQuery=true)
    List<Book> findAllBooksNative();
    @Query(value = "select * from Book b where b.price > (select AVG(b2.price) from Book b2) ",nativeQuery=true)
    List<Book> findBooksAboveAveragePriceNative();
    @Query(value = "select * from Book b ORDER BY price DESC LIMIT ?1",nativeQuery=true)
    List<Book> findTopNMostExpensiveBooksNative(int limit);
    
}   

package com.example.repository;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();

        // 1. Create and Add books
        System.out.println("--- Adding initial books ---");
        Book book1 = new Book("B001", "The Great Java Journey", "Alice Wonderland");
        Book book2 = new Book("B002", "Python for Beginners", "Bob Builder");
        Book book3 = new Book("B003", "Advanced Algorithms", "Charlie Chaplin");
        repository.addBook(book1);
        repository.addBook(book2);
        repository.addBook(book3);
        System.out.println("Current books in repository:");
        repository.findAllBooks().forEach(b -> System.out.println("- " + b.getTitle() + " by " + b.getAuthor()));

        // 2. Find a book by existing ID
        System.out.println("\n--- Finding Book B001 ---");
        Book foundBook = repository.findBookById("B001");
        if (foundBook != null) {
            System.out.println("Found Book: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Book B001 not found.");
        }

        // 3. Try to find a book by non-existent ID
        System.out.println("\n--- Finding Book B999 (non-existent) ---");
        Book nonExistentBook = repository.findBookById("B999");
        if (nonExistentBook == null) {
            System.out.println("Book B999 not found (as expected).");
        } else {
            System.out.println("Unexpectedly found Book B999: " + nonExistentBook.getTitle());
        }

        // 4. Update an existing book
        System.out.println("\n--- Updating Book B001 ---");
        Book updatedBook1 = new Book("B001", "The Ultimate Java Journey (Updated)", "Alice Wonderland");
        repository.updateBook(updatedBook1);
        System.out.println("Books after updating B001:");
        repository.findAllBooks().forEach(b -> System.out.println("- " + b.getTitle() + " by " + b.getAuthor()));
        Book verifiedUpdatedBook = repository.findBookById("B001");
        if (verifiedUpdatedBook != null) {
             System.out.println("Verified updated B001: " + verifiedUpdatedBook.getTitle());
        }


        // 5. Delete a book
        System.out.println("\n--- Deleting Book B002 ---");
        repository.deleteBook("B002");
        System.out.println("Books after deleting B002:");
        repository.findAllBooks().forEach(b -> System.out.println("- " + b.getTitle() + " by " + b.getAuthor()));

        // 6. Verify deletion
        System.out.println("\n--- Verifying deletion of B002 ---");
        Book deletedBook = repository.findBookById("B002");
        if (deletedBook == null) {
            System.out.println("Book B002 is successfully deleted (not found).");
        } else {
            System.out.println("Error: Book B002 still found after deletion: " + deletedBook.getTitle());
        }

        // 7. Final state
        System.out.println("\n--- Final state of the repository ---");
        repository.findAllBooks().forEach(b -> System.out.println("- " + b.getTitle() + " by " + b.getAuthor()));
    }
}
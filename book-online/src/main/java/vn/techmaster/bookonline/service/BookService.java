package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Author;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.entitiy.Comment;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Find by id
    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("No book with id = " + id));
    }

    // Find all
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Save entity
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // Add instance by request

    // Update instance by request


    // Delete by id
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    // Get authors names
    public List<String> getAuthorsNames(Book book) {
        return book.getAuthors().stream().map(Author::getFullName).toList();
    }

    // Add comment
    public void addComment(Book book, Comment comment) {
        book.addComment(comment);
        bookRepository.save(book);
    }

    // Remove comment
    public void removeComment(Book book, Comment comment) {
        book.removeComment(comment);
        bookRepository.save(book);
    }
}

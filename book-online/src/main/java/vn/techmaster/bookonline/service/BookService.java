package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Book;
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

    // Add entity
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    // Add instance by request

    // Update instance
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    // Update instance by request


    // Delete by id
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}

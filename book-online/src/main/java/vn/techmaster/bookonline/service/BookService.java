package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entity.Author;
import vn.techmaster.bookonline.entity.Book;
import vn.techmaster.bookonline.entity.Category;
import vn.techmaster.bookonline.entity.Comment;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.BookRepository;

import java.util.*;

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

    // Add entity by request

    // Update entity by request

    // Delete by id
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    // Get categories names
    public List<String> getCategoriesNames(Book book) {
        return book.getCategories().stream().map(Category::getName).toList();
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

    // Add category
    public void addCategory(Book book, Category category) {
        book.addCategory(category);
        bookRepository.save(book);
    }

    // Remove category
    public void removeCategory(Book book, Category category) {
        book.removeCategory(category);
        bookRepository.save(book);
    }

    // Filter books
    public List<Book> filterBooks(Collection<Category> categories, Long priceStart, Long priceEnd, Integer pagesStart, Integer pagesEnd,
                                  String name) {
        return bookRepository.filterBooks(categories, priceStart, priceEnd, pagesStart, pagesEnd, name);
    }

    // Find by category
    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategories(category);
    }

    // Find similar by categories
    public Set<Book> findSimilarByCategories(Book book) {
        Set<Book> result = new LinkedHashSet<>();
        for (Category category : book.getCategories()) {
            result.addAll(findByCategory(category));
        }
        return result;
    }

    // Find by author
    public List<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthors(author);
    }

    // Find similar by authors
    public Set<Book> findSimilarByAuthors(Book book) {
        Set<Book> result = new LinkedHashSet<>();
        for (Author author : book.getAuthors()) {
            result.addAll(findByAuthor(author));
        }
        return result;
    }

    // Find all, pageable order by name
    public Page<Book> findByOrderByNameAsc(Pageable pageable) {
        return bookRepository.findByOrderByNameAsc(pageable);
    }
}

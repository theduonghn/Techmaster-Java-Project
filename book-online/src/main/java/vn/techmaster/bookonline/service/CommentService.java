package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.entitiy.Category;
import vn.techmaster.bookonline.entitiy.Comment;
import vn.techmaster.bookonline.entitiy.User;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.BookRepository;
import vn.techmaster.bookonline.repository.CommentRepository;
import vn.techmaster.bookonline.repository.UserRepository;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    // Find by id
    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("No comment with id = " + id));
    }

    // Find all
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    // Save entity
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    // Add instance by request

    // Update instance by request


    // Delete by id
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    // Add user and book
    public void addUserAndBook(Comment comment, User user, Book book) {
        comment.setUser(user);
        user.getComments().add(comment);
        comment.setBook(book);
        book.getComments().add(comment);

        commentRepository.saveAndFlush(comment);
        userRepository.saveAndFlush(user);
        bookRepository.saveAndFlush(book);
    }

    // Find by book
    public List<Comment> findByBook(Book book) {
        return commentRepository.findByBook(book);
    }
}

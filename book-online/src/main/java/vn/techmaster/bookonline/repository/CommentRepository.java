package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.entitiy.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    // Find by book
    List<Comment> findByBook(Book book);

}
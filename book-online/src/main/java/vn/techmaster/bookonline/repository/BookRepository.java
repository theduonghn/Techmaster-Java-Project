package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
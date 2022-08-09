package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
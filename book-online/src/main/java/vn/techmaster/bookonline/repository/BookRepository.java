package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.entitiy.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    @Query("select b from Book b where upper(b.name) like upper(concat('%', ?1, '%'))")
    List<Book> findByName(String name);

    List<Book> findByCategories(Category categories);





}
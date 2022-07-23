package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
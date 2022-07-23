package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
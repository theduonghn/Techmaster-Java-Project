package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
}
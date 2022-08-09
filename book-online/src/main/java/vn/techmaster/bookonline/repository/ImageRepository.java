package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Image;

public interface ImageRepository extends JpaRepository<Image, String> {
}
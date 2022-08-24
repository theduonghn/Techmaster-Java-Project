package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
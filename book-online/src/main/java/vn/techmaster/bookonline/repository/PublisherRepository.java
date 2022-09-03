package vn.techmaster.bookonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
    // Find all, pageable order by name
    Page<Publisher> findByOrderByNameAsc(Pageable pageable);

}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Price;

public interface PriceRepository extends JpaRepository<Price, String> {
}
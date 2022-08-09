package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Price;

public interface PriceRepository extends JpaRepository<Price, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Shop;

public interface ShopRepository extends JpaRepository<Shop, String> {
}
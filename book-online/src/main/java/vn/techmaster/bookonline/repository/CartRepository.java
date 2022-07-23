package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
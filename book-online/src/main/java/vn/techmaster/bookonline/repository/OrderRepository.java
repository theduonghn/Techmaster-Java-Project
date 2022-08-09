package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.OrderBook;

public interface OrderBookRepository extends JpaRepository<OrderBook, String> {
}
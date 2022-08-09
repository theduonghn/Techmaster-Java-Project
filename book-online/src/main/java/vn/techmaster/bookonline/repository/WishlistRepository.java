package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, String> {
}
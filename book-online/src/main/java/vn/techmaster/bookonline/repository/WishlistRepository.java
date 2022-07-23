package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, String> {
}
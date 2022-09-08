package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entity.Cart;
import vn.techmaster.bookonline.entity.User;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    // Find by user
    public Cart findByUser(User user) {
        return cartRepository.findByUser(user).orElseThrow(() -> new NotFoundException("No cart found"));
    }
}

package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
}

package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.WishlistRepository;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
}

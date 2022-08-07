package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.PriceRepository;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
}

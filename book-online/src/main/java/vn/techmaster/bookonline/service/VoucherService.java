package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.VoucherRepository;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
}

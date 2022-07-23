package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, String> {
}
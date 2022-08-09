package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, String> {
}
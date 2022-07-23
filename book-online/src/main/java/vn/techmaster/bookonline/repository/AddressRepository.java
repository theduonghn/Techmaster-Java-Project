package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
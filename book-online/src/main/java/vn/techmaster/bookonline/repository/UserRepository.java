package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techmaster.bookonline.entitiy.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.id = ?1")
    @Override
    Optional<User> findById(String uuid);
}
package vn.techmaster.bookonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techmaster.bookonline.entitiy.Comment;
import vn.techmaster.bookonline.entitiy.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    // Find by id
    @Query("select u from User u where u.id = ?1")
    @Override
    Optional<User> findById(String uuid);

    // Find by comment
    User findByComments(Comment comment);

    // Find all, pageable order by username
    Page<User> findByOrderByUsernameAsc(Pageable pageable);
}
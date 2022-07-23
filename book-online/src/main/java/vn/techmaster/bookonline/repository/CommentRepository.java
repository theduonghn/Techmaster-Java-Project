package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
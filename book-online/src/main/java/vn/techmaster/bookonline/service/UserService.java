package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Comment;
import vn.techmaster.bookonline.entitiy.User;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Find by id
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("No user with id = " + id));
    }

    // Find all
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Save instance
    public User save(User user) {
        return userRepository.save(user);
    }

    // Delete by id
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    // Add comment
    public void addComment(User user, Comment comment) {
        user.addComment(comment);
        userRepository.save(user);
    }

    // Remove comment
    public void removeComment(User user, Comment comment) {
        user.removeComment(comment);
        userRepository.save(user);
    }

    // Find by comment
    public User findByComments(Comment comment) {
        return userRepository.findByComments(comment);
    }
}

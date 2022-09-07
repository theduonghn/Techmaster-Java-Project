package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.dto.RegisterRequest;
import vn.techmaster.bookonline.entity.*;
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

    // Save entity
    public User save(User user) {
        return userRepository.save(user);
    }

    // Save entity by registerRequest
    public User saveByRegisterRequest(RegisterRequest registerRequest) {
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFullName(registerRequest.getFullName());
        user.setStatus(Status.ACTIVE);
        user.setRoles(List.of("USER"));

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

    // Find all, pageable order by username
    public Page<User> findByOrderByUsernameAsc(Pageable pageable) {
        return userRepository.findByOrderByUsernameAsc(pageable);
    }

    // Check exists by email
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    // Check exists by username
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsernameIgnoreCase(username);
    }
}

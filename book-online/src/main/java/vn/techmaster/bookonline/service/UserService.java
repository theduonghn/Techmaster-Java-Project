package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.model.User;
import vn.techmaster.bookonline.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Find by id
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("No user with id = " + id));
    }

    // Find all
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Add instance
    public User add(User user) {
        return userRepository.save(user);
    }

    // Update instance
    public User update(User user) {
        return userRepository.save(user);
    }

    // Delete by id
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}

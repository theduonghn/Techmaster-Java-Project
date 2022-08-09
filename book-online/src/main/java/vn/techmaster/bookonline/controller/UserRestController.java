package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookonline.entitiy.User;
import vn.techmaster.bookonline.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    // Find by id
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    // Find all
    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }
}

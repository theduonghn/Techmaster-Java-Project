package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.bookonline.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public String showUserDetail(Model model, @PathVariable("id") String id) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "profile";
    }
}

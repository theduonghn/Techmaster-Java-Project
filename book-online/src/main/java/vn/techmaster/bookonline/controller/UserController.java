package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.techmaster.bookonline.dto.RegisterRequest;
import vn.techmaster.bookonline.service.UserService;

import javax.validation.Valid;

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

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String submitRegister(Model model,
                                 @Valid @ModelAttribute RegisterRequest registerRequest,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("registerRequest", registerRequest);
            return "register";
        }

        userService.saveByRegisterRequest(registerRequest);

        redirectAttributes.addFlashAttribute("successAlert", "User register successfully!");
        return "redirect:/";
    }
}

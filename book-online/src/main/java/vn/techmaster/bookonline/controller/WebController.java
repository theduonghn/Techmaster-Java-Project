package vn.techmaster.bookonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebController {
    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/books")
    public String showBooksPage() {
        return "books";
    }

    @GetMapping("/book-details")
    public String showBookDetailsPage() {
        return "book-details";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
}

package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.bookonline.service.BookService;

@Controller
@RequestMapping
public class WebController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/books")
    public String showBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll());
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

    @GetMapping("/blog")
    public String showBlogPage() {
        return "blog";
    }

    @GetMapping("/testimonials")
    public String showTestimonialsPage() {
        return "testimonials";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage() {
        return "checkout";
    }
}

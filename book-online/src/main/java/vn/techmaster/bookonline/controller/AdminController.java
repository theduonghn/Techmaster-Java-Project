package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.bookonline.service.BookService;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("bookService", bookService);
        return "admin-books";
    }
}

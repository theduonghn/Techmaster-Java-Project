package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.service.BookService;
import vn.techmaster.bookonline.util.Utils;

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

    @GetMapping("/book-details/{id}")
    public String showBookDetailsPage(Model model, @PathVariable("id") String id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", Utils.showList(bookService.getAuthorsNames(book)));
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

package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.techmaster.bookonline.entity.Book;
import vn.techmaster.bookonline.entity.Category;
import vn.techmaster.bookonline.entity.Comment;
import vn.techmaster.bookonline.service.BookService;
import vn.techmaster.bookonline.service.CategoryService;
import vn.techmaster.bookonline.service.CommentService;
import vn.techmaster.bookonline.service.UserService;
import vn.techmaster.bookonline.util.Utils;

import java.util.List;

@Controller
@RequestMapping
public class WebController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/books")
    public String showBooksPage(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @PostMapping("/books")
    public String submitFilterBooks(RedirectAttributes redirectAttributes,
            @ModelAttribute List<Category> selectedCategories,
            @ModelAttribute Long minPrice,
            @ModelAttribute Long maxPrice,
            @ModelAttribute Integer minPages,
            @ModelAttribute Integer maxPages,
            @ModelAttribute String keyword) {
        redirectAttributes.addAttribute("categories", selectedCategories);
        redirectAttributes.addAttribute("minPrice", minPrice);
        redirectAttributes.addAttribute("maxPrice", maxPrice);
        redirectAttributes.addAttribute("minPages", minPages);
        redirectAttributes.addAttribute("maxPages", maxPages);
        redirectAttributes.addAttribute("keyword", keyword);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String showBookDetailsPage(Model model, @PathVariable("id") String id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", Utils.showList(bookService.getCategoriesNames(book)));
        model.addAttribute("authors", Utils.showList(bookService.getAuthorsNames(book)));

        List<Comment> comments = commentService.findByBook(book);
        model.addAttribute("comments", comments);

        model.addAttribute("userService", userService);

        model.addAttribute("booksSameCategories", bookService.findSimilarByCategories(book));
        model.addAttribute("booksSameAuthors", bookService.findSimilarByAuthors(book));
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

    @GetMapping("/terms")
    public String showTermsPage() {
        return "terms";
    }
}

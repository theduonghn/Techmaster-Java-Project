package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.bookonline.entitiy.*;
import vn.techmaster.bookonline.service.*;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private UserService userService;

    // Show authors
    @GetMapping("/authors")
    public String showAuthors(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return "redirect:/admin/authors";
        }
        Page<Author> pageAuthor = authorService.findByOrderByFullNameAsc(PageRequest.of(page - 1, 5));
        Integer maxPage = pageAuthor.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        model.addAttribute("authors", pageAuthor.getContent());
        return "admin-authors";
    }

    // Show books
    @GetMapping("/books")
    public String showBooks(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return "redirect:/admin/books";
        }
        Page<Book> pageBook = bookService.findByOrderByNameAsc(PageRequest.of(page - 1, 5));
        Integer maxPage = pageBook.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        model.addAttribute("books", pageBook.getContent());
        model.addAttribute("bookService", bookService);
        return "admin-books";
    }

    // Show categories
    @GetMapping("/categories")
    public String showCategories(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return "redirect:/admin/categories";
        }
        Page<Category> pageCategory = categoryService.findByOrderByNameAsc(PageRequest.of(page - 1, 5));
        Integer maxPage = pageCategory.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        model.addAttribute("categories", pageCategory.getContent());
        return "admin-categories";
    }

    // Show publishers
    @GetMapping("/publishers")
    public String showPublishers(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return "redirect:/admin/publishers";
        }
        Page<Publisher> pagePublisher = publisherService.findByOrderByNameAsc(PageRequest.of(page - 1, 5));
        Integer maxPage = pagePublisher.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        model.addAttribute("publishers", pagePublisher.getContent());
        return "admin-publishers";
    }

    // Show users
    @GetMapping("/users")
    public String showUsers(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return "redirect:/admin/users";
        }
        Page<User> pageUser = userService.findByOrderByUsernameAsc(PageRequest.of(page - 1, 5));
        Integer maxPage = pageUser.getTotalPages();
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        model.addAttribute("users", pageUser.getContent());
        return "admin-users";
    }
}

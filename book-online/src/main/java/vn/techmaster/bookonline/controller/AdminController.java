package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Show author details
    @GetMapping("/authors/{id}")
    public String showAuthorDetails(Model model, @PathVariable("id") String id) {
        model.addAttribute("author", authorService.findById(id));
        return "admin-author-details";
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

    // Show book details
    @GetMapping("/books/{id}")
    public String showBookDetails(Model model, @PathVariable("id") String id) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("bookService", bookService);
        return "admin-book-details";
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

    // Show category details
    @GetMapping("/categories/{id}")
    public String showCategoryDetails(Model model, @PathVariable("id") String id) {
        model.addAttribute("category", categoryService.findById(id));
        return "admin-category-details";
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

    // Show publisher details
    @GetMapping("/publishers/{id}")
    public String showPublisherDetails(Model model, @PathVariable("id") String id) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "admin-publisher-details";
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

    // Show user details
    @GetMapping("/users/{id}")
    public String showUserDetails(Model model, @PathVariable("id") String id) {
        model.addAttribute("user", userService.findById(id));
        return "admin-user-details";
    }
}

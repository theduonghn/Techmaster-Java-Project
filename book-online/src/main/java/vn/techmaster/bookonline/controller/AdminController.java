package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.bookonline.entitiy.Author;
import vn.techmaster.bookonline.entitiy.Book;
import vn.techmaster.bookonline.service.AuthorService;
import vn.techmaster.bookonline.service.BookService;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

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
        model.addAttribute("authorService", authorService);
        return "admin-authors";
    }
}

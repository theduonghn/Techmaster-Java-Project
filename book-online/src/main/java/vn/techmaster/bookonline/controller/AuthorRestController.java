package vn.techmaster.bookonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.bookonline.entitiy.Author;
import vn.techmaster.bookonline.service.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    // Find by id
    @GetMapping("/{id}")
    public Author findById(@PathVariable("id") String id) {
        return authorService.findById(id);
    }

    // Find all
    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    // Add instance
    @PostMapping
    public Author add(@RequestBody Author author) {
        return authorService.add(author);
    }

    // Update instance
    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable("id") String id) {
        return authorService.update(author);
    }

    // Delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        authorService.deleteById(id);
    }
}

package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Author;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    // Find by id
    public Author findById(String id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("No author with id = " + id));
    }

    // Find all
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    // Add entity
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    // Add instance by request

    // Update instance
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    // Update instance by request


    // Delete by id
    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }
}

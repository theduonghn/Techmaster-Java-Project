package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
}

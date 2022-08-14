package vn.techmaster.bookonline;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.bookonline.entitiy.*;
import vn.techmaster.bookonline.repository.AuthorRepository;
import vn.techmaster.bookonline.repository.BookRepository;
import vn.techmaster.bookonline.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DataInitializer {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    private final Random random = new Random();

    @Transactional
    public void initData() {
        // Begin create users
        User admin = User.builder()
                .username("admin")
                .email("admin@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("Admin")
                .gender(Gender.FEMALE)
                .dob(LocalDate.now().minusYears(20))
                .status(Status.ACTIVE)
                .roles(List.of("admin", "user"))
                .build();
        userRepository.save(admin);

        User user1 = User.builder()
                .username("user1")
                .email("user1@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("User 1")
                .gender(Gender.FEMALE)
                .dob(LocalDate.now().minusYears(23))
                .status(Status.ACTIVE)
                .roles(List.of("user"))
                .build();
        userRepository.save(user1);

        User user2 = User.builder()
                .username("user2")
                .email("user2@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("User 2")
                .gender(Gender.MALE)
                .dob(LocalDate.now().minusYears(24))
                .status(Status.ACTIVE)
                .roles(List.of("user"))
                .build();
        userRepository.save(user2);
        // End create users

        // Begin create authors
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Author author = Author.builder()
                    .fullName("Author " + i)
                    .gender(Gender.values()[random.nextInt(Gender.values().length)])
                    .address("Address author " + i)
                    .yearOfBirth(random.nextInt(2000 - 1700) + 1700)
                    .books(null)
                    .build();
            if (author.getYearOfBirth() < 1950) {
                author.setYearOfDeath(author.getYearOfBirth() + random.nextInt(100 - 20) + 20);
            }
            authors.add(author);
        }
        authorRepository.saveAll(authors);
        // End create authors

        // Begin create books
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = Book.builder()
                    .name(faker.book().title())
                    .publishedYear(random.nextInt(2000 - 1700) + 1700)
                    .pages(random.nextInt(1000) + 50)
                    .quantity(random.nextInt(1000))
                    .thumbnail("upload/book-thumbnails/book" + i + ".webp")
                    .description(faker.lorem().paragraph(10))
                    .price((random.nextLong(500L - 10) + 10) * 1000)
                    .authors(Set.of(authors.get(random.nextInt(authors.size()))))
                    .build();
            books.add(book);
        }
        bookRepository.saveAll(books);
        // End create books
    }
}

package vn.techmaster.bookonline;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.bookonline.entitiy.*;
import vn.techmaster.bookonline.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

public class MockDataInitializer {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    private final Random random = new Random();

    @Transactional
    public void initData() {
        // Begin create admin
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
        // End create admin

        // Begin create active users
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .username("user" + i)
                    .email("user" + i + "@gmail.com")
                    .mobile("123")
                    .hashedPassword("123")
                    .fullName(faker.name().fullName())
                    .gender(Gender.values()[random.nextInt(Gender.values().length)])
                    .dob(LocalDate.now().minusYears(random.nextInt(70 - 18) + 18)
                            .minusDays(random.nextInt(365)))
                    .homeAddress(random.nextInt(2) == 0 ? null : faker.address().fullAddress())
                    .workAddress(random.nextInt(2) == 0 ? null : faker.address().fullAddress())
                    .status(Status.ACTIVE)
                    .roles(List.of("user"))
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);
        // End create active users

        // Begin create authors
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Author author = Author.builder()
                    .fullName(faker.name().fullName())
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

        // Begin create categories
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Category category = Category.builder()
                    .name(faker.book().genre() + " " + i) // Avoid duplicate category names
                    .build();
            categories.add(category);
        }
        categoryRepository.saveAll(categories);
        // End create categories

        // Begin create publishers
        List<Publisher> publishers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Publisher publisher = Publisher.builder()
                    .name(faker.book().publisher() + " " + i) // Avoid duplicate publishing company names
                    .build();
            publishers.add(publisher);
        }
        publisherRepository.saveAll(publishers);
        // End create publishers

        // Begin create books
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Set<Category> randomCategories = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                randomCategories.add(categories.get(random.nextInt(categories.size())));
            }

            Book book = Book.builder()
                    .name(faker.book().title())
                    .publisher(publishers.get(random.nextInt(publishers.size())))
                    .publishedYear(random.nextInt(2000 - 1700) + 1700)
                    .pages(random.nextInt(1000) + 50)
                    .quantity(random.nextInt(1000))
                    .thumbnail("upload/book-thumbnails/book" + i + ".jpg")
                    .description(faker.lorem().paragraph(10))
                    .price((random.nextLong(500L - 10) + 10) * 1000)
                    .authors(Set.of(authors.get(random.nextInt(authors.size()))))
                    .categories(randomCategories)
                    .build();
            books.add(book);
        }
        bookRepository.saveAll(books);
        // End create books
    }
}

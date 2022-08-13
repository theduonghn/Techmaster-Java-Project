package vn.techmaster.bookonline;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.bookonline.entitiy.*;
import vn.techmaster.bookonline.repository.AuthorRepository;
import vn.techmaster.bookonline.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public class DataInitializer {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private UserRepository userRepository;

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
                .status(Status.NORMAL)
                .roles(List.of("admin", "customer"))
                .build();
        userRepository.save(admin);

        User seller1 = User.builder()
                .username("seller1")
                .email("seller1@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("Seller 1")
                .gender(Gender.MALE)
                .dob(LocalDate.now().minusYears(21))
                .status(Status.NORMAL)
                .roles(List.of("seller", "customer"))
                .build();
        userRepository.save(seller1);

        User seller2 = User.builder()
                .username("seller2")
                .email("seller2@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("Seller 2")
                .gender(Gender.FEMALE)
                .dob(LocalDate.now().minusYears(22))
                .status(Status.NORMAL)
                .roles(List.of("seller", "customer"))
                .build();
        userRepository.save(seller2);

        User customer1 = User.builder()
                .username("customer1")
                .email("customer1@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("Customer 1")
                .gender(Gender.FEMALE)
                .dob(LocalDate.now().minusYears(23))
                .status(Status.NORMAL)
                .roles(List.of("customer"))
                .build();
        userRepository.save(customer1);

        User customer2 = User.builder()
                .username("customer2")
                .email("customer2@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("Customer 2")
                .gender(Gender.MALE)
                .dob(LocalDate.now().minusYears(24))
                .status(Status.NORMAL)
                .roles(List.of("customer"))
                .build();
        userRepository.save(customer2);
        // End create users

        // Begin create authors
        Author author1 = Author.builder()
                .fullName("Author 1")
                .gender(Gender.FEMALE)
                .address("Address author 1")
                .yearOfBirth(1980)
                .yearOfDeath(null)
                .books(null)
                .build();
        authorRepository.save(author1);

        Author author2 = Author.builder()
                .fullName("Author 2")
                .gender(Gender.MALE)
                .address("Address author 2")
                .yearOfBirth(1771)
                .yearOfDeath(1853)
                .books(null)
                .build();
        authorRepository.save(author2);
        // End create authors
    }
}

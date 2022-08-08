package vn.techmaster.bookonline.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.model.Gender;
import vn.techmaster.bookonline.model.Status;
import vn.techmaster.bookonline.model.User;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    // Find by id
    @Test
    void findById() {
        User testUser = User.builder()
                .username("test")
                .email("test@gmail.com")
                .mobile("123")
                .hashedPassword("123")
                .fullName("test")
                .gender(Gender.FEMALE)
                .dob(LocalDate.now().minusYears(20))
                .status(Status.NORMAL)
                .roles(List.of("customer"))
                .build();
        userRepository.save(testUser);
        User savedUser = userRepository.save(testUser);
        UUID id = savedUser.getId();
        User foundedUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Test failed"));
        assertThat(foundedUser.getId()).isEqualTo(id);
    }

    // Find all
    @Test
    void findAll() {
        assertThat(userRepository.findAll()).size().isEqualTo(5);
    }
}

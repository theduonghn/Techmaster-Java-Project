package vn.techmaster.bookonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.bookonline.model.Address;
import vn.techmaster.bookonline.model.Gender;
import vn.techmaster.bookonline.model.Status;
import vn.techmaster.bookonline.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class BookOnlineApplication implements ApplicationRunner {
	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(BookOnlineApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		// Create users
		User user1 = User.builder()
				.username("user1")
				.email("user1@gmail.com")
				.mobile("123")
				.hashedPassword("123")
				.fullName("User 1")
				.gender(Gender.FEMALE)
				.dob(LocalDate.now().minusYears(25))
				.status(Status.NORMAL)
				.build();
		entityManager.persist(user1);
		User user2 = User.builder()
				.username("user2")
				.email("user2@gmail.com")
				.mobile("123")
				.hashedPassword("123")
				.fullName("User 2")
				.gender(Gender.MALE)
				.dob(LocalDate.now().minusYears(25))
				.status(Status.NORMAL)
				.build();
		entityManager.persist(user2);

		// Create addresses
		Address address1 = Address.builder()
				.address("address 1")
				.user(user1)
				.build();
		entityManager.persist(address1);
		Address address2 = Address.builder()
				.address("address 2")
				.user(user1)
				.build();
		entityManager.persist(address2);
		Address address3 = Address.builder()
				.address("address 3")
				.user(user2)
				.build();
		entityManager.persist(address3);

		// Flush
		entityManager.flush();
	}
}

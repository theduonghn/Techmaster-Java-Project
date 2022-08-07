package vn.techmaster.bookonline;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.bookonline.model.Address;
import vn.techmaster.bookonline.model.Gender;
import vn.techmaster.bookonline.model.Status;
import vn.techmaster.bookonline.model.User;
import vn.techmaster.bookonline.repository.AddressRepository;
import vn.techmaster.bookonline.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public class DataInitializer {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void initData() {
        // Create users
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

        // Create addresses
        Address address1Admin = Address.builder()
                .address("address 1 admin")
                .user(admin)
                .build();
        addressRepository.save(address1Admin);

        Address address1Seller1 = Address.builder()
                .address("address 1 seller 1")
                .user(seller1)
                .build();
        addressRepository.save(address1Seller1);

        Address address2Seller1 = Address.builder()
                .address("address 2 seller 1")
                .user(seller1)
                .build();
        addressRepository.save(address2Seller1);
    }
}

package vn.techmaster.bookonline.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.bookonline.DataInitializer;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    // Find all
    @Test
    void findAll() {
        assertThat(addressRepository.findAll()).size().isEqualTo(3);
    }
}

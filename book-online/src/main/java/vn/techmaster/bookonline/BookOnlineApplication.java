package vn.techmaster.bookonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookOnlineApplication implements ApplicationRunner {
	@Autowired
	private MockDataInitializer mockDataInitializer;

	public static void main(String[] args) {
		SpringApplication.run(BookOnlineApplication.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {
		mockDataInitializer.initData();
	}
}

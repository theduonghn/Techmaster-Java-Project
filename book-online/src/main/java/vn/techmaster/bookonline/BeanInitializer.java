package vn.techmaster.bookonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializer {
    @Bean
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }
}

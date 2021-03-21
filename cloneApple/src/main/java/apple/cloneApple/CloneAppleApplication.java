package apple.cloneApple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing
@SpringBootApplication
public class CloneAppleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloneAppleApplication.class, args);
    }

}

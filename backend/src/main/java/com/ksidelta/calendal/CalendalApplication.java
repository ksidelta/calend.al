package com.ksidelta.calendal;

import com.ksidelta.calendal.mock.MockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Import(MockController.class)
public class CalendalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendalApplication.class, args);
    }

}

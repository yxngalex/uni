package com.metropolitan.it355dz08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class It355Dz08Application {

    public static void main(String[] args) {
        SpringApplication.run(It355Dz08Application.class, args);
    }

}

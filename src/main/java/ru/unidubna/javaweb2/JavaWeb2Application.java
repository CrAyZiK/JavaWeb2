package ru.unidubna.javaweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ru.unidubna.javaweb2.rep")
public class JavaWeb2Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaWeb2Application.class, args);
    }

}

package com.pablocomp.pablocompbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PabloCompBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PabloCompBackendApplication.class, args);
    }

}

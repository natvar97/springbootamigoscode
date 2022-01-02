package com.indialone.springbootamigoscode.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JULY;
import static java.time.Month.NOVEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student urvashi = new Student(
                    "Urvashi Prajapati",
                    "prajapatiurvashi2001@gmail.com",
                    LocalDate.of(2001, JULY, 17)
            );
            Student natu = new Student(
                    "Natavar Prajapati",
                    "prajapatinatavar21197@gmail.com",
                    LocalDate.of(1997, NOVEMBER, 02)
            );
            repository.saveAll(List.of(urvashi, natu));

        };
    }

}

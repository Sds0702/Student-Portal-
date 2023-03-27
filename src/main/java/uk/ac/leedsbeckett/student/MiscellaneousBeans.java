package uk.ac.leedsbeckett.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.leedsbeckett.student.model.Course;
import uk.ac.leedsbeckett.student.model.CourseRepository;

@Configuration
public class MiscellaneousBeans
{
    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            Course myCourse = new Course();
            myCourse.setTitle("SESC");
            myCourse.setDescription("Software Engineering for Service Computing");
            myCourse.setFee(10.00);
            courseRepository.save(myCourse);
        };
    }
}


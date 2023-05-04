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
            Course ISR = new Course();
            ISR.setTitle("ISR");
            ISR.setDescription("Intelligent Systems and Robotics");
            ISR.setFee(20.00);
            courseRepository.save(ISR);

            Course PGMT = new Course();
            PGMT.setTitle("PGMT");
            PGMT.setDescription("Project Management");
            PGMT.setFee(15.00);
            courseRepository.save(PGMT);

            Course SESC = new Course();
            SESC.setTitle("SESC");
            SESC.setDescription("Software Engineering for Service Computing");
            SESC.setFee(25.00);
            courseRepository.save(SESC);

            Course CCD = new Course();
            CCD.setTitle("CCD");
            CCD.setDescription("Cloud Computing Development");
            CCD.setFee(10.00);
            courseRepository.save(CCD);

            Course SS = new Course();
            SS.setTitle("SS");
            SS.setDescription("Smart Systems");
            SS.setFee(20.00);
            courseRepository.save(SS);


        };
    }
}


package uk.ac.leedsbeckett.student;

import org.h2.server.TcpServer;
import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.leedsbeckett.student.model.Course;
import uk.ac.leedsbeckett.student.model.CourseRepository;
import uk.ac.leedsbeckett.student.model.Student;
import uk.ac.leedsbeckett.student.model.StudentRepository;

import java.sql.SQLException;
import java.util.Set;

@Configuration
public class MiscellaneousBeans
{
    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository, StudentRepository studentRepository) {
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

            Student Samantha = new Student();
            Samantha.setExternalStudentId("c77339538");
            Samantha.setFirstname("Samantha");
            Samantha.setLastname("Sequeira");
            Samantha.setCoursesEnrolledIn(Set.of(SESC,CCD,ISR));

            Student Michael = new Student();
            Michael.setExternalStudentId("c74568915");
            Michael.setFirstname("Michael");
            Michael.setLastname("Charles");
            Michael.setCoursesEnrolledIn(Set.of(PGMT, SESC));

            studentRepository.saveAllAndFlush(Set.of(Samantha , Michael));
        };
    }
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
       return Server.createTcpServer("tcp","-tcpAllowOthers","-tcpPort","9092");
    }
}


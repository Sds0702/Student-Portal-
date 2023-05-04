package uk.ac.leedsbeckett.student.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(unique = true)
    private String externalStudentId;
    private String Firstname;
    private String Lastname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> coursesEnrolledIn;
}
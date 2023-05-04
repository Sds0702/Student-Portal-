package uk.ac.leedsbeckett.student.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface StudentRepository extends JpaRepository<Course, Long> {
    void saveAllAndFlush(Set<Student> samantha);
}

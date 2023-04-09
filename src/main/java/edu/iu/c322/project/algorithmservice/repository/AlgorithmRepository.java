package edu.iu.c322.project.algorithmservice.repository;

import edu.iu.c322.project.algorithmservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorithmRepository extends JpaRepository<Student, Integer> {

}

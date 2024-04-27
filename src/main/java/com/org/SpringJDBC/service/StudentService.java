package com.org.SpringJDBC.service;

import com.org.SpringJDBC.model.Student;
import com.org.SpringJDBC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repo ;



    public StudentRepository getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }


    public void addStudent(Student s) {
        repo.save(s);
    }

    public List<Student> getStudents(){
        return  repo.findAll();
    }

}

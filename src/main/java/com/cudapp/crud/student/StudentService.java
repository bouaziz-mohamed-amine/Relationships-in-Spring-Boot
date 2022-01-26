package com.cudapp.crud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        //        boolean exist = studentRepository.existsById(id);
//
//        if (exist) {
//            Optional<Student> std = studentRepository.findById(id);
//            return std;
//        } else {
//            throw new IllegalStateException(
//                    "student with id " + id + " does not exist "
//            );
//
//        }
        //System.out.println(studentRepository.findById(id).get().getPosts());
        return studentRepository.findById(id).get();
    }

    public void addStudent(Student student){

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist=studentRepository.existsById(id);

        if (exist){
                studentRepository.deleteById(id);
        }else {
            throw new IllegalStateException(
                    "student with id "+id+" does not exist "
            );
        };
    }


    public void updateStudent(Long id,Student student) {

        boolean exist = studentRepository.existsById(id);

        if (exist) {
            studentRepository.save(student);
        } else {
            throw new IllegalStateException(
                    "student with id " + id + " does not exist "
            );
        }
    }
}

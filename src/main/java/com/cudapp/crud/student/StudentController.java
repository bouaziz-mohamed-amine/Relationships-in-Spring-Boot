package com.cudapp.crud.student;

import com.cudapp.crud.role.Role;
import com.cudapp.crud.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/")
public class StudentController {


    private final StudentService studentService;
    private  final RoleService roleService;


    @Autowired
    public StudentController(StudentService studentService,RoleService roleService) {

        this.studentService =  studentService;
        this.roleService= roleService;
    }

    @GetMapping("students")
    public List<Student> getStudents() {

        return  studentService.getStudents();
    }

    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable Long id){

        return studentService.getStudent(id);
    }

    @PostMapping("students")
    public Student addStudent(@RequestBody Student student){

        studentService.addStudent(student);

         return student ;
    }

    @PutMapping("students/{id}")
    public void updateStudent(@PathVariable("id")  Long id, @RequestBody Student student ){
         studentService.updateStudent(id,student);
    }

    @DeleteMapping("students/{id}")
    public void   deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PostMapping("students/{studentId}/{roleId}")
    public void addRole(@PathVariable Long studentId, @PathVariable Long roleId){
        Student  student=studentService.getStudent(studentId);
        Role role=roleService.getRole(roleId);
        student.getRole().add(role);
        role.getStudent().add(student);
        studentService.addStudent(student);
        roleService.addRole(role);
    }

    @GetMapping("param")
    public String getParam(@RequestParam(name = "id") String id, @RequestParam String name){

        return "id: "+id+" "+name;
    }
}

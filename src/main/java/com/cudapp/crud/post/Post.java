package com.cudapp.crud.post;

import com.cudapp.crud.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;


@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private  String description;

    @ManyToOne
    //@JsonIgnore
    private Student student;

    public Post() {

    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
    @JsonIgnore
    public Student getStudent() {
        return student;
    }

    @JsonSetter
    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

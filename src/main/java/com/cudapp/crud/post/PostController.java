package com.cudapp.crud.post;


import com.cudapp.crud.student.Student;
import com.cudapp.crud.student.StudentService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class PostController {


    private  final PostService  postService;
    private  final StudentService studentService;

    @Autowired
    public PostController(PostService postService,StudentService studentService) {
        this.postService = postService;
        this.studentService=studentService;
    }

    @GetMapping("posts")
    public List<Post> getPosts() {

        return  postService.getPosts();
    }
    @GetMapping("posts/{id}")
    public Post getPost(@PathVariable Long id){

        return postService.getPost(id);
    }

    @PostMapping("/students/{studentId}/posts")
    public Post addPost(@PathVariable("studentId") Long id, @RequestBody Post post){

        Student student=studentService.getStudent(id);
        post.setStudent(student);
        postService.addPost(post);
        return post ;
    }

    @PutMapping("posts/{id}")
    public void updatePost(@PathVariable("id")  Long id, @RequestBody Post post ){
        postService.updatePost(id,post);
    }

    @DeleteMapping("posts/{id}")
    public void   deletePost(@PathVariable("id") Long id){

        postService.deletePost(id);
    }


}

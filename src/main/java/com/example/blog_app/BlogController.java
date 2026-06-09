package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BlogController {
    
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }
    
    @GetMapping("/blogs")
    //blogにきたらblog.htmlに移行
    public String blogs(){
        return "blogs";
    }

    @GetMapping("/blogs/{id}")
    public String idblog(){

    }

    @PostMapping("/post")
    public String post(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}

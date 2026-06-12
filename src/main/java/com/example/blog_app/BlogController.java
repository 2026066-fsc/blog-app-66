package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }
    
    @GetMapping("/blogs")
    //blogにきたらblog.htmlに移行
    public String blogs(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs); //blogsという名前のリストを運ぶ
        return "blogs";
    }

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blogs/detail";
    }

    @GetMapping("/post")
    public String postForm(){
        return "post";
    }

    @PostMapping("/post")
    public String create(@RequestParam String title, @RequestParam String body) {
        blogService.save(title, body);
        return "redirect:/blogs";
    }
    
}

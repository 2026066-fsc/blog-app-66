package com.example.blog_app;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Blog> findAll(){
        return postRepository.findAll();
    }

    public Optional<Blog> findById(Long id){
        return postRepository.findById(id);
    }

    public void save(String title, String body) {
        postRepository.save(title, body);
    }
}

package com.example.blog_app;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
    private final JdbcClient jdbcClient;

    public PostRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // 全部うけとるやつ
  public List<Blog> findAll(){
    return jdbcClient.sql("SELECT id, title, body FROM blogs")//１文を改行したいときは、改行してTab二回
        .query(Blog.class)
        .list(); //リストで受け取る。つまり全部
  }

  // 一個ずつ記事を表示
  public Optional<Blog> findById(Long id){
    return jdbcClient.sql("SELECT id, title, body FROM blogs WHERE id = :id")
        .param("id", id)
        .query(Blog.class)
        .optional();
  }

  //追加
  public void save(String title, String body) {
    jdbcClient.sql("INSERT INTO blogs (title, body) VALUES (:title, :body)")
        .param("title", title)
        .param("body", body)
        .update(); 
  }

}

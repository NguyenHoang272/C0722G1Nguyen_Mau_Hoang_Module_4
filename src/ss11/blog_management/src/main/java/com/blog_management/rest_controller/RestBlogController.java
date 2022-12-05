package com.blog_management.rest_controller;

import com.blog_management.model.Blog;
import com.blog_management.service.blog_service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> finById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
//        blog.setCategory(categoryService.findById(blog.getCategory().getId()));
        blogService.save(blog);
        Blog blog1 = blogService.findById(blog.getId());
        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @PutMapping(path="/update/{id}")
    public  ResponseEntity update(@PathVariable("id")int id, @RequestBody Blog blog){
        Blog blog2 = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.update(blog);
        return new ResponseEntity<>(blog2,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
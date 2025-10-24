package com.intexbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intexbox.dto.BlogPostDto;
import com.intexbox.service.BlogPostService;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

	private final BlogPostService blogPostService;

	@Autowired
	public BlogPostController(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

	// GET all blog posts
	@GetMapping
	public ResponseEntity<List<BlogPostDto>> getAllPosts() {
		List<BlogPostDto> posts = blogPostService.getAllBlogPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	// GET a single blog post by ID
	@GetMapping("/{id}")
	public ResponseEntity<BlogPostDto> getPostById(@PathVariable("id") Long id) {
		BlogPostDto post = blogPostService.getBlogPostById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	// CREATE a new blog post
	@PostMapping
	public ResponseEntity<BlogPostDto> createPost(@RequestBody BlogPostDto blogPostDto) {
		BlogPostDto newPost = blogPostService.createBlogPost(blogPostDto);
		return new ResponseEntity<>(newPost, HttpStatus.CREATED);
	}

	// UPDATE an existing blog post
	@PutMapping("/{id}")
	public ResponseEntity<BlogPostDto> updatePost(@PathVariable("id") Long id, @RequestBody BlogPostDto blogPostDto) {
		BlogPostDto updatedPost = blogPostService.updateBlogPost(id, blogPostDto);
		return new ResponseEntity<>(updatedPost, HttpStatus.OK);
	}

	// DELETE a blog post
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
		blogPostService.deleteBlogPost(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
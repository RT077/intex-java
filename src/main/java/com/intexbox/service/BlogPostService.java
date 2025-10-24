package com.intexbox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intexbox.dto.BlogPostDto;

@Service
public interface BlogPostService {

   List<BlogPostDto> getAllBlogPosts();

   BlogPostDto getBlogPostById(Long id);

   BlogPostDto createBlogPost(BlogPostDto blogPostDto);

   BlogPostDto updateBlogPost(Long id, BlogPostDto blogPostDto);

   void deleteBlogPost(Long id);
   
}
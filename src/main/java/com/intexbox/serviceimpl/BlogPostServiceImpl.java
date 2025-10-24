package com.intexbox.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intexbox.dto.BlogPostDto;
import com.intexbox.entity.BlogPost;
import com.intexbox.repositoy.BlogPostRepository;
import com.intexbox.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public List<BlogPostDto> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        return blogPosts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostDto getBlogPostById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog post not found with id: " + id));
        return convertToDto(blogPost);
    }

    @Override
    public BlogPostDto createBlogPost(BlogPostDto blogPostDto) {
        BlogPost blogPost = convertToEntity(blogPostDto);
        blogPost.setPublicationDate(LocalDateTime.now());
        BlogPost savedBlogPost = blogPostRepository.save(blogPost);
        return convertToDto(savedBlogPost);
    }

    @Override
    public BlogPostDto updateBlogPost(Long id, BlogPostDto blogPostDto) {
        BlogPost existingBlogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog post not found with id: " + id));

        existingBlogPost.setTitle(blogPostDto.getTitle());
        existingBlogPost.setContent(blogPostDto.getContent());
        existingBlogPost.setAuthor(blogPostDto.getAuthor());

        BlogPost updatedBlogPost = blogPostRepository.save(existingBlogPost);
        return convertToDto(updatedBlogPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new RuntimeException("Blog post not found with id: " + id);
        }
        blogPostRepository.deleteById(id);
    }

    // Helper methods for converting between Entity and DTO
    private BlogPostDto convertToDto(BlogPost blogPost) {
        return new BlogPostDto(
            blogPost.getId(),
            blogPost.getTitle(),
            blogPost.getContent(),
            blogPost.getAuthor(),
            blogPost.getPublicationDate()
        );
    }

    private BlogPost convertToEntity(BlogPostDto blogPostDto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostDto.getId());
        blogPost.setTitle(blogPostDto.getTitle());
        blogPost.setContent(blogPostDto.getContent());
        blogPost.setAuthor(blogPostDto.getAuthor());
        return blogPost;
    }
}

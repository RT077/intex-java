package com.intexbox.dto;

import java.time.LocalDateTime;

public class BlogPostDto {

	
	private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime publicationDate;
    
    
	
	public BlogPostDto(Long id, String title, String content, String author, LocalDateTime publicationDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.publicationDate = publicationDate;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDateTime publicationDate) {
		this.publicationDate = publicationDate;
	}
    
    
}

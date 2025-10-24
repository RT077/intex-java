package com.intexbox.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intexbox.entity.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

	// You can add custom query methods here if needed, e.g.,
	// List<BlogPost> findByAuthor(String author);

}
package com.intexbox.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intexbox.entity.ContactForm;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}
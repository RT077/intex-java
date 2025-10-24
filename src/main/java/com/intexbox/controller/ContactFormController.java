package com.intexbox.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intexbox.dto.ContactFormRequestDto;
import com.intexbox.dto.ContactFormResponseDto;
import com.intexbox.entity.ContactForm;
import com.intexbox.service.ContactFormService;

@RestController
@RequestMapping("/api")
public class ContactFormController {

	@Autowired
	private ContactFormService contactFormService;

	@PostMapping("/contact")
	public ResponseEntity<ContactFormResponseDto> submitContactForm(ContactFormRequestDto request) {

		ContactForm contactForm = new ContactForm();
		contactForm.setEnquiryType(request.getEnquiryType());
		contactForm.setFullName(request.getFullName());
		contactForm.setOrganization(request.getOrganization());
		contactForm.setJobTitle(request.getJobTitle());
		contactForm.setOfficialEmail(request.getOfficialEmail());
		contactForm.setPhoneNumber(request.getPhoneNumber());
		contactForm.setLocation(request.getLocation());
		contactForm.setSource(request.getSource());
		contactForm.setMessage(request.getMessage());
		contactForm.setPrivacyConsent(request.isPrivacyConsent());
		contactForm.setSubmissionTime(LocalDateTime.now());

		try {
			contactFormService.saveContactForm(contactForm);
			ContactFormResponseDto response = new ContactFormResponseDto("Form submitted successfully!", "success");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			ContactFormResponseDto response = new ContactFormResponseDto("Failed to submit form.", "error");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
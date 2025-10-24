package com.intexbox.dto;

public class ContactFormRequestDto {
	private String enquiryType;
	private String fullName;
	private String organization;
	private String jobTitle;
	private String officialEmail;
	private String phoneNumber;
	private String location;
	private String source;
	private String message;
	private boolean privacyConsent;

	// Default constructor is required
	public ContactFormRequestDto() {
	}

	public ContactFormRequestDto(String enquiryType, String fullName, String organization, String jobTitle,
			String officialEmail, String phoneNumber, String location, String source, String message,
			boolean privacyConsent) {
		super();
		this.enquiryType = enquiryType;
		this.fullName = fullName;
		this.organization = organization;
		this.jobTitle = jobTitle;
		this.officialEmail = officialEmail;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.source = source;
		this.message = message;
		this.privacyConsent = privacyConsent;
	}

	// Getters and setters for all fields
	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isPrivacyConsent() {
		return privacyConsent;
	}

	public void setPrivacyConsent(boolean privacyConsent) {
		this.privacyConsent = privacyConsent;
	}
}

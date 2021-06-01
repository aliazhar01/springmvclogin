package com.work.spring.DTO;

import lombok.Data;

@Data
public class RegistrationDto {

	private String fullName;
	private String EmailId;
	private String dob;
	private long contact;
	private String address;
	private String gender;
	private String password;

	public String getFullName() {
		return fullName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public String getDob() {
		return dob;
	}

	public long getContact() {
		return contact;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrationDto [fullName=" + fullName + ", EmailId=" + EmailId + ", dob=" + dob + ", contact="
				+ contact + ", address=" + address + ", gender=" + gender + ", password=" + password + "]";
	}

}

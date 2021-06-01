package com.work.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "springsave") // Login Table | Registaration Table
@Data
@NamedQueries({ @NamedQuery(name = "getByEmailId", query = "from RegistrationEntity as ed where ed.EmailId=:email"),
		@NamedQuery(name = "checkUserIsExistOrNot", query = "from RegistrationEntity as fn where fn.fullName=:Fullname") })
public class RegistrationEntity {

	@Id
	@Column(name = "ID")
	// @GenericGenerator(name = "anything", strategy ="increment" )
	// @GeneratedValue(generator = "anything")

	private int id;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "EMAIL_ID")
	private String EmailId;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "CONTACT")
	private long contact;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "REGISTEREDBY")
	private String registeredBy;
	@Column(name = "REGISTERED_DATE")
	private String registeredDate;

	public int getId() {
		return id;
	}

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

	public String getRegisteredBy() {
		return registeredBy;
	}

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", fullName=" + fullName + ", EmailId=" + EmailId + ", dob=" + dob
				+ ", contact=" + contact + ", address=" + address + ", gender=" + gender + ", password=" + password
				+ ", registeredBy=" + registeredBy + ", registeredDate=" + registeredDate + "]";
	}

}

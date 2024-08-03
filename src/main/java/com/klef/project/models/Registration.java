package com.klef.project.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="registration_table")
public class Registration implements Serializable
{

	private static final long serialVersionUID = 1L;
@Id
private int id;
@Column(name="fullname",nullable = false,length=100)
private String fullname;
@Column(name="email",nullable = false,length=100,unique=true)
private String email;
@Column(name="password",nullable=false,length=20)
private String password;
@Column(name="dob",nullable=false,length=20)
private Date dob;
@Column(name="gender",nullable=false,length=10)
private String gender;
@Column(name="marital_status",nullable=false,length=10)
private String marital_status;
@Column(name="blood_group",nullable=false,length=5)
private String blood_group;
@Column(name="contactno",nullable=false,length=15,unique = true)
private String contactno;
@Column(name="address",nullable = false,columnDefinition = "TEXT")
private String address;
@Column(name="position_title",nullable=false,length=50)
private String position_title;
@Column(name="department",nullable=false,length=50)
private String department;
@Column(name="data_of_joining",nullable=false,length=20)
private Date date_of_joining;
@Column(name="salary",nullable=false,precision = 10, scale = 2)
private BigDecimal salary;
@Column(name="years_of_experience",nullable=false,length=5)
private int years_of_experience;
@Column(name="emergency_contact_name",nullable = false,length=100)
private String emergency_contact_name;
@Column(name="emergency_contact_number",nullable = false,length=15)
private String emergency_contact_number;
@Column(name="national_id_number",nullable=false,length=50,unique = true)
private String national_id_number;
@Column(name="bank_account_details",nullable=false,length=100,unique = true)
private String bank_account_details;
@Column(name="previous_employer",nullable=false,length=10)
private String previous_employer;
@Column(name="education_qualification",nullable=false,length=100)
private String education_qualification;
@Column(name="skills",nullable=false,columnDefinition = "TEXT")
private String skills;
@Column(name="employee_type",nullable = false,length=20)
private String employee_type;
@Column(name="status",nullable=false,length=20)
private String status;
@Column(name="role",nullable=false,length=20)
private String role;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id =  id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMarital_status() {
	return marital_status;
}
public void setMarital_status(String marital_status) {
	this.marital_status = marital_status;
}
public String getBlood_group() {
	return blood_group;
}
public void setBlood_group(String blood_group) {
	this.blood_group = blood_group;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPosition_title() {
	return position_title;
}
public void setPosition_title(String position_title) {
	this.position_title = position_title;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public Date getDate_of_joining() {
	return date_of_joining;
}
public void setDate_of_joining(Date date_of_joining) {
	this.date_of_joining = date_of_joining;
}
public BigDecimal getSalary() {
	return salary;
}
public void setSalary(BigDecimal salary) {
	this.salary = salary;
}
public int getYears_of_experience() {
	return years_of_experience;
}
public void setYears_of_experience(int years_of_experience) {
	this.years_of_experience = years_of_experience;
}
public String getEmergency_contact_name() {
	return emergency_contact_name;
}
public void setEmergency_contact_name(String emergency_contact_name) {
	this.emergency_contact_name = emergency_contact_name;
}
public String getEmergency_contact_number() {
	return emergency_contact_number;
}
public void setEmergency_contact_number(String emergency_contact_number) {
	this.emergency_contact_number = emergency_contact_number;
}
public String getNational_id_number() {
	return national_id_number;
}
public void setNational_id_number(String national_id_number) {
	this.national_id_number = national_id_number;
}
public String getBank_account_details() {
	return bank_account_details;
}
public void setBank_account_details(String bank_account_details) {
	this.bank_account_details = bank_account_details;
}
public String getPrevious_employer() {
	return previous_employer;
}
public void setPrevious_employer(String previous_employer) {
	this.previous_employer = previous_employer;
}
public String getEducation_qualification() {
	return education_qualification;
}
public void setEducation_qualification(String education_qualification) {
	this.education_qualification = education_qualification;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public String getEmployee_type() {
	return employee_type;
}
public void setEmployee_type(String employee_type) {
	this.employee_type = employee_type;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}

package com.bezkoder.springjwt.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class StudentRequest {
    @NotBlank(message = "FirstName Should not be null")
    @Size(max = 30)
    private String firstname;

    @NotBlank(message = "LastName Should not be null")
    @Size(max = 30)
    private String lastname;

    @NotBlank(message = "FatherName Should not be null")
    private String fathername;
    @NotBlank(message = "FatherName Should not be null")
    private String mothername;
    @Email
    private String email;
    private LocalDate dob;

    private long contact;

    private String gender;
    private String religion;
    private String caste;
    private long adhaarNo;
    private String address;
    private String satsid;
    private String school;
    private String section;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public long getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(long adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSatsid() {
        return satsid;
    }

    public void setSatsid(String satsid) {
        this.satsid = satsid;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

}

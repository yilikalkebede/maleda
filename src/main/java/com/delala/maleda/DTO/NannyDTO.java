package com.delala.maleda.DTO;

public class NannyDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer expInYrs;
    private java.sql.Date availableDate;
    private Double expectedSalary;
    private String preferredLanguage;
    private String preferredSchedule;
    private String preferredCity;
    private String preferredState;
    private String primaryPhone;
    private String secondaryPhone;
    private String email;
    private java.sql.Timestamp createdDate;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getExpInYrs() {
        return this.expInYrs;
    }

    public void setExpInYrs(Integer expInYrs) {
        this.expInYrs = expInYrs;
    }

    public java.sql.Date getAvailableDate() {
        return this.availableDate;
    }

    public void setAvailableDate(java.sql.Date availableDate) {
        this.availableDate = availableDate;
    }

    public Double getExpectedSalary() {
        return this.expectedSalary;
    }

    public void setExpectedSalary(Double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredSchedule() {
        return this.preferredSchedule;
    }

    public void setPreferredSchedule(String preferredSchedule) {
        this.preferredSchedule = preferredSchedule;
    }

    public String getPreferredCity() {
        return this.preferredCity;
    }

    public void setPreferredCity(String preferredCity) {
        this.preferredCity = preferredCity;
    }

    public String getPreferredState() {
        return this.preferredState;
    }

    public void setPreferredState(String preferredState) {
        this.preferredState = preferredState;
    }

    public String getPrimaryPhone() {
        return this.primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return this.secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}

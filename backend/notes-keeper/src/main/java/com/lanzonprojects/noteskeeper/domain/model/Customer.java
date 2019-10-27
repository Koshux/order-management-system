package com.lanzonprojects.noteskeeper.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by james on 27/10/2019.
 */
@JsonApiResource(type = "customers")
public class Customer {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @JsonApiField(patchable = false, postable = false)
    private Timestamp creationDate;

    private String customerName;
    private String phoneNumber;
    private String houseName;
    private String streetName;
    private String postCode;
    private int dogsCount;
    private List<String> dogNames;
    private int limitDogCalories;
    private int dogAge;
    private String breed;
    private List<String> allergies;
    private List<String> healthIssues;
    private List<String> behaviouralProblems;
    private List<String> blacklistIngredients;
    private List<String> toysTypes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getDogsCount() {
        return dogsCount;
    }

    public void setDogsCount(int dogsCount) {
        this.dogsCount = dogsCount;
    }

    public List<String> getDogNames() {
        return dogNames;
    }

    public void setDogNames(List<String> dogNames) {
        this.dogNames = dogNames;
    }

    public int getLimitDogCalories() {
        return limitDogCalories;
    }

    public void setLimitDogCalories(int limitDogCalories) {
        this.limitDogCalories = limitDogCalories;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(List<String> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public List<String> getBehaviouralProblems() {
        return behaviouralProblems;
    }

    public void setBehaviouralProblems(List<String> behaviouralProblems) {
        this.behaviouralProblems = behaviouralProblems;
    }

    public List<String> getBlacklistIngredients() {
        return blacklistIngredients;
    }

    public void setBlacklistIngredients(List<String> blacklistIngredients) {
        this.blacklistIngredients = blacklistIngredients;
    }

    public List<String> getToysTypes() {
        return toysTypes;
    }

    public void setToysTypes(List<String> toysTypes) {
        this.toysTypes = toysTypes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", houseName='").append(houseName).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", postCode='").append(postCode).append('\'');
        sb.append(", dogsCount=").append(dogsCount);
        sb.append(", dogNames=").append(dogNames);
        sb.append(", limitDogCalories=").append(limitDogCalories);
        sb.append(", dogAge=").append(dogAge);
        sb.append(", breed='").append(breed).append('\'');
        sb.append(", allergies=").append(allergies);
        sb.append(", healthIssues=").append(healthIssues);
        sb.append(", behaviouralProblems=").append(behaviouralProblems);
        sb.append(", blacklistIngredients=").append(blacklistIngredients);
        sb.append(", toysTypes=").append(toysTypes);
        sb.append('}');
        return sb.toString();
    }
}

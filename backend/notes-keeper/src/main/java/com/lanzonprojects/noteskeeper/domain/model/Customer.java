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
}

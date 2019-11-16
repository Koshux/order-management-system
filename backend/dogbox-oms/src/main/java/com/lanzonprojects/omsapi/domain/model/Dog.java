package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * @author lanzon-projects
 */
@JsonApiResource(type = "dogs")
public class Dog {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 2)
    private String age;

    @Length(max = 6)
    private int limitCalories;

    @Length(max = 45)
    private String name;

    private int breedId;

    @JsonApiRelation(lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private Breed breed;

    @JsonApiRelation//(mappedBy = "dogAllergies", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<Allergy> allergies;

    @JsonApiRelation//(mappedBy = "dogToysTypes", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<ToyType> toysTypes;

    @JsonApiRelation//(mappedBy = "dogHealthIssues", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<HealthIssue> healthIssues;

    @JsonApiRelation//(mappedBy = "dogBehaviouralProblems", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<BehaviouralProblem> behaviouralProblems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getLimitCalories() {
        return limitCalories;
    }

    public void setLimitCalories(int limitCalories) {
        this.limitCalories = limitCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public List<ToyType> getToysTypes() {
        return toysTypes;
    }

    public void setToysTypes(List<ToyType> toysTypes) {
        this.toysTypes = toysTypes;
    }

    public List<HealthIssue> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(List<HealthIssue> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public List<BehaviouralProblem> getBehaviouralProblems() {
        return behaviouralProblems;
    }

    public void setBehaviouralProblems(List<BehaviouralProblem> behaviouralProblems) {
        this.behaviouralProblems = behaviouralProblems;
    }

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog{");
        sb.append("id=").append(id);
        sb.append(", age='").append(age).append('\'');
        sb.append(", limitCalories=").append(limitCalories);
        sb.append(", name='").append(name).append('\'');
        sb.append(", breedId=").append(breedId);
        sb.append(", breeds=").append(breed);
        sb.append(", allergies=").append(allergies);
        sb.append(", toysTypes=").append(toysTypes);
        sb.append(", healthIssues=").append(healthIssues);
        sb.append(", behaviouralProblems=").append(behaviouralProblems);
        sb.append('}');
        return sb.toString();
    }
}

package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.*;

import java.util.List;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "dogsInfo")
public class DogInfo {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long dogId;

    @JsonApiRelationId
    private int allergyId;

    @JsonApiRelationId
    private int toyTypeId;

    @JsonApiRelationId
    private int healthIssueId;

    @JsonApiRelationId
    private int behaviouralProblemsId;

    @JsonApiRelation(idField = "allergyId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<Allergy> allergies;

    @JsonApiRelation(idField = "toyTypeId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<ToyType> toysTypes;

    @JsonApiRelation(idField = "healthIssueId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<HealthIssue> healthIssues;

    @JsonApiRelation(idField = "behaviouralProblemsId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private List<BehaviouralProblem> behaviouralProblems;

    public long getDogId() {
        return dogId;
    }

    public void setDogId(long dogId) {
        this.dogId = dogId;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public int getToyTypeId() {
        return toyTypeId;
    }

    public void setToyTypeId(int toyTypeId) {
        this.toyTypeId = toyTypeId;
    }

    public int getHealthIssueId() {
        return healthIssueId;
    }

    public void setHealthIssueId(int healthIssueId) {
        this.healthIssueId = healthIssueId;
    }

    public int getBehaviouralProblemsId() {
        return behaviouralProblemsId;
    }

    public void setBehaviouralProblemsId(int behaviouralProblemsId) {
        this.behaviouralProblemsId = behaviouralProblemsId;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DogInfo{");
        sb.append("dogId=").append(dogId);
        sb.append(", allergyId=").append(allergyId);
        sb.append(", toyTypeId=").append(toyTypeId);
        sb.append(", healthIssueId=").append(healthIssueId);
        sb.append(", behaviouralProblemsId=").append(behaviouralProblemsId);
        sb.append(", allergies=").append(allergies);
        sb.append(", toysTypes=").append(toysTypes);
        sb.append(", healthIssues=").append(healthIssues);
        sb.append(", behaviouralProblems=").append(behaviouralProblems);
        sb.append('}');
        return sb.toString();
    }
}

package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.*;

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
    private int behaviouralProblemId;

    @JsonApiRelation(idField = "allergyId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private Allergy allergy;

    @JsonApiRelation(idField = "toyTypeId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private ToyType toysType;

    @JsonApiRelation(idField = "healthIssueId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private HealthIssue healthIssue;

    @JsonApiRelation(idField = "behaviouralProblemsId", lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
    private BehaviouralProblem behaviouralProblem;

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

    public int getBehaviouralProblemId() {
        return behaviouralProblemId;
    }

    public void setBehaviouralProblemId(int behaviouralProblemId) {
        this.behaviouralProblemId = behaviouralProblemId;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public ToyType getToysType() {
        return toysType;
    }

    public void setToysType(ToyType toysType) {
        this.toysType = toysType;
    }

    public HealthIssue getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(HealthIssue healthIssue) {
        this.healthIssue = healthIssue;
    }

    public BehaviouralProblem getBehaviouralProblem() {
        return behaviouralProblem;
    }

    public void setBehaviouralProblem(BehaviouralProblem behaviouralProblem) {
        this.behaviouralProblem = behaviouralProblem;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DogInfo{");
        sb.append("dogId=").append(dogId);
        sb.append(", allergyId=").append(allergyId);
        sb.append(", toyTypeId=").append(toyTypeId);
        sb.append(", healthIssueId=").append(healthIssueId);
        sb.append(", behaviouralProblemId=").append(behaviouralProblemId);
        sb.append(", allergy=").append(allergy);
        sb.append(", toysType=").append(toysType);
        sb.append(", healthIssue=").append(healthIssue);
        sb.append(", behaviouralProblem=").append(behaviouralProblem);
        sb.append('}');
        return sb.toString();
    }
}

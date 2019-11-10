package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
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
    private int age;

    @Length(max = 6)
    private int limitCalories;

    @Length(max = 45)
    private String name;

    @JsonApiRelation
    private Breed breeds;

    @JsonApiRelation
    private List<Allergy> allergies;

    @JsonApiRelation
    private List<ToyType> toysTypes;

    @JsonApiRelation
    private List<HealthIssue> healthIssues;

    @JsonApiRelation
    private List<BehaviouralProblem> behaviouralProblems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public Breed getBreeds() {
        return breeds;
    }

    public void setBreeds(Breed breeds) {
        this.breeds = breeds;
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
        final StringBuilder sb = new StringBuilder("Dog{");
        sb.append("id=").append(id);
        sb.append(", age=").append(age);
        sb.append(", limitCalories=").append(limitCalories);
        sb.append(", name='").append(name).append('\'');
        sb.append(", breeds=").append(breeds);
        sb.append(", allergies=").append(allergies);
        sb.append(", toysTypes=").append(toysTypes);
        sb.append(", healthIssues=").append(healthIssues);
        sb.append(", behaviouralProblems=").append(behaviouralProblems);
        sb.append('}');
        return sb.toString();
    }
}

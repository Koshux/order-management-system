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

    @JsonApiRelation(opposite = "breeds")
    private Breed breeds;
    @JsonApiRelation(opposite = "allergies")
    private List<String> allergies;
    @JsonApiRelation(opposite = "toysTypes")
    private List<String> toysTypes;
    @JsonApiRelation(opposite = "healthIssues")
    private List<String> healthIssues;
    @JsonApiRelation(opposite = "behaviourProblems")
    private List<String> behaviouralProblems;
}

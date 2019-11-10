package com.lanzonprojects.omsapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author lanzon-projects
 */
@JsonApiResource(type = "customers")
public class Customer {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @JsonApiField(patchable = false, postable = false)
    private Timestamp creationDate;

    @Length(max = 100)
    private String name;

    @Length(max = 12)
    private String phoneNumber;

    @Length(max = 20)
    private String houseName;

    @Length(max = 35)
    private String streetName;

    @Length(max = 20)
    private String postCode;

    @JsonApiRelation(opposite = "dogs")
    private List<Dog> dogs;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", houseName='").append(houseName).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", postCode='").append(postCode).append('\'');
        sb.append(", dogs=").append(dogs);
        sb.append('}');
        return sb.toString();
    }
}

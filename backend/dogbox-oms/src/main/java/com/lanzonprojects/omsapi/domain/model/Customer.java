package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.*;
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
    private String addrLine1;

    @Length(max = 35)
    private String addrLine2;

    @Length(max = 35)
    private String addrLine3;

    @Length(max = 20)
    private String postCode;

    @JsonApiRelation(lookUp = LookupIncludeBehavior.AUTOMATICALLY_ALWAYS)
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

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getAddrLine3() {
        return addrLine3;
    }

    public void setAddrLine3(String addrLine3) {
        this.addrLine3 = addrLine3;
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
        sb.append(", addrLine1='").append(addrLine1).append('\'');
        sb.append(", addrLine2='").append(addrLine2).append('\'');
        sb.append(", addrLine3='").append(addrLine3).append('\'');
        sb.append(", postCode='").append(postCode).append('\'');
        sb.append(", dogs=").append(dogs);
        sb.append('}');
        return sb.toString();
    }
}

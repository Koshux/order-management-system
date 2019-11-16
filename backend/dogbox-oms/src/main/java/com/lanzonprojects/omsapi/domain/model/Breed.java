package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

/**
 * @author lanzon-projects
 */
@JsonApiResource(type = "breeds")
public class Breed {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 100)
    private String name;

    @Length(max = 3)
    private int sizeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Breed{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sizeId='").append(sizeId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

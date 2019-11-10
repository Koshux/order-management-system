package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "allergies")
public class Allergy {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 50)
    private String name;
}

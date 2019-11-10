package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

import java.util.List;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "products")
public class Product {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @JsonApiRelation(opposite = "ingredients")
    private List<String> ingredients;
}

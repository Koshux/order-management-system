package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "suitabilityInfo")
public class SuitabilityInfo {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 35)
    private String age;

    @JsonApiRelation
    private Size size;

    @JsonApiRelation
    private Event event;

    @JsonApiRelation
    private Product product;

    @JsonApiRelation
    private Supplier supplier;

    @JsonApiRelation
    private List<Attribute> attributes;

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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SuitabilityInfo{");
        sb.append("id=").append(id);
        sb.append(", age='").append(age).append('\'');
        sb.append(", size=").append(size);
        sb.append(", event=").append(event);
        sb.append(", product=").append(product);
        sb.append(", supplier=").append(supplier);
        sb.append(", attributes=").append(attributes);
        sb.append('}');
        return sb.toString();
    }
}

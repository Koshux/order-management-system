package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "products")
public class Product {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 100)
    private String name;

    @Length(max = 100)
    private String weight;

    @Length(max = 500)
    private String notes;

    @Length(max = 250)
    private String sku;

    @JsonApiRelation
    private Size size;

    @JsonApiRelation
    private Brand brand;

    @JsonApiRelation
    private Flavour flavour;

    @JsonApiRelation
    private Supplier supplier;

    @JsonApiRelation
    private ProductType productType;

    @JsonApiRelation
    private FinancialInfo financialInfo;

    @JsonApiRelation
    private NutritionalInfo nutritionalInfo;

    @JsonApiRelation
    private SuitabilityInfo suitabilityInfo;

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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public FinancialInfo getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(FinancialInfo financialInfo) {
        this.financialInfo = financialInfo;
    }

    public NutritionalInfo getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(NutritionalInfo nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }

    public SuitabilityInfo getSuitabilityInfo() {
        return suitabilityInfo;
    }

    public void setSuitabilityInfo(SuitabilityInfo suitabilityInfo) {
        this.suitabilityInfo = suitabilityInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", sku='").append(sku).append('\'');
        sb.append(", size=").append(size);
        sb.append(", flavour=").append(flavour);
        sb.append(", supplier=").append(supplier);
        sb.append(", brand=").append(brand);
        sb.append(", productType=").append(productType);
        sb.append(", financialInfo=").append(financialInfo);
        sb.append(", nutritionalInfo=").append(nutritionalInfo);
        sb.append(", suitabilityInfo=").append(suitabilityInfo);
        sb.append('}');
        return sb.toString();
    }
}

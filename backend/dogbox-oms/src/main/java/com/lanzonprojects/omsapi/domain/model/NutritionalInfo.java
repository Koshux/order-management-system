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
@JsonApiResource(type = "nutritionalInfo")
public class NutritionalInfo {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    @Length(max = 1000)
    private String kcalPerHundred;

    @Length(max = 100)
    private String percentageMeat;

    @Length(max = 100)
    private String percentageProtein;

    @Length(max = 100)
    private String percentageFat;

    @Length(max = 100)
    private String percentageCarbs;

    @JsonApiRelation
    private Product product;

    @JsonApiRelation
    private List<Ingredient> ingredients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKcalPerHundred() {
        return kcalPerHundred;
    }

    public void setKcalPerHundred(String kcalPerHundred) {
        this.kcalPerHundred = kcalPerHundred;
    }

    public String getPercentageMeat() {
        return percentageMeat;
    }

    public void setPercentageMeat(String percentageMeat) {
        this.percentageMeat = percentageMeat;
    }

    public String getPercentageProtein() {
        return percentageProtein;
    }

    public void setPercentageProtein(String percentageProtein) {
        this.percentageProtein = percentageProtein;
    }

    public String getPercentageFat() {
        return percentageFat;
    }

    public void setPercentageFat(String percentageFat) {
        this.percentageFat = percentageFat;
    }

    public String getPercentageCarbs() {
        return percentageCarbs;
    }

    public void setPercentageCarbs(String percentageCarbs) {
        this.percentageCarbs = percentageCarbs;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NutritionalInfo{");
        sb.append("id=").append(id);
        sb.append(", kcalPerHundred='").append(kcalPerHundred).append('\'');
        sb.append(", percentageMeat='").append(percentageMeat).append('\'');
        sb.append(", percentageProtein='").append(percentageProtein).append('\'');
        sb.append(", percentageFat='").append(percentageFat).append('\'');
        sb.append(", percentageCarbs='").append(percentageCarbs).append('\'');
        sb.append(", product=").append(product);
        sb.append(", ingredients=").append(ingredients);
        sb.append('}');
        return sb.toString();
    }
}

package com.lanzonprojects.omsapi.domain.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.hibernate.validator.constraints.Length;

/**
 * @author lanzon-projects.
 */
@JsonApiResource(type = "financialInfo")
public class FinancialInfo {

    @JsonApiId
    @JsonApiField(patchable = false, postable = false)
    private long id;

    private boolean isVatUsed;

    @Length(max = 1000)
    private String rrp;

    @Length(max = 1000)
    private String profit;

    @Length(max = 1000)
    private String purchasePrice;

    @Length(max = 1000)
    private String vatValue;

    @Length(max = 1000)
    private String vatRefund;

    @Length(max = 1000)
    private String vatAdjustedCogs;

    @JsonApiRelation
    private Product product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVatUsed() {
        return isVatUsed;
    }

    public void setVatUsed(boolean vatUsed) {
        isVatUsed = vatUsed;
    }

    public String getRrp() {
        return rrp;
    }

    public void setRrp(String rrp) {
        this.rrp = rrp;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getVatValue() {
        return vatValue;
    }

    public void setVatValue(String vatValue) {
        this.vatValue = vatValue;
    }

    public String getVatRefund() {
        return vatRefund;
    }

    public void setVatRefund(String vatRefund) {
        this.vatRefund = vatRefund;
    }

    public String getVatAdjustedCogs() {
        return vatAdjustedCogs;
    }

    public void setVatAdjustedCogs(String vatAdjustedCogs) {
        this.vatAdjustedCogs = vatAdjustedCogs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FinancialInfo{");
        sb.append("id=").append(id);
        sb.append(", isVatUsed=").append(isVatUsed);
        sb.append(", rrp='").append(rrp).append('\'');
        sb.append(", profit='").append(profit).append('\'');
        sb.append(", purchasePrice='").append(purchasePrice).append('\'');
        sb.append(", vatValue='").append(vatValue).append('\'');
        sb.append(", vatRefund='").append(vatRefund).append('\'');
        sb.append(", vatAdjustedCogs='").append(vatAdjustedCogs).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

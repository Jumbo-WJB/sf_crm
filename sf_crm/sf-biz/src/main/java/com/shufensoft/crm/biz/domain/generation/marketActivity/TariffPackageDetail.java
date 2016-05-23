package com.shufensoft.crm.biz.domain.generation.marketActivity;

import java.math.BigDecimal;
import java.util.Date;

public class TariffPackageDetail {
    /**  */
    private Long id;

    /**  */
    private Date gmtCreated;

    /**  */
    private Date gmtModified;

    /**  */
    private String createdBy;

    /**  */
    private String modifiedBy;

    /**  */
    private String isDeleted;

    /**  */
    private String tariffType;

    /**  */
    private String tariffName;

    /**  */
    private Integer tariffAmount;

    /**  */
    private BigDecimal tariffMoney;

    /**  */
    private Integer tariffFree;

    /**  */
    private String tariffDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getTariffType() {
        return tariffType;
    }

    public void setTariffType(String tariffType) {
        this.tariffType = tariffType == null ? null : tariffType.trim();
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName == null ? null : tariffName.trim();
    }

    public Integer getTariffAmount() {
        return tariffAmount;
    }

    public void setTariffAmount(Integer tariffAmount) {
        this.tariffAmount = tariffAmount;
    }

    public BigDecimal getTariffMoney() {
        return tariffMoney;
    }

    public void setTariffMoney(BigDecimal tariffMoney) {
        this.tariffMoney = tariffMoney;
    }

    public Integer getTariffFree() {
        return tariffFree;
    }

    public void setTariffFree(Integer tariffFree) {
        this.tariffFree = tariffFree;
    }

    public String getTariffDesc() {
        return tariffDesc;
    }

    public void setTariffDesc(String tariffDesc) {
        this.tariffDesc = tariffDesc == null ? null : tariffDesc.trim();
    }
}
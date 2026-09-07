package com.andurasoftware.alexandria.business.common.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseAuditableState extends BaseState {

    @Column(name = "version")
    private LocalDateTime version;


    //region Getters and Setters
    public LocalDateTime getVersion() {
        return version;
    }
    public void setVersion(LocalDateTime version) {
        this.version = version;
    }
    //endregion
}

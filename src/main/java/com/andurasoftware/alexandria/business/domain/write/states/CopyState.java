package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.base.BaseAuditableState;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="[copy]")
public class CopyState extends BaseAuditableState {

    @Column
    private String code;
    @Column(name = "title_id", columnDefinition = "uniqueidentifier")
    private UUID titleId;

    //region Getters and Setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public UUID getTitleId() { return titleId; }
    public void setTitleId(UUID titleId) { this.titleId = titleId; }
    //endregion

}

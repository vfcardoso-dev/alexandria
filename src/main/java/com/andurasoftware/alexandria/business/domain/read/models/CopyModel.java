package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

@Immutable
@Entity
@Table(name="[copy]")
public class CopyModel extends BaseModel {

    @Column
    private String code;

    @ManyToOne()
    @JoinColumn(name="title_id")
    @JsonIgnore
    private TitleModel titleModel;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TitleModel getTitleModel() {
        return titleModel;
    }

    public void setTitleModel(TitleModel titleModel) {
        this.titleModel = titleModel;
    }
}

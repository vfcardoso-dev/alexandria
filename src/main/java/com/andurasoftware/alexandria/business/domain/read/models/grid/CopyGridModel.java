package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import jakarta.persistence.*;
import org.springframework.data.annotation.Immutable;

@Immutable
@Entity
@Table(name="[copy]")
public class CopyGridModel extends BaseModel {

    @Column
    private String code;

    @ManyToOne()
    @JoinColumn(name="title_id")
    private TitleGridModel titleModel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TitleGridModel getTitleModel() {
        return titleModel;
    }

    public void setTitleModel(TitleGridModel titleModel) {
        this.titleModel = titleModel;
    }
}

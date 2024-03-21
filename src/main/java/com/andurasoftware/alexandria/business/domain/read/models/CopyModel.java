package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[copy]")
public class CopyModel {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id; //TODO: abstrair

    @Column
    private String code;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="title_id")
    private TitleModel titleModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

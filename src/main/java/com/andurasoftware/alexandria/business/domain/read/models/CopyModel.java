package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[copy]")
public class CopyModel {
    @Id
    private UUID id; //TODO: abstrair

    @Column
    private int number;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="title_id")
    private TitleModel titleModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TitleModel getTitleModel() {
        return titleModel;
    }

    public void setTitleModel(TitleModel titleModel) {
        this.titleModel = titleModel;
    }
}

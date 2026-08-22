package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[title]")
public class TitleModel extends BaseModel {

    @Column
    private String name;
    @ManyToMany(mappedBy = "titleSet")
    private Set<AuthorModel> authorSet = new HashSet<>();

    @OneToMany(mappedBy = "titleModel")
    private Set<CopyModel> copySet = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorModel> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<AuthorModel> authorSet) {
        this.authorSet = authorSet;
    }

    public Set<CopyModel> getCopySet() {
        return copySet;
    }

    public void setCopySet(Set<CopyModel> copySet) {
        this.copySet = copySet;
    }
}

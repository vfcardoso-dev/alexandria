package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import com.andurasoftware.alexandria.business.domain.read.models.AuthorModel;
import com.andurasoftware.alexandria.business.domain.read.models.CopyModel;
import jakarta.persistence.*;
import org.springframework.data.annotation.Immutable;

import java.util.HashSet;
import java.util.Set;

@Immutable
@Entity
@Table(name="[title]")
public class TitleGridModel extends BaseModel {
    @Column
    private String name;

    @ManyToMany(mappedBy = "titleSet")
    private Set<AuthorGridModel> authorSet = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorGridModel> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<AuthorGridModel> authorSet) {
        this.authorSet = authorSet;
    }

}

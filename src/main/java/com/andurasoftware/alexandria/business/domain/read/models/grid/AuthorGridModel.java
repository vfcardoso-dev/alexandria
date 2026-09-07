package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import com.andurasoftware.alexandria.business.domain.read.models.AuthorModel;
import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Immutable
@Entity
@Table(name="[author]")
public class AuthorGridModel extends BaseModel {

    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String pseudonym;

    @ManyToMany()
    @JoinTable(
            name = "[author_title]",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "title_id") }
    )
    @JsonIgnore
    Set<TitleGridModel> titleSet = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
}

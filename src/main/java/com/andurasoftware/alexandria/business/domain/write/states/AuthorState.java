package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.base.BaseAuditableState;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="[author]")
public class AuthorState extends BaseAuditableState {

    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String pseudonym;


    @ManyToMany(mappedBy = "authors")
    private final Set<TitleState> titles = new HashSet<>();


    //region Getters and Setters

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

    //endregion
}

package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[author]")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AuthorModel implements Model {

    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String pseudonym;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "[author_title]",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "title_id") }
    )
    Set<TitleModel> titleSet = new HashSet<>();

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

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

    public Set<TitleModel> getTitleSet() {
        return titleSet;
    }

    public void setTitleSet(Set<TitleModel> titleSet) {
        this.titleSet = titleSet;
    }
}

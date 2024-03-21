package com.andurasoftware.alexandria.business.domain.read.models;

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
@Table(name="[title]")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TitleModel {
    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "titleSet")
    private Set<AuthorModel> authorSet = new HashSet<>();

    @OneToMany(mappedBy = "titleModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CopyModel> copySet = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

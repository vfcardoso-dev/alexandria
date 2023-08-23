package com.andurasoftware.alexandria.business.domain.read.models;

import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[title]")
public class TitleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "projectSet")
    private Set<AuthorModel> authorSet = new HashSet<>();

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
}

package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="[title]")
public class TitleState implements State {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column
    private String name;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "[author_title]",
            joinColumns = { @JoinColumn(name = "title_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    Set<AuthorState> authors = new HashSet<>();

    @Override
    public UUID getId() {
       return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorState> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorState> authors) {
        this.authors = authors;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Date getVersion() {
        return null;
    }

    @Override
    public void setVersion(Date version) {

    }
}

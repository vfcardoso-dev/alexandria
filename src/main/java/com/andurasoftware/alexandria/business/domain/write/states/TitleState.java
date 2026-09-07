package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.base.BaseState;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="[title]")
public class TitleState extends BaseState {

    @Column
    private String name;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "[author_title]",
            joinColumns = { @JoinColumn(name = "title_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    Set<AuthorState> authors = new HashSet<>();

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

}

package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="[author]")
public class AuthorState implements State {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String pseudonym;


    @ManyToMany(mappedBy = "authors")
    private final Set<TitleState> titles = new HashSet<>();

    @Column
    private Date version;

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

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }
}

package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[author]")
public class AuthorGridModel implements Model {

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
}

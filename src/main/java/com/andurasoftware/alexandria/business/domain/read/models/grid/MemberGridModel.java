package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[member]")
public class MemberGridModel implements Model {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column
    private String name;

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
}

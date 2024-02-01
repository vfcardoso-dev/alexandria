package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;

import javax.persistence.*;
import java.util.Date;
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

    @Override
    public UUID getId() {
       return this.id;
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

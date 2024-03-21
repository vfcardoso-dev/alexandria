package com.andurasoftware.alexandria.business.domain.write.states;

import javax.persistence.*;

import com.andurasoftware.alexandria.business.common.interfaces.State;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="[copy]")
public class CopyState implements State {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String code;

    @Column(name = "title_id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID titleId;

    @Column
    private Date version;

    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }

    public UUID getTitleId() { return titleId; }

    public void setTitleId(UUID titleId) { this.titleId = titleId; }

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
        return this.version;
    }
    @Override
    public void setVersion(Date version) {
        this.version = version;
    }
}

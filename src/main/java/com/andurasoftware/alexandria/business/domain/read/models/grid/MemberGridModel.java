package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[member]")
public class MemberGridModel extends BaseModel {

    @Column
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

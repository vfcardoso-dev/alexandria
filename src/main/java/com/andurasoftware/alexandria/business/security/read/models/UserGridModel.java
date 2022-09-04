package com.andurasoftware.alexandria.business.security.read.models;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import com.andurasoftware.alexandria.business.security.shared.valueobjects.SecurityRole;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Immutable
@Entity
@Table(name="[user]")
public class UserGridModel implements Model {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @Enumerated(STRING)
    private SecurityRole role;

    @Column
    private Boolean enabled = true;

    @Column
    private Date createdAt;

    @Override
    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SecurityRole getRole() {
        return role;
    }

    public void setRole(SecurityRole role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

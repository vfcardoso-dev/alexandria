package com.andurasoftware.alexandria.business.security.write.states;

import com.andurasoftware.alexandria.business.common.base.BaseAuditableState;
import com.andurasoftware.alexandria.business.security.shared.valueobjects.SecurityRole;

import jakarta.persistence.*;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name="[user]")
public class UserState extends BaseAuditableState {
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(STRING)
    private SecurityRole role;

    @Column(nullable = false)
    private Boolean enabled = true;


    //region Getters and Setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    //endregion
}

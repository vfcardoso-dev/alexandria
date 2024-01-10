package com.andurasoftware.alexandria.business.security.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;
import com.andurasoftware.alexandria.business.security.shared.valueobjects.SecurityRole;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name="[user]")
public class UserState implements State {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

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

    @Version()
    protected Date version;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }
}

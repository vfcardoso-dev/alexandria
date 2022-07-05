package com.andurasoftware.alexandria.business.models;

import com.andurasoftware.alexandria.business.valueobjects.SecurityRole;
import javax.persistence.*;
import java.util.Date;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name="[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(STRING)
    private SecurityRole role;

    @Column(nullable = false)
    private Boolean enabled = false;

    @Column(nullable = false)
    private Date dateCreate = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}

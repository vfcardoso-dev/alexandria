package com.andurasoftware.alexandria.business.domain.read.models;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import com.andurasoftware.alexandria.business.domain.read.models.TitleModel;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[author]")
public class AuthorModel implements Model {

    @Id
    private UUID id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String pseudonimo;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "[author_title]",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "title_id") }
    )
    Set<TitleModel> projectSet = new HashSet<>();

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public Set<TitleModel> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<TitleModel> projectSet) {
        this.projectSet = projectSet;
    }
}

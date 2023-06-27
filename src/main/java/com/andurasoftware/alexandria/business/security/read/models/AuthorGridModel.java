package com.andurasoftware.alexandria.business.security.read.models;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[author]")
public class AuthorGridModel implements Model {

    @Id
    private UUID id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String pseudonimo;

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
}

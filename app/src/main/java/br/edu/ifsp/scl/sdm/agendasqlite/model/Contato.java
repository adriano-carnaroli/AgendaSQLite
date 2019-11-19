package br.edu.ifsp.scl.sdm.agendasqlite.model;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {

    private int id;
    private String nome;
    private String fone;
    private String email;
    private Boolean favorito = Boolean.FALSE;
    private String foneSecundario;
    private String dataAniversario;

    public Contato(){
    }

    public Contato(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return id == contato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getFoneSecundario() {return foneSecundario;}

    public void setFoneSecundario(String foneSecundario) {this.foneSecundario = foneSecundario;}

    public String getDataAniversario() {return dataAniversario;}

    public void setDataAniversario(String dataAniversario) {this.dataAniversario = dataAniversario;}

    public Boolean getFavorito() {return favorito;}

    public void setFavorito(Boolean favorito) {this.favorito = favorito;}
}

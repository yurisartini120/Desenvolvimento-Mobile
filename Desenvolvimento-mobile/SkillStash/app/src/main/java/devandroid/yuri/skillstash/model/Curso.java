package devandroid.yuri.skillstash.model;

import java.io.Serializable;

public class Curso implements Serializable {
    private String nome;
    private String descricao;

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}


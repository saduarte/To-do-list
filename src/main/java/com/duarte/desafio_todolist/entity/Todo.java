package com.duarte.desafio_todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Boolean realizado;

    private int prioridade;

    public Todo(String nome, String descricao, Boolean realizado, int prioridade) {

        if (prioridade < 1 || prioridade > 3) {
            throw new IllegalArgumentException("Prioridade deve estar entre 1 e 2");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

}

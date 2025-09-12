package com.github.HeitorGCBorges.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private String nome;
    private List<Item> itens;

    public Pedido(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public List<Item> getItens(){
        return itens;
    }

}

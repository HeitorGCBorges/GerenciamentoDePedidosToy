package com.github.HeitorGCBorges.model;

public class Item {
    private String nomeItem;
    private double preco;

    public Item(String nomeItem, double preco){
        this.nomeItem = nomeItem;
        this.preco = preco;
    }

    public void setNomeItem(String nomeItem){
        this.nomeItem = nomeItem;
    }

    public String getNomeItem(){
        return nomeItem;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }
    
}

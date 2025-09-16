package com.github.HeitorGCBorges.model;

public class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public void setnome(String nome){
        this.nome = nome;
    }

    public String getnome(){
        return nome;
    }

    public void setPreco(double preco){
        if (preco >= 0){
            this.preco = preco;
        }else {
            throw new IllegalArgumentException("preço não pode ser negativo");
        }

    }

    public double getPreco(){
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.classes;

/**
 *
 * @author lucme
 */
public class Produtos {

    private static String nomeProduto = "";
    private String numeroCod = "";
    private String modelo = "";
    private int qtdDisponivel = 0;
    private float preco = 0;

    public Produtos() {

    }

    public static String getNomeProduto() {
        return nomeProduto;
    }

    public static void setNomeProduto(String nomeProduto) {
        Produtos.nomeProduto = nomeProduto;
    }

    public String getNumeroCod() {
        return numeroCod;
    }

    public void setNumeroCod(String numeroCod) {
        this.numeroCod = numeroCod;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.classes;

/**
 *
 * @author lucme
 */
public class Vendas {

    public int codProduto = 0;
    public String descProduto = "";
    public String modelProduto = "";
    public int qtdProduto = 0;
    public int codVenda = 0;
    public float valorProduto = 0;
    public float valorTotal = 0;
    public float valorRecebido = 0;
    public float troco = 0;

    public Vendas() {

    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getModelProduto() {
        return modelProduto;
    }

    public void setModelProduto(String modelProduto) {
        this.modelProduto = modelProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.model;

/**
 *
 * @author Compaq
 */
public class ItemVendas {
    
 public int idItemVenda;
 public int idVenda;
 public int idProduto;
 public int idcliente;
 public int Quantidade;
 public float Valortotal;
 public float troco;
 public float valorRecebido;
 public String descricao;
 public String modelo;
 public float valorProduto;

 public ItemVendas(){
    
    
}

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

  

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public float getValortotal() {
        return Valortotal;
    }

    public float getTroco() {
        return troco;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public void setValortotal(float Valortotal) {
        this.Valortotal = Valortotal;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
 
 
 
}

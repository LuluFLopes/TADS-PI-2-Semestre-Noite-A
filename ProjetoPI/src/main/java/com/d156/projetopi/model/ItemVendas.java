/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.model;

import java.util.Date;

/**
 *
 * @author Compaq
 */
public class ItemVendas {
    
 public String NomeCliente ="";
 public String NomeProduto ="";
 public String Descricao = "";
 public String codigo ="";
 public Date dataVenda ;
 public int idItemVenda;
 public int idVenda;
 public int idProduto;
 public int idcliente;
 public int Quantidade;
 public float Valortotal;
 public float troco;
 public float valorRecebido;
 public float valorProduto;

 public ItemVendas(){
    
    
}

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

 
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
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

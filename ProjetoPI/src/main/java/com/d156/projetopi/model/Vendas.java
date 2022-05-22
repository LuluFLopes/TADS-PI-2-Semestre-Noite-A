/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.model;

import java.util.Date;

/**
 *
 * @author lucme
 */
public class Vendas {

    
    public int idVenda;
    public String descricao;
    public Date dataVenda;
    public int idCliente;
    public float valorTotal;        
    public String NomeCliente ="";
    public Vendas() {

    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

  

    public int getIdVenda() {
        return idVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }



}

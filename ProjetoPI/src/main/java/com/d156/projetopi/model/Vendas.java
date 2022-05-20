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
    public String nomeCliente;
    public float valorTotal;        
    
    public Vendas() {

    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

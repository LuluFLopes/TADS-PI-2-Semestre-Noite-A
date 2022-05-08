/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.VendasDAO;
import com.d156.projetopi.model.Vendas;

/**
 *
 * @author lucme
 */
public class VendasController {
    public static boolean salvar(int idVenda,int idProduto,String descriçao,String modelo,int qtd,float valorProduto,float valorTotal,float valorRecebido,float troco){
      
        Vendas obj = new Vendas();
        
        obj.setIdVenda(idVenda);
        obj.setIdProduto(idProduto);
        obj.setDescricao(descriçao);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setValorProduto(valorProduto);
        obj.setValorTotal(valorTotal);
        obj.setValorRecebido(valorRecebido);
        obj.setTroco(troco);
         
        
    return VendasDAO.salvar(obj);
    }
    
    public static boolean atualizar(int idVenda,int idProduto,String descriçao,String modelo,int qtd,float valorProduto,float valorTotal,float valorRecebido,float troco){
      
        Vendas obj = new Vendas();
        
        obj.setIdVenda(idVenda);
        obj.setIdProduto(idProduto);
        obj.setDescricao(descriçao);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setValorProduto(valorProduto);
        obj.setValorTotal(valorTotal);
        obj.setValorRecebido(valorRecebido);
        obj.setTroco(troco);
         
        
    return VendasDAO.atualizar(obj);
    }
    
     public static Vendas consultar (Vendas obj) {
          
        return VendasDAO.consultarVendas(obj);
        
    }
    
    public static void excluir (Vendas obj){
        
        VendasDAO.excluir(obj);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ItemVendasDAO;
import com.d156.projetopi.model.ItemVendas;
import com.d156.projetopi.model.Produtos;
import com.d156.projetopi.model.RelatórioSintetico;
import com.d156.projetopi.model.Vendas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucme
 */
public class ItemVendasController {
    
    public static boolean salvar(int idVenda,int idProduto,int qtd,float valorProduto,int valorTotal,float valorRecebido,float troco){
      
        ItemVendas objItem = new ItemVendas();
        
        objItem.setIdVenda(idVenda);
        objItem.setIdProduto(idProduto);
        objItem.setQuantidade(qtd);
        objItem.setValortotal(valorTotal);
        objItem.setValorRecebido(valorRecebido);
        objItem.setTroco(troco);        
        objItem.setIdProduto(idProduto);
        objItem.setValorProduto(valorProduto);
        
    return com.d156.projetopi.dao.ItemVendasDAO.salvar(objItem);
    }
    
    public static boolean atualizar(int idVenda,int idProduto,int qtd,float valorProduto,int valorTotal,float valorRecebido,float troco){
      
       ItemVendas objItem = new ItemVendas();
        
        objItem.setIdVenda(idVenda);
        objItem.setIdProduto(idProduto);
        objItem.setQuantidade(qtd);
        objItem.setValortotal(valorTotal);
        objItem.setValorRecebido(valorRecebido);
        objItem.setTroco(troco); 
        objItem.setIdProduto(idProduto);
        objItem.setValorProduto(valorProduto);
        
    return ItemVendasDAO.atualizar(objItem);
    }
    
     public static ItemVendas consultar (int idItemVenda) {
          
         ItemVendas objItem = new ItemVendas();
         
         objItem.setIdItemVenda(idItemVenda);
         
       ItemVendasDAO.consultarItemVendas(objItem);
        
       return ItemVendasDAO.consultarItemVendas(objItem);
    }
    
     public static boolean excluir (int idVendas){
        
        ItemVendas objItem = new ItemVendas();
        objItem.setIdVenda(idVendas);
        
        return com.d156.projetopi.dao.ItemVendasDAO.excluir(objItem);
    }
    
    

}




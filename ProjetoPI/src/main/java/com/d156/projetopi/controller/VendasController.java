/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.VendasDAO;
import com.d156.projetopi.model.Vendas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucme
 */
public class VendasController {
    
    public static boolean salvar(int idVenda,int idProduto,String descriçao,String modelo,int qtd,float valorProduto,int valorTotal,float valorRecebido,float troco){
      
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
    
    public static boolean atualizar(int idVenda,int idProduto,String descriçao,String modelo,int qtd,float valorProduto,int valorTotal,float valorRecebido,float troco){
      
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
    
     public static boolean excluir (int idVendas){
        
        Vendas obj = new Vendas();
        obj.setIdVenda(idVendas);
        
        return VendasDAO.excluir(obj);
    }
    
    
    public static ArrayList<Vendas>listaSinteticoController(Date dataVenda) {
    
        Vendas obj = new Vendas();
        
       
       obj.setDataVenda(dataVenda);
    
       return VendasDAO.listaSintetico(obj);
    }

    public static ArrayList<Vendas>listaAnaliticoController (Date dataVenda) {

Vendas obj  = new Vendas();


obj.setDataVenda(dataVenda);

return VendasDAO.listaAnalitico(obj);

    }
}




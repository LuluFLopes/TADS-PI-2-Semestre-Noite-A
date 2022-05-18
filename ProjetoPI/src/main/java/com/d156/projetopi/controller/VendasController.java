/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.VendasDAO;
import com.d156.projetopi.model.Vendas;
import com.d156.projetopi.model.RelatórioSintetico;
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
    
    
    public static ArrayList<Vendas>listaSinteticoController(Date DataInicio,Date DataFim) {
    
        RelatórioSintetico objSintetico = new RelatórioSintetico();
        Vendas obj = new Vendas();
        objSintetico.setDataInicio(DataInicio);
        objSintetico.setDataFim(DataFim);
      
        
       return VendasDAO.listaSintetico(objSintetico,obj);
    }

    public static ArrayList<Vendas>listaAnaliticoController (Date dataInicio,Date DataFim) {

RelatórioSintetico objAnalitico = new RelatórioSintetico();
         Vendas obj = new Vendas();

        objAnalitico.setDataInicio(dataInicio);
        objAnalitico.setDataFim(DataFim);
    
       return VendasDAO.listaSintetico(objAnalitico,obj);

    }
}




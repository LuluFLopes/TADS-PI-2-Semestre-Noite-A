/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ProdutosDAO;
import com.d156.projetopi.model.Produtos;

/**
 *
 * @author lucme
 */
public class ProdutosController {
    
    public static boolean salvar(String nome, String codigo, String modelo, int qtd, float preco){

        
        Produtos obj = new Produtos();

        obj.setNome(nome);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setPreco(preco);
        
        return ProdutosDAO.salvar(obj); 

    }
    
    public static boolean atualizar(String nome, String codigo, String modelo, int qtd, float preco){

        
        Produtos obj = new Produtos();

        obj.setNome(nome);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setPreco(preco);
        
        return ProdutosDAO.atualizar(obj); 

    }
    
    public static Produtos consultar (Produtos obj) {
          
        return ProdutosDAO.consultarProduto(obj);
        
    }
    
    public static void excluir (Produtos obj){
        
        ProdutosDAO.excluir(obj);
    }
    
}

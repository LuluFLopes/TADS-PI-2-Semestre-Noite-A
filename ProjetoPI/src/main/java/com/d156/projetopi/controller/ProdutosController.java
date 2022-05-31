/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ProdutosDAO;
import com.d156.projetopi.model.Produtos;
import java.util.ArrayList;

/**
 * Métodos são utilizados para enviar objetos preenchidos às DAO
 *
 * @author lucme
 */
public class ProdutosController {
    
    // Inserção de produtos.
    public static boolean salvar(String descricao, String codigo, String modelo, int qtdEstoque, float preco) {
        Produtos obj = new Produtos();
        obj.setDescricao(descricao);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtdEstoque(qtdEstoque);
        obj.setPreco(preco);
        return ProdutosDAO.salvar(obj);
    }

    // Alteração de produtos.
    public static boolean alterar(int id, String descricao, String codigo, String modelo, int qtdEstoque, float preco) {
        Produtos obj = new Produtos();
        obj.setIdProduto(id);
        obj.setDescricao(descricao);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtdEstoque(qtdEstoque);
        obj.setPreco(preco);
        return ProdutosDAO.alterar(obj);
    }

    // Consulta produtos por id, retorna objeto preenchido.
    public static Produtos consultaId(int id) {
        Produtos obj = new Produtos();
        obj.setIdProduto(id);
        return ProdutosDAO.consultarProdutoId(obj);
    }

    // Exclusão de produtos.
    public static boolean excluir(int id) {
        Produtos obj = new Produtos();
        obj.setIdProduto(id);
        
        return ProdutosDAO.excluir(obj);
    }

   // Listagem de produtos pelo nome/descrição.
    public static ArrayList<Produtos> listaProdutosNome(String descricao) {
        Produtos obj = new Produtos();
        obj.setDescricao(descricao);
        return ProdutosDAO.listaProdutosDescricao(obj);
    }

    // Listagem de produtos pelo código.
    public static ArrayList<Produtos> listaProdutosCod(String codigo) {
        Produtos obj = new Produtos();
        obj.setCodigo(codigo);
        return ProdutosDAO.listaProdutosCod(obj);
    }

    // Consulta produtos pelo código, retorna objeto preenchido.
    public static Produtos consultar(String codigo) {
        Produtos obj = new Produtos();
        obj.setCodigo(codigo);
        return ProdutosDAO.consultarProdutoPeloCodigo(obj);
    }
}

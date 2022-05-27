/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ProdutosDAO;
import com.d156.projetopi.model.Produtos;
import java.util.ArrayList;

/**
 *
 * @author lucme
 */
public class ProdutosController {

    // Grava as informações no objeto para inserção.
    public static boolean salvar(String descricao, String codigo, String modelo, int qtdEstoque, float preco) {
        Produtos obj = new Produtos();
        obj.setDescricao(descricao);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtdEstoque(qtdEstoque);
        obj.setPreco(preco);
        
        return ProdutosDAO.salvar(obj);
    }

    // Grava as informações no objeto para alteração.
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

    // Consulta retorna um objeto preenchido a partir de um Id.
    public static Produtos consultaId(int id) {
        Produtos obj = new Produtos();
        obj.setIdProduto(id);
        
        return ProdutosDAO.consultarProdutoId(obj);
    }

    // Função que exclui um produto a partir de um código.
    public static boolean excluir(int id) {
        Produtos obj = new Produtos();
        obj.setIdProduto(id);
        
        return ProdutosDAO.excluir(obj);
    }

    // Função quando o usuário digitar o nome na pesquisa.
    public static ArrayList<Produtos> listaProdutosNome(String descricao) {
        Produtos obj = new Produtos();
        obj.setDescricao(descricao);
        
        return ProdutosDAO.listaProdutosDescricao(obj);
    }

    // Função quando o usuário digitar o código na pesquisa.
    public static ArrayList<Produtos> listaProdutosCod(String codigo) {
        Produtos obj = new Produtos();
        obj.setCodigo(codigo);
        
        return ProdutosDAO.listaProdutosCod(obj);
    }

    // Função que retorna um objeto preenchido a partir do Código. Usada na tela de "Venda".
    public static Produtos consultar(String codigo) {
        
        Produtos obj = new Produtos();
        obj.setCodigo(codigo);
        
        return ProdutosDAO.consultarProdutoPeloCodigo(obj);
    }
}

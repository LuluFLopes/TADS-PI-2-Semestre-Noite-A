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

    public static boolean salvar(String nome, String codigo, String modelo, int qtd, float preco) {

        Produtos obj = new Produtos();

        obj.setNome(nome);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setPreco(preco);

        return ProdutosDAO.salvar(obj);

    }

    public static boolean alterar(int id, String nome, String codigo, String modelo, int qtd, float preco) {

        Produtos obj = new Produtos();

        obj.setIdProduto(id);
        obj.setNome(nome);
        obj.setCodigo(codigo);
        obj.setModelo(modelo);
        obj.setQtd(qtd);
        obj.setPreco(preco);

        return ProdutosDAO.alterar(obj);

    }

    public static Produtos consultar(String nome, String codigo) {

        Produtos obj = new Produtos();
        obj.setNome(nome);
        obj.setCodigo(codigo);

        return ProdutosDAO.consultarProduto(obj);

    }

    public static Produtos consultaId(int id) {

        Produtos obj = new Produtos();
        obj.setIdProduto(id);

        return ProdutosDAO.consultarProduto(obj);

    }

    public static boolean excluir(int id) {

        Produtos obj = new Produtos();
        obj.setIdProduto(id);

        return ProdutosDAO.excluir(obj);
    }

    // Função quando o usuário digitar o nome na pesquisa.
    public static ArrayList<Produtos> listaProdutosNome(String nome) {

        return ProdutosDAO.listaProdutosNome(nome);

    }

    // Função quando o usuário digitar o código na pesquisa.
    public static ArrayList<Produtos> listaProdutosCod(String codigo) {

        return ProdutosDAO.listaProdutosCod(codigo);

    }

}

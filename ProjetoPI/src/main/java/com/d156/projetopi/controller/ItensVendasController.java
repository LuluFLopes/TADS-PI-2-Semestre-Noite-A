/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ItensVendasDAO;
import com.d156.projetopi.model.ItensVendas;
import java.util.ArrayList;

/**
 * Métodos são utilizados para enviar objetos preenchidos às DAO
 *
 * @author lucme
 */
public class ItensVendasController {
    
    // Inserção de produtos na venda.
    public static boolean salvar(int idCliente, int idVenda, int idProduto, String nomeCliente, String descricao, String codigo,
            int qtd, float valorProduto, float valorTotal) {
        ItensVendas obj = new ItensVendas();
        obj.setIdCliente(idCliente);
        obj.setIdVenda(idVenda);
        obj.setIdProduto(idProduto);
        obj.setNomeCliente(nomeCliente);
        obj.setDescricao(descricao);
        obj.setCodigo(codigo);
        obj.setQtdVenda(qtd);
        obj.setValorProduto(valorProduto);
        obj.setValorTotal(valorTotal);
        return ItensVendasDAO.salvar(obj);
    }

    // Grava o restante das informações ao finalizar a compra.
    public static boolean finalizaCompra(int id ,float recebido, float total, float troco) {
        ItensVendas obj = new ItensVendas();
        obj.setIdVenda(id);
        obj.setValorRecebido(recebido);
        obj.setValorTotal(total);
        obj.setTroco(troco);
        return ItensVendasDAO.finalizaCompra(obj);
    }

    // Exclui um item da venda.
    public static boolean excluir(int id) {
        ItensVendas obj = new ItensVendas();
        obj.setIdItemVenda(id);
        return ItensVendasDAO.excluir(obj);
    }
    
     // Exclui um item da venda.
    public static void excluirVenda(int id) {
        ItensVendas obj = new ItensVendas();
        obj.setIdVenda(id);
        ItensVendasDAO.excluirVenda(obj);
    }

    // Lista todos os itens de uma venda específica.
    public static ArrayList<ItensVendas> listaDetalhamentoController(int id) {
        ItensVendas obj = new ItensVendas();
        obj.setIdVenda(id);
        return ItensVendasDAO.listaDetalhamento(obj);
    }
    
    // Lista o total de uma venda específica.
    public static ItensVendas listaTotal(int id) {
        ItensVendas obj = new ItensVendas();
        obj.setIdVenda(id);
        return ItensVendasDAO.listaTotal(obj);
    }

    // Retorna um objeto a partir do código do produto.
    public static ItensVendas consultaId(String codigo) {
        ItensVendas obj = new ItensVendas();
        obj.setCodigo(codigo);
        return ItensVendasDAO.consultarId(obj);
    }
}

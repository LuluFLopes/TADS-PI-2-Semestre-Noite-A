/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ItensVendasDAO;
import com.d156.projetopi.model.ItensVendas;
import java.util.ArrayList;

/**
 *
 * @author lucme
 */
public class ItensVendasController {

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

    /*  **Essa função é usada ?**
    public static boolean atualizar(int idVenda, int idProduto, int qtd, float valorProduto, int valorTotal, float valorRecebido, float troco) {
        ItensVendas objItem = new ItensVendas();

        objItem.setIdVenda(idVenda);
        objItem.setIdProduto(idProduto);
        objItem.setQtdVenda(qtd);
        objItem.setValorTotal(valorTotal);
        objItem.setValorRecebido(valorRecebido);
        objItem.setTroco(troco);
        objItem.setIdProduto(idProduto);
        objItem.setValorProduto(valorProduto);

        return ItemVendasDAO.atualizar(objItem);
    }

    public static ItensVendas consultar(int idItemVenda) {
        ItensVendas objItem = new ItensVendas();

        objItem.setIdItemVenda(idItemVenda);

        return ItemVendasDAO.consultarItemVendas(objItem);
    }
     */
    public static boolean excluir(int id) {

        ItensVendas obj = new ItensVendas();

        obj.setIdItemVenda(id);

        return ItensVendasDAO.excluir(obj);
    }

    public static ArrayList<ItensVendas> listaDetalhamentoController(int id) {

        ItensVendas obj = new ItensVendas();

        obj.setIdItemVenda(id);

        return ItensVendasDAO.listaDetalhamento(obj);
    }

    public static ItensVendas consultaId(String codigo) {

        ItensVendas obj = new ItensVendas();

        obj.setCodigo(codigo);

        return ItensVendasDAO.consultarId(obj);
    }

}

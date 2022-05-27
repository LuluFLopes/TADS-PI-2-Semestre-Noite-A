/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ItemVendasDAO;
import com.d156.projetopi.model.ItensVendas;
import java.util.ArrayList;

/**
 *
 * @author lucme
 */
public class ItemVendasController {

    public static boolean salvar(int idVenda, int idProduto, int qtd, float valorProduto, int valorTotal, float valorRecebido, float troco) {
        ItensVendas objItem = new ItensVendas();

        objItem.setIdVenda(idVenda);
        objItem.setIdProduto(idProduto);
        objItem.setQtdVenda(qtd);
        objItem.setValorTotal(valorTotal);
        objItem.setValorRecebido(valorRecebido);
        objItem.setTroco(troco);
        objItem.setIdProduto(idProduto);
        objItem.setValorProduto(valorProduto);

        return ItemVendasDAO.salvar(objItem);
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
        ItensVendas objItem = new ItensVendas();

        objItem.setIdVenda(id);

        return ItemVendasDAO.excluir(objItem);
    }

    public static ArrayList<ItensVendas> listaDetalhamentoController(int id) {

        ItensVendas obj = new ItensVendas();

        obj.setIdItemVenda(id);

        return ItemVendasDAO.listaDetalhamento(obj);
    }

}

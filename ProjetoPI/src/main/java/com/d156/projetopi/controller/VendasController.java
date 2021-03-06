/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ItensVendasDAO;
import com.d156.projetopi.dao.VendasDAO;
import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.RelatorioSintetico;
import com.d156.projetopi.model.Vendas;
import java.util.ArrayList;
import java.util.Date;

/**
 * Métodos são utilizados para enviar objetos preenchidos às DAO
 *
 * @author lucme
 */
public class VendasController {

    // Inserção de produtos.
    public static boolean salvar(int idCliente, Date dataVenda) {
        Vendas obj = new Vendas();
        obj.setIdCliente(idCliente);
        obj.setDataVenda(dataVenda);
        return VendasDAO.salvar(obj);
    }

    // Consulta por id, retorna Objeto.
    public static Vendas consultaId(int idCliente) {
        Vendas obj = new Vendas();
        obj.setIdCliente(idCliente);
        return VendasDAO.consultaId(obj);
    }

    // Grava o id dentro da tabela vendas.
    public static boolean gravaId(int idCliente, int idVenda) {
        Vendas obj = new Vendas();
        obj.setIdVenda(idVenda);
        obj.setIdCliente(idCliente);
        return VendasDAO.salvaId(obj);
    }

    // Listagem relatório sintetico.
    public static ArrayList<ItensVendas> listaSinteticoController(Date DataInicio, Date DataFim) {
        ItensVendas obj = new ItensVendas();
        RelatorioSintetico objSintetico = new RelatorioSintetico();
        objSintetico.setDataInicio(DataInicio);
        objSintetico.setDataFim(DataFim);
        return VendasDAO.listaSintetico(objSintetico, obj);
    }

    // Listagem relatório analítico.
    public static ArrayList<ItensVendas> listaAnaliticoController(Date dataInicio, Date DataFim) {
        ItensVendas obj = new ItensVendas();
        RelatorioAnalitico objAnalitico = new RelatorioAnalitico();
        objAnalitico.setDataInicio(dataInicio);
        objAnalitico.setDataFim(DataFim);
        return VendasDAO.listaAnalitico(objAnalitico, obj);
    }

    // Gera a idVenda para enviar como parâmetro.
    public static Vendas salvaVenda(Date dataVenda) {
        Vendas obj = new Vendas();
        obj.setDataVenda(dataVenda);
        return VendasDAO.salvarData(obj);
    }
    
    // Gera a idVenda para enviar como parâmetro.
    public static Vendas pegaData(int idVenda) {
        Vendas obj = new Vendas();
        obj.setIdVenda(idVenda);
        return VendasDAO.pegaData(obj);
    }
    
    // Exclui um item da venda.
    public static void excluirVenda(int id) {
        Vendas obj = new Vendas();
        obj.setIdVenda(id);
        VendasDAO.excluirVenda(obj);
    }
}

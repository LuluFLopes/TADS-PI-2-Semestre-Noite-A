/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.VendasDAO;
import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.RelatórioSintetico;
import com.d156.projetopi.model.Vendas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Compaq
 */
public class VendasController {

    public static boolean salvar(int idCliente, Date dataVenda) {
        
        Vendas obj = new Vendas();

        obj.setIdCliente(idCliente);
        obj.setDataVenda(dataVenda);

        return VendasDAO.salvar(obj);
    }

    public static ArrayList<ItensVendas> listaSinteticoController(Date DataInicio, Date DataFim) {

        RelatórioSintetico objSintetico = new RelatórioSintetico();
        ItensVendas obj = new ItensVendas();

        objSintetico.setDataInicio(DataInicio);
        objSintetico.setDataFim(DataFim);

        return VendasDAO.listaSintetico(objSintetico, obj);
    }

    public static ArrayList<ItensVendas> listaAnaliticoController(Date dataInicio, Date DataFim) {

        RelatorioAnalitico objAnalitico = new RelatorioAnalitico();
        ItensVendas obj = new ItensVendas();

        objAnalitico.setDataInicio(dataInicio);
        objAnalitico.setDataFim(DataFim);

        return VendasDAO.listaAnalitico(objAnalitico, obj);
    }

}

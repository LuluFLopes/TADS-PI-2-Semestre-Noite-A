/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.model.ItemVendas;
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
    
    
    public static ArrayList<ItemVendas>listaSinteticoController(Date DataInicio,Date DataFim) {
    
        RelatórioSintetico objSintetico = new RelatórioSintetico();
        ItemVendas obj = new ItemVendas();
        
        objSintetico.setDataInicio(DataInicio);
        objSintetico.setDataFim(DataFim);
      
        
       return com.d156.projetopi.dao.VendasDAO.listaSintetico(objSintetico,obj);
    }

    public static ArrayList<ItemVendas>listaAnaliticoController (Date dataInicio,Date DataFim) {

        RelatorioAnalitico objAnalitico = new RelatorioAnalitico();
         ItemVendas obj = new ItemVendas();

         
        objAnalitico.setDataInicio(dataInicio);
        objAnalitico.setDataFim(DataFim);
    
       return com.d156.projetopi.dao.VendasDAO.listaAnalitico(objAnalitico,obj);

    }

    
    
    
}

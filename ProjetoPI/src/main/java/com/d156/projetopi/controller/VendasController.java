/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.model.RelatórioSintetico;
import com.d156.projetopi.model.Vendas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Compaq
 */
public class VendasController {
    
    
    public static ArrayList<Vendas>listaSinteticoController(Date DataInicio,Date DataFim) {
    
        RelatórioSintetico objSintetico = new RelatórioSintetico();
        Vendas obj = new Vendas();
        
        objSintetico.setDataInicio(DataInicio);
        objSintetico.setDataFim(DataFim);
      
        
       return com.d156.projetopi.dao.VendasDAO.listaSintetico(objSintetico,obj);
    }

    public static ArrayList<Vendas>listaAnaliticoController (Date dataInicio,Date DataFim) {

        RelatórioSintetico objAnalitico = new RelatórioSintetico();
         Vendas obj = new Vendas();

         
        objAnalitico.setDataInicio(dataInicio);
        objAnalitico.setDataFim(DataFim);
    
       return com.d156.projetopi.dao.VendasDAO.listaSintetico(objAnalitico,obj);

    }

    
    
    
}

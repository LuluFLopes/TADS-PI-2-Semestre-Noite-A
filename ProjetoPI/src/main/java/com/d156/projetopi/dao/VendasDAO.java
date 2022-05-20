/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.RelatórioSintetico;
import com.d156.projetopi.model.Vendas;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Compaq
 */
public class VendasDAO {
    
    
    public static ArrayList<Vendas> listaSintetico(RelatórioSintetico objSintetico,Vendas obj) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select b.nome,d.dataVenda,a.valorTotal  from ItensVendas a join clientes b on b.idCliente = a.fk_cliente_id_Cliente join produtos c on c.idProduto = fk_Produto_id_produto join vendas d on d.idVenda = fk_Venda_id_venda\n" +
" where dataVenda between ? and ? ");
            sql.setDate(1,  new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2,  new java.sql.Date(objSintetico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString(1));
                obj.setDataVenda(rs.getDate(2));
                obj.setValorTotal(3);
              
                listaRetorno.add(obj);
            }

        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }
    
    public static ArrayList<Vendas> listaAnalitico(RelatorioAnalitico objAnalitico,Vendas obj) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select b.nome,d.idVenda,d.dataVenda from ItensVendas a join clientes b on b.idCliente = a.fk_cliente_id_Cliente join produtos c on c.idProduto = fk_Produto_id_produto join vendas d on d.idVenda = fk_Venda_id_venda\n" +
" where dataVenda between ? and ?   ");
            sql.setDate(1,  new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2,  new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString(1));
                obj.setIdVenda(rs.getInt(2));
                obj.setDataVenda(rs.getDate(3));
                listaRetorno.add(obj);
            }

        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }

    
    
}

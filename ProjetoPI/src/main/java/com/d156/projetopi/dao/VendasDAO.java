/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.ItensVendas;
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

    public static boolean salvar(Vendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into vendas"
                    + "(fk_idCliente,dataVenda)"
                    + "values (?,?)");

            sql.setInt(1, obj.getIdCliente());
            sql.setDate(2, new java.sql.Date(obj.getDataVenda().getTime()));

            int linhasafetadas = sql.executeUpdate();

            if (linhasafetadas > 0) {
                retorno = true;
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public static ArrayList<ItensVendas> listaSintetico(RelatórioSintetico objSintetico, ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select a.fk_idVenda,b.nome,d.dataVenda,a.valorTotal  "
                    + "from ItensVendas a join clientes b on b.idCliente = a.fk_idCliente"
                    + "inner join produtos c on c.idProduto = fk_idProduto"
                    + "inner join vendas d on d.idVenda = fk_idVenda"
                    + "where dataVenda between ? and ? ");
            sql.setDate(1, new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objSintetico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdVenda(rs.getInt("a.idVenda"));
                obj.setNomeCliente(rs.getString("b.nome"));
                obj.setDataVenda(rs.getDate("d.dataVenda"));
                obj.setValorTotal(rs.getFloat("a.valorTotal"));
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

    public static ArrayList<ItensVendas> listaAnalitico(RelatorioAnalitico objAnalitico, ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement(" select it.fk_idVenda, c.nome, p.descricao, it.qtdVenda, p.codigo, it.valorTotal, v.dataVenda"
                    + "from itensvendas it"
                    + "inner join clientes c on c.idCliente = it.fk_idCliente"
                    + "inner join produtos p on p.idProduto = c.fk_idProduto"
                    + "inner join vendas v on v.idVenda = it.fk_idVenda"
                    + "where dataVenda between ? and ?");

            sql.setDate(1, new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString("c.nome"));
                obj.setIdVenda(rs.getInt("it.fk_idVenda"));
                obj.setDataVenda(rs.getDate("v.dataVenda"));
                obj.setCodigo(rs.getString("p.codigo"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setQtdVenda(rs.getInt("it.qtdVenda"));
                obj.setValorTotal(rs.getFloat("it.valorTotal"));
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

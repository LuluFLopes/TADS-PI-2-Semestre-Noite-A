/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.controller.RelatorioSintetico;
import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.Vendas;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public static ArrayList<ItensVendas> listaSintetico(RelatorioSintetico objSintetico, ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select a.fk_idVenda,b.nome,d.dataVenda,a.valorTotal  "
                    + " from itensvendas a "
                    + " inner join clientes b on b.idCliente = a.fk_idCliente"
                    + " inner join produtos c on c.idProduto = a.fk_idProduto"
                    + " inner join vendas d on d.idVenda = a.fk_idVenda"
                    + " where d.dataVenda between ? and ?");
            sql.setDate(1, new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objSintetico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdVenda(rs.getInt("a.fk_idVenda"));
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

            PreparedStatement sql = conexao.prepareStatement("select a.fk_idVenda, b.nome, c.descricao, a.qtdVenda, c.codigo, a.valorTotal, d.dataVenda"
                    + " from itensvendas a"
                    + " inner join clientes b on b.idCliente = a.fk_idCliente"
                    + " inner join produtos c on c.idProduto = a.fk_idProduto"
                    + " inner join vendas d on d.idVenda = a.fk_idVenda"
                    + " where d.dataVenda between ? and ?");

            sql.setDate(1, new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString("b.nome"));
                obj.setIdVenda(rs.getInt("a.fk_idVenda"));
                obj.setDataVenda(rs.getDate("d.dataVenda"));
                obj.setCodigo(rs.getString("c.codigo"));
                obj.setDescricao(rs.getString("c.descricao"));
                obj.setQtdVenda(rs.getInt("a.qtdVenda"));
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

    public static Vendas consultaId(Vendas obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where fk_idCliente=?");
            sql.setInt(1, obj.getIdCliente());
            rs = sql.executeQuery();

            while (rs.next()) {

                obj.setIdVenda(rs.getInt("idVenda"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar a Venda!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception ex) {
            }
        }
        return obj;
    }

}

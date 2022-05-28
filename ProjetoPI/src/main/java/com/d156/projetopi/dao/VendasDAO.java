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

    public static ArrayList<ItensVendas> listaSintetico(RelatórioSintetico objSintetico, ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select a.fk_idVenda,b.nome,d.dataVenda,a.valorTotal  \n" +
"                     from ItensVendas a join clientes b on b.idCliente = a.fk_idCliente\n" +
"                     inner join produtos c on c.idProduto = fk_idProduto\n" +
"                     inner join vendas d on d.idVenda = fk_idVenda\n" +
"                     where d.dataVenda between ? and ? ");
           sql.setDate(1, new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objSintetico.getDataFim().getTime()));
            
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdVenda(rs.getInt(1));
                obj.setNomeCliente(rs.getString(2));
                obj.setDataVenda(rs.getDate(3));
                obj.setValorTotal(rs.getFloat(4));
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

            PreparedStatement sql = conexao.prepareStatement("          \n" +
"            select a.fk_idVenda, c.nome, p.descricao, a.qtdVenda, p.codigo, a.valorTotal, v.dataVenda\n" +
"                    from itensvendas a\n" +
"                     inner join clientes c on c.idCliente = a.fk_idCliente\n" +
"                     inner join produtos p on p.idProduto = a.fk_idProduto\n" +
"                     inner join vendas v on v.idVenda = a.fk_idVenda\n" +
"                     where dataVenda  between ? and ?  ");

            sql.setDate(1, new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString(2));
                obj.setIdVenda(rs.getInt(1));
                obj.setDataVenda(rs.getDate(7));
                obj.setCodigo(rs.getString(5));
                obj.setDescricao(rs.getString(3));
                obj.setQtdVenda(rs.getInt(4));
                obj.setValorTotal(rs.getFloat(6));
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

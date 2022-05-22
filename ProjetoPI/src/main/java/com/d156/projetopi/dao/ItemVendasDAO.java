/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.ItemVendas;
import com.d156.projetopi.model.Produtos;
import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.RelatórioSintetico;
import com.d156.projetopi.model.Vendas;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ageu
 */
public class ItemVendasDAO {

    public static boolean salvar(ItemVendas objItem) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into itensVendas (fk_cliente_id_Cliente,Fk_Venda_id_Venda, Fk_Produto_id_Produto, QuantidadeVendido,Valortotal,troco,valorRecebido) \n" +
" values (?,?,?,?,?,?,?)\n" +
" ");
            //sql.setString(1, obj.getNome());
            sql.setInt(1, objItem.getIdcliente());
            sql.setInt(2, objItem.getIdVenda());
            sql.setInt(5, objItem.getIdProduto());
            sql.setFloat(6, objItem.getQuantidade());
            sql.setFloat(7, objItem.getValortotal());
            sql.setFloat(8, objItem.getTroco());
            sql.setFloat(9, objItem.getValorRecebido());

            int linhasafetadas = sql.executeUpdate();

            if (linhasafetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possivel realizar a venda!!");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public static boolean atualizar(ItemVendas objItem) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into vendas"
                    + "(idVenda,idProduto,descriçao,modelo,qtd,valorProduto,valorTotal,valorRecebido,troco)values(?,?,?,?,?,?,?,?,?)");
            //sql.setString(1, obj.getNome());
            sql.setInt(1, objItem.getIdVenda());
            sql.setInt(2, objItem.getIdProduto());
            sql.setInt(5, objItem.getQuantidade());
            sql.setFloat(6, objItem.getValorProduto());
            sql.setFloat(7, objItem.getValortotal());
            sql.setFloat(8, objItem.getValorRecebido());
            sql.setFloat(9, objItem.getTroco());

            int linhasafetadas = sql.executeUpdate();

            if (linhasafetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Erro ao Aterar Venda");

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public static ItemVendas consultarItemVendas(ItemVendas obj) {
        Connection conexao = null;
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idVendas=? or ValorTotal=?");

            sql.setInt(1, obj.getIdVenda());
            sql.setFloat(2, obj.getValortotal());
            rs = sql.executeQuery();

            obj.setIdVenda(rs.getInt("idVendas"));
            obj.setIdProduto(rs.getInt("idProdutos"));
            obj.setQuantidade(rs.getInt("qtd"));
            obj.setValorProduto(rs.getFloat("valorProduto"));
            obj.setValortotal(rs.getFloat("valorTotal"));
            obj.setValorRecebido(rs.getFloat("valorRecebido"));
            obj.setTroco(rs.getFloat("troco"));

        } catch (Exception ex) {
            System.out.println("Erro ao consultar Venda");
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

    public static boolean excluir(ItemVendas obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Delete from vendas where idVenda=?");
            sql.setInt(1, obj.getIdVenda());

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir a Venda!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception ex) {
            }
        }

        return retorno;

    }

}

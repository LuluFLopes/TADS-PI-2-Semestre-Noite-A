/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ageu
 */
public class ItensVendasDAO {

    // Inserção de itens em uma venda.
    public static boolean salvar(ItensVendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into itensVendas"
                    + "(fk_idCliente,fk_idVenda,fk_idProduto,nomeCliente,descricao,codigo,qtdVenda,valorProduto,valorTotal)"
                    + "values (?,?,?,?,?,?,?,?,?)");
            sql.setInt(1, obj.getIdCliente());
            sql.setInt(2, obj.getIdVenda());
            sql.setInt(3, obj.getIdProduto());
            sql.setString(4, obj.getNomeCliente());
            sql.setString(5, obj.getDescricao());
            sql.setString(6, obj.getCodigo());
            sql.setInt(7, obj.getQtdVenda());
            sql.setFloat(8, obj.getValorProduto());
            sql.setFloat(9, obj.getValorTotal());
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

    // Inserção das informações que estão faltando na tabela itensvendas.
    public static boolean finalizaCompra(ItensVendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("update itensvendas "
                    + "set valorTotal=?,troco=?,valorRecebido=?"
                    + " where fk_idVenda=?"
            );            
            sql.setFloat(1, obj.getValorTotal());
            sql.setFloat(2, obj.getTroco());
            sql.setFloat(3, obj.getValorRecebido());
            sql.setInt(4, obj.getIdVenda());
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

    // Consulta um produto a partir do código, retorna o objeto preenchido.
    public static ItensVendas consultarId(ItensVendas obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from itensvendas where codigo=?");
            sql.setString(1, obj.getCodigo());
            System.out.println(obj.getCodigo());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdItemVenda(rs.getInt("idItemVenda"));
                obj.setIdCliente(rs.getInt("fk_idCliente"));
                obj.setIdVenda(rs.getInt("fk_idVenda"));
                obj.setIdProduto(rs.getInt("fk_idProduto"));
                obj.setNomeCliente(rs.getString("nomeCliente"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setQtdVenda(rs.getInt("qtdVenda"));
                obj.setValorProduto(rs.getFloat("valorProduto"));
                obj.setValorTotal(rs.getFloat("valorTotal"));
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

    // Exclusão de um item da venda.
    public static boolean excluir(ItensVendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Delete from itensVendas where idItemVenda=?");
            sql.setInt(1, obj.getIdItemVenda());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a Venda!");
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
    
    // Exclusão de um item da venda.
    public static boolean excluirVenda(ItensVendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("delete from itensvendas where fk_idVenda=?");
            sql.setInt(1, obj.getIdVenda());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a Venda!");
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

    // Listagem dos produtos de uma venda específica.
    public static ArrayList<ItensVendas> listaDetalhamento(ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from itensvendas a"
                    + " inner join vendas b on a.fk_idVenda = b.idVenda"
                    + " where a.fk_idVenda=?");
            sql.setInt(1, obj.getIdVenda());
            rs = sql.executeQuery();
            while (rs.next()) {  
                obj = new ItensVendas();
                obj.setIdItemVenda(rs.getInt("idItemVenda"));
                obj.setIdCliente(rs.getInt("fk_idCliente"));
                obj.setIdVenda(rs.getInt("fk_idVenda"));
                obj.setIdProduto(rs.getInt("fk_idProduto"));
                obj.setNomeCliente(rs.getString("nomeCliente"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setQtdVenda(rs.getInt("qtdVenda"));
                obj.setTroco(rs.getFloat("troco"));
                obj.setValorRecebido(rs.getFloat("valorRecebido"));
                obj.setValorProduto(rs.getFloat("valorProduto"));
                obj.setValorTotal(rs.getFloat("valorTotal"));
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
    
    // Listagem de uma venda retornando o total.
    public static ItensVendas listaTotal(ItensVendas obj) {
        Connection conexao = null;
        ArrayList<ItensVendas> listaRetorno = new ArrayList<ItensVendas>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select sum(valorTotal) from itensvendas a"
                    + " inner join vendas b on a.fk_idVenda = b.idVenda"
                    + " where a.fk_idVenda=?");
            sql.setInt(1, obj.getIdVenda());
            rs = sql.executeQuery();
            while (rs.next()) {  
                obj = new ItensVendas(); 
                obj.setValorTotal(rs.getFloat("sum(valorTotal)"));
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
        return obj;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.model.RelatorioAnalitico;
import com.d156.projetopi.model.RelatorioSintetico;
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

    // Inserção de vendas.
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
    
    // Gera a data do sistema e retorna objeto preenchido com id.
    public static Vendas salvarData(Vendas obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into vendas"
                    + "(dataVenda)"
                    + "values (?)");
            sql.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            int linhasafetadas = sql.executeUpdate();
            if (linhasafetadas > 0) {
                PreparedStatement sql1 = conexao.prepareStatement("select * from vendas where dataVenda=?");
                sql1.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
                rs = sql1.executeQuery();
                while (rs.next()) {
                    obj = new Vendas();
                    obj.setIdVenda(rs.getInt("idVenda"));
                    obj.setDataVenda(rs.getDate("dataVenda"));
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return obj;
    }

    // Grava o idCliente após ele ser acessível na tela de vendas.
    public static boolean salvaId(Vendas obj) {
        Connection conexao = null;
        boolean retorno = false;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("update vendas set fk_idCliente=? where idVenda=?");
            sql.setInt(1, obj.getIdCliente());
            sql.setInt(2, obj.getIdVenda());
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

    // Listagem ordenada do relatório sintético.
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
                    + " where d.dataVenda between ? and ?"
                    + " group by a.fk_idVenda"
                    + " order by a.fk_idVenda desc");
            sql.setDate(1, new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objSintetico.getDataFim().getTime()));
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new ItensVendas();
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

    // Listagem ordenada do relatório analítico.
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
                    + " where d.dataVenda between ? and ?"
                    + " group by a.fk_idVenda"
                    + " order by a.fk_idVenda desc");
            sql.setDate(1, new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2, new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new ItensVendas();
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

    // Consulta por idCliente, retorna idVenda no objeto.
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
    
    // Consulta por idVenda, retorna objet prenchido.
    public static Vendas pegaData(Vendas obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idVenda=?");
            sql.setInt(1, obj.getIdVenda());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setDataVenda(rs.getDate("dataVenda"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar a data!");
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
    public static boolean excluirVenda(Vendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("delete from vendas where idVenda=?");
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
}

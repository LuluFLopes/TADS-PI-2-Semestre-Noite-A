/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

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
public class VendasDAO {

    public static boolean salvar(Vendas obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into vendas"
                    + "(idVenda,idProduto,descriçao,modelo,qtd,valorProduto,valorTotal,valorRecebido,troco)values(?,?,?,?,?,?,?,?,?)");
            //sql.setString(1, obj.getNome());
            sql.setInt(1, obj.getIdVenda());
            sql.setInt(2, obj.getIdProduto());
            sql.setString(3, obj.getDescricao());
            sql.setString(4, obj.getModelo());
            sql.setInt(5, obj.getQtd());
            sql.setFloat(6, obj.getValorProduto());
            sql.setFloat(7, obj.getValorTotal());
            sql.setFloat(8, obj.getValorRecebido());
            sql.setFloat(9, obj.getTroco());

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

    public static boolean atualizar(Vendas obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into vendas"
                    + "(idVenda,idProduto,descriçao,modelo,qtd,valorProduto,valorTotal,valorRecebido,troco)values(?,?,?,?,?,?,?,?,?)");
            //sql.setString(1, obj.getNome());
            sql.setInt(1, obj.getIdVenda());
            sql.setInt(2, obj.getIdProduto());
            sql.setString(3, obj.getDescricao());
            sql.setString(4, obj.getModelo());
            sql.setInt(5, obj.getQtd());
            sql.setFloat(6, obj.getValorProduto());
            sql.setFloat(7, obj.getValorTotal());
            sql.setFloat(8, obj.getValorRecebido());
            sql.setFloat(9, obj.getTroco());

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

    public static ArrayList<Vendas> listaProdutos(Vendas obj) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas");
            rs = sql.executeQuery();

            while (rs.next()) {

                //obj.setIdProduto(rs.getInt("idproduto"));
                obj.setIdVenda(rs.getInt("idVendas"));
                obj.setIdProduto(rs.getInt("idProdutos"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setValorProduto(rs.getFloat("valorProduto"));
                obj.setValorTotal(rs.getFloat("valorTotal"));
                obj.setValorRecebido(rs.getFloat("valorRecebido"));
                obj.setTroco(rs.getFloat("troco"));

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

    public static ArrayList<Vendas> listaProdutos(Vendas obj, int idVendas) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idVendas like ?");
            sql.setInt(1, '%' + idVendas + '%');
            rs = sql.executeQuery();

            while (rs.next()) {

                obj.setIdVenda(rs.getInt("idVendas"));
                obj.setIdProduto(rs.getInt("idProdutos"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setValorProduto(rs.getFloat("valorProduto"));
                obj.setValorTotal(rs.getFloat("valorTotal"));
                obj.setValorRecebido(rs.getFloat("valorRecebido"));
                obj.setTroco(rs.getFloat("troco"));

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

    public static Vendas consultarVendas(Vendas obj) {
        Connection conexao = null;
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idVendas=? or ValorTotal=?");

            sql.setInt(1, obj.getIdVenda());
            sql.setFloat(2, obj.getValorTotal());
            rs = sql.executeQuery();

            obj.setIdVenda(rs.getInt("idVendas"));
            obj.setIdProduto(rs.getInt("idProdutos"));
            obj.setDescricao(rs.getString("descricao"));
            obj.setModelo(rs.getString("modelo"));
            obj.setQtd(rs.getInt("qtd"));
            obj.setValorProduto(rs.getFloat("valorProduto"));
            obj.setValorTotal(rs.getFloat("valorTotal"));
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

    public static boolean excluir(Vendas obj) {
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

    public static ArrayList<Vendas> listaSintetico(Vendas obj) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idCliente like ?");
            sql.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setValorTotal(rs.getFloat("valorTotal"));
                obj.setDataVenda(rs.getDate("dataVenda"));
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

    // busca para gerar o relatorio analitico
    // precisa ver um jeito de arrumar a data como criterio like
    public static ArrayList<Vendas> listaAnalitico(Vendas obj) {

        Connection conexao = null;
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from vendas where idVenda like ?");
            sql.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setIdVenda(rs.getInt("idVenda"));
                obj.setDataVenda(rs.getDate("dataVenda"));
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.Produtos;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ageu
 */
public class ProdutosDAO {

    // Inserção de produtos.
    public static boolean salvar(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into produtos(descricao,codigo,modelo,qtdEstoque,preco) values(?,?,?,?,?)");
            sql.setString(1, obj.getDescricao());
            sql.setString(2, obj.getCodigo());
            sql.setString(3, obj.getModelo());
            sql.setInt(4, obj.getQtdEstoque());
            sql.setFloat(5, obj.getPreco());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possivel inserir o Produto");
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

    // Listagem de produtos sem parâmetro.
    public static ArrayList<Produtos> listaProdutos(Produtos obj) {
        Connection conexao = null;
        ArrayList<Produtos> listaRetorno = new ArrayList<Produtos>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from produtos");
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtdEstoque(rs.getInt("qtdEstoque"));
                obj.setPreco(rs.getFloat("preco"));
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

    // Listagem de produtos por nome.
    public static ArrayList<Produtos> listaProdutosDescricao(Produtos obj) {
        Connection conexao = null;
        ArrayList<Produtos> listaRetorno = new ArrayList<Produtos>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from produtos where descricao like ?");
            sql.setString(1, '%' + obj.getDescricao() + '%');
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new Produtos();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtdEstoque(rs.getInt("qtdEstoque"));
                obj.setPreco(rs.getFloat("preco"));
                listaRetorno.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage() + "Aqui!!");
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

    // Listagem produtos por cpf.
    public static ArrayList<Produtos> listaProdutosCod(Produtos obj) {
        Connection conexao = null;
        ArrayList<Produtos> listaRetorno = new ArrayList<Produtos>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from produtos where codigo like ?");
            sql.setString(1, '%' + obj.getCodigo() + '%');
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new Produtos();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtdEstoque(rs.getInt("qtdEstoque"));
                obj.setPreco(rs.getFloat("preco"));
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

    // Alteração de produtos.
    public static boolean alterar(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("update produtos set descricao=?,codigo=?,modelo=?,qtdEstoque=?,preco=? where idProduto=?");
            sql.setString(1, obj.getDescricao());
            sql.setString(2, obj.getCodigo());
            sql.setString(3, obj.getModelo());
            sql.setInt(4, obj.getQtdEstoque());
            sql.setFloat(5, obj.getPreco());
            sql.setInt(6, obj.getIdProduto());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possivel inserir o produto");
            }
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    // Consulta produtos por id, retorna objeto preenchido.
    public static Produtos consultarProdutoId(Produtos obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from produtos where idProduto=?");
            sql.setInt(1, obj.getIdProduto());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtdEstoque(rs.getInt("qtdEstoque"));
                obj.setPreco(rs.getFloat("preco"));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao consultar o produto!");
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

    // Exclusão de produtos.
    public static boolean excluir(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Delete from produtos where idProduto=?");
            sql.setInt(1, obj.getIdProduto());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao consultar o produto!");
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

    // Listagem produtos por id.
    public static Produtos consultarProdutoPeloCodigo(Produtos obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from produtos where codigo=?");
            sql.setString(1, obj.getCodigo());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtdEstoque(rs.getInt("qtdEstoque"));
                obj.setPreco(rs.getFloat("preco"));
            }
       } catch (Exception e) {
            System.out.println("Erro ao consultar o produto!");
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

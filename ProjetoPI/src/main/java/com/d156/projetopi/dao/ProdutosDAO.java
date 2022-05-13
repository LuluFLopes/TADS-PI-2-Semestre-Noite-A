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

    public static boolean salvar(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("insert into produtos" + "(nome,codigo,modelo,qtd,preco)Values(?,?,?,?,?)");

            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCodigo());
            sql.setString(3, obj.getModelo());
            sql.setInt(4, obj.getQtd());
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

    public static ArrayList<Produtos> listaProdutos(Produtos obj) {

        Connection conexao = null;
        ArrayList<Produtos> listaRetorno = new ArrayList<Produtos>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from produtos");
            rs = sql.executeQuery();

            while (rs.next()) {

                obj.setIdProduto(rs.getInt("idproduto"));
                obj.setNome(rs.getString("nome"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setPreco(rs.getFloat("preço"));

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
    
    public static ArrayList<Produtos> listaProdutos (Produtos obj, String nome){
        Connection conexao = null;
        ArrayList<Produtos> listaRetorno = new ArrayList<Produtos>();
        ResultSet rs = null;
        
        try{
            
                conexao = ConexaoFactory.getConexao();
                
                PreparedStatement sql = conexao.prepareStatement("Select * from clientes where nome like ?");
                sql.setString(1, '%' + nome + '%');
                rs = sql.executeQuery();
                
                while (rs.next()) {

                obj.setIdProduto(rs.getInt("idproduto"));
                obj.setNome(rs.getString("nome"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setModelo(rs.getString("modelo"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setPreco(rs.getFloat("preço"));

                listaRetorno.add(obj);
            }
        
    }catch (Exception e) {
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

    public static Produtos atualizar(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("insert into produtos" + "(nome,codigo,modelo,qtd,preco)Values(?,?,?,?,?)");

            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCodigo());
            sql.setString(3, obj.getModelo());
            sql.setInt(3, obj.getQtd());
            sql.setFloat(4, obj.getPreco());

            rs = sql.executeQuery();
            
               while(rs.next()){
            //obj.setIdProduto(rs.getInt("idProduto"));
            //obj.setNome(rs.getString("nome"));
            //obj.setCodigo(rs.getString("codigo"));
            //obj.setModelo(rs.getString("modelo"));
            //obj.setQtd(rs.getInt("qtd"));
            //obj.setPreco(rs.getFloat("preco"));
         
            }
           
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return obj;
    }

    public static Produtos consultarProduto(Produtos obj) {
        Connection conexao = null;
        ResultSet rs = null;
        
        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from produtos where nome=? or codigo=?");

            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCodigo());
            
     
            
            rs = sql.executeQuery();
            while(rs.next()){
            obj.setIdProduto(rs.getInt("idProduto"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setModelo(rs.getString("modelo"));
            obj.setQtd(rs.getInt("qtd"));
            obj.setPreco(rs.getFloat("preco"));
         
            }

            

        } catch (Exception ex) {
            System.out.println("Erro ao consultar o Produto");
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

    public static Produtos excluir(Produtos obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Delete from protudos where  nome=? or codigo=?");
            sql.setInt(1, obj.getIdProduto());

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir o produto!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception ex) {
            }
        }
        return obj;

    }
}

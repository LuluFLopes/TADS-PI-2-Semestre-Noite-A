/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.Clientes;
import com.d156.projetopi.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucme
 */
public class ClientesDAO {

    public static boolean salvar(Clientes obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("insert into clientes"
                    + "(nome,cpf,endereco,numero,genero,estadoCivil,email,telefone,dataNascimento)values(?,?,?,?,?,?,?,?,?)");

            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf());
            sql.setString(3, obj.getEndereco());
            sql.setString(4, obj.getNumero());
            sql.setString(5, obj.getGenero());
            sql.setString(6, obj.getEstadoCivil());
            sql.setString(7, obj.getEmail());
            sql.setString(8, obj.getTelefone());
            sql.setDate(9, new java.sql.Date(obj.getData().getTime()));

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possível inserir o cliente");
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

    public static Clientes consultarCliente(Clientes obj) {


        Connection conexao = null;
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where cpf=?");
            sql.setString(1, obj.getCpf());
            rs = sql.executeQuery();

            while(rs.next()){
                
            obj.setIdCliente(rs.getInt("idCliente"));
            obj.setNome(rs.getString("nome"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getString("numero"));
            obj.setGenero(rs.getString("genero"));
            obj.setEstadoCivil(rs.getString("estadoCivil"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setData(rs.getDate("dataNascimento"));
                
            }
            

        } catch (Exception e) {
            System.out.println("Erro ao consultar o Cliente!");
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
    public static ArrayList<Clientes> listaClientes(Clientes obj) {

        Connection conexao = null;
        ArrayList<Clientes> listaRetorno = new ArrayList<Clientes>();
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from clientes");
            rs = sql.executeQuery();

            while (rs.next()) {

                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setGenero(rs.getString("genero"));
                obj.setEstadoCivil(rs.getString("estadoCivil"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setData(rs.getDate("dataNascimento"));

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

    public static ArrayList<Clientes> listaClientes(Clientes obj, String cpf) {

        Connection conexao = null;
        ArrayList<Clientes> listaRetorno = new ArrayList<Clientes>();
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where cpf like ?");
            sql.setString(1, '%' + cpf + '%');
            rs = sql.executeQuery();

            while (rs.next()) {

                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setGenero(rs.getString("genero"));
                obj.setEstadoCivil(rs.getString("estadoCivil"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setData(rs.getDate("dataNascimento"));

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

    public static ArrayList<Clientes> listaClientesNome(String nome) {
        Connection conexao = null;
        ArrayList<Clientes> listaRetorno = new ArrayList<Clientes>();
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where nome like ?");
            sql.setString(1, '%' + nome + '%');
            rs = sql.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setGenero(rs.getString("genero"));
                obj.setEstadoCivil(rs.getString("estadoCivil"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setData(rs.getDate("dataNascimento"));

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

    public static ArrayList<Clientes> listaClientesCpf(String cpf) {
        Connection conexao = null;
        ArrayList<Clientes> listaRetorno = new ArrayList<Clientes>();
        ResultSet rs = null;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where cpf like ?");
            sql.setString(1, '%' + cpf + '%');
            rs = sql.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setGenero(rs.getString("genero"));
                obj.setEstadoCivil(rs.getString("estadoCivil"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setData(rs.getDate("dataNascimento"));

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

    public static boolean excluir(Clientes obj) {

        Connection conexao = null;
        boolean retorno = false;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("Delete from clientes where idCliente=?");
            sql.setInt(1, obj.getIdCliente());

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            } else {
                retorno = false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir o cliente!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return retorno;
    }
    
    public static boolean atualizar(Clientes obj) {

        Connection conexao = null;
        boolean retorno = false;

        try {

            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("update clientes"
                    + " set nome=?,cpf?,endereco=?,numero=?,genero=?,estadoCivil=?,email=?,telefone=?,dataNascimento=? where idCliente = ?");

            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf());
            sql.setString(3, obj.getEndereco());
            sql.setString(4, obj.getNumero());
            sql.setString(5, obj.getGenero());
            sql.setString(6, obj.getEstadoCivil());
            sql.setString(7, obj.getEmail());
            sql.setString(8, obj.getTelefone());
            sql.setDate(9, new java.sql.Date(obj.getData().getTime()));

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return retorno;
    }
}

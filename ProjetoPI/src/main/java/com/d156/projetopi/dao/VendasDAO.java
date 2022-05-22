/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.dao;

import com.d156.projetopi.model.ItemVendas;
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
    
    
    public static ArrayList<ItemVendas> listaSintetico(RelatórioSintetico objSintetico,ItemVendas obj) {

        Connection conexao = null;
        ArrayList<ItemVendas> listaRetorno = new ArrayList<ItemVendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement("select a.Fk_Venda_id_Venda,b.nome,d.dataVenda,a.valorTotal  from ItensVendas a join clientes b on b.idCliente = a.fk_cliente_id_Cliente join produtos c on c.idProduto = fk_Produto_id_produto join vendas d on d.idVenda = fk_Venda_id_venda "
                    + "where dataVenda between ? and ? ");
            sql.setDate(1,  new java.sql.Date(objSintetico.getDataInicio().getTime()));
            sql.setDate(2,  new java.sql.Date(objSintetico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setIdVenda(rs.getInt(1));
                obj.setNomeCliente(rs.getString(2));
                obj.setDataVenda(rs.getDate(3));
                obj.setValortotal(rs.getFloat(4));
              
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
    
    public static ArrayList<ItemVendas> listaAnalitico(RelatorioAnalitico objAnalitico,ItemVendas obj) {

        Connection conexao = null;
        ArrayList<ItemVendas> listaRetorno = new ArrayList<ItemVendas>();
        ResultSet rs = null;

        try {
            conexao = ConexaoFactory.getConexao();

            PreparedStatement sql = conexao.prepareStatement(" select a.Fk_Venda_id_Venda, b.nome,c.nome,c.descricao,a.QuantidadeVendido,c.codigo,a.ValorTotal,d.dataVenda\n" +
"     from itensvendas a join clientes b on b.idCliente = a.fk_cliente_id_Cliente \n" +
"     join produtos c on c.idProduto = a.Fk_Produto_id_Produto join vendas d on d.idVenda = a.Fk_Venda_id_Venda where dataVenda between ? and ?;\n" +
"      ");
            sql.setDate(1,  new java.sql.Date(objAnalitico.getDataInicio().getTime()));
            sql.setDate(2,  new java.sql.Date(objAnalitico.getDataFim().getTime()));
            rs = sql.executeQuery();

            while (rs.next()) {
                obj.setNomeCliente(rs.getString(2));
                obj.setIdVenda(rs.getInt(1));
                obj.setDataVenda(rs.getDate(8));
                obj.setNomeProduto(rs.getString(3));
                obj.setCodigo(rs.getString(6));
                obj.setDescricao(rs.getString(4));
                obj.setQuantidade(rs.getInt(5));
                obj.setValortotal(rs.getFloat(7));
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

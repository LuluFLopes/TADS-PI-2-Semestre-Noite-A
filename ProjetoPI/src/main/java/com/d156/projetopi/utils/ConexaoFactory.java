/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luciano.flopes
 */
public class ConexaoFactory {

    public static Connection getConexao() {

        Connection conexao = null;

        try {

            // Carregando Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Abrindo conexão.
            conexao = DriverManager.getConnection("mysql://localhost:3306/lojainstrumentos", "root", "");

        } catch (ClassNotFoundException ex) {

            System.out.println("Erro de Driver");

        } catch (SQLException ex) {

            System.out.println("Erro de Conexão");

        }

        // OBS: Colocar validação de a conexão foi gerada com sucesso!
        return conexao;
    }

}

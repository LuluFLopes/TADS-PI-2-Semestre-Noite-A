/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.d156.projetopi.utils;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucme
 */
public class ConexaoFactoryTest {
    
    public ConexaoFactoryTest() {
    }

    /**
     * Teste do método getConexao, testa se a conexão está aberta.
     * Resultado Esperado: Falha na conexão.
     */
    @Test
    public void testGetConexao() {
        System.out.println("getConexao");
        Connection expResult = null;
        Connection result = ConexaoFactory.getConexao();
        assertEquals(expResult, result);
    }
    
}

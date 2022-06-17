/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.d156.projetopi.utils;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucme
 */
public class ValidadorTest {

    public ValidadorTest() {
    }

    /**
     * Teste do método ValidarNumero, verifica se o número da erro.
     * Resultado Esperado: Erro.
     */
    @Test
    public void testValidarNumero() {
        System.out.println("ValidarNumero");
        JTextField txt = new JTextField();
        txt.setText("Carro");
        Validador instance = new Validador();
        instance.ValidarNumero(txt);
        assertFalse(instance.mensagensErro.isEmpty());
    }

    /**
     * Teste do método ValidarTexto, verifica a validação de texto funciona.
     * Resultado Esperado: Sem Erros.
     */
    @Test
    public void testValidarTexto() {
        System.out.println("ValidarTexto");
        JTextField txt = new JTextField();
        txt.setText("Carro");
        Validador instance = new Validador();
        instance.ValidarTexto(txt);
        assertTrue(instance.mensagensErro.isEmpty());
    }

    /**
     * Teste do método ValidarData, verifica se a validação de data funciona.
     * Resultado Esperado: Sem Erros.
     */
    @Test
    public void testValidarData() {
        System.out.println("ValidarData");
        JDateChooser data = new JDateChooser();
        SimpleDateFormat entraData = new SimpleDateFormat("yyyyMMdd");
        try {
            data.setDate(entraData.parse("20010520"));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível converter!");
        }
        Validador instance = new Validador();
        instance.ValidarData(data);
        assertTrue(instance.mensagensErro.isEmpty());
    }
    
    /**
     * Teste do método ValidarFloat, verfica se foi possível converter o
     * conteúdo enviado.
     * Resultado Esperado: Sem Erros.
     */
    @Test
    public void testValidarFloat() {
        System.out.println("ValidarFloat");
        JTextField txt = new JTextField();
        txt.setText("10.0");
        Validador instance = new Validador();
        instance.ValidarFloat(txt);
        assertTrue(instance.mensagensErro.isEmpty());
    }

    /**
     * Teste do método TemErro, verifica se a mensagem de erro adicionada surte
     * efeito na validação.
     * Resultado Esperado: Falso.
     */
    @Test
    public void testTemErro() {
        System.out.println("temErro");
        Validador instance = new Validador();
        boolean expResult = false;
        instance.mensagensErro.add("Erro");
        boolean result = instance.temErro();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método LimparMensagens, verifica se após adição de erro a
     * limpeza funciona corretamente.
     * Resultado Esperado: Sem Erros.
     */
    @Test
    public void testLimparMensagens() {
        System.out.println("limparMensagens");
        Validador instance = new Validador();
        instance.mensagensErro.add("Erro");
        instance.limparMensagens();
        assertTrue(instance.mensagensErro.isEmpty());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ClientesDAO;
import com.d156.projetopi.model.Clientes;
import java.util.Date;

/**
 *
 * @author lucme
 */
public class ClientesController {

    public static boolean salvar(String nome, String cpf, String endereco, String numero, String email, String estadoCivil, String telefone, String genero, Date dataNascimento) {

        Clientes obj = new Clientes();

        obj.setNome(nome);
        obj.setCpf(cpf);
        obj.setEndereco(endereco);
        obj.setNumero(numero);
        obj.setEmail(email);
        obj.setEstadoCivil(estadoCivil);
        obj.setTelefone(telefone);
        obj.setGenero(genero);
        obj.setData(dataNascimento);

        return ClientesDAO.salvar(obj);
        
    }

}

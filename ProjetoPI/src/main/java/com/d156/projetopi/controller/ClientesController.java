/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetopi.controller;

import com.d156.projetopi.dao.ClientesDAO;
import com.d156.projetopi.model.Clientes;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucme
 */
public class ClientesController {

    public static boolean salvar(String nome, String cpf, String endereco, String numero, String email, String estadoCivil, String telefone, 
            String genero, Date dataNascimento, String complemento, String bairro, String cidade, String cep, String estado) {

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
        obj.setComplemento(complemento);
        obj.setBairro(bairro);
        obj.setCidade(cidade);
        obj.setCep(cep);
        obj.setEstado(estado);

        return ClientesDAO.salvar(obj);

    }

    public static boolean alterar(int id, String nome, String endereco, String numero, String email, String estadoCivil, String telefone, 
            String genero, Date dataNascimento, String complemento, String bairro, String cidade, String cep, String estado) {

        Clientes obj = new Clientes();

        obj.setIdCliente(id);
        obj.setNome(nome);
        obj.setEndereco(endereco);
        obj.setNumero(numero);
        obj.setEmail(email);
        obj.setEstadoCivil(estadoCivil);
        obj.setTelefone(telefone);
        obj.setGenero(genero);
        obj.setData(dataNascimento);
        obj.setComplemento(complemento);
        obj.setBairro(bairro);
        obj.setCidade(cidade);
        obj.setCep(cep);
        obj.setEstado(estado);

        return ClientesDAO.atualizar(obj);

    }

    public static Clientes consultaId(int id) {

        Clientes obj = new Clientes();
        obj.setIdCliente(id);

        return ClientesDAO.consultarClienteId(obj);

    }

    public static boolean excluir(int id) {

        Clientes obj = new Clientes();
        obj.setIdCliente(id);

        return ClientesDAO.excluir(obj);

    }

    // Função quando o usuário digitar o nome na pesquisa.
    public static ArrayList<Clientes> listaClientesNome(String nome) {

        Clientes obj = new Clientes();
        obj.setNome(nome);

        return ClientesDAO.listaClientesNome(obj);

    }

    // Função quando o usuário digitar o código na pesquisa.
    public static ArrayList<Clientes> listaClientesCpf(String cpf) {

        Clientes obj = new Clientes();
        obj.setCpf(cpf);

        return ClientesDAO.listaClientesCpf(obj);

    }

    public static Clientes consultar(String cpf) {
        
        Clientes obj = new Clientes();
        obj.setCpf(cpf);

        return ClientesDAO.consultarCliente(obj);

    }

}

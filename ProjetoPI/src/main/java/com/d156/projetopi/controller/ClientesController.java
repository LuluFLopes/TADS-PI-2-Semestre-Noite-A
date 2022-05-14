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

    public static boolean alterar(String nome, String cpf, String endereco, String numero, String email, String estadoCivil, String telefone, String genero, Date dataNascimento) {

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

        return ClientesDAO.atualizar(obj);

    }

    /*public static Clientes parametroCliente(String nome, String cpf){
        
        // Terminar de criar a lógica de pesquisa para gravação dos dados dentro da alteração.
        
        return ;
        
    }*/
    public static Clientes consultar(Clientes obj) {

        return ClientesDAO.consultarCliente(obj);

    }

    public static boolean excluir(int idProduto) {

        return false;

    }

    // Função quando o usuário digitar o nome na pesquisa.
    public static ArrayList<Clientes> listaProdutosNome(Clientes obj) {

        obj.setNome(obj.getNome());

        return ClientesDAO.listaClientesNome(obj);

    }

    // Função quando o usuário digitar o código na pesquisa.
    public static ArrayList<Clientes> listaProdutosCpf(Clientes obj) {

        obj.setCpf(obj.getCpf());

        return ClientesDAO.listaClientesCpf(obj);

    }

}

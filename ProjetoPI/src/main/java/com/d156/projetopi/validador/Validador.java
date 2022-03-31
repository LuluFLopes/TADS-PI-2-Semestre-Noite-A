package com.d156.projetopi.validador;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validador {

    public ArrayList<String> mensagensErro = new ArrayList<>();

    //Validação de Número
    public void ValidarNumero(JTextField txt) {

        try {

            //Verifico se o campo está vazio
            if (txt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }

            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);

        } catch (NumberFormatException e) {

            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro");
            txt.setBackground(Color.red);
        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }

    }

    // Validação de Texto.
    public void ValidarTexto(JTextField txt) {

        try {

            // Verifico se o campo está vazio.
            if (txt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }

            txt.setBackground(Color.WHITE);

        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }

    }

    // Validação de ComboBox.
    public void ValidarCbo(JTextField txt) {

        try {

            // Verifico se o campo está vazio.
            if (txt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }

            txt.setBackground(Color.WHITE);

        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }

    }

    //Validação de Float.
    public void ValidarFloat(JTextField txt) {

        try {

            // Verifico se o campo está vazio.
            if (txt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }

            float valorConvertido = Float.parseFloat(txt.getText());
            txt.setBackground(Color.WHITE);

        } catch (NumberFormatException e) {

            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em float");
            txt.setBackground(Color.red);
        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }

    }

    // Limpador de Array.
    public void limparMensagens() {

        this.mensagensErro.clear();
    }

    

    // Modelo de Exibição 1.
    public void ExibirMensagensErro() {

        String errosFormulario = "";
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }

        if (!errosFormulario.equals("")) {
            JOptionPane.showMessageDialog(null, errosFormulario);
            this.limparMensagens();
        }

    }

    // Modelo de Exibição 2.
    public String getMensagensErro() {

        String errosFormulario = "";

        // Percorro o arrayList e concateno na variável errosFormulario.
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }

        if (!errosFormulario.equals("")) {
            this.limparMensagens();
        }

        return errosFormulario;

    }
 
    // Retorno Booleano em Caso de Preenchimento da Array.
    public boolean hasErro() {

        if (this.mensagensErro.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}

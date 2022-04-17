/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.d156.projetopi;

import com.d156.projetopi.classes.Clientes;
import com.d156.projetopi.classes.Produtos;
import com.d156.projetopi.classes.Validador;

/**
 *
 * @author luciano.flopes
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        lblReference = new javax.swing.JLabel();
        mnuBarra = new javax.swing.JMenuBar();
        mnuCadastro = new javax.swing.JMenu();
        mnuClientes = new javax.swing.JMenu();
        mnuCadastroCli = new javax.swing.JMenuItem();
        mnuAlterarCli = new javax.swing.JMenuItem();
        mnuProdutos = new javax.swing.JMenu();
        mnuCadastroProd = new javax.swing.JMenuItem();
        mnuAlterarProd = new javax.swing.JMenuItem();
        mnuRelatorios = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnuVendas = new javax.swing.JMenu();
        mnuNovaVenda = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuBarra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mnuCadastro.setText("Cadastro");

        mnuClientes.setText("Clientes");

        mnuCadastroCli.setText("Cadastrar");
        mnuCadastroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroCliActionPerformed(evt);
            }
        });
        mnuClientes.add(mnuCadastroCli);

        mnuAlterarCli.setText("Alterar/Exluir");
        mnuAlterarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarCliActionPerformed(evt);
            }
        });
        mnuClientes.add(mnuAlterarCli);

        mnuCadastro.add(mnuClientes);

        mnuProdutos.setText("Produtos");

        mnuCadastroProd.setText("Cadastrar");
        mnuCadastroProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroProdActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuCadastroProd);

        mnuAlterarProd.setText("Altera/Excluir");
        mnuAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarProdActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuAlterarProd);

        mnuCadastro.add(mnuProdutos);

        mnuBarra.add(mnuCadastro);

        mnuRelatorios.setText("Relatórios");

        jMenuItem7.setText("Relatório Sintético");
        mnuRelatorios.add(jMenuItem7);

        jMenuItem9.setText("Relatório Analítico");
        mnuRelatorios.add(jMenuItem9);

        mnuBarra.add(mnuRelatorios);

        mnuVendas.setText("Vendas");

        mnuNovaVenda.setText("Nova Venda");
        mnuNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNovaVendaActionPerformed(evt);
            }
        });
        mnuVendas.add(mnuNovaVenda);

        mnuBarra.add(mnuVendas);

        setJMenuBar(mnuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addComponent(lblReference)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(lblReference)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAlterarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarCliActionPerformed
        TelaDeConsultaClientes janelaConsulta = new TelaDeConsultaClientes();
        janelaConsulta.setVisible(true);
    }//GEN-LAST:event_mnuAlterarCliActionPerformed

    private void mnuCadastroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroCliActionPerformed
        CadastroClientes cadastro = new CadastroClientes();
        cadastro.setVisible(true);
    }//GEN-LAST:event_mnuCadastroCliActionPerformed

    private void mnuCadastroProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroProdActionPerformed
        CadastroProdutos cadastro = new CadastroProdutos();
        cadastro.setVisible(true);
    }//GEN-LAST:event_mnuCadastroProdActionPerformed

    private void mnuNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNovaVendaActionPerformed
        Venda vendas = new Venda();
        vendas.setVisible(true);
    }//GEN-LAST:event_mnuNovaVendaActionPerformed

    private void mnuAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarProdActionPerformed
        TelaIntermediariaProduto janelaInterProd = new TelaIntermediariaProduto();
        janelaInterProd.setVisible(true);
    }//GEN-LAST:event_mnuAlterarProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel lblReference;
    private javax.swing.JMenuItem mnuAlterarCli;
    private javax.swing.JMenuItem mnuAlterarProd;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenuItem mnuCadastroCli;
    private javax.swing.JMenuItem mnuCadastroProd;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenuItem mnuNovaVenda;
    private javax.swing.JMenu mnuProdutos;
    private javax.swing.JMenu mnuRelatorios;
    private javax.swing.JMenu mnuVendas;
    // End of variables declaration//GEN-END:variables
}

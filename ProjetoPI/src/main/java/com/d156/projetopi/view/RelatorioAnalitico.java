/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.d156.projetopi.view;

import com.d156.projetopi.controller.ItensVendasController;
import com.d156.projetopi.controller.VendasController;
import com.d156.projetopi.model.ItensVendas;
import com.d156.projetopi.utils.Validador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucme
 */
public class RelatorioAnalitico extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioAnalitico
     */
    public RelatorioAnalitico() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorioAnalitico = new javax.swing.JTable();
        btnDetalhar = new javax.swing.JButton();
        jdcDataInicial = new com.toedter.calendar.JDateChooser();
        jdcDataFim = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblRelatorioAnalitico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Venda", "Cliente", "Valor Total", "Data da Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRelatorioAnalitico);

        btnDetalhar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDetalhar.setText("Detalhar");
        btnDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalharActionPerformed(evt);
            }
        });

        jdcDataInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jdcDataInicial.setName("Data Inicial");

        jdcDataFim.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Final", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jdcDataFim.setName("Data Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDetalhar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDetalhar, btnPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDetalhar, btnPesquisar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalharActionPerformed
        // Pegando o modelo padrão.
        DefaultTableModel modelo = (DefaultTableModel) tblRelatorioAnalitico.getModel();

        // Pega a linha selecionada.
        int indice = tblRelatorioAnalitico.getSelectedRow();
        // Valida se alguma linha foi selecionada.
        if (indice < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        } else {
            // Pega o id em forma de objeto e converte para inteiro.
            Object obj1 = tblRelatorioAnalitico.getValueAt(indice, 0);
            String dados = String.valueOf(obj1);
            int id = Integer.parseInt(dados);

            // Manda o id para a tela de detalhamento.
            Detalhamento detalhamento = new Detalhamento(id);
            detalhamento.setVisible(true);
        }

    }//GEN-LAST:event_btnDetalharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // Pega as data do campo jdc. 
        Date dataInicial = jdcDataInicial.getDate();
        Date dataFim = jdcDataFim.getDate();

        Validador validador = new Validador();

        validador.ValidarData(jdcDataInicial);
        validador.ValidarData(jdcDataFim);
        boolean temErro = validador.temErro();
        validador.ExibirMensagensErro();

        if (temErro) {
            // Valida se a data inicial é menor ou igual a final.
            if (dataInicial.before(dataFim)) {
                ArrayList<ItensVendas> listaVendas = VendasController.listaAnaliticoController(dataInicial, dataFim);
                DefaultTableModel modelo = (DefaultTableModel) tblRelatorioAnalitico.getModel();
                // Valida se a lista tem conteúdo.
                if (!listaVendas.isEmpty()) {
                    modelo.setRowCount(0);
                    for (ItensVendas venda : listaVendas) {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        int id = venda.getIdVenda();
                        ItensVendas total = new ItensVendas();
                        total = ItensVendasController.listaTotal(id);
                        modelo.addRow(new Object[]{
                            venda.getIdVenda(),
                            venda.getNomeCliente(),
                            total.getValorTotal(),
                            String.valueOf(formato.format(venda.getDataVenda()))});
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Não há informações lançadas no período!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "A data inicial não pode ser maior que a data final");
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioAnalitico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalhar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcDataFim;
    private com.toedter.calendar.JDateChooser jdcDataInicial;
    private javax.swing.JTable tblRelatorioAnalitico;
    // End of variables declaration//GEN-END:variables
}

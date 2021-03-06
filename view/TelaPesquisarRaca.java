/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControleRaca;
import exception.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class TelaPesquisarRaca extends javax.swing.JFrame {

    private ControleRaca controleraca = new ControleRaca();
    
    public TelaPesquisarRaca() throws ParseException, DAOException, SQLException {
        initComponents();
        carregarDados();
        carregarMenuPopup();
    }
    
    private void carregarDados() throws ParseException, SQLException, DAOException
    {
        TableModelRaca modelo =  new TableModelRaca(controleraca.pesquisar(cFiltro.getText()));
        tabelaRacas.setModel(modelo);  
    }
    
    private void selecionarRaca(MouseEvent evt) throws ParseException, SQLException, DAOException
    {
        int linha = tabelaRacas.rowAtPoint(evt.getPoint());
        if(linha >= 0)
        {
            tabelaRacas.setRowSelectionInterval(linha, linha);
            linha = tabelaRacas.getSelectedRow();
            controleraca.setRaca(controleraca.pesquisar(cFiltro.getText()).get(linha));       
        }
    }
    
    private void realizarAcao(MouseEvent evt) throws ParseException, SQLException, DAOException
    {
        if(evt.getButton() == MouseEvent.BUTTON1)
        {
            if(evt.getClickCount() > 1)
            {
                
            }
        }else if(evt.getButton() == MouseEvent.BUTTON3)
        {
            menuTabela.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void carregarMenuPopup()
    {
        JMenuItem itemExcluir  = new JMenuItem("Excluir registro");
        
        itemExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Confirmar a exclusão do registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        
                if(resp ==JOptionPane.YES_OPTION){
                    try {
                        controleraca.excluir();
                        JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                    
                }
                
                try {  
                    carregarDados();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DAOException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }); 
        
        menuTabela.add(itemExcluir);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabela = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRacas = new javax.swing.JTable();
        bNovo = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pesquisar [Raça]");

        jLabel2.setText("Filtro");

        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        tabelaRacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaRacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaRacasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRacas);

        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bPesquisar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        try {
            new TelaCadastrarRaca().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPesquisarRaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TelaPesquisarRaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisarRaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bNovoActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        TelaPesquisarRaca.this.dispose();
    }//GEN-LAST:event_bSairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            carregarDados();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        try {
            carregarDados();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

            
    }//GEN-LAST:event_formMouseReleased

    private void tabelaRacasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRacasMouseReleased
        try {
            selecionarRaca(evt);
            realizarAcao(evt);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelaRacasMouseReleased

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
            java.util.logging.Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPesquisarAnimal().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DAOException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPesquisarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JButton bSair;
    private javax.swing.JTextField cFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu menuTabela;
    private javax.swing.JTable tabelaRacas;
    // End of variables declaration//GEN-END:variables
}

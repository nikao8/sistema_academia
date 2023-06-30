/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.academia.view.users;

import br.com.academia.dao.impl.InstrutorDAO;
import br.com.academia.model.pessoas.Instrutor;
import br.com.academia.model.sistema.Academia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nikao
 */
public class GerenciarInstrutor extends javax.swing.JDialog {

    /**
     * Creates new form GerenciarUsuarios
     */
    public GerenciarInstrutor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitleInstrutor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbPesquisarInstrutor = new javax.swing.JButton();
        jtfPesquisarNomeInstrutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfPesquisarLoginInstrutor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbNovoInstrutor = new javax.swing.JButton();
        jbAlterarInstrutor = new javax.swing.JButton();
        jbApagarInstrutor = new javax.swing.JButton();
        jbSairInstrutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInstrutor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        jlTitleInstrutor.setFont(new java.awt.Font("Fira Sans", 0, 36)); // NOI18N
        jlTitleInstrutor.setForeground(new java.awt.Color(242, 242, 242));
        jlTitleInstrutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitleInstrutor.setText("Instrutor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jlTitleInstrutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jlTitleInstrutor)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jbPesquisarInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jbPesquisarInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarInstrutorActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Login:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtfPesquisarNomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPesquisarLoginInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbPesquisarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPesquisarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPesquisarNomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesquisarLoginInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbNovoInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo_user.png"))); // NOI18N
        jbNovoInstrutor.setText("Novo");
        jbNovoInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoInstrutorActionPerformed(evt);
            }
        });

        jbAlterarInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jbAlterarInstrutor.setText("Alterar");
        jbAlterarInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarInstrutorActionPerformed(evt);
            }
        });

        jbApagarInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apagar.png"))); // NOI18N
        jbApagarInstrutor.setText("Apagar");
        jbApagarInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarInstrutorActionPerformed(evt);
            }
        });

        jbSairInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        jbSairInstrutor.setText("Fechar");
        jbSairInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairInstrutorActionPerformed(evt);
            }
        });

        jtInstrutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Login", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtInstrutor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbNovoInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAlterarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbApagarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSairInstrutor))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovoInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbApagarInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSairInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            allInstrutores = new InstrutorDAO().buscarTodos();
            preencheTable(allInstrutores);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar os intrutores no banco de dados.");
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jbPesquisarInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarInstrutorActionPerformed
        try {
            allInstrutores = new InstrutorDAO().buscarPesquisaPersonalizada(jtfPesquisarNomeInstrutor.getText(),jtfPesquisarLoginInstrutor.getText() );
            preencheTable(allInstrutores);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar os intrutores no banco de dados.");
        }
        
    }//GEN-LAST:event_jbPesquisarInstrutorActionPerformed

    private void jbNovoInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoInstrutorActionPerformed
        InserirInstrutor insi = new InserirInstrutor(null,true);
        insi.setAcademia(academia);
        insi.setVisible(true);
        
        formWindowOpened(null);
    }//GEN-LAST:event_jbNovoInstrutorActionPerformed

    private void jbApagarInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarInstrutorActionPerformed
        int row = jtInstrutor.getSelectedRow();
        
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Selecione um instrutor na lista para apagar!");
        } else {
            
            if(JOptionPane.showConfirmDialog(null, "Deseja apagar o instrutor " + allInstrutores.get(row).getNome() + "?",
                    "Apagar instrutor?",
                    JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION ){
                try {
                    new InstrutorDAO().apagar(allInstrutores.get(row));
                    JOptionPane.showMessageDialog(null, "Instrutor apagado com sucesso.");
                    formWindowOpened(null);
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel apagar o intrutor no banco de dados.");
                }
            }
        }
    }//GEN-LAST:event_jbApagarInstrutorActionPerformed

    private void jbSairInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairInstrutorActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSairInstrutorActionPerformed

    private void jbAlterarInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarInstrutorActionPerformed
        int row = jtInstrutor.getSelectedRow();
        
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Selecione um instrutor na lista para alterar!");
        } else {
            //allInstrutores.get(row);
            
            InserirInstrutor insi = new InserirInstrutor(null,true);
            insi.setAcademia(academia);
            
            insi.preparedEdit(allInstrutores.get(row));
            insi.setVisible(true);
        
            formWindowOpened(null);
            
 
        }
    }//GEN-LAST:event_jbAlterarInstrutorActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GerenciarInstrutor dialog = new GerenciarInstrutor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    private ArrayList<Instrutor> allInstrutores;
    
    private Academia academia;
    
    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterarInstrutor;
    private javax.swing.JButton jbApagarInstrutor;
    private javax.swing.JButton jbNovoInstrutor;
    private javax.swing.JButton jbPesquisarInstrutor;
    private javax.swing.JButton jbSairInstrutor;
    private javax.swing.JLabel jlTitleInstrutor;
    private javax.swing.JTable jtInstrutor;
    private javax.swing.JTextField jtfPesquisarLoginInstrutor;
    private javax.swing.JTextField jtfPesquisarNomeInstrutor;
    // End of variables declaration//GEN-END:variables
    
    
    private void preencheTable(ArrayList<Instrutor> allInstrutores) {
        DefaultTableModel dftm = (DefaultTableModel) jtInstrutor.getModel();
        
        while(dftm.getRowCount() > 0){
            dftm.removeRow(0);
        }
        
        for(Instrutor i : allInstrutores){
            String[] linha = {i.getNome(),i.getLogin(),i.getSalario()+""};
            dftm.addRow(linha);
        }
    }

}

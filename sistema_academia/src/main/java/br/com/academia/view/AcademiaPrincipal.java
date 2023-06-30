/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.academia.view;

import br.com.academia.model.pessoas.Aluno;
import br.com.academia.model.pessoas.Usuario;
import br.com.academia.model.sistema.Academia;
import br.com.academia.view.fichas.GerenciarExercicios;
import br.com.academia.view.fichas.GerenciarFichas;
import br.com.academia.view.fichas.VisualizarFichas;
import br.com.academia.view.financeiro.GerarPagamento;
import br.com.academia.view.financeiro.VisualizarPagamentos;
import br.com.academia.view.sistema.Informacoes;
import br.com.academia.view.sistema.Relatorio;
import br.com.academia.view.users.GerenciarAluno;
import br.com.academia.view.users.GerenciarInstrutor;
import javax.swing.JOptionPane;

/**
 *
 * @author nikao
 */
public class AcademiaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form AcademiaPrincipal
     */
    public AcademiaPrincipal() {
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
        jlLogo = new javax.swing.JLabel();
        jlUsuarioLogado = new javax.swing.JLabel();
        jlAcademiaLogada = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jmbMainMenu = new javax.swing.JMenuBar();
        jmAdmin = new javax.swing.JMenu();
        jmGerenciar = new javax.swing.JMenu();
        jmGerenciarInstrutor = new javax.swing.JMenuItem();
        jmGerenciarAluno = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenuItem();
        jmPagamento = new javax.swing.JMenuItem();
        jmInstrutor = new javax.swing.JMenu();
        jmCadastroFicha = new javax.swing.JMenu();
        jmFicha = new javax.swing.JMenuItem();
        jmExercicio = new javax.swing.JMenuItem();
        jmAluno = new javax.swing.JMenu();
        jmFichas = new javax.swing.JMenuItem();
        jmPagamentos = new javax.swing.JMenuItem();
        jmPerfil = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jlLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jlUsuarioLogado.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuarioLogado.setText("Usuario: ");

        jlAcademiaLogada.setForeground(new java.awt.Color(255, 255, 255));
        jlAcademiaLogada.setText("Academia: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(jlAcademiaLogada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jlAcademiaLogada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlUsuarioLogado)
                .addContainerGap())
        );

        jlTitle.setFont(new java.awt.Font("Nimbus Sans", 1, 36)); // NOI18N
        jlTitle.setText("EasyGym");

        jmAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin.png"))); // NOI18N
        jmAdmin.setText("Administrador");

        jmGerenciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N
        jmGerenciar.setText("Gerenciar usuários");

        jmGerenciarInstrutor.setText("Instrutor");
        jmGerenciarInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGerenciarInstrutorActionPerformed(evt);
            }
        });
        jmGerenciar.add(jmGerenciarInstrutor);

        jmGerenciarAluno.setText("Aluno");
        jmGerenciarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGerenciarAlunoActionPerformed(evt);
            }
        });
        jmGerenciar.add(jmGerenciarAluno);

        jmAdmin.add(jmGerenciar);

        jmRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio.png"))); // NOI18N
        jmRelatorios.setText("Relatórios");
        jmRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatoriosActionPerformed(evt);
            }
        });
        jmAdmin.add(jmRelatorios);

        jmPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pagamento.png"))); // NOI18N
        jmPagamento.setText("Gerar pagamento de mensalidade");
        jmPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPagamentoActionPerformed(evt);
            }
        });
        jmAdmin.add(jmPagamento);

        jmbMainMenu.add(jmAdmin);

        jmInstrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/instrutor.png"))); // NOI18N
        jmInstrutor.setText("Instrutor");

        jmCadastroFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nova_ficha.png"))); // NOI18N
        jmCadastroFicha.setText("Gerenciar Ficha/Exercicio");

        jmFicha.setText("Ficha");
        jmFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFichaActionPerformed(evt);
            }
        });
        jmCadastroFicha.add(jmFicha);

        jmExercicio.setText("Exercicio");
        jmExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExercicioActionPerformed(evt);
            }
        });
        jmCadastroFicha.add(jmExercicio);

        jmInstrutor.add(jmCadastroFicha);

        jmbMainMenu.add(jmInstrutor);

        jmAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aluno.png"))); // NOI18N
        jmAluno.setText("Aluno");

        jmFichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fichas.png"))); // NOI18N
        jmFichas.setText("Minhas fichas");
        jmFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFichasActionPerformed(evt);
            }
        });
        jmAluno.add(jmFichas);

        jmPagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/meus_pagamentos.png"))); // NOI18N
        jmPagamentos.setText("Pagamentos");
        jmPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPagamentosActionPerformed(evt);
            }
        });
        jmAluno.add(jmPagamentos);

        jmbMainMenu.add(jmAluno);

        jmPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N
        jmPerfil.setText("Perfil");
        jmPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmPerfilMouseClicked(evt);
            }
        });
        jmPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPerfilActionPerformed(evt);
            }
        });
        jmbMainMenu.add(jmPerfil);

        jmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jmSair.setText("Sair");
        jmSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSairMouseClicked(evt);
            }
        });
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jmbMainMenu.add(jmSair);

        setJMenuBar(jmbMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jlTitle)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jlTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Login login = new Login(this, true);
        login.setVisible(true);

        jlUsuarioLogado.setText("Usuario: " + login.getUser().getNome());
        jlAcademiaLogada.setText(("Academia: " + login.getAcademia().getNome()));

        this.user = login.getUser();
        this.academia = login.getAcademia();
        
        if(login.isAdministrador()){
            jmInstrutor.setEnabled(false);
            jmAluno.setEnabled(false);
            admin = true;
        } else if(login.isInstrutor()){
            jmAdmin.setEnabled(false);
            jmAluno.setEnabled(false);
            instrutor = true;
        } else if(login.isAluno()){
            jmAdmin.setEnabled(false);
            jmInstrutor.setEnabled(false);
            aluno = true;
        }
    }//GEN-LAST:event_formWindowOpened

    private void jmGerenciarInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGerenciarInstrutorActionPerformed
        GerenciarInstrutor gi = new GerenciarInstrutor(this, true);
        gi.setAcademia(academia);
        gi.setVisible(true);
    }//GEN-LAST:event_jmGerenciarInstrutorActionPerformed

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
  
            if(JOptionPane.showConfirmDialog(null, user.getNome() + ", deseja sair do sistema?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION ){
                    System.exit(0);
            }
    }//GEN-LAST:event_jmSairActionPerformed

    private void jmSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSairMouseClicked
        jmSairActionPerformed(null);
    }//GEN-LAST:event_jmSairMouseClicked

    private void jmGerenciarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGerenciarAlunoActionPerformed
        GerenciarAluno ga = new GerenciarAluno(this, true);
        ga.setAcademia(academia);
        ga.setVisible(true);
    }//GEN-LAST:event_jmGerenciarAlunoActionPerformed

    private void jmPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPagamentoActionPerformed
        GerarPagamento gp = new GerarPagamento(this,true);
        gp.setVisible(true);
    }//GEN-LAST:event_jmPagamentoActionPerformed

    private void jmRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatoriosActionPerformed
        Relatorio re = new Relatorio(this, true);
        re.setAcademia(academia);
        re.setVisible(true);
    }//GEN-LAST:event_jmRelatoriosActionPerformed

    private void jmFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFichaActionPerformed
        GerenciarFichas gf = new GerenciarFichas(this, true);
        gf.setInstrutor(user);
        gf.setVisible(true);
    }//GEN-LAST:event_jmFichaActionPerformed

    private void jmExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExercicioActionPerformed
        GerenciarExercicios ge = new GerenciarExercicios(this,true);
        ge.setInstrutor(user);
        ge.setVisible(true);
    }//GEN-LAST:event_jmExercicioActionPerformed

    private void jmPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPerfilActionPerformed
        Informacoes inf = new Informacoes(this, true);
        inf.setUsuario(user);
        inf.setAdmin(admin);
        inf.setInstrutor(instrutor);
        inf.setAluno(aluno);
        inf.setVisible(true);
    }//GEN-LAST:event_jmPerfilActionPerformed

    private void jmPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmPerfilMouseClicked
        jmPerfilActionPerformed(null);
    }//GEN-LAST:event_jmPerfilMouseClicked

    private void jmFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFichasActionPerformed
        VisualizarFichas vf = new VisualizarFichas(this, true);
        vf.setAluno(user);
        vf.setVisible(true);
        
    }//GEN-LAST:event_jmFichasActionPerformed

    private void jmPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPagamentosActionPerformed
        VisualizarPagamentos vp = new VisualizarPagamentos(this, true);
        vp.setAluno((Aluno) user);
        vp.setVisible(true);
    }//GEN-LAST:event_jmPagamentosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcademiaPrincipal().setVisible(true);
            }
        });
    }

    private Usuario user;
    private Academia academia;
    
    private boolean admin;
    private boolean instrutor;
    private boolean aluno;

    public Usuario getUser(){
        return user;
    }
    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlAcademiaLogada;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlUsuarioLogado;
    private javax.swing.JMenu jmAdmin;
    private javax.swing.JMenu jmAluno;
    private javax.swing.JMenu jmCadastroFicha;
    private javax.swing.JMenuItem jmExercicio;
    private javax.swing.JMenuItem jmFicha;
    private javax.swing.JMenuItem jmFichas;
    private javax.swing.JMenu jmGerenciar;
    private javax.swing.JMenuItem jmGerenciarAluno;
    private javax.swing.JMenuItem jmGerenciarInstrutor;
    private javax.swing.JMenu jmInstrutor;
    private javax.swing.JMenuItem jmPagamento;
    private javax.swing.JMenuItem jmPagamentos;
    private javax.swing.JMenu jmPerfil;
    private javax.swing.JMenuItem jmRelatorios;
    private javax.swing.JMenu jmSair;
    private javax.swing.JMenuBar jmbMainMenu;
    // End of variables declaration//GEN-END:variables
}

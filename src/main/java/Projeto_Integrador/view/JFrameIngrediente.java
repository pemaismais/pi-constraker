package Projeto_Integrador.view;

import Projeto_Integrador.utils.ViewUtils;
import Projeto_Integrador.controller.IngredienteController;
import Projeto_Integrador.model.DTO.IngredienteDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JFrameIngrediente extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private IngredienteController ingredienteController;

    public JFrameIngrediente() {
        this.ingredienteController = new IngredienteController();
        this.ingredienteController = new IngredienteController();

        initComponents();
        carregarIngredientes();
    }

    public JFrameIngrediente(MainFrame mainFrame) {
        this.ingredienteController = new IngredienteController();
        this.mainFrame = mainFrame;
        this.ingredienteController = new IngredienteController();

        initComponents();
        carregarIngredientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelForm = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jButtonEnviar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonRemove = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGREDIENTES");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNome.setToolTipText("Insira o nome do ingrediente.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor");

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValor.setToolTipText("Insira o valor do ingrediente.");

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidade.setToolTipText("Insira a quantidade do ingrediente.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo");

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo", "Gramas", "Mililitros", "Unidade" }));
        jComboBoxTipo.setToolTipText("Insira o tipo do ingrediente.");
        jComboBoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(200, 40));

        jButtonEnviar.setBackground(new java.awt.Color(204, 255, 204));
        jButtonEnviar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEnviar.setText("Enviar");
        jButtonEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enviar(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 204));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alterar(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Cadastro");

        jButtonRemove.setBackground(new java.awt.Color(255, 204, 204));
        jButtonRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRemove.setText("Remover");
        jButtonRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/_paint_brush-512-1211221507.png"))); // NOI18N
        jButton4.setToolTipText("Limpar formulário.");
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setIconTextGap(0);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetar(evt);
            }
        });

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNome)
                            .addComponent(jTextFieldValor)
                            .addComponent(jTextFieldQuantidade)
                            .addComponent(jComboBoxTipo, 0, 300, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                                .addComponent(jButtonRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Leite", "10", "1000", "Mililitros"}
            },
            new String [] {
                "Id", "Nome", "Valor", "Quantidade", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ingredientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private final ViewUtils utils = new ViewUtils();

    private void resetarCampos() {
        utils.limparCampos(new Object[]{jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo});
        jTable.clearSelection();
        carregarIngredientes();
    }

    private void carregarIngredientes() {
        try {
            ingredienteController.carregarIngredientesParaTabela(jTable);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    private void Enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enviar
        String nome = jTextFieldNome.getText();
        String valorStr = jTextFieldValor.getText();
        String quantidadeStr = jTextFieldQuantidade.getText();
        String tipo = jComboBoxTipo.getSelectedItem().toString();
        IngredienteDTO ingrediente = new IngredienteDTO(nome, valorStr, quantidadeStr, tipo);
        if (ingredienteController.cadastrar(ingrediente)) {
            resetarCampos();
        }
    }//GEN-LAST:event_Enviar

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void tableClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClicked
        utils.tableParaCampos(new Object[]{null, jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo}, jTable);
    }//GEN-LAST:event_tableClicked

    private void Alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alterar
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTable);
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int id = ids.get(0);
                String nome = jTextFieldNome.getText();
                String valor = jTextFieldValor.getText();
                String quantidade = jTextFieldQuantidade.getText();
                String tipo = jComboBoxTipo.getSelectedItem().toString();

                IngredienteDTO ingrediente = new IngredienteDTO(id, nome, valor, quantidade, tipo);

                if (ingredienteController.alterarIngrediente(ingrediente)) {
                    resetarCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas um produto para modificar!");
        }
    }//GEN-LAST:event_Alterar

    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTable);
        int resposta;
        if (ids.size() == 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else if (ids.size() > 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover mais de um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
            return;
        }
        switch (resposta) {
            case JOptionPane.YES_OPTION -> {
                // fazendo com 1 primeiro
                if (ingredienteController.removerIngredientes(ids)) {
                    if (ids.size() == 1) {
                        JOptionPane.showMessageDialog(null, "Item Removido com sucesso ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Itens Removidos com sucesso ");
                    }
                    resetarCampos();
                }
            }
        }
    }//GEN-LAST:event_remover

    private void resetar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetar
        resetarCampos();
    }//GEN-LAST:event_resetar

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
            java.util.logging.Logger.getLogger(JFrameIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameIngrediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}

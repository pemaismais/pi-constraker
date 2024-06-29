package Projeto_Integrador.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author henri
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonIngrediente = new javax.swing.JButton();
        jButtonProduto = new javax.swing.JButton();
        jButtonReceita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("=D");

        jButtonIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jButtonIngrediente.setText("Ingredientes");
        jButtonIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngredienteActionPerformed(evt);
            }
        });

        jButtonProduto.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jButtonProduto.setText("Produtos");
        jButtonProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoActionPerformed(evt);
            }
        });

        jButtonReceita.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jButtonReceita.setText("Receitas");
        jButtonReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(332, 332, 332))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButtonIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIngrediente)
                    .addComponent(jButtonReceita)
                    .addComponent(jButtonProduto))
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        IconFontSwing.register(FontAwesome.getIconFont());
        jButtonProduto.setIcon(IconFontSwing.buildIcon(FontAwesome.BIRTHDAY_CAKE, 20, Color.black));
        jButtonIngrediente.setIcon(IconFontSwing.buildIcon(FontAwesome.SHOPPING_BASKET, 20, Color.black));
        jButtonReceita.setIcon(IconFontSwing.buildIcon(FontAwesome.BOOK, 20, Color.black));


    }//GEN-LAST:event_formWindowOpened

    private void jButtonIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngredienteActionPerformed
        // TODO add your handling code here:

        JFrameIngrediente jframeIngrediente = new JFrameIngrediente(this);
        jframeIngrediente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonIngredienteActionPerformed

    private void jButtonProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoActionPerformed

        JFrameProduto2 jFrameProduto = new JFrameProduto2(this);
        jFrameProduto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonProdutoActionPerformed

    private void jButtonReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaActionPerformed
        // TODO add your handling code here:
        JFrameReceita2 jframeReceita = new JFrameReceita2(this);
        jframeReceita.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonReceitaActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngrediente;
    private javax.swing.JButton jButtonProduto;
    private javax.swing.JButton jButtonReceita;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

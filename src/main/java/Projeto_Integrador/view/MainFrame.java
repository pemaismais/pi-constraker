
package Projeto_Integrador.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        jMenuBar = new javax.swing.JMenuBar();
        jMenuIngrediente = new javax.swing.JMenu();
        jMenuReceitas = new javax.swing.JMenu();
        jMenuProdutos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("=D");

        jMenuIngrediente.setText("Ingredientes");
        jMenuIngrediente.setToolTipText("Veja e cadastre seus ingredientes.");
        jMenuIngrediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IngredienteCLicked(evt);
            }
        });
        jMenuBar.add(jMenuIngrediente);

        jMenuReceitas.setText("Receitas");
        jMenuReceitas.setToolTipText("Veja e cadastre suas receitas juntando ingredientes.");
        jMenuReceitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuReceitas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReceitaClicked(evt);
            }
        });
        jMenuBar.add(jMenuReceitas);

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.setToolTipText("Veja e cadastre seus Produtos juntando Receitas e colocando lucro.");
        jMenuProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuProdutos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                produtosClicked(evt);
            }
        });
        jMenuBar.add(jMenuProdutos);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IngredienteCLicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngredienteCLicked
        JFrameIngrediente jframeIngrediente = new JFrameIngrediente(this);
        jframeIngrediente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_IngredienteCLicked

    private void ReceitaClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReceitaClicked
        JFrameReceita jframeReceita = new JFrameReceita(this);
        jframeReceita.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ReceitaClicked

    private void produtosClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosClicked
        // TODO add your handling code here:

        JFrameProdutos jFrameProduto = new JFrameProdutos(this);
        jFrameProduto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_produtosClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuIngrediente;
    private javax.swing.JMenu jMenuProdutos;
    private javax.swing.JMenu jMenuReceitas;
    // End of variables declaration//GEN-END:variables
}

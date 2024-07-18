/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Projeto_Integrador.view;

import Projeto_Integrador.utils.Utils;
import Projeto_Integrador.controller.ProdutoController;
import Projeto_Integrador.controller.ReceitaController;
import Projeto_Integrador.model.DTO.ProdutoDTO;
import Projeto_Integrador.model.DTO.ReceitaDTO;
import Projeto_Integrador.utils.ResultadoValidacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jiconfont.icons.elusive.Elusive;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author henri
 */
public class JFrameProduto2 extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private ReceitaController receitaController;
    private ProdutoController produtoController;

    public JFrameProduto2() {
        this.receitaController = new ReceitaController();
        this.produtoController = new ProdutoController();
        initComponents();
    }

    public JFrameProduto2(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.receitaController = new ReceitaController();
        this.produtoController = new ProdutoController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelForm = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorAdicional = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxLucro = new javax.swing.JComboBox<>();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonRemove = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonEnviar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelContainerReceitas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonNovoIngrediente = new javax.swing.JButton();
        jLabelIngredientesDaReceita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNome.setToolTipText("Insira o nome da receita.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidade.setToolTipText("Insira o quanto a receita rende.");
        jTextFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo");

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo", "Gramas", "Mililitros", "Unidade" }));
        jComboBoxTipo.setToolTipText("Selecione o tipo da receita");
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(200, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Valor Adicional");

        jTextFieldValorAdicional.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorAdicional.setText("0");
        jTextFieldValorAdicional.setToolTipText("Insira um valor adicional caso necessario.");
        jTextFieldValorAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorAdicionalKeyPressed(evt);
            }
        });

        jButtonLimpar.setToolTipText("Limpar formulário.");
        jButtonLimpar.setBorderPainted(false);
        jButtonLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpar.setIconTextGap(0);
        jButtonLimpar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonLimpar.setMaximumSize(new java.awt.Dimension(23, 23));
        jButtonLimpar.setMinimumSize(new java.awt.Dimension(23, 23));
        jButtonLimpar.setPreferredSize(new java.awt.Dimension(23, 23));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTudo(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Lucro");

        jComboBoxLucro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxLucro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.0", "1.5", "2.0", "2.5", "3.0" }));
        jComboBoxLucro.setToolTipText("Selecione o lucro desejado do produto");
        jComboBoxLucro.setPreferredSize(new java.awt.Dimension(200, 40));
        jComboBoxLucro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLucroItemStateChanged(evt);
            }
        });

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValor.setText("0");
        jTextFieldValor.setToolTipText("O valor é carregado automaticamente.");
        jTextFieldValor.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor");

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFormLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                                    .addComponent(jTextFieldValorAdicional)))
                            .addComponent(jTextFieldNome))
                        .addGap(6, 6, 6)))
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxLucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldValor))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Produtos");

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Valor", "Lucro", "Quantidade", "Tipo", "Valor p/ unid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(jTableProdutos);
        if (jTableProdutos.getColumnModel().getColumnCount() > 0) {
            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableProdutos.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTableProdutos.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTableProdutos.getColumnModel().getColumn(5).setPreferredWidth(5);
        }
        jTableProdutos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
                    if (jTableProdutos.getSelectedRow() != -1) {
                        // Quando selecionou uma row
                        jTableProdutosSelecionouUmaRow();
                    } else {
                        // Nenhuma linha está selecionada
                        jTableProdutosDesselecionouUmaRow();
                    }
                }
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonRemove.setBackground(new java.awt.Color(255, 204, 204));
        jButtonRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRemove.setText("Excluir");
        jButtonRemove.setToolTipText("Excluir uma ou mais receitas.");
        jButtonRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 204));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar uma receita já cadastrada.");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar(evt);
            }
        });

        jButtonEnviar1.setBackground(new java.awt.Color(204, 255, 204));
        jButtonEnviar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEnviar1.setText("Enviar");
        jButtonEnviar1.setToolTipText("Enviar uma nova receita");
        jButtonEnviar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviar(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviar1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout jPanelContainerReceitasLayout = new javax.swing.GroupLayout(jPanelContainerReceitas);
        jPanelContainerReceitas.setLayout(jPanelContainerReceitasLayout);
        jPanelContainerReceitasLayout.setHorizontalGroup(
            jPanelContainerReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        jPanelContainerReceitasLayout.setVerticalGroup(
            jPanelContainerReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelContainerReceitas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonNovoIngrediente.setBackground(new java.awt.Color(204, 255, 204));
        jButtonNovoIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNovoIngrediente.setText("Nova receita");
        jButtonNovoIngrediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovoIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoIngredienteActionPerformed(evt);
            }
        });

        jLabelIngredientesDaReceita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelIngredientesDaReceita.setText("Receitas do produto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIngredientesDaReceita, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNovoIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNovoIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIngredientesDaReceita)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<ReceitaDTO> receitasDTO = new ArrayList<>();

    private void carregarProdutos() {
        produtoController.carregarProdutosParaTabela(jTableProdutos);
    }

    private ArrayList<String> separarIdENome() {
        ArrayList<String> idsENomes = new ArrayList<>();
        for (ReceitaDTO receitaDTO : this.receitasDTO) {
            String IdENome = receitaDTO.getId() + " " + receitaDTO.getNome();
            idsENomes.add(IdENome);
        }
        return idsENomes;
    }

    private void inserirReceitasNoCombobox(ArrayList<String> IdENome, JComboBox jComboBox) {

        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) jComboBox.getModel();

        // Adicionando os entradaes no modelo do JComboBox
        for (String idENome : IdENome) {
            comboBoxModel.addElement(idENome);
        }
    }

    private Map<String, String> pegarReceitasEQuantidades() {

        Map<String, String> ReceitasEQuantidades = new HashMap<>();
        Component[] containers = jPanelContainerReceitas.getComponents();
        for (Component container : containers) {
            if (container instanceof JPanel) {
                // trabalhando no container
                String Receita = null;
                String quantidade = null;
                JPanel subPanel = (JPanel) container;
                Component[] subComponents = subPanel.getComponents();
                for (Component subComponent : subComponents) {
                    // trabalhando com os componentes dentro de um container
                    if (subComponent instanceof JTextField) {
                        JTextField textField = (JTextField) subComponent;
                        quantidade = textField.getText();
                    }
                    if (subComponent instanceof JComboBox) {
                        JComboBox comboBox = (JComboBox) subComponent;
                        Receita = comboBox.getSelectedItem().toString();
                    }
                }
                ReceitasEQuantidades.put(Receita, quantidade);
            }
        }
        return ReceitasEQuantidades;
    }

    private void SetarReceitasEQuantidades(Map<String, String> receitasEQuantidades) {
        Component[] containers = jPanelContainerReceitas.getComponents();
        int i = 0;
        for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
            String receita = entry.getKey();
            String quantidade = entry.getValue();
            if (containers[i] instanceof JPanel) {
                // trabalhando no container
                JPanel subPanel = (JPanel) containers[i];
                Component[] subComponents = subPanel.getComponents();
                for (Component subComponent : subComponents) {
                    // trabalhando com os componentes dentro de um container
                    if (subComponent instanceof JTextField) {
                        JTextField textField = (JTextField) subComponent;
                        textField.setText(quantidade);
                    } else if (subComponent instanceof JComboBox) {
                        JComboBox comboBox = (JComboBox) subComponent;
                        comboBox.setSelectedItem(receita);
                    }
                }
            }
            i++;
        }
    }

    private void adicionar() {
        IconFontSwing.register(FontAwesome.getIconFont());
        jPanelContainerReceitas.setLayout(new BoxLayout(jPanelContainerReceitas, BoxLayout.Y_AXIS));
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Ajuste de espaçamento horizontal e vertical  
        // criando e estilizando
        JComboBox comboBox = new JComboBox(new Object[]{"Selecione a receita",});
        comboBox.setPreferredSize(new Dimension(200, 40));
        comboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        JTextField textField = new JTextField("0");
        textField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        textField.setPreferredSize(new Dimension(102, 40));
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    jTextFieldValor.setText(calcularValor());

                }
            }
        });
        JButton button = new JButton("Remover");
        button.setIcon(IconFontSwing.buildIcon(Elusive.REMOVE_SIGN, 16, Color.black));
        button.setBackground(new java.awt.Color(255, 204, 204));

        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Função que deleta o container 
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Container buttonParent = button.getParent();
                Container parentOfButtonParent = button.getParent().getParent();
                // Remove o painel que contém o botão do seu componente pai
                parentOfButtonParent.remove(buttonParent);
                parentOfButtonParent.revalidate();
                parentOfButtonParent.repaint();
            }
        });

        // pegando as receitas e colocando no combobox
        ArrayList<String> IdENomeReceitas = separarIdENome();
        inserirReceitasNoCombobox(IdENomeReceitas, comboBox);

        //container.add(label);
        container.add(comboBox);
        container.add(textField);
        container.add(button);
        container.setPreferredSize(new Dimension(600, 50));
        container.setMaximumSize(new Dimension(Short.MAX_VALUE, 50)); // Define tamanho máximo
        jPanelContainerReceitas.add(container);
        jPanelContainerReceitas.revalidate();
        jPanelContainerReceitas.repaint();

    }

    private void limparContainer() {
        jPanelContainerReceitas.removeAll();
        jPanelContainerReceitas.revalidate();
        jPanelContainerReceitas.repaint();
    }

    private String calcularValor() {
        float valor = 0;
        float valorAdicional = 0;
        float multiplicador = Float.parseFloat(jComboBoxLucro.getSelectedItem().toString());

        Map<String, String> receitasEQuantidades = new HashMap<>();
        receitasEQuantidades = pegarReceitasEQuantidades();
        ResultadoValidacao resultado = receitaController.validarReceitasEQuantidades(receitasEQuantidades);

        if (resultado.isValido()) {
            for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
                int id = Integer.parseInt(Utils.pegarIdDaString(entry.getKey()));
                float quantidade = Float.parseFloat(entry.getValue());
                float valorMedio = 0;
                float quantidadeMedia = 0;
                for (ReceitaDTO receitaDTO : this.receitasDTO) {
                    if (id == receitaDTO.getId()) {
                        valorMedio = receitaDTO.getValor();
                        quantidadeMedia = receitaDTO.getQuantidade();
                    }
                }
                valor += quantidade * valorMedio / quantidadeMedia;
            }
        } else {
            JOptionPane.showMessageDialog(null, resultado.getMensagem());
        }

        // se nao tiver nada no field ele seta pra 0 
        if (jTextFieldValorAdicional.getText().isBlank()) {
            valorAdicional = 0;
        } else {
            try {
                String valorFormatado = Utils.formatarStringParaFloat(jTextFieldValorAdicional.getText());
                valorAdicional = Float.parseFloat(valorFormatado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um valor adicional valido");
            }
        }

        // pegando o valor adicional
        valor *= multiplicador;
        valor += valorAdicional;

        String valorFormatado = String.format("%.02f", valor);
        return valorFormatado;
    }

    private void resetarCampos() {
        Utils.limparCampos(new Object[]{jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo, jComboBoxLucro, jTextFieldValorAdicional});
        limparContainer();
        jTableProdutos.clearSelection();
    }

    private void atualizarLabelIngredientesDaReceita(String nomeReceita, JLabel label) {
        if (nomeReceita != null) {
            label.setText("Receitas de: " + nomeReceita);
        } else {
            label.setText("Receitas do Produto: ");
        }
    }

    private void jTableProdutosSelecionouUmaRow() {
        ArrayList<Integer> ids = Utils.pegarIdsSelecionadosDaTable(jTableProdutos);
        // só fazer se selecionou uma row
        if (ids.size() == 1) {
            Utils.limparCampos(new Object[]{jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo, jComboBoxLucro, jTextFieldValorAdicional});
            limparContainer();
            int idReceita = ids.get(0);
            // atualizando a label 
            ArrayList<String> nomeReceita = new ArrayList<>();
            nomeReceita = Utils.pegarStringsSelecionadasDaTable(jTableProdutos, 1);
            atualizarLabelIngredientesDaReceita(nomeReceita.get(0), jLabelIngredientesDaReceita);

            // passando o valores da tabela pros campos p/ preencher 
            Utils.tableParaCampos(new Object[]{null, jTextFieldNome, jTextFieldValor, jComboBoxLucro, jTextFieldQuantidade, jComboBoxTipo, null}, jTableProdutos);
            // reforçando as x n vai
            jTextFieldValor.setText(Utils.pegarStringsSelecionadasDaTable(jTableProdutos, 2).get(0));
            // adicionando os containers das receitas
            Map<String, String> receitasEQuantidades = produtoController.getReceitasEQuantidadesDoProduto(ids.get(0));
            // criando os containers
            for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
                adicionar();   
            }
            // settando os containers
            SetarReceitasEQuantidades(receitasEQuantidades);
            // calculando o valor adicional
            float valorTabela = Float.parseFloat(
                    Utils.formatarStringParaFloat(
                            jTextFieldValor.getText()));
            float valorCalculado = Float.parseFloat(
                    Utils.formatarStringParaFloat(
                            calcularValor())); 
            float valorAdicional = Math.abs(valorTabela - valorCalculado);
            String valorFormatado = String.format("%.02f", valorAdicional);
            jTextFieldValorAdicional.setText(String.valueOf(valorFormatado));
        }
    }

    private void jTableProdutosDesselecionouUmaRow() {
        limparContainer();
        atualizarLabelIngredientesDaReceita(null, jLabelIngredientesDaReceita);
        //calcularValor();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover
        ArrayList<Integer> ids = Utils.pegarIdsSelecionadosDaTable(jTableProdutos);
        int resposta;
        if (ids.size() == 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else if (ids.size() > 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover MAIS de um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
            return;
        }
        switch (resposta) {
            case JOptionPane.YES_OPTION -> {
                // fazendo com 1 primeiro
                if (produtoController.removerProdutos(ids) == true) {
                    JOptionPane.showMessageDialog(null, "Item Removido com sucesso ");
                    resetarCampos();
                    carregarProdutos();
                }
            }
        }
    }//GEN-LAST:event_remover

    private void alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar
        ArrayList<Integer> ids = Utils.pegarIdsSelecionadosDaTable(jTableProdutos);
        // Verificando se há apenas uma row selecionada
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar uma receita. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                int id = ids.get(0);
                String nome = jTextFieldNome.getText();
                String valor = calcularValor();
                String quantidade = jTextFieldQuantidade.getText();
                String tipo = jComboBoxTipo.getSelectedItem().toString();
                Float lucro = Float.valueOf(
                        jComboBoxLucro.getSelectedItem().toString());
                Map<String, String> receitasEQuantidades = pegarReceitasEQuantidades();

                ProdutoDTO produtoDTO = new ProdutoDTO(id, nome, valor, quantidade, tipo, lucro);

                if (produtoController.alterar2(produtoDTO, receitasEQuantidades)) {
                    JOptionPane.showMessageDialog(null, "Alteração feita!");
                    resetarCampos();
                    carregarProdutos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas uma receita para modificar!");
        }
    }//GEN-LAST:event_alterar

    private void enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar
        // pegando os valores da receita
        String nome = jTextFieldNome.getText();
        String valor = calcularValor();
        String quantidade = jTextFieldQuantidade.getText();
        String tipo = jComboBoxTipo.getSelectedItem().toString();
        Float lucro = Float.valueOf(
                jComboBoxLucro.getSelectedItem().toString());

        ProdutoDTO produtoDTO = new ProdutoDTO(nome, valor, quantidade, tipo, lucro);
        Map<String, String> receitasEQuantidades = pegarReceitasEQuantidades();

        boolean sucesso = produtoController.cadastrar2(produtoDTO, receitasEQuantidades);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");
            resetarCampos();
            carregarProdutos();
        }

    }//GEN-LAST:event_enviar

    private void jTextFieldValorAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorAdicionalKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldValor.setText(calcularValor());
        }
    }//GEN-LAST:event_jTextFieldValorAdicionalKeyPressed

    private void clearTudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTudo
        resetarCampos();
    }//GEN-LAST:event_clearTudo

    private void jButtonNovoIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoIngredienteActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_jButtonNovoIngredienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        carregarProdutos();
        this.receitasDTO = receitaController.carregarReceitasDTOs();
        IconFontSwing.register(Elusive.getIconFont());
        jButtonNovoIngrediente.setIcon(IconFontSwing.buildIcon(Elusive.PLUS_SIGN, 16, Color.black));
        jButtonLimpar.setIcon(IconFontSwing.buildIcon(Elusive.BROOM, 20, Color.black));
        jButtonRemove.setIcon(IconFontSwing.buildIcon(Elusive.TRASH, 16, Color.black));
        jButtonEnviar1.setIcon(IconFontSwing.buildIcon(Elusive.SHARE_ALT, 16, Color.black));
        jButtonAlterar.setIcon(IconFontSwing.buildIcon(Elusive.PENCIL, 16, Color.black));
        Float lucro = Float.valueOf(
                jComboBoxLucro.getSelectedItem().toString());
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyReleased
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldValor.setText(calcularValor());
        }
    }//GEN-LAST:event_jTextFieldQuantidadeKeyReleased

    private void jComboBoxLucroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLucroItemStateChanged
        jTextFieldValor.setText(calcularValor());
    }//GEN-LAST:event_jComboBoxLucroItemStateChanged

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
            java.util.logging.Logger.getLogger(JFrameProduto2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProduto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonEnviar1;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovoIngrediente;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<String> jComboBoxLucro;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelIngredientesDaReceita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelContainerReceitas;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorAdicional;
    // End of variables declaration//GEN-END:variables
}

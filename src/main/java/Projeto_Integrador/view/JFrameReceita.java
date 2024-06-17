/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Projeto_Integrador.view;

import Projeto_Integrador.utils.ViewUtils;
import Projeto_Integrador.controller.IngredienteController;
import Projeto_Integrador.controller.ReceitaController;
import Projeto_Integrador.model.DTO.IngredienteDTO;
import Projeto_Integrador.model.DTO.ReceitaDTO;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henri
 */
public class JFrameReceita extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private IngredienteController ingredienteController;
    private ReceitaController receitaController;

    public JFrameReceita() {
        this.ingredienteController = new IngredienteController();
        this.receitaController = new ReceitaController();
        initComponents();
        carregarIngredientes();
        carregarReceitas();
    }

    public JFrameReceita(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.receitaController = new ReceitaController();
        this.ingredienteController = new IngredienteController();

        initComponents();
        carregarIngredientes();
        carregarReceitas();
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
        jButtonRemove = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonEnviar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorAdicional = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIngredientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableReceitas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelQuantidades = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableIngredientesReceita = new javax.swing.JTable();
        jLabelIngredientesDaReceita = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECEITA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNome.setToolTipText("Insira o nome da receita.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor");

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValor.setText("0");
        jTextFieldValor.setToolTipText("O valor é carregado automaticamente.");
        jTextFieldValor.setEnabled(false);

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidade.setToolTipText("Insira o quanto a receita rende.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo");

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo", "Gramas", "Mililitros", "Unidade" }));
        jComboBoxTipo.setToolTipText("Selecione o tipo da receita");
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(200, 40));

        jButtonRemove.setBackground(new java.awt.Color(255, 204, 204));
        jButtonRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRemove.setText("Remover");
        jButtonRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 204));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar(evt);
            }
        });

        jButtonEnviar1.setBackground(new java.awt.Color(204, 255, 204));
        jButtonEnviar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEnviar1.setText("Enviar");
        jButtonEnviar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviar(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Cadastro");
        jLabel6.setToolTipText("Cadastre sua receita!");

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
                clearTudo(evt);
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
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jTextFieldValor)
                            .addComponent(jTextFieldValorAdicional)
                            .addComponent(jTextFieldQuantidade)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonRemove)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEnviar1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEnviar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRemove)
                        .addComponent(jButtonAlterar)))
                .addContainerGap())
        );

        jTableIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jTableIngredientes.setToolTipText("Selecione os ingredientes usados na receita");
        jTableIngredientes.getTableHeader().setReorderingAllowed(false);
        jTableIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableIngredientesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableIngredientes);
        if (jTableIngredientes.getColumnModel().getColumnCount() > 0) {
            jTableIngredientes.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Todos ingredientes");
        jLabel7.setToolTipText("Selecione os ingredientes usados na receita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );

        jTableReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jTableReceitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableReceitas);
        if (jTableReceitas.getColumnModel().getColumnCount() > 0) {
            jTableReceitas.getColumnModel().getColumn(1).setPreferredWidth(120);
        }
        jTableReceitas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
                    if (jTableReceitas.getSelectedRow() != -1) {
                        // Quando selecionou uma row
                        jTableReceitaSelecionouUmaRow();
                    } else {
                        // Nenhuma linha está selecionada
                        jTableReceitaDesselecionouUmaRow();
                    }
                }
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Todas receitas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelQuantidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelQuantidadesFocusLost(evt);
            }
        });

        javax.swing.GroupLayout panelQuantidadesLayout = new javax.swing.GroupLayout(panelQuantidades);
        panelQuantidades.setLayout(panelQuantidadesLayout);
        panelQuantidadesLayout.setHorizontalGroup(
            panelQuantidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        panelQuantidadesLayout.setVerticalGroup(
            panelQuantidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelQuantidades);
        panelQuantidades = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        jTableIngredientesReceita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Quantidade", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableIngredientesReceita.setEnabled(false);
        jTableIngredientesReceita.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(jTableIngredientesReceita);

        jLabelIngredientesDaReceita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelIngredientesDaReceita.setText("Ingredientes da receita");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIngredientesDaReceita))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelIngredientesDaReceita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Quantidade dos ingredientes");
        jLabel9.setToolTipText("Insira as quantidades de ingrediente da receita!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    ViewUtils utils = new ViewUtils();
    private Map<String, JTextField> quantidadeFieldsMap = new HashMap<>();

    private void carregarIngredientes() {
        ingredienteController.carregarIngredientesParaTabela(jTableIngredientes);
    }

    private void carregarReceitas() {

        receitaController.carregarReceitaParaTabela(jTableReceitas);
    }

    private void calcularValor() {
        float valor = 0;
        float valorAdicional = 0;

        // pegando os ingredientes selecionados
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableIngredientes);
        if (ids.isEmpty()) {
            jTextFieldValor.setText(String.valueOf(valor));
        }

        List<IngredienteDTO> ingredientesDTO = ingredienteController.idsParaDTOS(ids);
        ArrayList<Float> quantidadesIngredientes = new ArrayList<>();

        // pegando as quantidades dos ingredientes usadas na receita
        for (Integer id : ids) {
            quantidadesIngredientes.add(pegarQuantidade(id));
        }

        // pegando o valor de cada pela regra de 3
        for (int i = 0; i < ingredientesDTO.size(); i++) {
            valor += quantidadesIngredientes.get(i) * ingredientesDTO.get(i).getValor() / ingredientesDTO.get(i).getQuantidade();
        }

        // se nao tiver nada no field ele seta pra 0 
        if (jTextFieldValorAdicional.getText().isBlank()) {
            valorAdicional = 0;
        } else {
            valorAdicional = Float.parseFloat(jTextFieldValorAdicional.getText());
        }

        // pegando o valor adicional
        valor += valorAdicional;
        String valorFormatado = String.format("%.02f", valor);
        jTextFieldValor.setText(valorFormatado);
    }

    private void resetarCampos() {
        utils.limparCampos(new Object[]{jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo, jTextFieldValorAdicional});
        jTableIngredientes.clearSelection();
        jTableReceitas.clearSelection();
        DefaultTableModel model = (DefaultTableModel) jTableIngredientesReceita.getModel();
        model.setRowCount(0);
        carregarReceitas();
        calcularValor();
        gerarQuantidadeFields();
    }

    private void atualizarLabelIngredientesDaReceita(String nomeReceita, JLabel label) {
        if (nomeReceita != null) {
            label.setText("Ingredientes de: " + nomeReceita);
        } else {
            label.setText("Ingredientes da Receita: ");
        }
    }

    private void gerarQuantidadeFields() {
        // pegando os ids dos ingredientes selecionados
        quantidadeFieldsMap.clear();
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableIngredientes);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        List<IngredienteDTO> ingredientes = new ArrayList<>();

        // pegando os ingredientes pelo id
        ingredientes = ingredienteController.idsParaDTOS(ids);

        for (IngredienteDTO ingrediente : ingredientes) {
            // label tem o nome do ingrediente
            JLabel label = new JLabel(ingrediente.getId() + " - " + ingrediente.getNome() + ":");
            JTextField field = new JTextField();
            //
            field.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                        calcularValor();
                    }
                }
            });
            //
            field.setMaximumSize(jTextFieldNome.getSize());
            panel.add(label);
            panel.add(field);
            // a key é o id do ingrediente
            quantidadeFieldsMap.put(String.valueOf(ingrediente.getId()), field);
        }

        jScrollPane3.setViewportView(panel);
        this.add(jScrollPane3);
        setVisible(true);
    }

    private void quantidadeTableParaQuantidadeFields() {
        Map<String, String> idQuantidades = new HashMap<>();
        ArrayList<String> quantidades = utils.pegarStringsDaTable(jTableIngredientesReceita, 2);
        ArrayList<String> ids2 = utils.pegarStringsDaTable(jTableIngredientesReceita, 0);

        for (int j = 0; j < ids2.size(); j++) {
            idQuantidades.put(ids2.get(j), quantidades.get(j));
        }
        // setando os valores dentro dos fields
        for (Map.Entry<String, String> entry : idQuantidades.entrySet()) {
            String idIngrediente = entry.getKey();
            String qtd = entry.getValue();
            for (Map.Entry<String, JTextField> entryQuantidadeFieldsMap : quantidadeFieldsMap.entrySet()) {
                String idField = entryQuantidadeFieldsMap.getKey();
                JTextField field = entryQuantidadeFieldsMap.getValue();
                if (idField.equals(idIngrediente)) {
                    field.setText(qtd);
                }
            }
        }
    }

    public Float pegarQuantidade(int id) {
        try {
            JTextField field = quantidadeFieldsMap.get(String.valueOf(id));
            if (field != null) {
                return Float.valueOf(field.getText());
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira as quantidades de ingrediente presentes na receita!");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void jTableReceitaSelecionouUmaRow() {
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
        // só fazer se selecionou uma row
        if (ids.size() == 1) {
            int idReceita = ids.get(0);
            // atualizando a label 
            ArrayList<String> nomeReceita = new ArrayList<>();
            nomeReceita = utils.pegarStringsSelecionadasDaTable(jTableReceitas, 1);
            atualizarLabelIngredientesDaReceita(nomeReceita.get(0), jLabelIngredientesDaReceita);

            jTableIngredientes.clearSelection();
            // passando o valores da tabela pros campos p/ preencher 
            utils.tableParaCampos(new Object[]{null, jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo}, jTableReceitas);
            receitaController.SelecionarIngredientesDaReceitaNaTable(idReceita, jTableIngredientes);
            // gerando os campos pra colocar a quantidade
            gerarQuantidadeFields();

            receitaController.ingredientesDaReceitaParaTable(jTableIngredientesReceita, ids.get(0));
            quantidadeTableParaQuantidadeFields();
            // calculando o valor
            calcularValor();
        }
    }

    private void jTableReceitaDesselecionouUmaRow() {
        atualizarLabelIngredientesDaReceita(null, jLabelIngredientesDaReceita);
        calcularValor();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover

        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
        int resposta;
        if (ids.size() == 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover uma receita. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else if (ids.size() > 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover MAIS de uma receita. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma receita para remover!");
            return;
        }
        switch (resposta) {
            case JOptionPane.YES_OPTION -> {
                // fazendo com 1 primeiro
                if (receitaController.removerReceitas(ids) == true) {
                    JOptionPane.showMessageDialog(null, "Item Removido com sucesso ");
                    resetarCampos();
                }
            }
        }
    }//GEN-LAST:event_remover

    private void alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
        // Verificando se há apenas uma row selecionada
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar uma receita. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            calcularValor();
            if (resposta == JOptionPane.YES_OPTION) {
                int idReceita = ids.get(0);
                String nome = jTextFieldNome.getText();
                String valor = jTextFieldValor.getText();
                String quantidade = jTextFieldQuantidade.getText();
                String tipo = jComboBoxTipo.getSelectedItem().toString();
                ArrayList<Integer> idIngredientes = utils.pegarIdsSelecionadosDaTable(jTableIngredientes);
                ArrayList<Float> quantidadesIngredientes = new ArrayList<>();

                for (Integer idIngrediente : idIngredientes) {
                    Float value = pegarQuantidade(idIngrediente);
                    if (value != null) {
                        quantidadesIngredientes.add(value);
                    }
                }
                ReceitaDTO receitaDTO = new ReceitaDTO(idReceita, nome, valor, quantidade, tipo);

                if (receitaController.alterar(receitaDTO, idIngredientes, quantidadesIngredientes)) {
                    resetarCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas uma receita para modificar!");
        }
    }//GEN-LAST:event_alterar


    private void enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar
        try {
            calcularValor();
            // pegando os valores da receita
            String nome = jTextFieldNome.getText();
            String valor = jTextFieldValor.getText();
            String quantidade = jTextFieldQuantidade.getText();
            String tipo = jComboBoxTipo.getSelectedItem().toString();

            ReceitaDTO receitaDTO = new ReceitaDTO(nome, valor, quantidade, tipo);
            ArrayList<Integer> idIngredientes = utils.pegarIdsSelecionadosDaTable(jTableIngredientes);
            ArrayList<Float> quantidadesIngredientes = new ArrayList<>();

            for (Integer idIngrediente : idIngredientes) {
                Float value = pegarQuantidade(idIngrediente);
                if (value != null) {
                    quantidadesIngredientes.add(value);
                }
            }

            boolean sucesso = receitaController.cadastrar(receitaDTO, idIngredientes, quantidadesIngredientes);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");
                resetarCampos();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_enviar

    private void jTextFieldValorAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorAdicionalKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            calcularValor();
        }
    }//GEN-LAST:event_jTextFieldValorAdicionalKeyPressed

    private void clearTudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTudo
        resetarCampos();
    }//GEN-LAST:event_clearTudo

    private void jTableIngredientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIngredientesMouseReleased
        gerarQuantidadeFields();
    }//GEN-LAST:event_jTableIngredientesMouseReleased

    private void panelQuantidadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelQuantidadesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panelQuantidadesFocusLost

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
            java.util.logging.Logger.getLogger(JFrameReceita.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameReceita.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameReceita.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameReceita.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameReceita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonEnviar1;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIngredientesDaReceita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableIngredientes;
    private javax.swing.JTable jTableIngredientesReceita;
    private javax.swing.JTable jTableReceitas;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorAdicional;
    private javax.swing.JPanel panelQuantidades;
    // End of variables declaration//GEN-END:variables
}

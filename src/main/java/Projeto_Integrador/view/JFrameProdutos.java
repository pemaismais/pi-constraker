/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Projeto_Integrador.view;

import Projeto_Integrador.controller.ProdutoController;
import Projeto_Integrador.controller.ReceitaController;
import Projeto_Integrador.model.DTO.ProdutoDTO;
import Projeto_Integrador.model.DTO.ReceitaDTO;
import Projeto_Integrador.utils.ViewUtils;
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
public class JFrameProdutos extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private ReceitaController receitaController;
    private ProdutoController produtoController;
    private ViewUtils utils;

    public JFrameProdutos() {
        this.receitaController = new ReceitaController();
        this.produtoController = new ProdutoController();
        this.utils = new ViewUtils();
        initComponents();
        carregarReceitas();
        carregarProdutos();
    }

    public JFrameProdutos(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.receitaController = new ReceitaController();
        this.produtoController = new ProdutoController();
        this.utils = new ViewUtils();
        initComponents();
        carregarReceitas();
        carregarProdutos();
    }

    private Map<String, JTextField> quantidadeFieldsMap = new HashMap<>();

    private void carregarReceitas() {
        receitaController.carregarReceitaParaTabela(jTableReceitas);
    }

    private void carregarProdutos() {
        produtoController.carregarProdutosParaTabela(jTableProdutos);
    }

    private void calcularValor() {
        float valor = 0;
        float valorAdicional = 0;
        float multiplicador = Float.parseFloat(jComboBoxTipo1.getSelectedItem().toString());

        // pegando as receitas selecionados
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
        if (ids.isEmpty()) {
            jTextFieldValor.setText(String.valueOf(valor));
        }

        List<ReceitaDTO> receitasDTO = receitaController.idsParaDTOS(ids);
        ArrayList<Float> quantidadesReceitas = new ArrayList<>();

        if (receitasDTO != null) {
            // pegando as quantidades dos ingredientes usadas na receita
            for (Integer id : ids) {
                quantidadesReceitas.add(pegarQuantidade(id));
            }

            // pegando o valor de cada pela regra de 3
            for (int i = 0; i < receitasDTO.size(); i++) {
                valor += quantidadesReceitas.get(i) * receitasDTO.get(i).getValor() / receitasDTO.get(i).getQuantidade();
            }

            // se nao tiver nada no field ele seta pra 0 
            if (jTextFieldValorAdicional.getText().isBlank()) {
                valorAdicional = 0;
            } else {
                valorAdicional = Float.parseFloat(jTextFieldValorAdicional.getText());
            }

            // pegando o valor adicional e multiplicando
            valor += valorAdicional;
            valor *= multiplicador;
            String valorFormatado = String.format("%.02f", valor);
            jTextFieldValor.setText(valorFormatado);
        }
    }

    private void resetarCampos() {
        utils.limparCampos(new Object[]{jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo, jTextFieldValorAdicional, jComboBoxTipo1});
        jTableReceitas.clearSelection();
        jTableProdutos.clearSelection();
        DefaultTableModel model = (DefaultTableModel) jTableReceitasDoProduto.getModel();
        model.setRowCount(0);
        carregarProdutos();
        calcularValor();
        gerarQuantidadeFields();

    }

    private void atualizarLabelReceitasDoProduto(String nomeProduto, JLabel label) {
        if (nomeProduto != null) {
            label.setText("Receitas do produto: " + nomeProduto);
        } else {
            label.setText("Receitas do produto selecionado:");
        }
    }

    private void gerarQuantidadeFields() {
        // pegando os ids das receitas selecionados
        quantidadeFieldsMap.clear();
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableReceitas);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        List<ReceitaDTO> receitas = new ArrayList<>();

        receitas = receitaController.idsParaDTOS(ids);

        for (ReceitaDTO receita : receitas) {
            // label tem o nome do ingrediente
            JLabel label = new JLabel(receita.getId() + " - " + receita.getNome() + ":");
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
            quantidadeFieldsMap.put(String.valueOf(receita.getId()), field);
        }

        // Adicionando o JPanel ao JScrollPane
        jScrollPane3.setViewportView(panel);
        this.add(jScrollPane3);
        // Adicionando o JScrollPane ao JFrame
        setVisible(true);
    }

    private void quantidadeTableParaQuantidadeFields() {
        Map<String, String> idQuantidades = new HashMap<>();

        ArrayList<String> quantidades = utils.pegarStringsDaTable(jTableReceitasDoProduto, 2);
        ArrayList<String> ids = utils.pegarStringsDaTable(jTableReceitasDoProduto, 0);

        for (int j = 0; j < ids.size(); j++) {
            idQuantidades.put(ids.get(j), quantidades.get(j));
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
            JOptionPane.showMessageDialog(null, "Insira as quantidades das receitas presentes no produto!!");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void jTableProdutosSelecionouUmaRow() {
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableProdutos);
        // só fazer se selecionou uma row
        if (ids.size() == 1) {
            // atualizando a label 
            int idProduto = ids.get(0);
            ArrayList<String> nomeProduto = new ArrayList<>();
            nomeProduto = utils.pegarStringsSelecionadasDaTable(jTableProdutos, 1);
            atualizarLabelReceitasDoProduto(nomeProduto.get(0), jLabel9);

            jTableReceitas.clearSelection();
            // passando o valores da tabela pros campos p/ preencher e selecionando as receitas
            utils.tableParaCampos(new Object[]{null, jTextFieldNome, jTextFieldValor, jTextFieldQuantidade, jComboBoxTipo}, jTableProdutos);
            produtoController.SelecionarReceitasDoProdutoNaTable(idProduto, jTableReceitas);
            // gerando os campos pra colocar a quantidade
            gerarQuantidadeFields();

            produtoController.receitasDoProdutoParaTable(jTableReceitasDoProduto, idProduto);
            quantidadeTableParaQuantidadeFields();
            calcularValor();
        }
    }

    private void jTableProdutosDesselecionouUmaRow() {
        // resetando a label
        atualizarLabelReceitasDoProduto(null, jLabel9);
        calcularValor();
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
        jComboBoxTipo1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanelTables = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        label = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableReceitas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReceitasDoProduto = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelQuantidades = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUTOS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNome.setToolTipText("Insira o nome do produto.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor");

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValor.setText("0");
        jTextFieldValor.setToolTipText("O valor é carregado automaticamente.");
        jTextFieldValor.setEnabled(false);

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidade.setToolTipText("Insira o quanto o produto rende.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo");

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo", "Unidade" }));
        jComboBoxTipo.setToolTipText("Selecione o tipo do produto.");
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
                clear(evt);
            }
        });

        jComboBoxTipo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.5", "2", "2.5", "3" }));
        jComboBoxTipo1.setToolTipText("Selecione o lucro desejado do produto");
        jComboBoxTipo1.setPreferredSize(new java.awt.Dimension(200, 40));
        jComboBoxTipo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipo1ItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Lucro");

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldValor)
                    .addComponent(jTextFieldValorAdicional)
                    .addComponent(jTextFieldQuantidade)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonRemove)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar1)
                        .addGap(12, 12, 12))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 123, Short.MAX_VALUE))
                            .addComponent(jComboBoxTipo1, 0, 1, Short.MAX_VALUE))))
                .addContainerGap())
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
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonEnviar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Valor", "Quantidade", "Tipo", "Valor p/ unid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(jTableProdutos);
        if (jTableProdutos.getColumnModel().getColumnCount() > 0) {
            jTableProdutos.getColumnModel().getColumn(0).setMinWidth(35);
            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTableProdutos.getColumnModel().getColumn(2).setMinWidth(40);
            jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTableProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableProdutos.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTableProdutos.getColumnModel().getColumn(5).setPreferredWidth(70);
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

        label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label.setText("Todos produtos");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
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
        jTableReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableReceitasMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableReceitas);
        if (jTableReceitas.getColumnModel().getColumnCount() > 0) {
            jTableReceitas.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Todas receitas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)))
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

        jTableReceitasDoProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableReceitasDoProduto.setToolTipText("Selecione os ingredientes usados na receita");
        jTableReceitasDoProduto.setEnabled(false);
        jTableReceitasDoProduto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableReceitasDoProduto);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Receitas do produto selecionado");
        jLabel9.setToolTipText("Selecione os ingredientes usados na receita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(523, 523, 523))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablesLayout.createSequentialGroup()
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablesLayout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)))))
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablesLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Quantidade dos ingredientes");
        jLabel11.setToolTipText("Insira as quantidades de ingrediente da receita!");

        javax.swing.GroupLayout panelQuantidadesLayout = new javax.swing.GroupLayout(panelQuantidades);
        panelQuantidades.setLayout(panelQuantidadesLayout);
        panelQuantidadesLayout.setHorizontalGroup(
            panelQuantidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        panelQuantidadesLayout.setVerticalGroup(
            panelQuantidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelQuantidades);
        panelQuantidades = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableProdutos);
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
                }
            }
        }
    }//GEN-LAST:event_remover

    private void alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar
        ArrayList<Integer> ids = utils.pegarIdsSelecionadosDaTable(jTableProdutos);
        // Verificando se há apenas uma row selecionada
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            calcularValor();
            if (resposta == JOptionPane.YES_OPTION) {
                int idProduto = ids.get(0);
                String nome = jTextFieldNome.getText();
                String valor = jTextFieldValor.getText();
                String quantidade = jTextFieldQuantidade.getText();
                String tipo = jComboBoxTipo.getSelectedItem().toString();
                ArrayList<Integer> idReceitas = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
                ArrayList<Float> quantidadesReceitas = new ArrayList<>();

                for (Integer id : idReceitas) {
                    Float value = pegarQuantidade(id);
                    if (value != null) {
                        quantidadesReceitas.add(value);
                    }
                }

                ProdutoDTO produtoDTO = new ProdutoDTO(idProduto, nome, valor, quantidade, tipo);

                if (produtoController.alterar(produtoDTO, idReceitas, quantidadesReceitas)) {
                    resetarCampos();

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas um produto para modificar!");
        }
    }//GEN-LAST:event_alterar

    private void enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar
        calcularValor();
        // pegando os valores da receita
        String nome = jTextFieldNome.getText();
        String valor = jTextFieldValor.getText();
        String quantidade = jTextFieldQuantidade.getText();
        String tipo = jComboBoxTipo.getSelectedItem().toString();
        ProdutoDTO produtoDTO = new ProdutoDTO(nome, valor, quantidade, tipo);
        // utils select by id podeira dar throw
        ArrayList<Integer> idReceitas = utils.pegarIdsSelecionadosDaTable(jTableReceitas);
        ArrayList<Float> quantidadesReceitas = new ArrayList<>();

        for (Integer idReceita : idReceitas) {
            Float value = pegarQuantidade(idReceita);
            if (value != null) {
                quantidadesReceitas.add(value);
            }
        }

        boolean sucesso = produtoController.cadastrar(produtoDTO, idReceitas, quantidadesReceitas);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");
            resetarCampos();
        }
    }//GEN-LAST:event_enviar

    private void jTextFieldValorAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorAdicionalKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            calcularValor();
        }
    }//GEN-LAST:event_jTextFieldValorAdicionalKeyPressed

    private void clear(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear
        resetarCampos();
    }//GEN-LAST:event_clear

    private void jTableReceitasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReceitasMouseReleased
        gerarQuantidadeFields();
    }//GEN-LAST:event_jTableReceitasMouseReleased

    private void jComboBoxTipo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipo1ItemStateChanged
        calcularValor();
    }//GEN-LAST:event_jComboBoxTipo1ItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(JFrameProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonEnviar1;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JComboBox<String> jComboBoxTipo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTable jTableReceitas;
    private javax.swing.JTable jTableReceitasDoProduto;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorAdicional;
    private javax.swing.JLabel label;
    private javax.swing.JPanel panelQuantidades;
    // End of variables declaration//GEN-END:variables
}

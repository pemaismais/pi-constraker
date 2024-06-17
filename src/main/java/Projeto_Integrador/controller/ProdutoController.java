/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.controller;

import Projeto_Integrador.dao.ProdutoDAO;
import Projeto_Integrador.dao.ReceitaDAO;
import Projeto_Integrador.model.DTO.ProdutoDTO;
import Projeto_Integrador.model.Produto;
import Projeto_Integrador.model.ProdutoReceita;
import Projeto_Integrador.model.Receita;
import Projeto_Integrador.utils.ResultadoValidacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henri
 */
public class ProdutoController {

    private ReceitaDAO receitaDAO;
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.receitaDAO = new ReceitaDAO();
        this.produtoDAO = new ProdutoDAO();
    }

    public ResultadoValidacao validarReceita(ProdutoDTO produto) {
        ResultadoValidacao resultado = new ResultadoValidacao(); // Cria um objeto para armazenar o resultado da validação
        // Verifica se o nome está vazio
        if (produto.getNome().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Nome do produto não pode estar vazio.");
            return resultado;
        }
        if (produto.getValor().contains(",")) {
            produto.setValor(produto.getValor().replace(",", "."));
        }
        // Verifica se o valor é um número válido
        try {
            float valorFloat = Float.parseFloat(produto.getValor());
            if (valorFloat <= 0) {
                resultado.setValido(false);
                resultado.setMensagem("Valor do preço deve ser um número positivo.");
                return resultado;
            }
        } catch (NumberFormatException e) {
            resultado.setValido(false);
            resultado.setMensagem("Valor do preço deve ser um número válido.");
            return resultado;
        }
        // Verifica se a quantidade é um número válido
        try {
            float quantidadeFloat = Float.parseFloat(produto.getQuantidade());
            if (quantidadeFloat <= 0) {
                resultado.setValido(false);
                resultado.setMensagem("Valor da quantidade deve ser um número positivo.");
                return resultado;
            }
        } catch (NumberFormatException e) {
            resultado.setValido(false);
            resultado.setMensagem("Valor da quantidade deve ser um número válido.");
            return resultado;
        }

        // Verifica se o tipo foi selecionado
        if ("Selecione um tipo".equals(produto.getTipo())) {
            resultado.setValido(false);
            resultado.setMensagem("Selecione um tipo.");
            return resultado;
        }

        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public void carregarProdutosParaTabela(JTable table) {
        try {
            //  selecionando todos items da table na db
            List<Produto> produtos = produtoDAO.selectAll();
            if (produtos != null) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                for (Produto produto : produtos) {
                    String valor = String.format("%.02f", produto.getValor());
                    String valorPorQuantidade = String.format("%.02f", produto.getValor() / produto.getQuantidade());
                    model.addRow(new Object[]{produto.getId(), produto.getNome(), valor, produto.getQuantidade(), produto.getTipo(), valorPorQuantidade});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean cadastrar(ProdutoDTO produtoDTO, ArrayList<Integer> idReceitas, ArrayList<Float> quantidadeReceitas) {
        try {
            ResultadoValidacao resultado = validarReceita(produtoDTO);
            if (idReceitas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione as receitas do produto!");
                return false;
            }

            if (resultado.isValido()) {
                ArrayList<Receita> ReceitasSelecionadas = new ArrayList<>();
                List<ProdutoReceita> receitasComQtd = new ArrayList<>();
                float valor = Float.parseFloat(produtoDTO.getValor());
                float quantidade = Float.parseFloat(produtoDTO.getQuantidade());

                Produto produto = new Produto(produtoDTO.getNome(), valor, quantidade, produtoDTO.getTipo());

                // adicionando as receitas  no arraylist pelo ID
                for (Integer id : idReceitas) {
                    Receita receita = receitaDAO.selectById(id);
                    ReceitasSelecionadas.add(receita);
                }

                // juntando os ingredientes com a quantidade e colocando no array
                for (int i = 0; i < ReceitasSelecionadas.size(); i++) {
                    ProdutoReceita ReceitaComQtd = new ProdutoReceita();
                    float quantidadeReceita = quantidadeReceitas.get(i);

                    ReceitaComQtd.setQuantidade(quantidadeReceita);
                    ReceitaComQtd.setReceita(ReceitasSelecionadas.get(i));
                    ReceitaComQtd.setProduto(produto);

                    receitasComQtd.add(ReceitaComQtd);
                }
                produto.setReceitas(receitasComQtd);
                produtoDAO.cadastrarProduto(produto);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean alterar(ProdutoDTO novoProdutoDTO, ArrayList<Integer> idReceitas, ArrayList<Float> quantidadesReceitas) {
        try {
            ResultadoValidacao resultado = validarReceita(novoProdutoDTO);
            // vendo se selecionou algum ingrediente p/ receita
            if (idReceitas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione os ingredientes da receita");
                return false;
            }
            if (resultado.isValido() == false) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
            // Validando se colocou a quantidade para todos os ingredientes
            for (Integer idReceita : idReceitas) {
                if (idReceita == null || idReceita == 0) {
                    String IngredienteNome = receitaDAO.selectById(idReceitas.get(idReceita)).getNome();
                    JOptionPane.showMessageDialog(null, "Insira a quantidade do ingrediente: " + IngredienteNome);
                    return false;
                }
            }

            // transformando as strings
            ArrayList<Receita> receitasSelecionadas = new ArrayList<>();
            List<ProdutoReceita> receitasComQuantidade = new ArrayList<>();

            float valor = Float.parseFloat(novoProdutoDTO.getValor());
            float quantidade = Float.parseFloat(novoProdutoDTO.getQuantidade());
            Produto novoProduto = produtoDAO.selectById(novoProdutoDTO.getId());
            novoProduto.setNome(novoProdutoDTO.getNome());
            novoProduto.setValor(valor);
            novoProduto.setQuantidade(quantidade);
            novoProduto.setTipo(novoProdutoDTO.getTipo());
            produtoDAO.removerTodasReceitas(novoProdutoDTO.getId());

            // juntando os ingredientes com a quantidade e colocando no array
            for (Integer id : idReceitas) {
                Receita receita = receitaDAO.selectById(id);
                receitasSelecionadas.add(receita);
            }

            // juntando os ingredientes com a quantidade e colocando no array
            for (int i = 0; i < receitasSelecionadas.size(); i++) {
                ProdutoReceita receitaComQtd = new ProdutoReceita();
                float quantidadeIngrediente = quantidadesReceitas.get(i);

                receitaComQtd.setQuantidade(quantidadeIngrediente);
                receitaComQtd.setReceita(receitasSelecionadas.get(i));
                receitaComQtd.setProduto(novoProduto);

                receitasComQuantidade.add(receitaComQtd);
            }
            novoProduto.setReceitas(receitasComQuantidade);

            if (!produtoDAO.alterarProduto(novoProduto)) {
                JOptionPane.showMessageDialog(null, " Erro ao alterar Receita no DB ");
                return false;
            } else {
                JOptionPane.showMessageDialog(null, " Receita alterada com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean removerProdutos(ArrayList<Integer> ids) {
        boolean sucesso = true;
        try {
            for (Integer id : ids) {
                produtoDAO.removerProduto(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return sucesso;
    }

    public void carregarReceitasDoProdutoParaTabela(JTable table, int idProduto) {
        try {
            Produto produto = produtoDAO.selectById(idProduto);

            List<ProdutoReceita> receitas = produto.getReceitas();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0);

            for (ProdutoReceita receita : receitas) {
                Object[] dados = new Object[]{receita.getReceita().getId(), receita.getReceita().getNome(), receita.getReceita()};
                tableModel.addRow(dados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void SelecionarReceitasDoProdutoNaTable(int idProduto, JTable tableReceita) {
        try {
            Produto produto = produtoDAO.selectById(idProduto);
            List<ProdutoReceita> receitas = produto.getReceitas();
            List<Integer> receitasIds = new ArrayList<>();

            // pegando as receitas pelo id
            for (ProdutoReceita produtoReceita : receitas) {
                receitasIds.add(produtoReceita.getReceita().getId());
            }
            // Selecionando as Ingredientes da receita que tao na table            
            for (int i = 0; i < tableReceita.getRowCount(); i++) {
                int id = (int) tableReceita.getValueAt(i, 0);
                if (receitasIds.contains(id)) {
                    tableReceita.addRowSelectionInterval(i, i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void receitasDoProdutoParaTable(JTable jTableReceitasProduto, int idProduto) {
        try {
            Produto produto = produtoDAO.selectById(idProduto);

            List<ProdutoReceita> receitas = produto.getReceitas();
            DefaultTableModel tableModel = (DefaultTableModel) jTableReceitasProduto.getModel();
            tableModel.setRowCount(0);

            for (ProdutoReceita receita : receitas) {
                Object[] dados = new Object[]{receita.getReceita().getId(), receita.getReceita().getNome(), receita.getQuantidade(), receita.getReceita().getTipo()};
                tableModel.addRow(dados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}

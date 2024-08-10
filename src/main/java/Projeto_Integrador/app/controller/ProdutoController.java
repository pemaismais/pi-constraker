/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.app.controller;

import Projeto_Integrador.app.dao.ProdutoDAO;
import Projeto_Integrador.app.dao.ReceitaDAO;
import Projeto_Integrador.app.model.DTO.ProdutoDTO;
import Projeto_Integrador.app.model.Produto;
import Projeto_Integrador.app.model.ProdutoReceita;
import Projeto_Integrador.app.model.Receita;
import Projeto_Integrador.app.utils.ResultadoValidacao;
import Projeto_Integrador.app.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                    model.addRow(new Object[]{produto.getId(), produto.getNome(), valor, produto.getLucro(), produto.getQuantidade(), produto.getTipo(), valorPorQuantidade});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean cadastrar2(ProdutoDTO produtoDTO, Map<String, String> receitasEQuantidades) {
        try {
            ResultadoValidacao resultado = validarReceita(produtoDTO);
            ResultadoValidacao resultadoReceitas = ReceitaController.validarReceitasEQuantidades(receitasEQuantidades);

            if (resultado.isValido() && resultadoReceitas.isValido()) {
                List<ProdutoReceita> items = new ArrayList<>();
                float valor = Float.parseFloat(produtoDTO.getValor());
                float quantidade = Float.parseFloat(produtoDTO.getQuantidade());
                Produto produto = new Produto(produtoDTO.getNome(), valor, quantidade, produtoDTO.getTipo(), produtoDTO.getLucro());
                //
                for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();

                    int id = Integer.parseInt(Utils.pegarIdDaString(key));
                    Receita receita = receitaDAO.selectById(id);

                    ProdutoReceita itemReceita = new ProdutoReceita();
                    float quantidadeItem = Float.parseFloat(val);
                    itemReceita.setQuantidade(quantidadeItem);
                    itemReceita.setProduto(produto);
                    itemReceita.setReceita(receita);
                    items.add(itemReceita);
                }
                //
                produto.setReceitas(items);
                produtoDAO.cadastrarProduto(produto);
                return true;
            } else if (!resultado.isValido()) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultadoReceitas.getMensagem());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean alterar2(ProdutoDTO novoProdutoDTO, Map<String, String> receitasEQuantidades) {
        try {
            ResultadoValidacao resultado = validarReceita(novoProdutoDTO);
            ResultadoValidacao resultadoReceitas = ReceitaController.validarReceitasEQuantidades(receitasEQuantidades);
            if (resultado.isValido() && resultadoReceitas.isValido()) {

                // transformando as strings
                List<ProdutoReceita> items = new ArrayList<>();
                float valor = Float.parseFloat(novoProdutoDTO.getValor());
                float quantidade = Float.parseFloat(novoProdutoDTO.getQuantidade());

                Produto produto = produtoDAO.selectById(novoProdutoDTO.getId());
                produto.setNome(novoProdutoDTO.getNome());
                produto.setValor(valor);
                produto.setQuantidade(quantidade);
                produto.setTipo(novoProdutoDTO.getTipo());
                produto.setLucro(novoProdutoDTO.getLucro());
                produtoDAO.removerTodasReceitas(novoProdutoDTO.getId());

                // inserindo os produtos dentro da list
                for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();

                    int id = Integer.parseInt(Utils.pegarIdDaString(key));
                    Receita receita = receitaDAO.selectById(id);

                    ProdutoReceita itemReceita = new ProdutoReceita();
                    float quantidadeItem = Float.parseFloat(val);
                    itemReceita.setQuantidade(quantidadeItem);
                    itemReceita.setProduto(produto);
                    itemReceita.setReceita(receita);
                    items.add(itemReceita);
                }
                //
                produto.setReceitas(items);
                produtoDAO.alterarProduto(produto);
                return true;
            } else if (!resultado.isValido()) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultadoReceitas.getMensagem());
                return false;
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

    public Map<String, String> getReceitasEQuantidadesDoProduto(int id) {
        try {
            Produto produto = produtoDAO.selectById(id);
            return produto.getReceitasEQuantidades();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

}

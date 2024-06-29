/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.controller;

import Projeto_Integrador.dao.IngredienteDAO;
import Projeto_Integrador.dao.ReceitaDAO;
import Projeto_Integrador.model.Ingrediente;
import Projeto_Integrador.model.IngredienteReceita;
import Projeto_Integrador.model.Receita;
import Projeto_Integrador.model.DTO.ReceitaDTO;
import Projeto_Integrador.utils.ResultadoValidacao;
import Projeto_Integrador.utils.Utils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henri
 */
public class ReceitaController {

    private ReceitaDAO receitaDAO;
    private IngredienteDAO ingredienteDAO;

    public ReceitaController() {
        this.receitaDAO = new ReceitaDAO();
        this.ingredienteDAO = new IngredienteDAO();
    }

    public ResultadoValidacao validarReceita(ReceitaDTO receita) {
        ResultadoValidacao resultado = new ResultadoValidacao();
        // Verifica se o nome está vazio

        if (receita.getNome().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Nome do ingrediente não pode estar vazio.");
            return resultado;
        }
        if (receita.getValorStr().contains(",")) {
            receita.setValorStr(receita.getValorStr().replace(",", "."));
        }
        // Verifica se o valor é um número válido
        try {
            float valorFloat = Float.parseFloat(receita.getValorStr());
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
            float quantidadeFloat = Float.parseFloat(receita.getQuantidadeStr());
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
        if ("Selecione um tipo".equals(receita.getTipo())) {
            resultado.setValido(false);
            resultado.setMensagem("Selecione um tipo.");
            return resultado;
        }

        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public static ResultadoValidacao validarReceitasEQuantidades(Map<String, String> receitasEQuantidades) {
        ResultadoValidacao resultado = new ResultadoValidacao();
        for (Map.Entry<String, String> entry : receitasEQuantidades.entrySet()) {
            String Ingrediente = entry.getKey();
            String val = entry.getValue();
            if (Ingrediente.equals("Selecione a receita")) {
                resultado.setValido(false);
                resultado.setMensagem("Selecione a receita corretamente.");
                return resultado;
            }
            if (val.contains(",")) {
                val = val.replace(",", ".");
            }
            try {
                float quantidadeFloat = Float.parseFloat(val);
                if (quantidadeFloat <= 0) {
                    resultado.setValido(false);
                    resultado.setMensagem("Valor da quantidade deve ser um número positivo.");
                    return resultado;
                }
            } catch (NumberFormatException e) {
                resultado.setValido(false);
                resultado.setMensagem("Valor da quantidade das receitas deve ser um número válido.");
                return resultado;
            }
        }
        resultado.setValido(true);
        return resultado;
    }

    public Map<String, String> getIngredientesEQuantidadesDaReceita(int id) {
        try {
            Receita receita = receitaDAO.selectById(id);
            return receita.getIngredientesEQuantidades2();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void carregarReceitaParaTabela(JTable tableReceita) {
        try {
            //  selecionando todos items da table na db
            List<Receita> receitas = new ReceitaDAO().selectAll();
            if (receitas != null) {
                DefaultTableModel tableReceitaModel = (DefaultTableModel) tableReceita.getModel();
                tableReceitaModel.setRowCount(0);

                for (Receita receita : receitas) {
                    String valor = String.format("%.02f", receita.getValor());
                    tableReceitaModel.addRow(new Object[]{receita.getId(), receita.getNome(), valor, receita.getQuantidade(), receita.getTipo()});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean cadastrar2(ReceitaDTO receitaDTO, Map<String, String> ingredientesEQuantidades) {
        try {
            ResultadoValidacao resultado = validarReceita(receitaDTO);
            ResultadoValidacao resultadoIngredientes = IngredienteController.validarIngredientesQuantidades(ingredientesEQuantidades);
            if (resultado.isValido() && resultadoIngredientes.isValido()) {
                List<IngredienteReceita> items = new ArrayList<>();
                float valor = Float.parseFloat(receitaDTO.getValorStr());
                float quantidade = Float.parseFloat(receitaDTO.getQuantidadeStr());
                Receita receita = new Receita(receitaDTO.getNome(), valor, quantidade, receitaDTO.getTipo());

                for (Map.Entry<String, String> entry : ingredientesEQuantidades.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    // pegando o ingrediente pelo ID
                    int id = Integer.parseInt(Utils.pegarIdDaString(key));
                    Ingrediente ingrediente = ingredienteDAO.selectById(id);

                    IngredienteReceita itemIngrediente = new IngredienteReceita();
                    float quantidadeItem = Float.parseFloat(val);
                    itemIngrediente.setQuantidade(quantidadeItem);
                    itemIngrediente.setIngrediente(ingrediente);
                    itemIngrediente.setReceita(receita);
                    items.add(itemIngrediente);
                }
                receita.setIngredientes(items);

                receitaDAO.cadastrarReceita(receita);
                return true;
            } else if (!resultado.isValido()) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultadoIngredientes.getMensagem());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean alterar2(ReceitaDTO novaReceitaDTO, Map<String, String> ingredientesEQuantidades) {
        try {
            ResultadoValidacao resultado = validarReceita(novaReceitaDTO);
            ResultadoValidacao resultadoIngredientes = IngredienteController.validarIngredientesQuantidades(ingredientesEQuantidades);

            if (resultado.isValido() && resultadoIngredientes.isValido()) {
                List<IngredienteReceita> items = new ArrayList<>();
                float valor = Float.parseFloat(novaReceitaDTO.getValorStr());
                float quantidade = Float.parseFloat(novaReceitaDTO.getQuantidadeStr());
                Receita receita = receitaDAO.selectById(novaReceitaDTO.getId());
                receita.setNome(novaReceitaDTO.getNome());
                receita.setValor(valor);
                receita.setQuantidade(quantidade);
                receita.setTipo(novaReceitaDTO.getTipo());
                receitaDAO.removerTodosIngredientes(novaReceitaDTO.getId());

                for (Map.Entry<String, String> entry : ingredientesEQuantidades.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    // pegando o ingrediente pelo ID
                    int id = Integer.parseInt(Utils.pegarIdDaString(key));
                    Ingrediente ingrediente = ingredienteDAO.selectById(id);

                    IngredienteReceita itemIngrediente = new IngredienteReceita();
                    float quantidadeItem = Float.parseFloat(val);
                    itemIngrediente.setQuantidade(quantidadeItem);
                    itemIngrediente.setIngrediente(ingrediente);
                    itemIngrediente.setReceita(receita);
                    items.add(itemIngrediente);
                }
                receita.setIngredientes(items);
                receitaDAO.alterarReceita(receita);
                return true;

            } else if (!resultado.isValido()) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultadoIngredientes.getMensagem());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean removerReceitas(ArrayList<Integer> ids) {
        boolean sucesso = true;
        try {
            for (Integer id : ids) {
                receitaDAO.removerReceita(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sucesso;
    }

    public List<ReceitaDTO> carregarReceitasDTOs() {
        try {
            List<Receita> receitas = receitaDAO.selectAll();
            List<ReceitaDTO> ReceitasDTO = new ArrayList<>();

            for (Receita receita : receitas) {
                ReceitaDTO receitaDTO = new ReceitaDTO(
                        receita.getId(),
                        receita.getNome(),
                        receita.getValor(),
                        receita.getQuantidade(),
                        receita.getTipo());
                ReceitasDTO.add(receitaDTO);
            }
            return ReceitasDTO;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}

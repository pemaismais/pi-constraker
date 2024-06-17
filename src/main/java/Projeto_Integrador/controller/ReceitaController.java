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

    public List<ReceitaDTO> idsParaDTOS(ArrayList<Integer> ids) {
        try {
            List<ReceitaDTO> receitasDTO = new ArrayList<>();
            for (Integer id : ids) {
                receitasDTO.add(new ReceitaDTO(receitaDAO.selectById(id).getId(),
                        receitaDAO.selectById(id).getNome(),
                        receitaDAO.selectById(id).getValor(),
                        receitaDAO.selectById(id).getQuantidade(),
                        receitaDAO.selectById(id).getTipo()
                ));
            }
            return receitasDTO;
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

    public boolean cadastrar(ReceitaDTO receitaDTO, ArrayList<Integer> idIngredientes, ArrayList<Float> quantidadesIngredientes) {
        try {
            ResultadoValidacao resultado = validarReceita(receitaDTO);
            if (idIngredientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione os ingredientes da receita");
                return false;
            }
            if (resultado.isValido()) {
                ArrayList<Ingrediente> ingredientesSelecionados = new ArrayList<>();
                List<IngredienteReceita> ingredientesComQtd = new ArrayList<>();
                float valor = Float.parseFloat(receitaDTO.getValorStr());
                float quantidade = Float.parseFloat(receitaDTO.getQuantidadeStr());
                Receita receita = new Receita(receitaDTO.getNome(), valor, quantidade, receitaDTO.getTipo());

                // adicionando os ingredientes no arraylist pelo ID
                for (Integer id : idIngredientes) {
                    Ingrediente ingrediente = ingredienteDAO.selectById(id);
                    ingredientesSelecionados.add(ingrediente);
                }

                // juntando os ingredientes com a quantidade e colocando no array
                for (int i = 0; i < ingredientesSelecionados.size(); i++) {
                    IngredienteReceita ingredienteComQtd = new IngredienteReceita();
                    float quantidadeIngrediente = quantidadesIngredientes.get(i);

                    ingredienteComQtd.setQuantidade(quantidadeIngrediente);
                    ingredienteComQtd.setIngrediente(ingredientesSelecionados.get(i));
                    ingredienteComQtd.setReceita(receita);

                    ingredientesComQtd.add(ingredienteComQtd);
                }
                receita.setIngredientes(ingredientesComQtd);

                receitaDAO.cadastrarReceita(receita);
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

    public boolean alterar(ReceitaDTO novaReceitaDTO, ArrayList<Integer> idIngredientes, ArrayList<Float> quantidadesIngredientes) {
        try {
            ResultadoValidacao resultado = validarReceita(novaReceitaDTO);
            // vendo se selecionou algum ingrediente p/ receita
            if (idIngredientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione os ingredientes da receita");
                return false;
            }
            if (resultado.isValido() == false) {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
            // Validando se colocou a quantidade para todos os ingredientes
            for (Integer idIngrediente : idIngredientes) {
                if (idIngrediente == null || idIngrediente == 0) {
                    String IngredienteNome = ingredienteDAO.selectById(idIngredientes.get(idIngrediente)).getNome();
                    JOptionPane.showMessageDialog(null, "Insira a quantidade do ingrediente: " + IngredienteNome);
                    return false;
                }
            }

            // transformando as strings
            ArrayList<Ingrediente> ingredientesSelecionados = new ArrayList<>();
            List<IngredienteReceita> ingredientesComQtd = new ArrayList<>();
            float valor = Float.parseFloat(novaReceitaDTO.getValorStr());
            float quantidade = Float.parseFloat(novaReceitaDTO.getQuantidadeStr());
            Receita novaReceita = receitaDAO.selectById(novaReceitaDTO.getId());
            novaReceita.setNome(novaReceitaDTO.getNome());
            novaReceita.setValor(valor);
            novaReceita.setQuantidade(quantidade);
            novaReceita.setTipo(novaReceitaDTO.getTipo());
            receitaDAO.removerTodosIngredientes(novaReceitaDTO.getId());

            // juntando os ingredientes com a quantidade e colocando no array
            for (Integer id : idIngredientes) {
                Ingrediente ingrediente = ingredienteDAO.selectById(id);
                ingredientesSelecionados.add(ingrediente);
            }

            // juntando os ingredientes com a quantidade e colocando no array
            for (int i = 0; i < ingredientesSelecionados.size(); i++) {
                IngredienteReceita ingredienteComQtd = new IngredienteReceita();
                float quantidadeIngrediente = quantidadesIngredientes.get(i);

                ingredienteComQtd.setQuantidade(quantidadeIngrediente);
                ingredienteComQtd.setIngrediente(ingredientesSelecionados.get(i));
                ingredienteComQtd.setReceita(novaReceita);

                ingredientesComQtd.add(ingredienteComQtd);
            }
            novaReceita.setIngredientes(ingredientesComQtd);

            if (!receitaDAO.alterarReceita(novaReceita)) {
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
    
    public void SelecionarIngredientesDaReceitaNaTable(int idReceita, JTable tableIngrediente) {
        try {
            Receita receita = receitaDAO.selectById(idReceita);
            List<IngredienteReceita> ingredientes = receita.getIngredientes();
            List<Integer> ingredientesIds = new ArrayList<>();

            // pegando os ids dos ingredientes
            for (IngredienteReceita ingredienteReceita : ingredientes) {
                ingredientesIds.add(ingredienteReceita.getIngrediente().getId());
            }

            System.out.println(ingredientesIds);
            
            // Selecionando as Ingredientes da receita que tao na table pelo id          
            for (int i = 0; i < tableIngrediente.getRowCount(); i++) {
                int id = (int) tableIngrediente.getValueAt(i, 0);
                if (ingredientesIds.contains(id)) {
                    tableIngrediente.addRowSelectionInterval(i, i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ingredientesDaReceitaParaTable(JTable table, int idReceita) {
        try {
            Receita receita = receitaDAO.selectById(idReceita);

            List<IngredienteReceita> ingredientes = receita.getIngredientes();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0);

            for (IngredienteReceita ingrediente : ingredientes) {
                Object[] dados = new Object[]{ingrediente.getIngrediente().getId(), ingrediente.getIngrediente().getNome(), ingrediente.getQuantidade()};
                tableModel.addRow(dados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

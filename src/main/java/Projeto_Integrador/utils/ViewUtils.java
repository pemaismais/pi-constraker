/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.utils;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class ViewUtils {

    public ViewUtils() {
    }

    public void limparCampos(Object[] components) {
        for (Object component : components) {
            if (component instanceof JComboBox) {
                ((JComboBox<?>) component).setSelectedIndex(0); // Limpa a seleção do JComboBox
            } else if (component instanceof JTextField jTextField) {
                jTextField.setText(""); // Limpa o texto do JTextField
            }
        }
    }

    public void tableParaCampos(Object[] components, JTable table) {
        Object value;
        for (int i = 0; i < components.length; i++) {
            value = table.getValueAt(table.getSelectedRow(), i);
            if (components[i] instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) components[i];
                comboBox.setSelectedItem(value.toString());
            } else if (components[i] instanceof JTextField) {
                JTextField textField = (JTextField) components[i];
                textField.setText(value.toString());
            }
        }
    }

    public ArrayList<String> pegarStringsDaTable(JTable table, int column) {
        int rows = table.getRowCount();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String value = table.getValueAt(i, column).toString();
            values.add(value);
        }
        return values;
    }

    public ArrayList<Integer> pegarIdsSelecionadosDaTable(JTable table) {
        if (table.getSelectedRows() == null) {
            return null;
        }
        int[] rowsIndexes = table.getSelectedRows();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < rowsIndexes.length; i++) {
            int id = Integer.parseInt(table.getValueAt(rowsIndexes[i], 0).toString());
            ids.add(id);
        }
        return ids;
    }

    public ArrayList<String> pegarStringsSelecionadasDaTable(JTable table, int column) {
        if (table.getSelectedRows() == null) {
            return null;
        }
        int[] rowsIndexes = table.getSelectedRows();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < rowsIndexes.length; i++) {
            String value = table.getValueAt(rowsIndexes[i], column).toString();
            values.add(value);
        }
        return values;
    }

}

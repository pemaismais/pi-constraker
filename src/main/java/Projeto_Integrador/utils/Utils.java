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
public class Utils {

    public Utils() {
    }

    public static String pegarIdDaString(String string) {
        int posicaoDoEspaco = string.indexOf(" "); // pega a posicao do primeiro espaco q achar
        String idString = string.substring(0, posicaoDoEspaco); // Extrair a parte do ID (como string)
        return idString;
    }

    public static String pegarNomeDaString(String string) {
        int posicaoDoEspaco = string.indexOf(" "); // pega a posicao do primeiro espaco q achar
        String nomeString = string.substring(posicaoDoEspaco + 1).trim(); // Extrair a parte do ID (como string)
        return nomeString;
    }

    public static String formatarStringParaFloat(String string) {
        if (string.contains(",")) {
            string = string.replace(",", ".");
        }
        return string;
    }

    public static void limparCampos(Object[] components) {
        for (Object component : components) {
            if (component instanceof JComboBox) {
                ((JComboBox<?>) component).setSelectedIndex(0); // Limpa a seleção do JComboBox
            } else if (component instanceof JTextField jTextField) {
                jTextField.setText(""); // Limpa o texto do JTextField
            }
        }
    }

    public static void tableParaCampos(Object[] components, JTable table) {
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

    public static ArrayList<Integer> pegarIdsSelecionadosDaTable(JTable table) {
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

    public static ArrayList<String> pegarStringsSelecionadasDaTable(JTable table, int column) {
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

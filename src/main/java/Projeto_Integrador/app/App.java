package Projeto_Integrador.app;

import Projeto_Integrador.app.view.MainFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            // Set FlatLaf look and feel
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
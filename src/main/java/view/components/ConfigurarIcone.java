package view.components;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ConfigurarIcone {

    public static void aplicar(
            JLabel label,
            String caminho,
            int largura,
            int altura) {

        try {
            ImageIcon imageIcon = new ImageIcon(ConfigurarIcone.class.getResource(caminho));

            Image image = imageIcon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(image));

            java.awt.Dimension dimensao = new java.awt.Dimension(largura, altura);

            label.setPreferredSize(dimensao);
            label.setMinimumSize(dimensao);
            label.setMaximumSize(dimensao);

        } catch (Exception e) {
            System.out.println("Ícone não encontrado: " + caminho);
        }
    }
}
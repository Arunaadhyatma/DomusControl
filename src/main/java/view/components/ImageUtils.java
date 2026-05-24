package view.components;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageUtils {
    private static final Logger logger =
            Logger.getLogger(ImageUtils.class.getName());

    public static void aplicar(
            JLabel label,
            String caminho,
            int largura,
            int altura) {

        try {
            ImageIcon imageIcon = new ImageIcon(ImageUtils.class.getResource(caminho));

            Image image = imageIcon.getImage().getScaledInstance(largura,altura,Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(image));

            java.awt.Dimension dimensao = new java.awt.Dimension(largura, altura);

            label.setPreferredSize(dimensao);
            label.setMinimumSize(dimensao);
            label.setMaximumSize(dimensao);
        } catch (Exception e) {
            logger.log(Level.WARNING,"Ícone não encontrado: " + caminho);
        }
    }
}

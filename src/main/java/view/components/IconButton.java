package view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class IconButton extends JButton {
    private final Color corNormal = new Color(190, 190, 190);
    private final Color corHover = Color.WHITE;
    
    public IconButton(String texto, String caminhoIcone) {
        super(texto);
        
        setIcon(new ImageIcon(getClass().getResource(caminhoIcone)));
        
        setHorizontalAlignment(SwingConstants.LEFT);
        setIconTextGap(15);
        
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        
        setForeground(corNormal);
        setFont(new Font("Arial", Font.PLAIN, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setForeground(corHover);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                setForeground(corNormal);
            }
        });
    }
}

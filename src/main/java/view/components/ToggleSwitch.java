package view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JToggleButton;

public class ToggleSwitch extends JToggleButton {
    public ToggleSwitch() {
        setPreferredSize(new Dimension(50, 25));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        
        setText("");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isSelected()) {
            g2.setColor(new Color(46, 158, 18));
        } else {
            g2.setColor(new Color(130, 130, 130));
        }
        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2.setColor(Color.WHITE);
        
        int diametro = getHeight()-4;
        int x;
        
        if (isSelected()) {
            x = getWidth()-diametro-2;
        } else {
            x = 2;
        }
        
        g2.fillOval(x, 2, diametro, diametro);
        
        g2.dispose();
    }
}

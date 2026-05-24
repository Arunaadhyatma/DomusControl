/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

/**
 *
 * @author gabri
 */
public class BordaArredondada implements javax.swing.border.Border {
    private final int radius;
    private final java.awt.Color cor;
    
    public BordaArredondada(int radius, java.awt.Color cor) {
        this.radius = radius;
        this.cor = cor;
        
    }
    
    @Override
    public java.awt.Insets getBorderInsets(java.awt.Component c) {
        if (c instanceof javax.swing.JTextField || c instanceof javax.swing.JComboBox) {
            return new java.awt.Insets(6, 12, 6, 12);
        }
        
        return new java.awt.Insets(4, 8, 4, 8);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
    @Override
    public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
        
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(cor);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }
}

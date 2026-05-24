package view.components;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LinkLabel extends JLabel {
    
    public LinkLabel(String texto) {
        super("<html><u>" + texto + "</u></html>");
        
        setForeground(new Color(30, 144, 255));
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addMouseListener(new MouseAdapter() {
           
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(new Color(100, 180, 255));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(new Color(30, 144, 255));
            }
        });
    }
}

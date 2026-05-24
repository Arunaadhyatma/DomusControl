package view;

import javax.swing.JFrame;
import view.theme.AppTheme;

public abstract class TelaBase extends JFrame {
    public TelaBase() {
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(AppTheme.BACKGROUND);
    }
}

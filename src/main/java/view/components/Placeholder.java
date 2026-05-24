
package view.components;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Placeholder {
    
    public static void aplicar (JTextField campo, String texto) {
        campo.setText(texto);
        campo.setForeground(new Color(153, 153, 153));
        campo.addFocusListener(new FocusAdapter() {
            
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(texto)) {
                    campo.setText("");
                    campo.setForeground(Color.WHITE);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if(campo.getText().isEmpty()) {
                    campo.setText(texto);
                    campo.setForeground(new Color(153, 153, 153));
                }
            }
        });
    }
}

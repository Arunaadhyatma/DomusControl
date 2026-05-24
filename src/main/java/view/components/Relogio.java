package view.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Relogio {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public static void iniciar(JLabel label) {
        atualizar(label);
        
        Timer timer = new Timer(1000, e -> atualizar(label));
        timer.start();
    }
    
    private static void atualizar(JLabel label) {
        label.setText(LocalDateTime.now().format(FORMATTER));
    }
}

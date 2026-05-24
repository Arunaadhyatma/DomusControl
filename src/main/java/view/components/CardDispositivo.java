package view.components;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import model.Dispositivo;
import model.TipoDispositivo;

public class CardDispositivo extends JPanel {
    
    private JLabel lblNome;
    private JLabel lblAmbiente;
    private JLabel lblEstado;
    private JLabel lblIcone;
    
    private ToggleSwitch toggle;
    
    public CardDispositivo(String nome, String ambiente, String caminhoIcone) {
        inicializarComponentes(nome, ambiente, caminhoIcone);
    }
    
    public CardDispositivo(Dispositivo dispositivo) {
        this(
                dispositivo.getNome(),
                dispositivo.getAmbiente().getNome(),
                escolherIcone(dispositivo.getTipo())
        );

        if (dispositivo.isLigado()) {
            ligar();
        } else {
            desligar();
        }
    }
    
    private static String escolherIcone(TipoDispositivo tipo) {
        return switch (tipo) {
            case ILUMINACAO -> "/view/lampada.png";
            case CLIMATIZACAO -> "/view/floconeve.png";
            case SEGURANCA -> "/view/portaogaragem.png";
            default -> "/view/iconDispositivos.png";
        };
    }
    
    private void inicializarComponentes(String nome, String ambiente, String caminhoIcone) {
        setLayout(null);
        setOpaque(false);
        setBackground(new Color(76, 75, 75));
        setBorder(new BordaArredondada(20, new Color(76, 75, 75)));
        setPreferredSize(new Dimension(255,145));
        setMinimumSize(new Dimension(255, 145));
        setMaximumSize(new Dimension(255, 145));
        
        lblIcone = new JLabel();
        lblIcone.setBounds(12, 60, 58, 58);
        lblIcone.setIcon(new ImageIcon(getClass().getResource(caminhoIcone)));
        
        lblNome = new JLabel(nome);
        lblNome.setBounds(12, 8, 230, 32);
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Arial", Font.BOLD, 25));
        
        lblAmbiente = new JLabel(ambiente);
        lblAmbiente.setBounds(12, 38, 220, 24);
        lblAmbiente.setForeground(Color.LIGHT_GRAY);
        
        lblEstado = new JLabel("DESLIGADO");
        lblEstado.setBounds(12, 115, 120, 24);
        lblEstado.setForeground(Color.GRAY);
        
        toggle = new ToggleSwitch();
        
        toggle.setBounds(188, 105, 55, 30);
        toggle.addActionListener(e -> atualizarEstado());
        
        add(lblIcone);
        add(lblNome);
        add(lblAmbiente);
        add(lblEstado);
        add(toggle);
    }
    
    public void ligar() {
        toggle.setSelected(true);
        atualizarEstado();
    }
    
    public void desligar() {
        toggle.setSelected(false);
        atualizarEstado();
    }
    
    private void atualizarEstado() {
        if(toggle.isSelected()) {
            lblEstado.setText("LIGADO");
            lblEstado.setForeground(new Color(46, 159, 18));
        } else {
            lblEstado.setText("DESLIGADO");
            lblEstado.setForeground(Color.GRAY);
        }
        
        repaint();
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
        
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(76, 75, 75));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        g2.dispose();
        
        super.paintComponent(g);
    }
}

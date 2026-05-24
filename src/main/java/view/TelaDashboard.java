package view;

import DAO.DispositivoDAO;
import java.awt.Color;
import view.components.BordaArredondada;
import view.components.CardDispositivo;
import view.components.Relogio;
import view.theme.AppTheme;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import model.Dispositivo;

public class TelaDashboard extends TelaBase {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaDashboard.class.getName());

    /**
     * Creates new form TelaDashboard
     */
    public TelaDashboard() {
        initComponents();
        
        aplicarEstilos();
        configurarMenuLateral();
        configurarAcoes();
        adicionarCards();
        Relogio.iniciar(lblDateTimeNumber);
        
        this.setSize(1200, 700);
        this.setMinimumSize(new java.awt.Dimension(1200, 700));
        this.setLocationRelativeTo(null);
    }
    
    private void aplicarEstilos() {
        LayoutPrincipal.setBackground(AppTheme.BACKGROUND);
        LayoutLateral.setBackground(AppTheme.PANEL);
                
        estilizarBotaoAcao(BtnLigarTudo);
        estilizarBotaoAcao(BtnDesligarTudo);
    }
    
    private void estilizarBotaoAcao(JButton botao) {
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(true);
        
        botao.setPreferredSize(new java.awt.Dimension(170, 44));
        botao.setMinimumSize(new java.awt.Dimension(170, 44));
        botao.setMaximumSize(new java.awt.Dimension(170, 44));
        
        botao.setBackground(new Color(80, 79, 79));
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(new BordaArredondada(15, new Color(80, 79, 79)));
    }
    
    private void configurarMenuLateral() {
        configurarBotaoMenu(btnInicio, "Início", "/view/iconInicio.png");
        configurarBotaoMenu(btnAmbiente, "Ambiente", "/view/iconAmbiente.png");
        configurarBotaoMenu(btnDispositivos, "Dispositivos", "/view/iconDispositivos.png");
        configurarBotaoMenu(btnRotinas, "Rotinas", "/view/iconRotinas.png");
        configurarBotaoMenu(btnConfiguracoes, "Configurações", "/view/iconConfiguracoes.png");
    }
    
    private void configurarBotaoMenu(JButton botao, String texto, String caminhoIcone) {
        botao.setText(texto);
        
        try {
            botao.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminhoIcone)));
        } catch (Exception e) {
            System.out.println("Ícone não encontrado: " + caminhoIcone);
        }
        
        botao.setPreferredSize(new java.awt.Dimension(210, 55));
        botao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao.setIconTextGap(15);
        
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(false);
        
        botao.setForeground(new Color(190, 190, 190));
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
           @Override
           public void mouseEntered(java.awt.event.MouseEvent e) {
               botao.setForeground(Color.WHITE);
           }
           
           @Override
           public void mouseExited(java.awt.event.MouseEvent e) {
               botao.setForeground(new Color(190, 190, 190));
           }
        });
    }
    
    private void adicionarCards() {
        painelCards.removeAll();
        painelCards.setBounds(390, 160, 690, 430);
        painelCards.setPreferredSize(new java.awt.Dimension(690, 430));
        painelCards.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 18, 14));
        
        DispositivoDAO dao = new DispositivoDAO();

        java.util.List<Dispositivo> dispositivos = dao.listarTodos();
        
        for (Dispositivo dispositivo : dispositivos) {
            
            CardDispositivo card = new CardDispositivo(dispositivo);
            painelCards.add(card);
        }

        painelCards.revalidate();
        painelCards.repaint();
    }
    
    private void configurarAcoes() {
        BtnLigarTudo.addActionListener(e -> {
            for(java.awt.Component componente : painelCards.getComponents()) {
                if(componente instanceof CardDispositivo card) {
                    card.ligar();
                }
            }
        });
        
        BtnDesligarTudo.addActionListener(e -> {
            for(java.awt.Component componente : painelCards.getComponents()) {
                if(componente instanceof CardDispositivo card) {
                    card.desligar();
                }
            }
        });
        
        btnDispositivos.addActionListener(e -> {
            TelaCadastro cadastro = new TelaCadastro();
            cadastro.setVisible(true);
            dispose();
        });
        
        btnInicio.addActionListener(e -> {
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
            dispose();
        });
        
        btnAmbiente.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada nesta etapa.");
        });
        
        btnRotinas.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada nesta etapa.");
        });
        
        btnConfiguracoes.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada nesta etapa.");
        });

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayoutPrincipal = new javax.swing.JPanel();
        LayoutLateral = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnAmbiente = new javax.swing.JButton();
        btnDispositivos = new javax.swing.JButton();
        btnRotinas = new javax.swing.JButton();
        btnConfiguracoes = new javax.swing.JButton();
        lblOla = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblDateTimeNumber = new javax.swing.JLabel();
        BtnLigarTudo = new javax.swing.JButton();
        BtnDesligarTudo = new javax.swing.JButton();
        scrollCards = new javax.swing.JScrollPane();
        painelCards = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        LayoutPrincipal.setBackground(new java.awt.Color(30, 30, 30));

        LayoutLateral.setBackground(new java.awt.Color(76, 75, 75));

        btnInicio.setText("Início");
        btnInicio.addActionListener(this::btnInicioActionPerformed);

        btnAmbiente.setText("Ambientes");

        btnDispositivos.setText("Dispositivos");

        btnRotinas.setText("Rotinas");

        btnConfiguracoes.setText("Configurações");

        javax.swing.GroupLayout LayoutLateralLayout = new javax.swing.GroupLayout(LayoutLateral);
        LayoutLateral.setLayout(LayoutLateralLayout);
        LayoutLateralLayout.setHorizontalGroup(
            LayoutLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayoutLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LayoutLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRotinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addContainerGap())
        );
        LayoutLateralLayout.setVerticalGroup(
            LayoutLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutLateralLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRotinas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblOla.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblOla.setForeground(new java.awt.Color(242, 242, 242));
        lblOla.setText("Olá, Gabriel!");

        lblDateTime.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblDateTime.setForeground(new java.awt.Color(191, 191, 191));
        lblDateTime.setText("Date/Time");

        lblDateTimeNumber.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDateTimeNumber.setForeground(new java.awt.Color(136, 133, 133));
        lblDateTimeNumber.setText("07/11/2021 19:00");

        BtnLigarTudo.setBackground(new java.awt.Color(80, 79, 79));
        BtnLigarTudo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        BtnLigarTudo.setForeground(new java.awt.Color(255, 255, 255));
        BtnLigarTudo.setText("Ligar Tudo");
        BtnLigarTudo.addActionListener(this::BtnLigarTudoActionPerformed);

        BtnDesligarTudo.setBackground(new java.awt.Color(80, 79, 79));
        BtnDesligarTudo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        BtnDesligarTudo.setForeground(new java.awt.Color(255, 255, 255));
        BtnDesligarTudo.setText("Desligar Tudo");

        painelCards.setBackground(new java.awt.Color(30, 30, 30));
        painelCards.setPreferredSize(new java.awt.Dimension(690, 700));

        javax.swing.GroupLayout painelCardsLayout = new javax.swing.GroupLayout(painelCards);
        painelCards.setLayout(painelCardsLayout);
        painelCardsLayout.setHorizontalGroup(
            painelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        painelCardsLayout.setVerticalGroup(
            painelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        scrollCards.setViewportView(painelCards);

        javax.swing.GroupLayout LayoutPrincipalLayout = new javax.swing.GroupLayout(LayoutPrincipal);
        LayoutPrincipal.setLayout(LayoutPrincipalLayout);
        LayoutPrincipalLayout.setHorizontalGroup(
            LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                .addComponent(LayoutLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                        .addComponent(lblOla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateTimeNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDateTime, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                        .addComponent(scrollCards, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addGroup(LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnLigarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnDesligarTudo))))
                .addGap(17, 17, 17))
        );

        LayoutPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnDesligarTudo, BtnLigarTudo});

        LayoutPrincipalLayout.setVerticalGroup(
            LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayoutLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                        .addComponent(lblDateTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateTimeNumber))
                    .addComponent(lblOla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LayoutPrincipalLayout.createSequentialGroup()
                        .addComponent(BtnLigarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(BtnDesligarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollCards, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayoutPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayoutPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLigarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLigarTudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLigarTudoActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDesligarTudo;
    private javax.swing.JButton BtnLigarTudo;
    private javax.swing.JPanel LayoutLateral;
    private javax.swing.JPanel LayoutPrincipal;
    private javax.swing.JButton btnAmbiente;
    private javax.swing.JButton btnConfiguracoes;
    private javax.swing.JButton btnDispositivos;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnRotinas;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblDateTimeNumber;
    private javax.swing.JLabel lblOla;
    private javax.swing.JPanel painelCards;
    private javax.swing.JScrollPane scrollCards;
    // End of variables declaration//GEN-END:variables
}

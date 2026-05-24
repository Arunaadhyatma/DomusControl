/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.UsuarioDAO;
import java.awt.Image;
import javax.swing.ImageIcon;
import view.components.BordaArredondada;
import view.components.Placeholder;
import view.components.ImageUtils;
import view.theme.AppTheme;

/**
 *
 * @author gabri
 */
public class TelaLogin extends TelaBase {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaLogin.class.getName());

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        
        configurarLogo();
        configurarIconesCampos();
        aplicarBordasArredondadas();
        configurarPlaceholders();
        configurarLinks();
        configurarAcoes();
        
        corrigirTamanhos();
        this.setSize(920, 600);
        this.setMinimumSize(new java.awt.Dimension(920, 600));
        this.setLocationRelativeTo(null);
        
    }
    
    private void configurarLogo() {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/view/Icon.png"));
            Image image = imageIcon.getImage().getScaledInstance(65, 55, Image.SCALE_SMOOTH);
            icon.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Logo não encontrado na pasta view.");
        }
    }
    
    private void configurarIconesCampos() {
        ImageUtils.aplicar(iconEmail, "/view/Mail.png", 30, 30);
        ImageUtils.aplicar(iconSenha, "/view/Lock.png", 40, 40);
    }
    
    private void configurarLinks() {
        lblEsqueciSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCadastrarNovaConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        lblEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionalidade de recuperação de senha ainda não implementada!");
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                lblEsqueciSenha.setForeground(new java.awt.Color(100, 180, 255));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                lblEsqueciSenha.setForeground(AppTheme.PRIMARY);
            }
        });
        
        lblCadastrarNovaConta.addMouseListener(new java.awt.event.MouseAdapter(){

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                TelaCadastroUsuario cadastro = new TelaCadastroUsuario();
                cadastro.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                lblCadastrarNovaConta.setForeground(new java.awt.Color(100, 180, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                lblCadastrarNovaConta.setForeground(AppTheme.PRIMARY);
            }
        });
    }
    
    private void aplicarBordasArredondadas() {
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBackground(AppTheme.PRIMARY);
        btnEntrar.setForeground(AppTheme.TEXT);
        
        btnEntrar.setBorder(new BordaArredondada(15, AppTheme.PRIMARY));
        
        TxtFieldEmail.setBorder(new BordaArredondada(10, AppTheme.PLACEHOLDER));
        TxtFieldSenha.setBorder(new BordaArredondada(10, AppTheme.PLACEHOLDER));
    }
    
    private void configurarPlaceholders() {
        Placeholder.aplicar(TxtFieldEmail, "E-mail");
        Placeholder.aplicar(TxtFieldSenha, "Senha");
    }
    
    private void configurarAcoes() {
        btnEntrar.addActionListener(e -> {
            String email = TxtFieldEmail.getText();
            String senha = TxtFieldSenha.getText();

            UsuarioDAO dao = new UsuarioDAO();

            if (dao.login(email, senha)) {
                TelaDashboard dashboard = new TelaDashboard();
                dashboard.setVisible(true);
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "E-mail ou senha inválidos."
                );
            }
        });
    }
    
    private void corrigirTamanhos() {
        icon.setPreferredSize(new java.awt.Dimension(65, 55));
        icon.setMinimumSize(new java.awt.Dimension(65, 55));
        icon.setMaximumSize(new java.awt.Dimension(65, 55));

        iconEmail.setPreferredSize(new java.awt.Dimension(30, 40));
        iconEmail.setMinimumSize(new java.awt.Dimension(30, 40));
        iconEmail.setMaximumSize(new java.awt.Dimension(30, 40));

        iconSenha.setPreferredSize(new java.awt.Dimension(40, 40));
        iconSenha.setMinimumSize(new java.awt.Dimension(40, 40));
        iconSenha.setMaximumSize(new java.awt.Dimension(40, 40));

        TxtFieldEmail.setPreferredSize(new java.awt.Dimension(460, 40));
        TxtFieldEmail.setMinimumSize(new java.awt.Dimension(460, 40));
        TxtFieldEmail.setMaximumSize(new java.awt.Dimension(460, 40));

        TxtFieldSenha.setPreferredSize(new java.awt.Dimension(460, 40));
        TxtFieldSenha.setMinimumSize(new java.awt.Dimension(460, 40));
        TxtFieldSenha.setMaximumSize(new java.awt.Dimension(460, 40));

        btnEntrar.setPreferredSize(new java.awt.Dimension(198, 50));
        btnEntrar.setMinimumSize(new java.awt.Dimension(198, 50));
        btnEntrar.setMaximumSize(new java.awt.Dimension(198, 50));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalLayout = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        interiorLayout = new javax.swing.JPanel();
        lblAcessoAoSistema = new javax.swing.JLabel();
        TxtFieldEmail = new javax.swing.JTextField();
        iconEmail = new javax.swing.JLabel();
        TxtFieldSenha = new javax.swing.JTextField();
        iconSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lblEsqueciSenha = new javax.swing.JLabel();
        lblCadastrarNovaConta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 655));
        setPreferredSize(new java.awt.Dimension(920, 600));

        principalLayout.setBackground(new java.awt.Color(30, 30, 30));
        principalLayout.setPreferredSize(new java.awt.Dimension(1200, 555));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icon.png"))); // NOI18N
        icon.setAlignmentX(501.0F);
        icon.setAlignmentY(85.0F);
        icon.setMaximumSize(new java.awt.Dimension(65, 55));
        icon.setMinimumSize(new java.awt.Dimension(65, 55));
        icon.setPreferredSize(new java.awt.Dimension(65, 55));

        title.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        title.setForeground(new java.awt.Color(242, 242, 242));
        title.setText("<html><b>Domus</b>Control</html>");

        interiorLayout.setBackground(new java.awt.Color(76, 75, 75));

        lblAcessoAoSistema.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblAcessoAoSistema.setForeground(new java.awt.Color(255, 255, 255));
        lblAcessoAoSistema.setText("Acesso ao Sistema");

        TxtFieldEmail.setBackground(new java.awt.Color(0, 0, 0));
        TxtFieldEmail.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        TxtFieldEmail.setForeground(new java.awt.Color(153, 153, 153));
        TxtFieldEmail.setText("E-mail");
        TxtFieldEmail.setBorder(null);
        TxtFieldEmail.addActionListener(this::TxtFieldEmailActionPerformed);

        iconEmail.setBackground(new java.awt.Color(0, 0, 0));
        iconEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Mail.png"))); // NOI18N

        TxtFieldSenha.setBackground(new java.awt.Color(0, 0, 0));
        TxtFieldSenha.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        TxtFieldSenha.setForeground(new java.awt.Color(153, 153, 153));
        TxtFieldSenha.setText("Senha");
        TxtFieldSenha.setBorder(null);
        TxtFieldSenha.addActionListener(this::TxtFieldSenhaActionPerformed);

        iconSenha.setBackground(new java.awt.Color(0, 0, 0));
        iconSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Lock.png"))); // NOI18N

        btnEntrar.setBackground(new java.awt.Color(30, 144, 255));
        btnEntrar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnEntrar.setText("Entrar");

        lblEsqueciSenha.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblEsqueciSenha.setForeground(new java.awt.Color(30, 144, 255));
        lblEsqueciSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEsqueciSenha.setText("<html><u>Esqueci a Senha?</u></html>");

        lblCadastrarNovaConta.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblCadastrarNovaConta.setForeground(new java.awt.Color(30, 144, 255));
        lblCadastrarNovaConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastrarNovaConta.setText("<html><u>Cadastrar Nova Conta</u></html>");

        javax.swing.GroupLayout interiorLayoutLayout = new javax.swing.GroupLayout(interiorLayout);
        interiorLayout.setLayout(interiorLayoutLayout);
        interiorLayoutLayout.setHorizontalGroup(
            interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interiorLayoutLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(interiorLayoutLayout.createSequentialGroup()
                        .addComponent(iconSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(interiorLayoutLayout.createSequentialGroup()
                        .addComponent(iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(171, 171, 171))
            .addGroup(interiorLayoutLayout.createSequentialGroup()
                .addGroup(interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interiorLayoutLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lblAcessoAoSistema))
                    .addGroup(interiorLayoutLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCadastrarNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        interiorLayoutLayout.setVerticalGroup(
            interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interiorLayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAcessoAoSistema)
                .addGap(18, 18, 18)
                .addGroup(interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFieldEmail)
                    .addComponent(iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(interiorLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtFieldSenha))
                .addGap(18, 18, 18)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCadastrarNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout principalLayoutLayout = new javax.swing.GroupLayout(principalLayout);
        principalLayout.setLayout(principalLayoutLayout);
        principalLayoutLayout.setHorizontalGroup(
            principalLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayoutLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title)
                .addGap(481, 481, 481))
            .addGroup(principalLayoutLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(interiorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayoutLayout.setVerticalGroup(
            principalLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayoutLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(principalLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(interiorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldEmailActionPerformed

    private void TxtFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldSenhaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFieldEmail;
    private javax.swing.JTextField TxtFieldSenha;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel iconEmail;
    private javax.swing.JLabel iconSenha;
    private javax.swing.JPanel interiorLayout;
    private javax.swing.JLabel lblAcessoAoSistema;
    private javax.swing.JLabel lblCadastrarNovaConta;
    private javax.swing.JLabel lblEsqueciSenha;
    private javax.swing.JPanel principalLayout;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

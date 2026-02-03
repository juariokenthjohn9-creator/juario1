package juarioacti1;

import config.config;
import config.session;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        emm = new javax.swing.JTextField();
        email = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        log = new javax.swing.JButton();
        signup = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(emm, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, 30));

        jLabel2.setText("EMAIL");
        javax.swing.GroupLayout emailLayout = new javax.swing.GroupLayout(email);
        email.setLayout(emailLayout);
        emailLayout.setHorizontalGroup(
            emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(jLabel2).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        emailLayout.setVerticalGroup(
            emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(emailLayout.createSequentialGroup().addComponent(jLabel2).addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 70, 20));

        jLabel3.setText("PASSWORD");
        javax.swing.GroupLayout passLayout = new javax.swing.GroupLayout(pass);
        pass.setLayout(passLayout);
        passLayout.setHorizontalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(passLayout.createSequentialGroup().addContainerGap().addComponent(jLabel3).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        passLayout.setVerticalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(passLayout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 20));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 30));

        log.setBackground(new java.awt.Color(102, 102, 255));
        log.setText("LOG IN");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        jPanel1.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 120, 30));

        signup.setBackground(new java.awt.Color(204, 204, 255));
        signup.setText("REGISTER");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel1.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

private void logActionPerformed(java.awt.event.ActionEvent evt) {                                    
    config conf = new config();
    String userEmail = emm.getText();
    String userPass = password.getText();

    try {
        String query = "SELECT * FROM tbl_accounts WHERE u_email = ? AND u_password = ?";
        java.sql.Connection conn = config.connectDB();
        java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userEmail);
        pstmt.setString(2, userPass);
        java.sql.ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Save data to Session
            session sess = session.getInstance();
            sess.setUid(rs.getInt("u_id"));
            sess.setFname(rs.getString("u_fname"));
            sess.setLname(rs.getString("u_lname"));
            sess.setEmail(rs.getString("u_email"));

            JOptionPane.showMessageDialog(null, "Login Success! Welcome " + sess.getFname());
            
            new LandingForm().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
}                               

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {                                       
        regester reg = new regester();
        reg.setVisible(true);
        this.dispose(); // Closes Login and opens Register
    }                                      

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel email;
    private javax.swing.JTextField emm;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton log;
    private javax.swing.JPanel pass;
    private javax.swing.JTextField password;
    private javax.swing.JToggleButton signup;
    // End of variables declaration                   
}
package system;
import MENU.png;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class login_signup extends javax.swing.JFrame {
    
    static JSONObject folder;
    static JSONArray list;
    static JSONObject info;
    static JSONParser jsonParser;
    static {
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        info = new JSONObject();
        
    }
        int clickCount = 0;
        static String fName;
        static String lName;
        static String fullname;
    public static String Fullname(){
       return fullname;
    }
    public login_signup() {
        initComponents();
     
       Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
       Border lineBorder = BorderFactory.createLineBorder(Color.WHITE);
       txtUSERNAME.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtPASSWORD.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtsignupFN.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtsignupLN.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtsignupUSERNAME.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtsignupPASSWORD.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
       txtsignupCONFIRMPASS.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
    }
    private void boxATSActionPerformed(java.awt.event.ActionEvent evt) {     
        
    }   
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void errortext(JLabel lbl){
        lbl.setText(lbl.getText()+"*");
        lbl.setForeground(Color.RED);
        lbl.setFont(new Font(lbl.getFont().getName(), Font.BOLD, 12));
    }
    private void resettext(JLabel lbl){
        lbl.setText(lbl.getText());
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font(lbl.getFont().getName(), Font.PLAIN, 12));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        login = new javax.swing.JPanel();
        txtUSERNAME = new javax.swing.JTextField();
        txtPASSWORD = new javax.swing.JPasswordField();
        btnLOGIN = new javax.swing.JButton();
        EXIT = new javax.swing.JLabel();
        MINIMIZE = new javax.swing.JLabel();
        lblHELLOAGAIN = new javax.swing.JLabel();
        lblBELOWMAIN = new javax.swing.JLabel();
        lblNOTMEMBERYET = new javax.swing.JLabel();
        lblREGISTER = new javax.swing.JLabel();
        lblUSERNAME = new javax.swing.JLabel();
        lblPASSWORD = new javax.swing.JLabel();
        ico_USER = new javax.swing.JLabel();
        ico_PASSWORD = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        txtsignupFN = new javax.swing.JTextField();
        txtsignupLN = new javax.swing.JTextField();
        txtsignupUSERNAME = new javax.swing.JTextField();
        txtsignupPASSWORD = new javax.swing.JPasswordField();
        txtsignupCONFIRMPASS = new javax.swing.JPasswordField();
        btnREGISTER = new javax.swing.JButton();
        lblsignupUSER = new javax.swing.JLabel();
        lblsignupLN = new javax.swing.JLabel();
        lblsignupFN = new javax.swing.JLabel();
        lblsignupPASS = new javax.swing.JLabel();
        lblsignupCONFPASS = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        boxATS = new javax.swing.JCheckBox();
        lblagreement = new javax.swing.JLabel();
        BACKsignup6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));

        login.setBackground(new java.awt.Color(255, 255, 255));

        txtUSERNAME.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtUSERNAME.setToolTipText("");
        txtUSERNAME.setBorder(null);
        txtUSERNAME.setMargin(new java.awt.Insets(2, 2, 2, 5));

        txtPASSWORD.setBorder(null);

        btnLOGIN.setBackground(new java.awt.Color(255, 0, 0));
        btnLOGIN.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLOGIN.setForeground(new java.awt.Color(255, 255, 255));
        btnLOGIN.setText("Login");
        btnLOGIN.setToolTipText("");
        btnLOGIN.setBorder(null);
        btnLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGINActionPerformed(evt);
            }
        });

        EXIT.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        EXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/exitbutton.png"))); // NOI18N
        EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EXITMouseClicked(evt);
            }
        });

        MINIMIZE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        MINIMIZE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/minimizebutton.png"))); // NOI18N
        MINIMIZE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MINIMIZEMouseClicked(evt);
            }
        });

        lblHELLOAGAIN.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lblHELLOAGAIN.setText("Hello Again!");

        lblBELOWMAIN.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblBELOWMAIN.setText("Welcome back you've been missed!");

        lblNOTMEMBERYET.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        lblNOTMEMBERYET.setText("Not a member yet?");

        lblREGISTER.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        lblREGISTER.setForeground(new java.awt.Color(102, 102, 255));
        lblREGISTER.setText("Register Now!");
        lblREGISTER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblREGISTERMouseClicked(evt);
            }
        });

        lblUSERNAME.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblUSERNAME.setText("Username");

        lblPASSWORD.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblPASSWORD.setText("Password");

        ico_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/usericon.png"))); // NOI18N

        ico_PASSWORD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/passwordicon.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/yumqueuewithlogo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MINIMIZE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EXIT)
                .addContainerGap())
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBELOWMAIN)
                            .addComponent(lblHELLOAGAIN))
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addComponent(ico_PASSWORD)
                                        .addGap(7, 7, 7))
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addComponent(ico_USER)
                                        .addGap(6, 6, 6)))
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPASSWORD)
                                        .addComponent(txtUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(loginLayout.createSequentialGroup()
                                            .addComponent(lblNOTMEMBERYET)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblREGISTER)))
                                    .addComponent(lblPASSWORD)
                                    .addComponent(lblUSERNAME)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MINIMIZE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(lblHELLOAGAIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBELOWMAIN)
                .addGap(24, 24, 24)
                .addComponent(lblUSERNAME)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(ico_USER))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ico_PASSWORD))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addComponent(lblPASSWORD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNOTMEMBERYET)
                    .addComponent(lblREGISTER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 220, Short.MAX_VALUE))
        );

        signup.setBackground(new java.awt.Color(255, 255, 255));

        txtsignupFN.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtsignupFN.setForeground(new java.awt.Color(153, 153, 153));
        txtsignupFN.setToolTipText("");
        txtsignupFN.setBorder(null);
        txtsignupFN.setMargin(new java.awt.Insets(2, 2, 2, 5));

        txtsignupLN.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtsignupLN.setForeground(new java.awt.Color(153, 153, 153));
        txtsignupLN.setToolTipText("");
        txtsignupLN.setBorder(null);
        txtsignupLN.setMargin(new java.awt.Insets(2, 2, 2, 5));

        txtsignupUSERNAME.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtsignupUSERNAME.setForeground(new java.awt.Color(153, 153, 153));
        txtsignupUSERNAME.setToolTipText("");
        txtsignupUSERNAME.setBorder(null);
        txtsignupUSERNAME.setMargin(new java.awt.Insets(2, 2, 2, 5));

        txtsignupPASSWORD.setBorder(null);

        txtsignupCONFIRMPASS.setBorder(null);

        btnREGISTER.setBackground(new java.awt.Color(255, 102, 0));
        btnREGISTER.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnREGISTER.setForeground(new java.awt.Color(255, 255, 255));
        btnREGISTER.setText("Register!");
        btnREGISTER.setToolTipText("");
        btnREGISTER.setBorder(null);
        btnREGISTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREGISTERActionPerformed(evt);
            }
        });

        lblsignupUSER.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblsignupUSER.setText("Username");

        lblsignupLN.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblsignupLN.setText("Lastname");

        lblsignupFN.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblsignupFN.setText("Firstname");

        lblsignupPASS.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblsignupPASS.setText("Password");

        lblsignupCONFPASS.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblsignupCONFPASS.setText("Confirm Password");

        jLabel63.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel63.setText("Account Creation");

        boxATS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxATSActionPerformed(evt);
            }
        });

        lblagreement.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblagreement.setForeground(new java.awt.Color(153, 153, 255));
        lblagreement.setText("Agree Terms of Service");
        lblagreement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblagreementMouseClicked(evt);
            }
        });

        BACKsignup6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        BACKsignup6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/backbutton.png"))); // NOI18N
        BACKsignup6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKsignup6MouseClicked(evt);
            }
        });

        jLabel2.setText("________________________________________________________________");

        javax.swing.GroupLayout signupLayout = new javax.swing.GroupLayout(signup);
        signup.setLayout(signupLayout);
        signupLayout.setHorizontalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupLayout.createSequentialGroup()
                .addComponent(BACKsignup6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                .addGap(0, 113, Short.MAX_VALUE)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                        .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsignupFN, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(lblsignupFN)
                            .addComponent(txtsignupUSERNAME)
                            .addComponent(txtsignupLN)
                            .addComponent(lblsignupUSER)
                            .addComponent(lblsignupLN)
                            .addComponent(lblsignupCONFPASS)
                            .addComponent(btnREGISTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsignupPASSWORD)
                            .addComponent(txtsignupCONFIRMPASS)
                            .addGroup(signupLayout.createSequentialGroup()
                                .addComponent(boxATS)
                                .addGap(4, 4, 4)
                                .addComponent(lblagreement))
                            .addComponent(lblsignupPASS))
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(161, 161, 161))))
        );
        signupLayout.setVerticalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BACKsignup6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel63)
                .addGap(50, 50, 50)
                .addComponent(lblsignupFN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsignupFN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblsignupLN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsignupLN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblsignupUSER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsignupUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblsignupPASS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsignupPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblsignupCONFPASS)
                .addGap(2, 2, 2)
                .addComponent(txtsignupCONFIRMPASS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxATS)
                    .addGroup(signupLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblagreement)))
                .addGap(16, 16, 16)
                .addComponent(btnREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        jLayeredPane1.setLayer(login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(signup, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(signup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void btnLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGINActionPerformed
       
        try {
            list = JSON.reader();
                          boolean USERexists = false;
                          boolean USERpass  = false;
                          String user = txtUSERNAME.getText();
                          String pass = txtPASSWORD.getText();
                          String getid = "";
                          int toview = 1;
                            for (int i = 0; i < list.size(); i++) {
                            JSONObject infoObj = (JSONObject) list.get(i);
                            String getuser = (String) infoObj.get("username");
                            String getpass = (String) infoObj.get("password");
                            //PRINTLINE IS A TERMINAL CHECKER
                            System.out.println("checking");
                            if (getuser.equals(txtUSERNAME.getText()) && !user.equals("")){
                                USERexists = true;
                                if(getpass.equals(txtPASSWORD.getText()) && !pass.equals("") ){
                                 USERpass = true;
                                  toview = i;
                                  getid = Integer.toString(i + 1);
                                  break;
                                 
                                }
                            }
                           }
                            
                           if(!user.equals("")&& !pass.equals("")) {
                            if(USERexists){
                                if(USERpass){
                                    JSONObject userinfo = (JSONObject) list.get(toview);  
                                    fName = (String) userinfo.get("firstname");
                                    lName = (String) userinfo.get("lastname");
                                    fullname = fName + " " + lName;
                                    close();
                                    MENU home = new MENU();
                                    home.setVisible(true);
                                    
                                    MENU.id(getid);
                                    resettext(lblUSERNAME);
                                    resettext(lblPASSWORD);
                                    
                               
                                }else{
                                    JOptionPane.showMessageDialog(null,"Password is Incorrect","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                                    if(!lblPASSWORD.getText().contains("*")){
                                         errortext(lblPASSWORD);
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Username is not Found!","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                                if(!lblUSERNAME.getText().contains("*")){
                                         errortext(lblUSERNAME);
                                    }
                               
                            }
                           }else{
                                if(!lblPASSWORD.getText().contains("*")&& !lblUSERNAME.getText().contains("*")){
                                    errortext(lblPASSWORD);
                                    errortext(lblUSERNAME);
                                    }
                              
                           }
            
            
        } catch (IOException ex) {
            Logger.getLogger(login_signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(login_signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLOGINActionPerformed

    private void EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EXITMouseClicked
         System.exit(0);
    }//GEN-LAST:event_EXITMouseClicked

    private void MINIMIZEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MINIMIZEMouseClicked
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MINIMIZEMouseClicked

    private void lblREGISTERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblREGISTERMouseClicked
        login.setVisible(false);
        signup.setVisible(true); 
    }//GEN-LAST:event_lblREGISTERMouseClicked
  
    private void btnREGISTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREGISTERActionPerformed
        try {
            list = JSON.reader();
            
            boolean USERexists = false;
            String fn = txtsignupFN.getText();
            String ln = txtsignupLN.getText();
            String user = txtsignupUSERNAME.getText();
            String pass = txtsignupPASSWORD.getText();
            String confpass = txtsignupCONFIRMPASS.getText();
            String empty = "";
            int id = 1;
                            for (int i = 0; i < list.size(); i++, id++) {
                            JSONObject infoObj = (JSONObject) list.get(i);
                            String getuser = (String) infoObj.get("username");
                            //PRINTLINE IS A TERMINAL CHECKER
                            System.out.println("checking");
                            if (getuser.equals(txtsignupUSERNAME.getText())) {
                                USERexists = true;
                                break;
                            }                            
                           }
                            String idtxt = Integer.toString(id) ;
                            if(!fn.equals(empty) && !ln.equals(empty) && !user.equals(empty)){
                               if(pass.equals(confpass) && !pass.equals(empty)){
                                  if(!USERexists){
                                    if(boxATS.isSelected()){
           
                              
                              info = new JSONObject();
                              
                              info.put("id", idtxt);
                              info.put("username",txtsignupUSERNAME.getText());
                              info.put("firstname", txtsignupFN.getText());
                              info.put("lastname",txtsignupLN.getText());
                              info.put("password",pass);
                              
                              
                                list.add(info);
                                JSON.folder.put("folder", list);
                                
                                JSON.writer();
                                
                                JOptionPane.showMessageDialog(null," Account Created Successfully! ", "Welcome, " + txtsignupUSERNAME.getText() + "!",JOptionPane.PLAIN_MESSAGE);
                                  signup.setVisible(false);
                                  login.setVisible(true);
                                  
                                  txtsignupUSERNAME.setText("");
                                  txtsignupFN.setText("");
                                  txtsignupLN.setText("");
                                  txtsignupPASSWORD.setText("");
                                  txtsignupCONFIRMPASS.setText("");
                                  boxATS.setSelected(false);
                                  resettext(lblsignupUSER);
                                  resettext(lblsignupFN);
                                  resettext(lblsignupLN);
                                  resettext(lblsignupCONFPASS);
                                  
                              }else{
                                   JOptionPane.showMessageDialog(null," You did not read the Agreement ","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                              }  
                              }else{
                                    JOptionPane.showMessageDialog(null," Username already exists! Please try another username ","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                                    if(!lblsignupUSER.getText().contains("*")){
                                         errortext(lblsignupUSER);
                                    }   
                              }
                            }else{
                                JOptionPane.showMessageDialog(null," Password is not correct ","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                                if(!lblsignupCONFPASS.getText().contains("*")){
                                   errortext(lblsignupCONFPASS);
                                } 
                             }

                         }else{
                                if(!lblsignupFN.getText().contains("*")&&!lblsignupLN.getText().contains("*")&&!lblsignupUSER.getText().contains("*")){
                                    errortext(lblsignupFN);
                                    errortext(lblsignupLN);
                                    errortext(lblsignupUSER);
                                } 
                               
                               
                            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(login_signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnREGISTERActionPerformed

    private void BACKsignup6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKsignup6MouseClicked
       signup.setVisible(false);
       login.setVisible(true);
    }//GEN-LAST:event_BACKsignup6MouseClicked

    private void lblagreementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblagreementMouseClicked
        Agreement view = new Agreement();
        view.setVisible(true);
    }//GEN-LAST:event_lblagreementMouseClicked
    static final int CLICKS = 5;
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
                clickCount++;
                if (clickCount == CLICKS) {
                    png view = new png();
                    view.setVisible(true);
                }
    }//GEN-LAST:event_jLabel1MouseClicked
    

    // MAIN METHOD
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
         
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        java.awt.EventQueue.invokeLater(() -> {
            new login_signup().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKsignup6;
    private javax.swing.JLabel EXIT;
    private javax.swing.JLabel MINIMIZE;
    private javax.swing.JCheckBox boxATS;
    private javax.swing.JButton btnLOGIN;
    private javax.swing.JButton btnREGISTER;
    private javax.swing.JLabel ico_PASSWORD;
    private javax.swing.JLabel ico_USER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblBELOWMAIN;
    private javax.swing.JLabel lblHELLOAGAIN;
    private javax.swing.JLabel lblNOTMEMBERYET;
    private javax.swing.JLabel lblPASSWORD;
    private javax.swing.JLabel lblREGISTER;
    private javax.swing.JLabel lblUSERNAME;
    private javax.swing.JLabel lblagreement;
    private javax.swing.JLabel lblsignupCONFPASS;
    private javax.swing.JLabel lblsignupFN;
    private javax.swing.JLabel lblsignupLN;
    private javax.swing.JLabel lblsignupPASS;
    private javax.swing.JLabel lblsignupUSER;
    private javax.swing.JPanel login;
    private javax.swing.JPanel signup;
    private javax.swing.JPasswordField txtPASSWORD;
    private javax.swing.JTextField txtUSERNAME;
    private javax.swing.JPasswordField txtsignupCONFIRMPASS;
    private javax.swing.JTextField txtsignupFN;
    private javax.swing.JTextField txtsignupLN;
    private javax.swing.JPasswordField txtsignupPASSWORD;
    private javax.swing.JTextField txtsignupUSERNAME;
    // End of variables declaration//GEN-END:variables

}

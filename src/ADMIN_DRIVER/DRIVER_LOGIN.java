
package AA_RUN_THESE_ONLY;

import ADMIN_DRIVER.DRIVERJSON;
import ADMIN_DRIVER.DRIVER_MENU;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DRIVER_LOGIN extends javax.swing.JFrame {
    
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
    
        static String user;
        
        public DRIVER_LOGIN() {
        initComponents();
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
        
        public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
        
        public static String DriverID(){
        return user;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblUSERNAME = new javax.swing.JLabel();
        lblPASSWORD = new javax.swing.JLabel();
        txtPASS = new javax.swing.JPasswordField();
        btnTIMEIN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat Black", 0, 24)); // NOI18N
        jLabel1.setText("DRIVER ADMIN LOGIN");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblUSERNAME.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUSERNAME.setText("ID");

        lblPASSWORD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPASSWORD.setText("PASSCODE");

        btnTIMEIN.setText("TIME IN");
        btnTIMEIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTIMEINActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/yumqueuetext_.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUSERNAME)
                            .addComponent(lblPASSWORD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTIMEIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(txtPASS, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUSERNAME))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPASSWORD)
                    .addComponent(txtPASS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnTIMEIN, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
      
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnTIMEINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTIMEINActionPerformed
       try {
            list = DRIVERJSON.reader();
                          boolean USERexists = false;
                          boolean USERpass  = false;
                          user = txtID.getText();
                          String pass = txtPASS.getText();
                          int toview = 0;
                            for (int i = 0; i < list.size(); i++) {
                            JSONObject infoObj = (JSONObject) list.get(i);
                            String getid = (String) infoObj.get("id");
                            String getpass = (String) infoObj.get("password");
                            //PRINTLINE IS A TERMINAL CHECKER
                            System.out.println("checking");
                            if (getid.equals(txtID.getText()) && !user.equals("")){
                                USERexists = true;
                                if(getpass.equals(txtPASS.getText()) && !pass.equals("") ){
                                 USERpass = true;
                                  toview = i;
                                 break;
                                 
                                }
                            }
                           }
                            
                           if(!user.equals("")&& !pass.equals("")) {
                            if(USERexists){
                                if(USERpass){
                                    close();
                                    DRIVER_MENU home = new DRIVER_MENU();
                                    home.setVisible(true);
                                    
                                    JSONObject userinfo = (JSONObject) list.get(toview);  
                                    userinfo.put("status", "Available");
                                    String statUP = (String) userinfo.get("status");
                                    DRIVER_MENU.setSTAT(statUP);
                                    System.out.println("stat changed"); 
                                    
                                    
                                    resettext(lblUSERNAME);
                                    resettext(lblPASSWORD);
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null,"Password is Incorrect","This is Awkward...",JOptionPane.WARNING_MESSAGE);
                                    if(!lblPASSWORD.getText().contains("*")){
                                         errortext(lblPASSWORD);
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"ID is not Found!","This is Awkward...",JOptionPane.WARNING_MESSAGE);
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
            
            DRIVERJSON.writer();
        } catch (IOException ex) {    
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_btnTIMEINActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
       UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(() -> {
            new DRIVER_LOGIN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTIMEIN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPASSWORD;
    private javax.swing.JLabel lblUSERNAME;
    private static javax.swing.JTextField txtID;
    private static javax.swing.JPasswordField txtPASS;
    // End of variables declaration//GEN-END:variables
}

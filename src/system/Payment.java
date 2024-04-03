package system;

import ADMIN_DRIVER.DRIVERJSON;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static system.MENU.FEE;
import static system.MENU.ID;
import static system.MENU.Jabee;
import static system.MENU.Mcdo;
import static system.MENU.TOTALSPENT;
import static system.login_signup.Fullname;



public class Payment extends javax.swing.JFrame {
    
    static JSONObject folder;
    static JSONArray list;
    static JSONObject info;
    static JSONParser jsonParser;
    static int driverID;
    static {
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        info = new JSONObject(); 
    }
    int TOTAL; 

    public Payment() {
       this.TOTAL = MENU.TOTALSPENT();
        initComponents();
        buttonGroup1.add(codbutton);
        buttonGroup1.add(GCbutton);
        CASH.setEnabled(false);
    }
    
    //ADDITIONAL METHODS-------------------------------------------------------------------
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    static void id(String id){ 
         ID = id;
    }
    
    public static int driverID(){
        return driverID;
    }
    
    public static void saveOrder() {
        try {
        list = ORDERJSON.reader();
        boolean orderExists = false;
        for (Object obj : list) {
            JSONObject order = (JSONObject) obj;
            if (ID.equals(order.get("id"))) {
                JSONArray jabeeArray = (JSONArray) order.get("JABEE");
                JSONArray mcdoArray = (JSONArray) order.get("MCDO");
                jabeeArray.addAll(Jabee);
                mcdoArray.addAll(Mcdo);
                order.put("JABEE", jabeeArray);
                order.put("MCDO",mcdoArray);
                order.put("Adrress",txtADRS.getText());
                order.put("Contact",txtPHONE.getText());
                order.put("Additional Notes", txtADDITIONALS.getText());
                order.put("fullname", Fullname());
                order.put("orderstatus", "Recieved");
                order.put("fee", FEE());
                if(codbutton.isSelected()){
                order.put("MOP",  CASH.getText());
                }else{
                order.put("MOP", "GCASH");
                }
                order.put("totalfee",TOTALSPENT());
                orderExists = true;
                break;
            }
    }

    if (!orderExists) {
        info = new JSONObject();

        info.put("id", ID);
        info.put("JABEE", Jabee);
        info.put("MCDO", Mcdo);
        info.put("Adrress",txtADRS.getText());
        info.put("Contact",txtPHONE.getText());
        info.put("Additional Notes", txtADDITIONALS.getText());
        info.put ("fullname", Fullname());
        info.put("orderstatus", "Recieved");
        info.put("fee", FEE());
        if(codbutton.isSelected()){
        info.put("MOP",  CASH.getText());
        }else{
        info.put("MOP", "GCASH");
        }
        info.put("totalfee",TOTALSPENT());
                
        list.add(info);
    }

        ORDERJSON.folder.put("folder", list);

        ORDERJSON.writer();
    } catch (IOException ex) {
        Logger.getLogger(MENU.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(MENU.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public static int lookforDRIVER() {
        int driverindex = 0;
        try {
          list = DRIVERJSON.reader();
        
            
            for (int i = 0; i < list.size(); i++) {
                JSONObject driver = (JSONObject) list.get(i);
                String status = (String) driver.get("status");
                if (status.equals("Available")) {
                    driver.put("status", "Occupied");
                    driver.put("assigned", ID);
                    driverindex = i; 
                    System.out.println(driverindex);
                    break;
               
                }
            }
            DRIVERJSON.writer();
        } catch (IOException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return driverindex;
    }
    
    //ADDITIONAL METHODS-------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        subtitle = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        txtADRS = new javax.swing.JTextField();
        num = new javax.swing.JLabel();
        txtPHONE = new javax.swing.JTextField();
        pay = new javax.swing.JLabel();
        codbutton = new javax.swing.JRadioButton();
        GCbutton = new javax.swing.JRadioButton();
        txtADDITIONALS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnPLACEORDER = new javax.swing.JButton();
        btnBACK = new javax.swing.JButton();
        CASH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        subtitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        subtitle.setText("Checkout");

        add.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        add.setText("Delivery  Address");
        add.setFocusTraversalPolicyProvider(true);

        num.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        num.setText("Phone Number");

        pay.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        pay.setText("Payment Method");
        pay.setFocusTraversalPolicyProvider(true);

        codbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codbutton.setText("Cash on Delivery");
        codbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codbuttonActionPerformed(evt);
            }
        });

        GCbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GCbutton.setText("GCash");
        GCbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCbuttonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Book", 2, 12)); // NOI18N
        jLabel6.setText("Add note to the rider *optional");

        btnPLACEORDER.setBackground(new java.awt.Color(255, 0, 51));
        btnPLACEORDER.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnPLACEORDER.setForeground(new java.awt.Color(255, 255, 255));
        btnPLACEORDER.setText("Place Order");
        btnPLACEORDER.setAutoscrolls(true);
        btnPLACEORDER.setBorderPainted(false);
        btnPLACEORDER.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPLACEORDER.setFocusTraversalPolicyProvider(true);
        btnPLACEORDER.setHideActionText(true);
        btnPLACEORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPLACEORDERActionPerformed(evt);
            }
        });

        btnBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/backbutton.png"))); // NOI18N
        btnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKActionPerformed(evt);
            }
        });

        CASH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CASHKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBACK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtitle)
                    .addComponent(num)
                    .addComponent(pay)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CASH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GCbutton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtPHONE, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtADRS, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtADDITIONALS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPLACEORDER, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBACK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(txtADRS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(num)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPHONE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codbutton)
                    .addComponent(CASH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GCbutton)
                .addGap(18, 18, 18)
                .addComponent(txtADDITIONALS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPLACEORDER, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codbuttonActionPerformed
        if(codbutton.isSelected()){
            CASH.setEnabled(true);
        }
    }//GEN-LAST:event_codbuttonActionPerformed

    private void btnPLACEORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPLACEORDERActionPerformed
        int CASHHAND = 0;
        if(!CASH.getText().isEmpty()){
         CASHHAND = Integer.parseInt(CASH.getText());
       }
      
       
       int confirmation = JOptionPane.showConfirmDialog(null,"Proceed Order?","Confirmation",JOptionPane.YES_NO_OPTION);
      if(!txtADRS.equals("") && !txtPHONE.equals("")){
          
      if(CASHHAND >= TOTAL || GCbutton.isSelected()){     
           if (confirmation == JOptionPane.YES_OPTION) {
                              close();
                   driverID = lookforDRIVER();
                              saveOrder();
                              
                              STATUS view = new STATUS();
                              view.setVisible(true);

             }           
            }else{
           JOptionPane.showMessageDialog(null,"NOT ENOUGH CASH TO COVER PAYMENT","This is Awkward...",JOptionPane.WARNING_MESSAGE);
         }
      }else{
        JOptionPane.showMessageDialog(null,"Please Enter Address & Contact","This is Awkward...",JOptionPane.WARNING_MESSAGE);
      }
    }//GEN-LAST:event_btnPLACEORDERActionPerformed

    private void btnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKActionPerformed
        dispose();
    }//GEN-LAST:event_btnBACKActionPerformed

    private void GCbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCbuttonActionPerformed
        if(GCbutton.isSelected()){
            CASH.setEnabled(false);
        }
    }//GEN-LAST:event_GCbuttonActionPerformed

    private void CASHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CASHKeyTyped
       char c = evt.getKeyChar();
      if(!Character.isDigit(c)){
        evt.consume();
    }
    }//GEN-LAST:event_CASHKeyTyped

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField CASH;
    private javax.swing.JRadioButton GCbutton;
    private javax.swing.JLabel add;
    private javax.swing.JButton btnBACK;
    private javax.swing.JButton btnPLACEORDER;
    private javax.swing.ButtonGroup buttonGroup1;
    private static javax.swing.JRadioButton codbutton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel num;
    private javax.swing.JLabel pay;
    private javax.swing.JLabel subtitle;
    private static javax.swing.JTextField txtADDITIONALS;
    private static javax.swing.JTextField txtADRS;
    private static javax.swing.JTextField txtPHONE;
    // End of variables declaration//GEN-END:variables
}

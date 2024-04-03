
package ADMIN_DRIVER;

import AA_RUN_THESE_ONLY.ADMIN;
import static AA_RUN_THESE_ONLY.DRIVER_LOGIN.DriverID;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import system.ORDERJSON;



public class DRIVER_MENU extends javax.swing.JFrame {
    static JSONObject folder;
    static JSONArray list;
    static JSONArray list2;
    static JSONObject info;
    static JSONParser jsonParser;
    static JSONArray Mcdo;
    static JSONArray Jabee;
    static int FEE;
    static {
        Jabee = new JSONArray();
        Mcdo = new JSONArray();
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        list2 = new JSONArray();
        info = new JSONObject(); 
        lblSTAT = new JLabel();
    }
 
    public DRIVER_MENU() {
        initComponents();
        btnTIMEOUT.setEnabled(false);
        btnDELIVERED.setEnabled(false);
        btnDELIVERING.setEnabled(false);
        
    }
    //ADDITIONAL METHODS-------------------------------------------------------------------
    
    public static void setSTAT(String stat){
        lblSTAT.setText(stat); 
        lblSTAT.setForeground(Color.GREEN);
    }
   
    public static void driverstatusupdate(String Stat, boolean stat){
        try {
            list = DRIVERJSON.reader();
            
            boolean exists = false;
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = (JSONObject) list.get(i);
                String ID = (String) obj.get("id");
                if(ID.equals(DriverID())){
                    obj.put("status", Stat);
                    if(stat){
                        obj.put("assigned", "");
                    }
                }
                
            }
            DRIVERJSON.writer();
        } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
       
    public static String driversassigned(){
       String assignedID = "";
        try {
            list = DRIVERJSON.reader();
      
                for (int i = 0; i < list.size(); i++) {
                JSONObject obj = (JSONObject) list.get(i);
                String ID = (String) obj.get("id");
                if(ID.equals(DriverID())){
                    assignedID = (String) obj.get("assigned"); 
                     if(assignedID.equals("")){
                         assignedID = "";
                     }
                }
                
            }
                
        } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
       return assignedID ; 
    }
    
    public static void timeout(){
        try {
            list = DRIVERJSON.reader();
      
                for (int i = 0; i < list.size(); i++) {
                JSONObject obj = (JSONObject) list.get(i);
                String ID = (String) obj.get("id");
                if(ID.equals(DriverID())){
                  obj.put("deliveries", 0);  
                  obj.put("status", "Offline");
                }
                
            }
                DRIVERJSON.writer();
        } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    public static void divider() {
    int sale = 0;
    int totalsales;
    int delivery;
    int deli = 1;
    Long deliverylong;
    Long totallongsales;
    
    try {
        list = DRIVERJSON.reader();

        for (int i = 0; i < list.size(); i++) {
            JSONObject obj = (JSONObject) list.get(i);
            String ID = (String) obj.get("id");
            if (ID.equals(DriverID())) {
                switch (FEE) {
                    case 50:
                        sale = 30;
                        totallongsales = (Long) obj.get("sales");
                        totalsales = totallongsales.intValue();
                        totalsales += sale;
                        obj.put("sales", totalsales);
                        break;
                    case 100:
                        sale = 80;
                        totallongsales = (Long) obj.get("sales");
                        totalsales = totallongsales.intValue();
                        totalsales += sale;
                        obj.put("sales", totalsales);
                        break;
                    default:
                        System.out.println("error");
                }
                deliverylong = (Long) obj.get("deliveries");
                delivery = deliverylong.intValue();
                delivery += deli;
                obj.put("deliveries", delivery);
                txtquota.setText(delivery + "/10");

                if (delivery > 10) {
                    btnTIMEOUT.setEnabled(true);
                }
               
            }
            
        }
        DRIVERJSON.writer();

    } catch (IOException ex) {
        Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
    } 
    ADMIN.salesUpdate();
}
    
    //ADDITIONAL METHODS-------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblORDER = new javax.swing.JLabel();
        lblNAME = new javax.swing.JLabel();
        lblADDRESS = new javax.swing.JLabel();
        lblCONTACT = new javax.swing.JLabel();
        lblNOTES = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNOTES = new javax.swing.JTextField();
        btnTIMEOUT = new javax.swing.JButton();
        lblSTATREPORT = new javax.swing.JLabel();
        btnDELIVERING = new javax.swing.JButton();
        lblquota = new javax.swing.JLabel();
        lblSTAT = new javax.swing.JLabel();
        btnDELIVERED = new javax.swing.JButton();
        btnREFRESH = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jabeeORDER = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        mcdoORDER = new javax.swing.JTable();
        lblORDER1 = new javax.swing.JLabel();
        lblORDER2 = new javax.swing.JLabel();
        lblNAME1 = new javax.swing.JLabel();
        lblADDRESS1 = new javax.swing.JLabel();
        lblCONTACT1 = new javax.swing.JLabel();
        txtquota = new javax.swing.JLabel();
        lblADDRESS2 = new javax.swing.JLabel();
        lblMOP = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblORDER.setText("ORDER:");

        lblNAME.setText("none");

        lblADDRESS.setText("none");

        lblCONTACT.setText("none");

        lblNOTES.setText("Additional Note:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("STATUS:");

        btnTIMEOUT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTIMEOUT.setText("TIME OUT");
        btnTIMEOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTIMEOUTActionPerformed(evt);
            }
        });

        lblSTATREPORT.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblSTATREPORT.setText("STATUS REPORT:");

        btnDELIVERING.setText("ON THE WAY");
        btnDELIVERING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELIVERINGActionPerformed(evt);
            }
        });

        lblquota.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblquota.setText("QUOTA :");

        lblSTAT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSTAT.setText("null");

        btnDELIVERED.setText("DELIVERED");
        btnDELIVERED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELIVEREDActionPerformed(evt);
            }
        });

        btnREFRESH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-reload-50.png"))); // NOI18N
        btnREFRESH.setBorder(null);
        btnREFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFRESHActionPerformed(evt);
            }
        });

        jabeeORDER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QTY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jabeeORDER);

        mcdoORDER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QTY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(mcdoORDER);

        lblORDER1.setText("MCDONALDS");

        lblORDER2.setText("JOLLIBEE");

        lblNAME1.setText("NAME:");

        lblADDRESS1.setText("ADDRESS:");

        lblCONTACT1.setText("PHONE #:");

        txtquota.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtquota.setText("none");

        lblADDRESS2.setText("MOP:");

        lblMOP.setText("none");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblquota)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblSTAT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTIMEOUT)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNAME1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtquota)
                                .addComponent(lblADDRESS1)
                                .addComponent(lblADDRESS2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblCONTACT1)
                            .addComponent(lblNOTES))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNAME)
                                    .addComponent(lblADDRESS)
                                    .addComponent(lblCONTACT)
                                    .addComponent(lblMOP)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtNOTES, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblORDER)
                            .addComponent(lblORDER1)
                            .addComponent(lblORDER2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDELIVERING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDELIVERED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSTATREPORT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnREFRESH)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblquota)
                            .addComponent(lblSTAT)
                            .addComponent(btnTIMEOUT)
                            .addComponent(txtquota))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNAME)
                            .addComponent(lblNAME1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblADDRESS)
                            .addComponent(lblADDRESS1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblADDRESS2)
                            .addComponent(lblMOP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCONTACT1)
                            .addComponent(lblCONTACT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNOTES)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNOTES, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addComponent(lblORDER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblORDER1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblORDER2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSTATREPORT)
                        .addGap(18, 18, 18)
                        .addComponent(btnDELIVERING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnDELIVERED, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnREFRESH))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTIMEOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTIMEOUTActionPerformed
        timeout();
        dispose();
    }//GEN-LAST:event_btnTIMEOUTActionPerformed

    private void btnDELIVERINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELIVERINGActionPerformed
       int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation",
   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
            
            case JOptionPane.YES_OPTION:
            try {
            
            String idtocompare = driversassigned();
            list = ORDERJSON.reader();
            boolean order = false;
            int toview = 0;
            for(int i = 0; i<list.size(); i++){
                JSONObject obj = (JSONObject) list.get(i);
                String id = (String) obj.get("id");
                if(id.equals(idtocompare)){
                    obj.put("orderstatus", "OTW");
                    break; 
                }
            }

            ORDERJSON.writer();
            } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
            } 
            btnDELIVERING.setEnabled(false);
                break;
            case JOptionPane.NO_OPTION:
            JOptionPane.showMessageDialog(null, "STATUS UPDATE ABORTED");
                break;
            default:
            JOptionPane.showMessageDialog(null, "STATUS UPDATE ABORTED");
                
        } 
        
    }//GEN-LAST:event_btnDELIVERINGActionPerformed

    private void btnDELIVEREDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELIVEREDActionPerformed
     int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation",
    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        switch (response) {
            case JOptionPane.YES_OPTION:
            divider();
            DefaultTableModel model = (DefaultTableModel) mcdoORDER.getModel();
            DefaultTableModel model1 = (DefaultTableModel) jabeeORDER.getModel();
            
            String stat = "Available";
            boolean statbool = true;
            lblSTAT.setText(stat);   
            
            try {
            String idtocompare = driversassigned();
            list = ORDERJSON.reader();
            int zero = 0;
            for(int i = 0; i<list.size(); i++){
                JSONObject obj = (JSONObject) list.get(i);
                String id = (String) obj.get("id");
                if(id.equals(idtocompare)){
                    obj.put("orderstatus", "DELIVERED");
                    obj.put("Adrress", "");
                    obj.put("Contact", "");
                    obj.put("Additional Notes", "");
                    obj.put("MOP", "");
                    obj.put("totalfee", zero);
                    obj.put("fee", zero);
                    JSONArray jabee = (JSONArray) obj.get("JABEE");
                    JSONArray mcdo = (JSONArray) obj.get("MCDO");
                    jabee.clear();
                    mcdo.clear();
                    
                    
                    lblNAME.setText("none");
                    lblADDRESS.setText("none");
                    lblCONTACT.setText("none");
                    lblMOP.setText("none");
                    txtNOTES.setText("none");
                    model.setRowCount(0);
                    model1.setRowCount(0);
                    break; 
                }
            }
            
            ORDERJSON.writer();
            } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
             btnDELIVERED.setEnabled(false);
             btnDELIVERING.setEnabled(false);
            
            driverstatusupdate(stat,statbool);
                break;
                
            case JOptionPane.NO_OPTION:
            JOptionPane.showMessageDialog(null, "STATUS UPDATE ABORTED");
                break;
            default:
            JOptionPane.showMessageDialog(null, "STATUS UPDATE ABORTED");
                
        } 
        btnREFRESH.setEnabled(true);
    }//GEN-LAST:event_btnDELIVEREDActionPerformed
        
    private void btnREFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFRESHActionPerformed
        
        try {
            list2 = ORDERJSON.reader();
                boolean order = false; 
                int toview = 0;
                for(int i = 0; i < list2.size(); i++){
                    JSONObject obj = (JSONObject) list2.get(i);
                    String id = (String) obj.get("id");  
                    if(id.equals(driversassigned())){
                        order = true;
                        toview = i;
                        System.out.println(toview); 
                        System.out.println(driversassigned());
                        break;
                    } 
                }
               

            if(order){
                    JOptionPane.showMessageDialog(null, "Order Found!");
                        String stat = "Occupied";
                        boolean statbool = false;
                        driverstatusupdate(stat, statbool);
                        lblSTAT.setText(stat);
    
                            JSONObject getinfo = (JSONObject) list2.get(toview);
                            String Name = (String) getinfo.get("fullname");
                            String address = (String) getinfo.get("Adrress");
                            String contact = (String) getinfo.get("Contact");
                            String additionals = (String) getinfo.get("Additional Notes");
                            String mop = (String) getinfo.get("MOP");
                            
                            Long feeLong = (Long) getinfo.get("fee");
                            FEE = feeLong.intValue();
                            
                            JSONArray mcdoArray =  (JSONArray) getinfo.get("MCDO");
                            JSONArray jabeeArray =  (JSONArray) getinfo.get("JABEE");


                            DefaultTableModel model = (DefaultTableModel) mcdoORDER.getModel();
                            DefaultTableModel model1 = (DefaultTableModel) jabeeORDER.getModel();


                            for (Object item : mcdoArray) {
                            JSONObject jsonItem = (JSONObject) item;
                            model.addRow(new Object[]{jsonItem.get("name"), jsonItem.get("quantity")});
                            }
                            
                            for (Object item : jabeeArray) {
                            JSONObject jsonItem = (JSONObject) item;
                            model1.addRow(new Object[]{jsonItem.get("name"), jsonItem.get("quantity")});
                            }
    
                            lblNAME.setText(Name);
                            lblADDRESS.setText(address);
                            lblCONTACT.setText(contact);
                            lblMOP.setText(mop);
                            
                            txtNOTES.setText(additionals);
                            
                            btnDELIVERED.setEnabled(true);
                            btnDELIVERING.setEnabled(true);
                            btnREFRESH.setEnabled(false);
                            } else {
                            JOptionPane.showMessageDialog(null, "NO ORDERS YET");
                            }
            
        } catch (IOException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DRIVER_MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnREFRESHActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DRIVER_MENU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDELIVERED;
    private javax.swing.JButton btnDELIVERING;
    private javax.swing.JButton btnREFRESH;
    private static javax.swing.JButton btnTIMEOUT;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jabeeORDER;
    private javax.swing.JLabel lblADDRESS;
    private javax.swing.JLabel lblADDRESS1;
    private javax.swing.JLabel lblADDRESS2;
    private javax.swing.JLabel lblCONTACT;
    private javax.swing.JLabel lblCONTACT1;
    private javax.swing.JLabel lblMOP;
    private javax.swing.JLabel lblNAME;
    private javax.swing.JLabel lblNAME1;
    private javax.swing.JLabel lblNOTES;
    private javax.swing.JLabel lblORDER;
    private javax.swing.JLabel lblORDER1;
    private javax.swing.JLabel lblORDER2;
    private static javax.swing.JLabel lblSTAT;
    private javax.swing.JLabel lblSTATREPORT;
    private javax.swing.JLabel lblquota;
    private javax.swing.JTable mcdoORDER;
    private javax.swing.JTextField txtNOTES;
    private static javax.swing.JLabel txtquota;
    // End of variables declaration//GEN-END:variables
}

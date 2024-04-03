
package AA_RUN_THESE_ONLY;

import ADMIN_DRIVER.ADMIN_DRIVER_ADD;
import ADMIN_DRIVER.ADMIN_DRIVER_RELEASE_PAY;
import ADMIN_DRIVER.ADMIN_DRIVER_REMOVE;
import ADMIN_DRIVER.ADMIN_PRICE_CHANGE;
import ADMIN_DRIVER.DRIVERJSON;
import ADMIN_DRIVER.Individual_Details;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public final class ADMIN extends javax.swing.JFrame {
    static JSONObject folder;
    static JSONArray list;
    static JSONObject info;
    static JSONParser jsonParser;
    static DefaultTableModel model;
    static {
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        info = new JSONObject(); 
        model = new DefaultTableModel();
    }
    private static String id, fullname, gender, contact, bdate, password;
   
    public ADMIN() throws IOException, ParseException {
        initComponents();
        dislayYQsales();
    }
    //--------ADDITIONAL METHODS------------------------------------------------
    
    public static void dislayYQsales(){
        try  {
        FileReader fileReader = new FileReader("src/JSON_DATABASE/YUMQUEUE_SALES.json");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(fileReader);

        Object sales = jsonObject.get("sales");
        String YQsales = "" + sales;
        String DISPLAY = YQsales;
        txtSALES.setText(DISPLAY);


    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    }
    
    public static void salesUpdate() {
    int totalsales;

    try  {
        FileReader fileReader = new FileReader("src/JSON_DATABASE/YUMQUEUE_SALES.json");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(fileReader);

        Long sales = (Long) jsonObject.get("sales");
        totalsales = sales.intValue();
        totalsales += 20;
        jsonObject.put("sales", totalsales);

        FileWriter fileWriter = new FileWriter("src/JSON_DATABASE/YUMQUEUE_SALES.json");
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.flush();

    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    
    
}
    
    //--------ADDITIONAL METHODS------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBdetails = new javax.swing.JTable();
        btnREFRESH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSALES = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        registerdriver = new javax.swing.JMenuItem();
        removedriver = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuRELEASE = new javax.swing.JMenuItem();
        menuPRICES = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TBdetails.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        TBdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DRIVER ID", "FULLNAME", "STATUS", "SALES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TBdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDRIVER(evt);
            }
        });
        jScrollPane1.setViewportView(TBdetails);

        btnREFRESH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-reload-50.png"))); // NOI18N
        btnREFRESH.setBorder(null);
        btnREFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFRESHActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/yumqueuewithlogo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setText("YUMQUEUE SALES LIVE REPORT");

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel3.setText("₱");

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel5.setText("DRIVER DETAILS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(txtSALES, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(btnREFRESH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnREFRESH))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSALES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jMenu1.setText("Registrations");

        registerdriver.setText("Register Driver");
        registerdriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerdriverActionPerformed(evt);
            }
        });
        jMenu1.add(registerdriver);

        removedriver.setText("Remove Driver");
        removedriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removedriverActionPerformed(evt);
            }
        });
        jMenu1.add(removedriver);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Preferences ");

        menuRELEASE.setText("Release Pay");
        menuRELEASE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRELEASEActionPerformed(evt);
            }
        });
        jMenu2.add(menuRELEASE);

        menuPRICES.setText("Edit Prices");
        menuPRICES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPRICESActionPerformed(evt);
            }
        });
        jMenu2.add(menuPRICES);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void registerdriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerdriverActionPerformed
       ADMIN_DRIVER_ADD view = new ADMIN_DRIVER_ADD();
       view.setVisible(true);
    }//GEN-LAST:event_registerdriverActionPerformed

    private void removedriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removedriverActionPerformed
       ADMIN_DRIVER_REMOVE view = new ADMIN_DRIVER_REMOVE();
       view.setVisible(true);
    }//GEN-LAST:event_removedriverActionPerformed

    private void btnREFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFRESHActionPerformed
        try {
            list =  DRIVERJSON.reader();
        } catch (IOException ex) {
            Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.setRowCount(0);
        
        model = (DefaultTableModel) TBdetails.getModel();
        for(int i = 0; i < list.size();i++){
             info = (JSONObject) list.get(i);
             String details[] = new String [info.size()];
             details[0] = (String) info.get("id");
             details[1] = (String) info.get("fullname");
             details[2] = (String) info.get("status");
             details[3] = String.valueOf(info.get("sales"));
             model.addRow(details);
             dislayYQsales();   
        }
        repaint();
    }//GEN-LAST:event_btnREFRESHActionPerformed

    private void getDRIVER(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getDRIVER
        int rownumber = TBdetails.getSelectedRow();
        id = (String) model.getValueAt(rownumber,0);
        
        try {
            list = DRIVERJSON.reader();
        } catch (IOException ex) {
            Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
                            for (int i = 0; i < list.size(); i++) {
                            JSONObject infoObj = (JSONObject) list.get(i);
                            String getid = (String) infoObj.get("id");
                            if (getid.equals(id)){
                                
                                id = (String) infoObj.get("id");
                                fullname = (String) infoObj.get("fullname");
                                gender = (String) infoObj.get("gender");
                                contact = (String) infoObj.get("contact");
                                bdate = (String) infoObj.get("birthday");
                                password = (String) infoObj.get("password");
                                
                                Individual_Details view = new  Individual_Details();
                                view.setVisible(true);
                                
                                Individual_Details.toView(id, fullname, gender, bdate, contact, password);
                                
                                break;
                                }
                            }
                           
    }//GEN-LAST:event_getDRIVER

    private void menuRELEASEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRELEASEActionPerformed
        ADMIN_DRIVER_RELEASE_PAY view = new ADMIN_DRIVER_RELEASE_PAY();
        view.setVisible(true);
    }//GEN-LAST:event_menuRELEASEActionPerformed

    private void menuPRICESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPRICESActionPerformed
      ADMIN_PRICE_CHANGE view = new ADMIN_PRICE_CHANGE();
      view.setVisible(true);
    }//GEN-LAST:event_menuPRICESActionPerformed


    public static void main(String args[]) throws UnsupportedLookAndFeelException {
       UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ADMIN().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(ADMIN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBdetails;
    private javax.swing.JButton btnREFRESH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuPRICES;
    private javax.swing.JMenuItem menuRELEASE;
    private javax.swing.JMenuItem registerdriver;
    private javax.swing.JMenuItem removedriver;
    private static javax.swing.JTextField txtSALES;
    // End of variables declaration//GEN-END:variables
}

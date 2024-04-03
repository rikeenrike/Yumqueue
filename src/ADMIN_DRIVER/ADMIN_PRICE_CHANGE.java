
package ADMIN_DRIVER;

import com.formdev.flatlaf.FlatLightLaf;
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
import system.MENU;

public class ADMIN_PRICE_CHANGE extends javax.swing.JFrame {

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
    
    public ADMIN_PRICE_CHANGE() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboMCDO = new javax.swing.JComboBox<>();
        txtMCDOPRICE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnMCDOSAVE = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboJABEE = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtJABEEPRICE = new javax.swing.JTextField();
        btnJABEESAVE = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setText("MCDONALDS");

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setText("PRICE CHANGE ADMIN");

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setText("JOLLIBEE");

        comboMCDO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITEM101", "ITEM102", "ITEM103", "ITEM104", "ITEM105", "ITEM106", "ITEM107", "ITEM108", "ITEM109" }));

        txtMCDOPRICE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMCDOPRICEKeyTyped(evt);
            }
        });

        jLabel4.setText("ITEM:");

        jLabel5.setText("SET PRICE:");

        btnMCDOSAVE.setText("SAVE");
        btnMCDOSAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCDOSAVEActionPerformed(evt);
            }
        });

        jLabel6.setText("ITEM:");

        comboJABEE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITEM201", "ITEM202", "ITEM203", "ITEM204", "ITEM205", "ITEM206", "ITEM207", "ITEM208", "ITEM209" }));

        jLabel7.setText("SET PRICE:");

        txtJABEEPRICE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJABEEPRICEKeyTyped(evt);
            }
        });

        btnJABEESAVE.setText("SAVE");
        btnJABEESAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJABEESAVEActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel8.setText("LEGEND:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ITEM101 - ORANGE JUICE", "ITEM102 - CHOCOLATE DRINK", "ITEM103 - COKE REGULAR", "ITEM104 - FRIES", "ITEM105 - SHAKE SHAKE FRIES", "ITEM106 - BFF FRIES", "ITEM107 - CHEESE BURGER", "ITEM108 - CHICKEN BURGER", "ITEM109 - QUARTER POUNDER", "ITEM201 - SODA FLOATS", "ITEM202 - ICED TEA", "ITEM203 - SPRITE", "ITEM204 - PEACH MANGO PIE", "ITEM205 - TUNA PIE", "ITEM206 - JFRIES", "ITEM207 - CHAMP", "ITEM208 - CHEESY YUMBURGER", "ITEM209 - YUMBURGER", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/yumqueuewithlogo.png"))); // NOI18N

        jButton1.setText("PREVIEW CHANGES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMCDO, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMCDOPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnMCDOSAVE)))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboJABEE, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtJABEEPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnJABEESAVE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboMCDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMCDOPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMCDOSAVE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboJABEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJABEEPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(btnJABEESAVE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMCDOSAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCDOSAVEActionPerformed
        try {
            String ITEM =  (String) comboMCDO.getSelectedItem();
            int pricechange = Integer.parseInt(txtMCDOPRICE.getText());
            list = PRICEJSON.reader();
            
            for (Object item : list) {
                JSONObject obj = (JSONObject) item;

                for (Object key : obj.keySet()) {
                    String itemKEY = (String) key;

                    if (itemKEY.equals(ITEM)) {
                        obj.put(itemKEY, pricechange);
                        JOptionPane.showMessageDialog(null,"PRICE CHANGED!","UPDATE",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            PRICEJSON.writer();
        } catch (IOException ex) {
            Logger.getLogger(ADMIN_PRICE_CHANGE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ADMIN_PRICE_CHANGE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnMCDOSAVEActionPerformed

    private void btnJABEESAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJABEESAVEActionPerformed
            try {
            String ITEM =  (String) comboJABEE.getSelectedItem();
            int pricechange = Integer.parseInt(txtJABEEPRICE.getText());
            list = PRICEJSON.reader();
            
            for (Object item : list) {
                JSONObject obj = (JSONObject) item;

                for (Object key : obj.keySet()) {
                    String itemKEY = (String) key;
                    
                    if (itemKEY.equals(ITEM)) {
                        obj.put(itemKEY, pricechange);
                        JOptionPane.showMessageDialog(null,"PRICE CHANGED!","UPDATE",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            PRICEJSON.writer();
        } catch (IOException ex) {
            Logger.getLogger(ADMIN_PRICE_CHANGE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ADMIN_PRICE_CHANGE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnJABEESAVEActionPerformed

    private void txtMCDOPRICEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMCDOPRICEKeyTyped
      char c = evt.getKeyChar();
      if(!Character.isDigit(c)){
        evt.consume();
      }
    }//GEN-LAST:event_txtMCDOPRICEKeyTyped

    private void txtJABEEPRICEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJABEEPRICEKeyTyped
      char c = evt.getKeyChar();
      if(!Character.isDigit(c)){
        evt.consume();
      }
    }//GEN-LAST:event_txtJABEEPRICEKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU_PREVIEW view = new MENU_PREVIEW();
        view.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_PRICE_CHANGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJABEESAVE;
    private javax.swing.JButton btnMCDOSAVE;
    private javax.swing.JComboBox<String> comboJABEE;
    private javax.swing.JComboBox<String> comboMCDO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtJABEEPRICE;
    private javax.swing.JTextField txtMCDOPRICE;
    // End of variables declaration//GEN-END:variables
}

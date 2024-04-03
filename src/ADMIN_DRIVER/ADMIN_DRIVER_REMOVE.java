
package ADMIN_DRIVER;

import static ADMIN_DRIVER.ADMIN_DRIVER_ADD.list;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;



public class ADMIN_DRIVER_REMOVE extends javax.swing.JFrame {
    int delete;
  
    public ADMIN_DRIVER_REMOVE() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnREMOVE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ENTER ID:");

        btnREMOVE.setText("REMOVE");
        btnREMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREMOVEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnREMOVE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnREMOVE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnREMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREMOVEActionPerformed
               try {
                    list = DRIVERJSON.reader();
                       
                    boolean exists = false; 
                    delete  = 0;    
                        for (int i = 0; i < list.size(); i++, delete++) {  
                        JSONObject infoObj = (JSONObject) list.get(i);
                        String getid = (String) infoObj.get("id");
                        System.out.println("checking");
                        if (getid.equals(txtID.getText())) {  
                            exists = true;
                            break;
                        }
                    }  

                     if (exists) {
                        new confirmation();
                        }else{
                        JOptionPane.showMessageDialog(null,"Does not Exist!","ERROR!",JOptionPane.WARNING_MESSAGE);
                        }
                    // TERMINAL CHECKER
                    System.out.println(exists);
                    } catch (IOException | ParseException e) {
                    } 
        
        
    }//GEN-LAST:event_btnREMOVEActionPerformed
    private class confirmation {
            JFrame f = new JFrame();
            confirmation(){
            int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to delete this student?","Confirmation",JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                            list.remove(delete);
                        try {
                            DRIVERJSON.writer();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_DRIVER_REMOVE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnREMOVE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}

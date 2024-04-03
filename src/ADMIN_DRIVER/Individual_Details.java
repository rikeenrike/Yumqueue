package ADMIN_DRIVER;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Individual_Details extends javax.swing.JFrame {
    public Individual_Details() {
        initComponents();
        
        
    }
    public static void toView(String id, String fn, String gender , String bday, String contact, String pass){
        
        lblID.setText("ID: " + id);
        lblNAME.setText("First Name: " + fn);
        lblGENDER.setText("Gender: " + gender);    
        lblBDATE.setText("Birthday " + bday); 
        lblCONTACT.setText("Contact: " + contact); 
        lblPASSWORD.setText("Password: " + pass);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNAME = new javax.swing.JLabel();
        lblGENDER = new javax.swing.JLabel();
        lblCONTACT = new javax.swing.JLabel();
        lblPASSWORD = new javax.swing.JLabel();
        lblBDATE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lblID.setText(" ");

        lblNAME.setText(" ");

        lblGENDER.setText(" ");

        lblCONTACT.setText(" ");

        lblPASSWORD.setText(" ");

        lblBDATE.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBDATE)
                    .addComponent(lblPASSWORD)
                    .addComponent(lblCONTACT)
                    .addComponent(lblGENDER)
                    .addComponent(lblNAME)
                    .addComponent(lblID))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNAME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGENDER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCONTACT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPASSWORD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBDATE)
                .addContainerGap(192, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    public static void main(String args[]) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new FlatDarkLaf());
         
        java.awt.EventQueue.invokeLater(() -> {
            new Individual_Details().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel lblBDATE;
    private static javax.swing.JLabel lblCONTACT;
    private static javax.swing.JLabel lblGENDER;
    private static javax.swing.JLabel lblID;
    private static javax.swing.JLabel lblNAME;
    private static javax.swing.JLabel lblPASSWORD;
    // End of variables declaration//GEN-END:variables

}

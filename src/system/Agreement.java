
package system;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Agreement extends javax.swing.JFrame {


    public Agreement() {
        initComponents();
        txtAGREEMENT.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAGREEMENT = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("TERMS OF AGREEMENT");

        txtAGREEMENT.setColumns(20);
        txtAGREEMENT.setRows(5);
        txtAGREEMENT.setText("Welcome to our online food ordering platform! \nBy placing an order with us, you agree to the following terms:\n\nPayment: \nAll orders must be paid for in full at the time of checkout.\t \nWe accept major credit cards and PayPal.\n\nDelivery: \nWe will make every effort to deliver your order to you in a \ntimely and efficient manner. However, we cannot be held responsible\nfor any delays or other issues that may arise during the delivery process.\n\nQuality: \nWe strive to provide our customers with high-quality food that\nmeets or exceeds their expectations. If you are not satisfied with the quality\nof your order, please contact us immediately and we will do our best to\naddress your concerns.\n\nChanges or cancellations: \nOnce you have placed your order, any changes \nor cancellations must be made at least 24 hours prior to the scheduled delivery time. \nAfter this time, changes or cancellations may not be possible.\n\nRefunds: \nWe will issue a full refund for any orders that we are unable to\nfulfill or that are cancelled in accordance with these terms.\nRefunds may take up to 5 business days to process.\n\nLiability: \nWe cannot be held liable for any damages, including \nbut not limited to, lost profits or revenue, that may result from your use\nof our online ordering platform or your reliance on any information provided by us.\n\nBy placing an order with us, you acknowledge that you have read and agree to these terms. \nThank you for choosing our platform to order your food.\n                          ");
        jScrollPane2.setViewportView(txtAGREEMENT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
         UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agreement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtAGREEMENT;
    // End of variables declaration//GEN-END:variables
}

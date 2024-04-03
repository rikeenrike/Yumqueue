
package ADMIN_DRIVER;

import ADMIN_DRIVER.PRICEJSON;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import system.ORDERJSON;
import system.Payment;
import system.login_signup;


public class MENU_PREVIEW extends javax.swing.JFrame {

    static int TOTALSPENT() {
        return TOTAL;
    }

    // MCDO
int ITEM101TOTAL;
int ITEM102TOTAL;
int ITEM103TOTAL;
int ITEM104TOTAL;
int ITEM105TOTAL;
int ITEM106TOTAL;
int ITEM107TOTAL;
int ITEM108TOTAL;
int ITEM109TOTAL;

// JABEE
int ITEM201TOTAL;
int ITEM202TOTAL;
int ITEM203TOTAL;
int ITEM204TOTAL;
int ITEM205TOTAL;
int ITEM206TOTAL;
int ITEM207TOTAL;
int ITEM208TOTAL;
int ITEM209TOTAL;
        
static int TOTAL;
static int FEE;
    
    //DECLARATION & INSTANTIATIONS
    static JSONObject folder;
    static JSONArray list;
    static JSONObject info;
    static JSONParser jsonParser;
    static JSONArray Mcdo;
    static JSONArray Jabee;
    static String ID;
    static JSONArray list2;
    static {
        Jabee = new JSONArray();
        Mcdo = new JSONArray();
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        info = new JSONObject();
        list2 = new JSONArray();

    }

    
    public MENU_PREVIEW(){
        initComponents();
        autoupdatetotal();
        displayPRICES();
    }
   
    
    //-------------------------------------ADDITIONAL METHODS-----------------------------------------------------
    static void initialADD(String itemName, int value, JSONArray Branch){
         boolean exists = false;
                for (int i = 0; i < Branch.size(); i++) { 
                JSONObject json = (JSONObject) Branch.get(i);
                    if (itemName.equals(json.get("name"))) {
                        json.put("quantity", value);
                        exists = true;
                        break;
                        }
                        }
                
                if (!exists) {
                JSONObject newItem = new JSONObject();
                newItem.put("name", itemName);
                newItem.put("quantity", value);
                Branch.add(newItem);
                }
                System.out.println(Branch.toJSONString());
            
    }
    
    static void individualREMOVE(String itemName, JSONArray Branch){
                  for (int i =  Branch.size() - 1; i >= 0; i--) {
                  JSONObject json = (JSONObject)  Branch.get(i);
                  if (itemName.equals(json.get("name"))) {
                  Branch.remove(i);
                }
            }
       System.out.println(Mcdo.toJSONString());
    }
    
    static void id(String id){ 
         ID = id;
    }
    
    static String userID(){
        return ID;
    }
       
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private class confirmation {
        JFrame f = new JFrame();
            confirmation(){
            int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to Log out?","Confirmation",JOptionPane.YES_NO_OPTION);
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    
                    if (result == JOptionPane.YES_OPTION) {
                         if (confirmation == JOptionPane.YES_OPTION) {
                                boolean orderExists = false;
                                for (Object obj : list) {
                                JSONObject order = (JSONObject) obj;
                                String orderId = (String) order.get("id");

                                if (ID.equals(orderId)) {
                                order.put("JABEE", new JSONArray());
                                order.put("MCDO", new JSONArray());
                                orderExists = true;
                                break;
                                }
                            }

                        if (!orderExists) {
                        info = new JSONObject();
                        info.put("id", ID);
                        info.put("JABEE", new JSONArray());
                        info.put("MCDO", new JSONArray());
                        list.add(info);
                    }

                    folder.put("folder", list);

                    try {
                    ORDERJSON.writer();
                    } catch (IOException ex) {
                     Logger.getLogger(MENU_PREVIEW.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Jabee.clear();
                    Mcdo.clear();
                    
                    close();
                    
                    login_signup login = new login_signup();
                    login.setVisible(true);   
                         }
                         
                    
                    }
                    
                }
            }
    
    public static int showSpinnerDialog(String title, String message, int minValue, int maxValue, int initialValue) {
    SpinnerModel spinnerModel = new SpinnerNumberModel(initialValue, minValue, maxValue, 1);
    JSpinner spinner = new JSpinner(spinnerModel);

    JPanel panel = new JPanel();
    panel.add(new JLabel(message));
    panel.add(spinner);

    int option = JOptionPane.showOptionDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

    if (option == JOptionPane.OK_OPTION) {
        return (int) spinner.getValue();
    } else {
        return minValue;
    }
}

    public void autoupdatetotal(){
    
    if(!Mcdo.isEmpty() && !Jabee.isEmpty()){
    FEE = 100;
    TOTAL = 0;
    TOTAL = ITEM101TOTAL + ITEM102TOTAL + ITEM103TOTAL + ITEM104TOTAL + ITEM105TOTAL + ITEM106TOTAL 
        + ITEM107TOTAL + ITEM108TOTAL + ITEM109TOTAL + ITEM201TOTAL + ITEM202TOTAL + ITEM203TOTAL 
        + ITEM204TOTAL + ITEM205TOTAL + ITEM206TOTAL + ITEM207TOTAL + ITEM208TOTAL + ITEM209TOTAL + FEE;

    DLVRYFEE.setText("100");
    TTL.setText(String.valueOf(TOTAL)); 
    repaint();   
    }else{
    FEE = 50;
    TOTAL = 0;
    TOTAL = ITEM101TOTAL + ITEM102TOTAL + ITEM103TOTAL + ITEM104TOTAL + ITEM105TOTAL + ITEM106TOTAL 
        + ITEM107TOTAL + ITEM108TOTAL + ITEM109TOTAL + ITEM201TOTAL + ITEM202TOTAL + ITEM203TOTAL 
        + ITEM204TOTAL + ITEM205TOTAL + ITEM206TOTAL + ITEM207TOTAL + ITEM208TOTAL + ITEM209TOTAL + FEE;

    DLVRYFEE.setText("50");
    TTL.setText(String.valueOf(TOTAL)); 
    repaint();   
    }
    }
    
    static int FEE(){
        return FEE;
    }
    
    public static void displayPRICES(){
        try {
            list2 = PRICEJSON.reader();

        JLabel[] labels = { lbl101, lbl102, lbl103, lbl104, 
                           lbl105, lbl106, lbl107, lbl108, lbl109, lbl201,
                           lbl202, lbl203, lbl204, lbl205, lbl206, lbl207,
                           lbl208, lbl209};
            for (int i = 0; i < labels.length; i++) {
            JSONObject obj = (JSONObject) list2.get(i);
            Object price;
            String PRICING;

            if (i < 9) {
                price = obj.get("ITEM" + (i + 101));
                PRICING = "" + price;
                labels[i].setText("₱ " + PRICING);
            } else {
                price = obj.get("ITEM" + (i - 9 + 201));
                PRICING = "" + price;
                labels[i].setText("₱ " + PRICING);
            }
        }
            
        } catch (IOException ex) {
            Logger.getLogger(MENU_PREVIEW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MENU_PREVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getPRICE(String ITEM){
        int price = 0;
        try {
            list = PRICEJSON.reader();
            
            for (Object item : list) {
                JSONObject obj = (JSONObject) item;

                for (Object key : obj.keySet()) {
                    String itemKEY = (String) key;
                    
                    if (itemKEY.equals(ITEM)) {
                        Object pricing =  obj.get(ITEM);
                        price = (int) (long) obj.get(ITEM);
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MENU_PREVIEW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MENU_PREVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    //-------------------------------------ADDITIONAL METHODS-----------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneMCDO = new javax.swing.JPanel();
        mcdoOJ = new javax.swing.JButton();
        mcdoCHOCO = new javax.swing.JButton();
        mcdoCOKE = new javax.swing.JButton();
        jabeeFLOAT = new javax.swing.JButton();
        jabeeICEDTEA = new javax.swing.JButton();
        jabeeSPRITE = new javax.swing.JButton();
        mcdoAPPLEPIE = new javax.swing.JButton();
        mcdoSSF = new javax.swing.JButton();
        mcdoBFF = new javax.swing.JButton();
        jabeeMANGOPIE = new javax.swing.JButton();
        jabeeTUNAPIE = new javax.swing.JButton();
        jabeeFRIES = new javax.swing.JButton();
        jabeeCHEESY = new javax.swing.JButton();
        jabeeYUMBURGER = new javax.swing.JButton();
        jabeeCHAMP = new javax.swing.JButton();
        mcdoQPBURGER = new javax.swing.JButton();
        mcdoCHICKENBURGER = new javax.swing.JButton();
        mcdoCHEESEBURGER = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMCDO = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableJABEE = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DLVRYFEE = new javax.swing.JLabel();
        TTL = new javax.swing.JLabel();
        lbl101 = new javax.swing.JLabel();
        lbl102 = new javax.swing.JLabel();
        lbl103 = new javax.swing.JLabel();
        lbl104 = new javax.swing.JLabel();
        lbl105 = new javax.swing.JLabel();
        lbl106 = new javax.swing.JLabel();
        lbl107 = new javax.swing.JLabel();
        lbl108 = new javax.swing.JLabel();
        lbl109 = new javax.swing.JLabel();
        lbl201 = new javax.swing.JLabel();
        lbl202 = new javax.swing.JLabel();
        lbl203 = new javax.swing.JLabel();
        lbl204 = new javax.swing.JLabel();
        lbl205 = new javax.swing.JLabel();
        lbl206 = new javax.swing.JLabel();
        lbl207 = new javax.swing.JLabel();
        lbl208 = new javax.swing.JLabel();
        lbl209 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        paneMCDO.setBackground(new java.awt.Color(255, 255, 255));

        mcdoOJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/orange.png"))); // NOI18N
        mcdoOJ.setBorder(null);
        mcdoOJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoOJActionPerformed(evt);
            }
        });

        mcdoCHOCO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/choco (2).png"))); // NOI18N
        mcdoCHOCO.setBorder(null);
        mcdoCHOCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoCHOCOActionPerformed(evt);
            }
        });

        mcdoCOKE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/coke.png"))); // NOI18N
        mcdoCOKE.setBorder(null);
        mcdoCOKE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoCOKEActionPerformed(evt);
            }
        });

        jabeeFLOAT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JSoda Floats.png.png"))); // NOI18N
        jabeeFLOAT.setBorder(null);
        jabeeFLOAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeFLOATActionPerformed(evt);
            }
        });

        jabeeICEDTEA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JIced tea.png.png"))); // NOI18N
        jabeeICEDTEA.setBorder(null);
        jabeeICEDTEA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeICEDTEAActionPerformed(evt);
            }
        });

        jabeeSPRITE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JSprite.png.png"))); // NOI18N
        jabeeSPRITE.setBorder(null);
        jabeeSPRITE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeSPRITEActionPerformed(evt);
            }
        });

        mcdoAPPLEPIE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/applepie.png"))); // NOI18N
        mcdoAPPLEPIE.setBorder(null);
        mcdoAPPLEPIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoAPPLEPIEActionPerformed(evt);
            }
        });

        mcdoSSF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/shakr.png"))); // NOI18N
        mcdoSSF.setBorder(null);
        mcdoSSF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoSSFActionPerformed(evt);
            }
        });

        mcdoBFF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/bbff.png"))); // NOI18N
        mcdoBFF.setBorder(null);
        mcdoBFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoBFFActionPerformed(evt);
            }
        });

        jabeeMANGOPIE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JPeach Mango Pie.png.png"))); // NOI18N
        jabeeMANGOPIE.setBorder(null);
        jabeeMANGOPIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeMANGOPIEActionPerformed(evt);
            }
        });

        jabeeTUNAPIE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JTuna pie.png.png"))); // NOI18N
        jabeeTUNAPIE.setBorder(null);
        jabeeTUNAPIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeTUNAPIEActionPerformed(evt);
            }
        });

        jabeeFRIES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JFries.png.png"))); // NOI18N
        jabeeFRIES.setBorder(null);
        jabeeFRIES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeFRIESActionPerformed(evt);
            }
        });

        jabeeCHEESY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JCheesy Yumburger.png.png"))); // NOI18N
        jabeeCHEESY.setBorder(null);
        jabeeCHEESY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeCHEESYActionPerformed(evt);
            }
        });

        jabeeYUMBURGER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JYumburger.png.png"))); // NOI18N
        jabeeYUMBURGER.setBorder(null);
        jabeeYUMBURGER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeYUMBURGERActionPerformed(evt);
            }
        });

        jabeeCHAMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/JChamp.png.png"))); // NOI18N
        jabeeCHAMP.setBorder(null);
        jabeeCHAMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabeeCHAMPActionPerformed(evt);
            }
        });

        mcdoQPBURGER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/quarter.png"))); // NOI18N
        mcdoQPBURGER.setBorder(null);
        mcdoQPBURGER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoQPBURGERActionPerformed(evt);
            }
        });

        mcdoCHICKENBURGER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/chicken .png"))); // NOI18N
        mcdoCHICKENBURGER.setBorder(null);
        mcdoCHICKENBURGER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoCHICKENBURGERActionPerformed(evt);
            }
        });

        mcdoCHEESEBURGER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MENU/cheese.png"))); // NOI18N
        mcdoCHEESEBURGER.setBorder(null);
        mcdoCHEESEBURGER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcdoCHEESEBURGERActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("MCDONALDS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("JOLLIBEE");

        tableMCDO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QTY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tableMCDO);

        tableJABEE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QTY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tableJABEE);

        jLabel7.setText("DELIVERY FEE:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setText("TOTAL:");

        DLVRYFEE.setText("0");

        TTL.setText("0");

        lbl101.setText("₱");

        lbl102.setText("₱");

        lbl103.setText("₱");

        lbl104.setText("₱");

        lbl105.setText("₱");

        lbl106.setText("₱");

        lbl107.setText("₱");

        lbl108.setText("₱");

        lbl109.setText("₱");

        lbl201.setText("₱");

        lbl202.setText("₱");

        lbl203.setText("₱");

        lbl204.setText("₱");

        lbl205.setText("₱");

        lbl206.setText("₱");

        lbl207.setText("₱");

        lbl208.setText("₱");

        lbl209.setText("₱");

        javax.swing.GroupLayout paneMCDOLayout = new javax.swing.GroupLayout(paneMCDO);
        paneMCDO.setLayout(paneMCDOLayout);
        paneMCDOLayout.setHorizontalGroup(
            paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMCDOLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl107, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(lbl108, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(lbl109, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(lbl207, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(lbl208, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(lbl209, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paneMCDOLayout.createSequentialGroup()
                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMCDOLayout.createSequentialGroup()
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mcdoCHEESEBURGER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mcdoAPPLEPIE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mcdoOJ, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(32, 32, 32)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(mcdoCHICKENBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneMCDOLayout.createSequentialGroup()
                                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mcdoCHOCO)
                                    .addComponent(mcdoSSF))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mcdoQPBURGER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mcdoCOKE)
                                .addComponent(mcdoBFF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createSequentialGroup()
                                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jabeeFLOAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jabeeMANGOPIE))
                                .addGap(34, 34, 34)
                                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneMCDOLayout.createSequentialGroup()
                                        .addComponent(jabeeTUNAPIE, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jabeeFRIES, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createSequentialGroup()
                                        .addComponent(jabeeICEDTEA, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jabeeSPRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createSequentialGroup()
                                .addComponent(jabeeCHAMP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jabeeCHEESY, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jabeeYUMBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(paneMCDOLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneMCDOLayout.createSequentialGroup()
                                .addComponent(lbl101, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(lbl102, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(lbl103, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)
                                .addComponent(lbl201, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(lbl202, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl203, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneMCDOLayout.createSequentialGroup()
                                .addComponent(lbl104, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(lbl105, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(lbl106, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addComponent(lbl204, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(lbl205, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl206, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)))
                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMCDOLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneMCDOLayout.createSequentialGroup()
                                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DLVRYFEE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TTL, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(288, 288, 288))
                            .addGroup(paneMCDOLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(61, 61, 61))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMCDOLayout.createSequentialGroup()
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))))
        );
        paneMCDOLayout.setVerticalGroup(
            paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMCDOLayout.createSequentialGroup()
                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMCDOLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mcdoOJ, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mcdoCHOCO, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mcdoCOKE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jabeeFLOAT)
                                .addComponent(jabeeICEDTEA, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jabeeSPRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl201, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl203))
                        .addGap(28, 28, 28)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mcdoAPPLEPIE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcdoSSF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcdoBFF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeMANGOPIE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeTUNAPIE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeFRIES, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl104)
                            .addComponent(lbl105)
                            .addComponent(lbl106)
                            .addComponent(lbl204)
                            .addComponent(lbl205)
                            .addComponent(lbl206))
                        .addGap(22, 22, 22)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mcdoCHEESEBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcdoCHICKENBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcdoQPBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeCHAMP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeCHEESY, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabeeYUMBURGER, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneMCDOLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(DLVRYFEE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TTL))))
                .addGap(5, 5, 5)
                .addGroup(paneMCDOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl107)
                    .addComponent(lbl108)
                    .addComponent(lbl109)
                    .addComponent(lbl207)
                    .addComponent(lbl208)
                    .addComponent(lbl209))
                .addGap(455, 455, 455))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneMCDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMCDO, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mcdoCHOCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoCHOCOActionPerformed
    String ITEM = "ITEM102";
    int ITEM102 = getPRICE(ITEM);
    ITEM102TOTAL = 0;
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "CHOCOLATE DRINK";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        
        ITEM102 *= value;
        ITEM102TOTAL =+ ITEM102;
        
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM102TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
        autoupdatetotal();
        
        //ITEM102
    }//GEN-LAST:event_mcdoCHOCOActionPerformed
    
    private void jabeeICEDTEAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeICEDTEAActionPerformed
    String ITEM = "ITEM202";
    int ITEM202 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "ICED TEA";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    
    if (value >= 1) {
        ITEM202 *= value;
        ITEM202TOTAL =+ ITEM202;  
        initialADD(itemName, value, Jabee);
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM202TOTAL = 0;
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
        //ITEM202
    }//GEN-LAST:event_jabeeICEDTEAActionPerformed

    private void mcdoSSFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoSSFActionPerformed
    String ITEM = "ITEM105";
    int ITEM105 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "SHAKE SHAKE FRIES";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM105 *= value;
        ITEM105TOTAL =+ ITEM105;  
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM105TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
     autoupdatetotal();
    }//GEN-LAST:event_mcdoSSFActionPerformed

    private void jabeeTUNAPIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeTUNAPIEActionPerformed
    String ITEM = "ITEM205";
    int ITEM205 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "TUNA PIE";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM205 *= value;
        ITEM205TOTAL =+ ITEM205; 
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM205TOTAL = 0;
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_jabeeTUNAPIEActionPerformed

    private void mcdoCHICKENBURGERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoCHICKENBURGERActionPerformed
    String ITEM = "ITEM108";
    int ITEM108 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "CHICKEN BURGER";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM108 *= value;
        ITEM108TOTAL =+ ITEM108; 
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM108TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_mcdoCHICKENBURGERActionPerformed

    private void jabeeCHEESYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeCHEESYActionPerformed
    String ITEM = "ITEM208";
    int ITEM208 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "CHEESY BURGER";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM208 *= value;
        ITEM208TOTAL =+ ITEM208; 
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM208TOTAL = 0;
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_jabeeCHEESYActionPerformed

    private void mcdoCHEESEBURGERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoCHEESEBURGERActionPerformed
    String ITEM = "ITEM107";
    int ITEM107 = getPRICE(ITEM);
        
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "CHEESE BURGER";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM107 *= value;
        ITEM107TOTAL =+ ITEM107; 
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
         ITEM107TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_mcdoCHEESEBURGERActionPerformed

    private void jabeeCHAMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeCHAMPActionPerformed
    String ITEM = "ITEM207";
    int ITEM207 = getPRICE(ITEM);
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "BURGER CHAMPION";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM207 *= value;
        ITEM207TOTAL =+ ITEM207; 
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM207TOTAL = 0; 
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_jabeeCHAMPActionPerformed

    private void mcdoOJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoOJActionPerformed
    String ITEM = "ITEM101";
    int ITEM101 = getPRICE(ITEM);
   
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "ORANGE JUICE";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM101*= value;
        ITEM101TOTAL =+ ITEM101; 
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM101TOTAL = 0; 
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_mcdoOJActionPerformed

    private void mcdoCOKEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoCOKEActionPerformed
    String ITEM = "ITEM103";
    int ITEM103 = getPRICE(ITEM);
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "COCA COLA";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM103*= value;
        ITEM103TOTAL =+ ITEM103; 
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM103TOTAL = 0; 
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_mcdoCOKEActionPerformed

    private void jabeeFLOATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeFLOATActionPerformed
    String ITEM = "ITEM201";
    int ITEM201 = getPRICE(ITEM);
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "COKE FLOAT";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM201*= value;
        ITEM204TOTAL =+ ITEM201;
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
          ITEM204TOTAL = 0; 
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
    autoupdatetotal();
    }//GEN-LAST:event_jabeeFLOATActionPerformed

    private void jabeeSPRITEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeSPRITEActionPerformed
    String ITEM = "ITEM203";
    int ITEM203 = getPRICE(ITEM);
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "SPRITE";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM203*= value;
        ITEM203TOTAL =+ ITEM203;
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM203TOTAL = 0; 
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_jabeeSPRITEActionPerformed

    private void mcdoBFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoBFFActionPerformed
    String ITEM = "ITEM106";
    int ITEM106 = getPRICE(ITEM);
        
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "BFF FRIES";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM106*= value;
        ITEM106TOTAL =+ ITEM106;
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
          ITEM106TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_mcdoBFFActionPerformed

    private void jabeeMANGOPIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeMANGOPIEActionPerformed
    int ITEM204 = 63;
    ITEM204TOTAL = 0; 
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "PEACH MANGO PIE";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM204*= value;
        ITEM204TOTAL =+ ITEM204;
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM204TOTAL = 0; 
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
     autoupdatetotal();
    }//GEN-LAST:event_jabeeMANGOPIEActionPerformed

    private void jabeeFRIESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeFRIESActionPerformed
    String ITEM = "ITEM206";
    int ITEM206 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "JOLLY FRIES";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM206*= value;
        ITEM206TOTAL =+ ITEM206;
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM206TOTAL = 0;
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_jabeeFRIESActionPerformed

    private void mcdoQPBURGERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoQPBURGERActionPerformed
    String ITEM = "ITEM109";
    int ITEM109 = getPRICE(ITEM);
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "QUARTER POUND BURGER";
    DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelMcdo.getRowCount(); i++) {
        if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Mcdo);
        ITEM109*= value;
        ITEM109TOTAL =+ ITEM109;
        if (rowIndex != -1) {
            modelMcdo.setValueAt(value, rowIndex, 1);
        } else {
            modelMcdo.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Mcdo);
        ITEM109TOTAL = 0;
        if (rowIndex != -1) {
            modelMcdo.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_mcdoQPBURGERActionPerformed

    private void jabeeYUMBURGERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabeeYUMBURGERActionPerformed
    String ITEM = "ITEM209";
    int ITEM209 = getPRICE(ITEM);
    
    int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
    String itemName = "YUM BURGER";
    DefaultTableModel modelJabee = (DefaultTableModel) tableJABEE.getModel();

    int rowIndex = -1;
    for (int i = 0; i < modelJabee.getRowCount(); i++) {
        if (itemName.equals(modelJabee.getValueAt(i, 0))) {
            rowIndex = i;
            break;
        }
    }
    if (value >= 1) {
        initialADD(itemName, value, Jabee);
        ITEM209*= value;
        ITEM209TOTAL =+ ITEM209;
        if (rowIndex != -1) {
            modelJabee.setValueAt(value, rowIndex, 1);
        } else {
            modelJabee.addRow(new Object[]{itemName, value});
        }
        repaint();
    } else {
        individualREMOVE(itemName, Jabee);
        ITEM209TOTAL = 0;
        if (rowIndex != -1) {
            modelJabee.removeRow(rowIndex);
        }
        repaint();
    }
       autoupdatetotal();
    }//GEN-LAST:event_jabeeYUMBURGERActionPerformed
 
    private void mcdoAPPLEPIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcdoAPPLEPIEActionPerformed
        String ITEM = "ITEM104";
        int ITEM104 = getPRICE(ITEM);
        int value = showSpinnerDialog("Quantity", "TEST QUANTITY", 0, 10, 0);
        String itemName = "APPLE PIE";
        DefaultTableModel modelMcdo = (DefaultTableModel) tableMCDO.getModel();

        int rowIndex = -1;
        for (int i = 0; i < modelMcdo.getRowCount(); i++) {
            if (itemName.equals(modelMcdo.getValueAt(i, 0))) {
                rowIndex = i;
                break;
            }
        }
        if (value >= 1) {
            initialADD(itemName, value, Mcdo);
            ITEM104*= value;
            ITEM104TOTAL =+ ITEM104;
            if (rowIndex != -1) {
                modelMcdo.setValueAt(value, rowIndex, 1);
            } else {
                modelMcdo.addRow(new Object[]{itemName, value});
            }
            repaint();
        } else {
            individualREMOVE(itemName, Mcdo);
            ITEM104TOTAL = 0;
            if (rowIndex != -1) {
                modelMcdo.removeRow(rowIndex);
            }
            repaint();
        }
        autoupdatetotal();
    }//GEN-LAST:event_mcdoAPPLEPIEActionPerformed
    
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU_PREVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DLVRYFEE;
    private javax.swing.JLabel TTL;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jabeeCHAMP;
    private javax.swing.JButton jabeeCHEESY;
    private javax.swing.JButton jabeeFLOAT;
    private javax.swing.JButton jabeeFRIES;
    private javax.swing.JButton jabeeICEDTEA;
    private javax.swing.JButton jabeeMANGOPIE;
    private javax.swing.JButton jabeeSPRITE;
    private javax.swing.JButton jabeeTUNAPIE;
    private javax.swing.JButton jabeeYUMBURGER;
    private static javax.swing.JLabel lbl101;
    private static javax.swing.JLabel lbl102;
    private static javax.swing.JLabel lbl103;
    private static javax.swing.JLabel lbl104;
    private static javax.swing.JLabel lbl105;
    private static javax.swing.JLabel lbl106;
    private static javax.swing.JLabel lbl107;
    private static javax.swing.JLabel lbl108;
    private static javax.swing.JLabel lbl109;
    private static javax.swing.JLabel lbl201;
    private static javax.swing.JLabel lbl202;
    private static javax.swing.JLabel lbl203;
    private static javax.swing.JLabel lbl204;
    private static javax.swing.JLabel lbl205;
    private static javax.swing.JLabel lbl206;
    private static javax.swing.JLabel lbl207;
    private static javax.swing.JLabel lbl208;
    private static javax.swing.JLabel lbl209;
    private javax.swing.JButton mcdoAPPLEPIE;
    private javax.swing.JButton mcdoBFF;
    private javax.swing.JButton mcdoCHEESEBURGER;
    private javax.swing.JButton mcdoCHICKENBURGER;
    private javax.swing.JButton mcdoCHOCO;
    private javax.swing.JButton mcdoCOKE;
    private javax.swing.JButton mcdoOJ;
    private javax.swing.JButton mcdoQPBURGER;
    private javax.swing.JButton mcdoSSF;
    private static javax.swing.JPanel paneMCDO;
    private javax.swing.JTable tableJABEE;
    private javax.swing.JTable tableMCDO;
    // End of variables declaration//GEN-END:variables
}



package sellsage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dashboard extends javax.swing.JFrame {
    CardLayout layout;

    public Dashboard(String username, String userType) {
        setDarkTheme(); // Set Nimbus dark theme
        initComponents();
        navPanel.setVisible(true);
        menuPanel.setVisible(true);
        layout = new CardLayout();

        displayPanel.setLayout(layout);
        displayPanel.add("Home", new HomePage());
        displayPanel.add("Customers", new CustomerPage());
        displayPanel.add("Products", new ProductPage(username, this));
        displayPanel.add("Current Stock", new CurrentStockPage(username));
        displayPanel.add("Sales", new PurchasePage(this));
        // Create and add InsightsPage
        //InsightsPage insightsPage = new InsightsPage();
        //displayPanel.add("Insights", insightsPage);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

        setTitle("Inventory Manager");
        
        setVisible(true);
        
     
    }

    private void setDarkTheme() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.getLookAndFeelDefaults().put("nimbusBase", new Color(0, 0, 0)); // Background color (dark)
                    UIManager.getLookAndFeelDefaults().put("nimbusBlueGrey", new Color(0, 0, 0)); // Text color (dark)
                    UIManager.getLookAndFeelDefaults().put("control", new Color(0x333333)); // Control (buttons, etc.) color (dark)
                    UIManager.getLookAndFeelDefaults().put("nimbusFocus", new Color(0x82BBFF)); // Focus color
                    UIManager.getLookAndFeelDefaults().put("nimbusSelectionBackground", new Color(0x82BBFF)); // Selection background color
                    UIManager.getLookAndFeelDefaults().put("nimbusSelection", new Color(0x82BBFF)); // Selection foreground color
                    UIManager.getLookAndFeelDefaults().put("TextField.font", new Font("Arial", Font.PLAIN, 14)); // Text field font
                    UIManager.getLookAndFeelDefaults().put("TextArea.font", new Font("Arial", Font.PLAIN, 14)); // Text area font
                    UIManager.getLookAndFeelDefaults().put("TextPane.font", new Font("Arial", Font.PLAIN, 14)); // Text pane font
                    UIManager.getLookAndFeelDefaults().put("EditorPane.font", new Font("Arial", Font.PLAIN, 14)); // Editor pane font
                    UIManager.getLookAndFeelDefaults().put("TableHeader.foreground", Color.YELLOW); // Table column header text color
                    UIManager.getLookAndFeelDefaults().put("TableHeader.background", Color.LIGHT_GRAY);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }

    public void addHomePage(){
        layout.show(displayPanel, "Home");
    }
    public void addCustPage() {
        layout.show(displayPanel, "Customers");
    }
    public void addProdPage() {
        layout.show(displayPanel, "Products");
    }
    public void addStockPage() {
        layout.show(displayPanel, "Current Stock");
    }
    public void addPurchasePage() {
        layout.show(displayPanel, "Sales");
    }
    public void showInsights() {
        layout.show(displayPanel, "Insights");
    }
    
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        navPanel = new javax.swing.JPanel();
        prodButton = new javax.swing.JButton();
        stockButton = new javax.swing.JButton();
        custButton = new javax.swing.JButton();
        purchaseButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        //insightsButton = new javax.swing.JButton(); // Added Insights button

        mainPanel.setBackground(new Color(0X888888));//green to grey
        menuPanel.setBackground(new Color(0X888888));
        navPanel.setBackground(new Color(0X888888));
        userPanel.setBackground(new Color(0X888888));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 100, 0, 0));

        menuPanel.setPreferredSize(new java.awt.Dimension(120, 26));

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        prodButton.setText("Products");
        prodButton.setBackground(new Color(0X05386B));
        prodButton.setForeground(new Color(0XEDF5E1));
        prodButton.setFocusable(false);
        prodButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButtonActionPerformed(evt);
            }
        });

        stockButton.setText("Current Stock");
        stockButton.setBackground(new Color(0X05386B));
        stockButton.setForeground(new Color(0XEDF5E1));
        stockButton.setFocusable(false);
        stockButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        custButton.setText("Customers");
        custButton.setBackground(new Color(0X05386B));
        custButton.setForeground(new Color(0XEDF5E1));
        custButton.setFocusable(false);
        custButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custButtonActionPerformed(evt);
            }
        });

        purchaseButton.setText("Sales");
        purchaseButton.setBackground(new Color(0X05386B));
        purchaseButton.setForeground(new Color(0XEDF5E1));
        purchaseButton.setFocusable(false);
        purchaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });
        
        // Add action listener for Insights button
        //insightsButton.setText("Insights");
        //insightsButton.setBackground(new Color(0X05386B));
        //insightsButton.setForeground(new Color(0XEDF5E1));
        //insightsButton.setFocusable(false);
        //insightsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        //insightsButton.addActionListener(new java.awt.event.ActionListener() {
        //    public void actionPerformed(java.awt.event.ActionEvent evt) {
         //       showInsights();
         //   }
        //});
        
        
        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(custButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    //.addComponent(insightsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(prodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(stockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(custButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                //.addComponent(insightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
        );

        displayPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void custButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        addCustPage();
    }                                          

    private void stockButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        addStockPage();
    }                                           

    private void prodButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        addProdPage();
    }                                          

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        addPurchasePage();
    }
    
    private void insightsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        showInsights();
    }


     javax.swing.JButton custButton;
     javax.swing.JPanel displayPanel;
     javax.swing.JMenuBar jMenuBar1;
     javax.swing.JPanel mainPanel;
     javax.swing.JPanel menuPanel;
     javax.swing.JPanel navPanel;
     javax.swing.JButton prodButton;
     javax.swing.JButton purchaseButton;
     javax.swing.JButton stockButton;
     javax.swing.JPanel userPanel;
     private javax.swing.JButton insightsButton;

}

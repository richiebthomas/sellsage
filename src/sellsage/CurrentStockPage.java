

package sellsage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;

public class CurrentStockPage extends javax.swing.JPanel {

    public CurrentStockPage(String username) {
        initComponents();
        loadDataSet();
    }

    private void initComponents() {
        // Existing code for labels, separator, and table initialization...
jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 15)); 
        jLabel1.setText("CURRENT STOCK");
        jLabel1.setToolTipText("");
        
        

        setBackground(new Color(0X888888));

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(stockTable);
        jSeparator1.setBackground(new Color(0X888888));
        stockTable.setBackground(new Color(0XEDF5E1));
        // Create Refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButton.setBackground(new Color(0X05386B));
        refreshButton.setForeground(new Color(0XEDF5E1));
        refreshButton.setFocusable(false);

        // Add action listener for refresh button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        // Layout code for the Refresh button
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        this.setBackground(new Color(0X888888));
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(refreshButton))) // Add Refresh button here
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(refreshButton)) // Add Refresh button here
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(88, Short.MAX_VALUE))
        );
    }

    private void refreshButtonActionPerformed(ActionEvent evt) {
        loadDataSet(); // Call loadDataSet method to refresh the data when Refresh button is clicked
    }

public void loadDataSet() {
        try {
            ProductDAO productDAO = new ProductDAO();
            stockTable.setModel(productDAO.buildTableModel(productDAO.getCurrentStockInfo()));
        } catch (SQLException e) {
        }
    }

     javax.swing.JLabel jLabel1;
     javax.swing.JScrollPane jScrollPane1;
     javax.swing.JSeparator jSeparator1;
     javax.swing.JTable stockTable;
}

package sellsage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List;
import java.util.Set;

public class Transactions extends JPanel {

    private JButton getInsightsButton;
    private JLabel messageLabel;
    
    public Transactions() {
        setBackground(new Color(0X888888)); // Set the background color to white

        // Create the label to display the insights
        messageLabel = new JLabel();
        
        // Create the "Get Insights" button
        getInsightsButton = new JButton("Get insights");
        getInsightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Run Apriori algorithm to get frequently bought together items
                List<Set<String>> frequentItemsets = runAprioriAlgorithm(); // Implement this method to run Apriori

                // Display frequent itemsets in the messageLabel
                StringBuilder insightsText = new StringBuilder("<html><body>");
                for (Set<String> itemset : frequentItemsets) {
                    insightsText.append(itemset.toString()).append("<br>");
                }
                insightsText.append("</body></html>");
                messageLabel.setText(insightsText.toString());
            }
        });

        // Add components to the panel
        add(getInsightsButton);
        add(messageLabel);
    }

    // Implement the Apriori algorithm logic to find frequently bought together items
    private List<Set<String>> runAprioriAlgorithm() {
        // Implement Apriori algorithm logic here and return the frequent itemsets
        // You can use existing libraries like Apriori4j or Weka for Apriori implementation
        // Example: Apriori algorithm using Apriori4j library:
        // List<Set<String>> frequentItemsets = Apriori.runApriori(transactions, minSupport);
        return null;
    }
}

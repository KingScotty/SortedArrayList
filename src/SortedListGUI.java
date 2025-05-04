import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextField inputField;
    private JTextArea outputArea;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("SortedList GUI");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for input and buttons
        JPanel topPanel = new JPanel();
        inputField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("Input:"));
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // Text area for output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    String[] parts = input.split("[,\\s]+"); // split by commas or spaces
                    for (String word : parts) {
                        sortedList.add(word);
                        outputArea.append("Added: " + word + "\n");
                    }
                    outputArea.append("List: " + sortedList + "\n\n");
                    inputField.setText("");
                }
            }
        });
//different version of the add button
        /*
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    outputArea.append("Added: " + input + "\n");
                    outputArea.append("List: " + sortedList + "\n\n");
                    inputField.setText("");
                }
            }
        }); */

        // Search Button Action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    int result = sortedList.search(input);
                    if (result >= 0) {
                        outputArea.append("Found '" + input + "' at index: " + result + "\n\n");
                    } else {
                        int insertPos = -result - 1;
                        outputArea.append("'" + input + "' not found. Would be at index: " + insertPos + "\n\n");
                    }
                    inputField.setText("");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}

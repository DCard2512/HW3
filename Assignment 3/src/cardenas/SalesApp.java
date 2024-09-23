package cardenas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class SalesApp {

	private JFrame frame;
	private JTextField itemInput;
	private JTextField costInput;
	private JTextField quantInput;
	private JLabel titleLabel;
	private JButton btnSales;
	private JScrollPane scrollPane;
	private JTextArea outputText;
	private JLabel totalLabel;
	private JTextArea totalSaleOutput;
	private SalesSlip sales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesApp window = new SalesApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesApp() {
		sales = new SalesSlip();
		initialize();
		outputBtn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titleLabel = new JLabel("Sales List");
		titleLabel.setBounds(186, 6, 61, 16);
		frame.getContentPane().add(titleLabel);
		
		JLabel itemLbl = new JLabel("Item");
		itemLbl.setHorizontalAlignment(SwingConstants.CENTER);
		itemLbl.setBounds(50, 30, 61, 16);
		frame.getContentPane().add(itemLbl);
		
		itemInput = new JTextField();
		itemInput.setBounds(123, 25, 220, 26);
		frame.getContentPane().add(itemInput);
		itemInput.setColumns(10);
		
		JLabel CostLbl = new JLabel("Cost: $");
		CostLbl.setHorizontalAlignment(SwingConstants.CENTER);
		CostLbl.setBounds(50, 60, 61, 16);
		frame.getContentPane().add(CostLbl);
		
		costInput = new JTextField();
		costInput.setBounds(123, 55, 130, 26);
		frame.getContentPane().add(costInput);
		costInput.setColumns(10);
		
		JLabel quantLbl = new JLabel("Quantity");
		quantLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantLbl.setBounds(50, 90, 61, 16);
		frame.getContentPane().add(quantLbl);
		
		quantInput = new JTextField();
		quantInput.setBounds(123, 85, 130, 26);
		frame.getContentPane().add(quantInput);
		quantInput.setColumns(10);
		
		btnSales = new JButton("Add Item to Sales List");
		btnSales.setBounds(82, 118, 261, 29);
		frame.getContentPane().add(btnSales);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 147, 348, 140);
		frame.getContentPane().add(scrollPane);
		
		outputText = new JTextArea();
		scrollPane.setViewportView(outputText);
		
		totalLabel = new JLabel("Total Sales:");
		totalLabel.setBounds(82, 310, 72, 16);
		frame.getContentPane().add(totalLabel);
		
		totalSaleOutput = new JTextArea();
		totalSaleOutput.setBounds(166, 299, 186, 29);
		frame.getContentPane().add(totalSaleOutput);
	}
	
	private void outputBtn() {
		btnSales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildSales();
            }
        });
	}
	
	private void buildSales() {	
		
		String iInput = itemInput.getText();
		double cInput = Double.parseDouble(costInput.getText());
		int qInput = Integer.parseInt(quantInput.getText());
		
		SalesItem saleItem = new SalesItem(iInput,cInput,qInput);
		sales.addSale(saleItem);
		
		outputText.setText(sales.toString());
		totalSaleOutput.setText(String.format("%-6s", sales.totalSales()));
	
	}
}

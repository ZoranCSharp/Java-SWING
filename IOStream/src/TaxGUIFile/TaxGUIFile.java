package TaxGUIFile;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;



public class TaxGUIFile {

	private JFrame frame;
	private JTextField textGross;
	private JTextField textDependents;
	private JTextField textStateTax;

	//Define a data model for the ComboBox chState
	Vector<String> states = new Vector<>(50);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxGUIFile window = new TaxGUIFile();
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
	public TaxGUIFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGrossIncome = new JLabel("Gross Income:");
		lblGrossIncome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrossIncome.setBounds(10, 11, 94, 14);
		frame.getContentPane().add(lblGrossIncome);
		
		JLabel lblNewLabel = new JLabel("Number of Dependents:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 59, 164, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStateTax = new JLabel("State Tax:");
		lblStateTax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStateTax.setBounds(10, 156, 70, 14);
		frame.getContentPane().add(lblStateTax);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(10, 107, 52, 14);
		frame.getContentPane().add(lblState);
		
		textGross = new JTextField();
		textGross.setBounds(218, 10, 206, 20);
		frame.getContentPane().add(textGross);
		textGross.setColumns(10);
		
		textDependents = new JTextField();
		textDependents.setBounds(218, 58, 206, 20);
		frame.getContentPane().add(textDependents);
		textDependents.setColumns(10);
		
		//Create a comboBox to get data from the model 
		JComboBox comboBoxState = new JComboBox(states);
		comboBoxState.setBounds(218, 106, 206, 20);
		frame.getContentPane().add(comboBoxState);
		
		textStateTax = new JTextField();
		textStateTax.setBounds(218, 155, 206, 20);
		frame.getContentPane().add(textStateTax);
		textStateTax.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(evt -> {
			
			try {
				
				int grossInc = Integer.parseInt(textGross.getText());
				int dependents = Integer.parseInt(textDependents.getText());
				String state = (String)comboBoxState.getSelectedItem();
				
				Tax tax = new Tax(grossInc, state, dependents);
				String sTax = Double.toString(tax.calcTax());
				textStateTax.setText(sTax);
			
			}catch(NumberFormatException e){
				
				textStateTax.setText("Non-Numeric Data");
			}catch(Exception e) {
				
				textStateTax.setText(e.getMessage());
			}
			
		});
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGo.setBackground(new Color(154, 205, 50));
		btnGo.setBounds(10, 227, 199, 23);
		frame.getContentPane().add(btnGo);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(evt -> {
			
			textGross.setText("");
			textDependents.setText("");
			textStateTax.setText("");
			comboBoxState.setSelectedIndex(0);
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBackground(new Color(255, 99, 71));
		btnReset.setBounds(218, 227, 206, 23);
		frame.getContentPane().add(btnReset);
		
		
		/*//Define, instantiate and register a WindowAdapter
		//to process windowClosing Event of this frame
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
		
		//Populate states from a file
		populateStates(); 
		
		comboBoxState.setSelectedIndex(0);
		textStateTax.setEditable(false);
		
		
	}

	/*private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}*/

	
	//The code below will read the file states.txt and
	//populate the dropdown chStates
	private void populateStates() {

		states.add("Select State");

		try  (FileInputStream myFile = new FileInputStream("states.txt");
			  InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF8");
			  BufferedReader reader = new BufferedReader(inputStreamReader);)
		{
				
			String stateName;
			
			while( (stateName = reader.readLine()) != null) {
				
				states.addElement(stateName);
			}
			
				
			
		}catch(IOException ioe) {
			
			textStateTax.setText("Cant read states,txt: " + ioe.getMessage());
			
		}
		
		
		
	}
}

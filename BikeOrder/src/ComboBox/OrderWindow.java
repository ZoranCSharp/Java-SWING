package ComboBox;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderWindow {

	private JFrame frmPlaceYourOrder;
	private JTextField txtOrder;
	private BikeOrder order;
	private String selectedModel;
	private int selectQuantity;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderWindow window = new OrderWindow();
					window.frmPlaceYourOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrderWindow() {
		
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		order = new BikeOrder();
		String[] bikeModel = {"", "Roadmaster", "Diamondblack", "Mongoose", "Zesty Trail"};
		
		
		frmPlaceYourOrder = new JFrame();
		frmPlaceYourOrder.setResizable(false);
		frmPlaceYourOrder.setTitle("Place your order");
		frmPlaceYourOrder.setBounds(100, 100, 450, 189);
		frmPlaceYourOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlaceYourOrder.getContentPane().setLayout(null);
		
		JLabel lblSelect = new JLabel("Select model:");
		lblSelect.setBounds(10, 11, 95, 14);
		frmPlaceYourOrder.getContentPane().add(lblSelect);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 57, 66, 14);
		frmPlaceYourOrder.getContentPane().add(lblQuantity);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(181, 111, 212, 23);
		frmPlaceYourOrder.getContentPane().add(lblStatus);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					if(selectedModel =="") {
				
					
					lblStatus.setText("Please choose model!");
					
				} else {
					
					selectQuantity = Integer.parseInt(txtOrder.getText().toString());
					order.validateOrder(selectedModel, selectQuantity);
					lblStatus.setText(order.getOrder());
					
				}
			
			}catch(NumberFormatException e1) {
				lblStatus.setText("Quantity must be a number");
			} catch (TooManyBikesException tmbe) {
				lblStatus.setText(tmbe.getMessage());
			}
				
				
			}
			
			
		
			
				
		});
		
		btnOrder.setBounds(10, 111, 128, 23);
		frmPlaceYourOrder.getContentPane().add(btnOrder);
		
		JComboBox comboOrder = new JComboBox(bikeModel);
		comboOrder.setToolTipText("");
		comboOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JComboBox combo = (JComboBox) e.getSource();
				selectedModel = combo.getSelectedItem().toString();
			}
		});
		comboOrder.setBounds(234, 8, 159, 20);
		frmPlaceYourOrder.getContentPane().add(comboOrder);
		
		txtOrder = new JTextField();
		txtOrder.setBounds(234, 54, 159, 20);
		frmPlaceYourOrder.getContentPane().add(txtOrder);
		txtOrder.setColumns(10);
		
		
	}
}


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JPanel;


public class MyCustomizableGUI {

	private JFrame frame;
	private JFrame frame_1;
	private JTextField textProperties;
	private JComboBox comboColor;
	private JComboBox comboFont;
	private JComboBox comboFontSize;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnPreferences;
	private JLabel lblColor;
	private JLabel lblFont;
	private JLabel lblFontSize;
	
	
	
	
	private String[] color = {"Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "Black"};
	private String[] font = {"Arial", "Times New Roman", "Helvetica"};
	private String[] fontSize = {"12", "18", "25", "40", "64"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCustomizableGUI window = new MyCustomizableGUI();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		MyCustomizableGUI custGUI = new MyCustomizableGUI();
		UserPreferences savedPrefs;
		
		try(FileInputStream fIs = new FileInputStream("preferences.ser");
		    ObjectInputStream oIs = new ObjectInputStream(fIs);){
			
			
			savedPrefs = (UserPreferences) oIs.readObject();
			
			if( savedPrefs.getColor().contains("Red")) {
				
				custGUI.textProperties.setForeground(Color.red);
				custGUI.comboColor.setSelectedItem("Red");
				
			}else if(savedPrefs.getColor().contains("Green")) {
				
				custGUI.textProperties.setForeground(Color.green);
				custGUI.comboColor.setSelectedItem("Green");
				
			}else if(savedPrefs.getColor().contains("Blue")) {
				
				custGUI.textProperties.setForeground(Color.blue);
				custGUI.comboColor.setSelectedItem("Blue");
				
			}else if(savedPrefs.getColor().contains("Cyan")) {
				
				custGUI.textProperties.setForeground(Color.cyan);
				custGUI.comboColor.setSelectedItem("Cyan");
			
			}else if(savedPrefs.getColor().contains("Magenta")) {
				
				custGUI.textProperties.setForeground(Color.magenta);
				custGUI.comboColor.setSelectedItem("Magenta");
			
			}else if(savedPrefs.getColor().contains("Yellow")) {
				
				custGUI.textProperties.setForeground(Color.yellow);
				custGUI.comboColor.setSelectedItem("Yellow");
			
			}else if(savedPrefs.getColor().contains("Black")) {
				
				custGUI.textProperties.setForeground(Color.black);
				custGUI.comboColor.setSelectedItem("Black");
				
			}
			
			custGUI.setFont(savedPrefs.getFont(),savedPrefs.getFontSize());
			custGUI.comboFont.setSelectedItem(savedPrefs.getFont());
			custGUI.comboFontSize.setSelectedItem("" + savedPrefs.getFontSize());
			
			
			
		}catch(FileNotFoundException fnf) {
			
			//load defaul color and font
			custGUI.setFont("Arial", 25);
			custGUI.textProperties.setForeground(Color.black);
			
			
		}catch(ClassNotFoundException cnf) {
			
			cnf.printStackTrace();
			
		}catch(IOException e) {
			
			System.out.println("I/O Error: " + e.getMessage());
		}
		
	}

	/**
	 * Create the application.
	 */
	public MyCustomizableGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame_1 = new JFrame();
		frame_1.getContentPane().setBackground(new Color(255, 255, 255));
		frame_1.setResizable(true);
		frame_1.setBounds(100, 100, 450, 180);
		frame_1.setLocationRelativeTo(null);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setResizable(false);		 
		frame.setBounds(100, 100, 450, 232);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JComboBox comboColor = new JComboBox(color);
		comboColor.setVisible(false);
		comboColor.setBounds(240, 10, 184, 20);
		frame.getContentPane().add(comboColor);
				
		JLabel lblColor = new JLabel("Color:");
		lblColor.setVisible(false);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColor.setBounds(10, 11, 53, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblFont = new JLabel("Font:");
		lblFont.setVisible(false);
		lblFont.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFont.setBounds(10, 57, 46, 14);
		frame.getContentPane().add(lblFont);
		
		JLabel lblFontsize = new JLabel("FontSize:");
		lblFontsize.setVisible(false);
		lblFontsize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFontsize.setBounds(10, 108, 67, 14);
		frame.getContentPane().add(lblFontsize);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e -> {
			
			frame.setVisible(false);;
		});
		btnCancel.setVisible(false);
		btnCancel.setBounds(10, 169, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JComboBox comboFont = new JComboBox(font);
		comboFont.setVisible(false);
		comboFont.setBounds(240, 56, 184, 20);
		frame.getContentPane().add(comboFont);
		
		JComboBox comboFontSize = new JComboBox(fontSize);
		comboFontSize.setVisible(false);
		comboFontSize.setBounds(240, 107, 184, 20);
		frame.getContentPane().add(comboFontSize);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(evtSave -> {
			
			String fontChoosen;
			int fontSizeChoosen;
			
			frame.setVisible(false);
			
			if ((String) comboColor.getSelectedItem() == "Red") {
				
				textProperties.setForeground(Color.red);
				
			}else if((String) comboColor.getSelectedItem() == "Green"){
			
			    textProperties.setForeground(Color.green);
			    
		    }else if((String) comboColor.getSelectedItem() == "Blue"){
			
		        textProperties.setForeground(Color.blue);
	        }else if((String) comboColor.getSelectedItem() == "Cyan"){
		
	            textProperties.setForeground(Color.cyan);
            }else if((String) comboColor.getSelectedItem() == "Magenta"){
	
                textProperties.setForeground(Color.magenta);
            }else if((String) comboColor.getSelectedItem() == "Yellow"){
	
                textProperties.setForeground(Color.yellow);
            }else if((String) comboColor.getSelectedItem() == "Black"){
	
                textProperties.setForeground(Color.black);
            }
			
			fontChoosen = (String)comboFont.getSelectedItem();
			fontSizeChoosen = Integer.parseInt((String) comboFontSize.getSelectedItem());
			textProperties.setFont(new Font(fontChoosen, Font.PLAIN, fontSizeChoosen));
			
			
			UserPreferences userPref = new UserPreferences();
			userPref.setColor((String) comboColor.getSelectedItem());
			userPref.setFont(fontChoosen);
			userPref.setFontSize(fontSizeChoosen);
			
			
			try(FileOutputStream fOut = new FileOutputStream("preferences.ser");
		        ObjectOutputStream oOut = new ObjectOutputStream(fOut);){
				
				oOut.writeObject(userPref);
				
				
			}catch(IOException ioe) {
				
				System.out.printf("I/O Error!!!", ioe.getMessage());
				
			}						
			
		});
		
		btnSave.setVisible(false);
		btnSave.setBounds(119, 169, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 157, 444, 1);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(0, 157, 444, 46);
		frame.getContentPane().add(panel_1);
		
		
		
		
		
		
		textProperties = new JTextField("Type some text");
		textProperties.setFont(new Font("Arial", Font.PLAIN, 30));
		textProperties.setBounds(10, 11, 415, 58);
		frame_1.getContentPane().add(textProperties);
		textProperties.setColumns(10);
		
		JButton btnPreferences = new JButton("Preferences");
		btnPreferences.addActionListener(evt -> {			
			
			frame.setVisible(true);
			btnCancel.setVisible(true);
			btnSave.setVisible(true);
			lblColor.setVisible(true);
			lblFont.setVisible(true);
			lblFontsize.setVisible(true);
			comboColor.setVisible(true);
			comboFont.setVisible(true);
			comboFontSize.setVisible(true);			
		});				
		btnPreferences.setBounds(61, 106, 307, 23);
		frame_1.getContentPane().add(btnPreferences);
	}
	
	
	public void setFont (String f, int fs) {
		textProperties.setFont(new Font(f, Font.PLAIN, fs));	
	}
}

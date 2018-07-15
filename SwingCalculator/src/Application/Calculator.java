package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Calculator {

	private JFrame Calculator_v1;
	private JTextField txtDisplay;
	
	double firstNum;
	double secondNum;
	double result;
	String operations;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.Calculator_v1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Calculator_v1 = new JFrame();
		Calculator_v1.setMaximumSize(new Dimension(289, 434));
		Calculator_v1.setMinimumSize(new Dimension(289, 434));
		Calculator_v1.setAlwaysOnTop(true);
		Calculator_v1.setTitle("Calculator v1");
		Calculator_v1.setBounds(100, 100, 298, 434);
		Calculator_v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calculator_v1.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setAlignmentY(Component.TOP_ALIGNMENT);
		txtDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDisplay.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 34));
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(26, 11, 230, 59);
		Calculator_v1.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EnterNumber = txtDisplay.getText() + btn7.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn7.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn7.setBounds(26, 142, 50, 50);
		Calculator_v1.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EnterNumber = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn8.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn8.setBounds(86, 142, 50, 50);
		Calculator_v1.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn9.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn9.setBounds(146, 142, 50, 50);
		Calculator_v1.getContentPane().add(btn9);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "+";
			}
		});
		btnPlus.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnPlus.setBounds(206, 264, 50, 50);
		Calculator_v1.getContentPane().add(btnPlus);
		
		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn4.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn4.setBounds(26, 203, 50, 50);
		Calculator_v1.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn5.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn5.setBounds(86, 203, 50, 50);
		Calculator_v1.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn6.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn6.setBounds(146, 203, 50, 50);
		Calculator_v1.getContentPane().add(btn6);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-";
			}
		});
		btnMinus.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnMinus.setBounds(206, 203, 50, 50);
		Calculator_v1.getContentPane().add(btnMinus);
		
		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn1.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn1.setBounds(26, 264, 50, 50);
		Calculator_v1.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn2.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn2.setBounds(86, 264, 50, 50);
		Calculator_v1.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn3.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn3.setBounds(146, 264, 50, 50);
		Calculator_v1.getContentPane().add(btn3);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				
				secondNum = Double.parseDouble(txtDisplay.getText());
				
				if(operations == "+") {
					
					result = firstNum + secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
					
				} else if(operations == "-") {
					
					result = firstNum - secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
					
				}else if(operations == "*") {
					
					result = firstNum * secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
					
				}else if(operations == "/") {
					
					result = firstNum / secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
					
				} else if(operations == "%") {
					
					result = firstNum % secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
					
				}else if(operations ==".") {
					
					result = firstNum * 1.0;
				}
			}
		});
		btnEqual.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnEqual.setBounds(206, 325, 49, 50);
		Calculator_v1.getContentPane().add(btnEqual);
		
		JButton btn0 = new JButton("0");
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn0.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn0.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn0.setBounds(86, 325, 50, 50);
		Calculator_v1.getContentPane().add(btn0);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "/";
			}
		});
		btnDivide.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnDivide.setBounds(206, 81, 50, 50);
		Calculator_v1.getContentPane().add(btnDivide);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnMultiply.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "*";
			}
		});
		btnMultiply.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnMultiply.setBounds(206, 142, 50, 50);
		Calculator_v1.getContentPane().add(btnMultiply);
		
		JButton btnPercent = new JButton("%");
		btnPercent.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "%";
			}
		});
		btnPercent.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnPercent.setBounds(146, 81, 50, 50);
		Calculator_v1.getContentPane().add(btnPercent);
		
		JButton btnC = new JButton("+/-");
		btnC.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = ops * (-1);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnC.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnC.setBounds(26, 325, 50, 50);
		Calculator_v1.getContentPane().add(btnC);
		
		JButton btnDelete = new JButton("\uF0E7");
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String backspace = null;
				
				if(txtDisplay.getText().length()>0) {
					StringBuilder strB = new StringBuilder(txtDisplay.getText());
					strB.deleteCharAt(txtDisplay.getText().length() - 1);
					backspace = strB.toString();
					txtDisplay.setText(backspace);
				}
			}
		});
		btnDelete.setFont(new Font("Wingdings", Font.PLAIN, 15));
		btnDelete.setBounds(26, 81, 50, 50);
		Calculator_v1.getContentPane().add(btnDelete);
		
		JButton btnDot = new JButton(".");
		btnDot.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btnDot.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btnDot.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnDot.setBounds(146, 325, 50, 50);
		Calculator_v1.getContentPane().add(btnDot);
		
		JButton btnC_1 = new JButton("C");
		btnC_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btnMultiply.getText();
				txtDisplay.setText(null);
			}
		});
		btnC_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnC_1.setBounds(86, 81, 50, 50);
		Calculator_v1.getContentPane().add(btnC_1);
	}
}

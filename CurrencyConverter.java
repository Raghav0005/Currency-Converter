/**
 *  A currency converter between set 7 currencies.
 * 
 * modified     20210825
 * date         20210825
 * @filename    CurrencyConverter.java
 * @author      Raghav Vasudeva
 * @version     1.0
 * @see         unit 5.1 and 5.2 content
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CurrencyConverter {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
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
	public CurrencyConverter() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(115, 10, 154, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 115, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(76, 117, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(139, 198, 180, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Converting from...");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 61, 106, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("to...");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1.setBounds(219, 61, 50, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		
		String[] conversionFrom = {"USD", "CAD", "Pounds", "Rupee", "Euro", "Swiss Franc", "Yen"};
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(conversionFrom));
		comboBox.setBounds(106, 57, 103, 21);
		frame.getContentPane().add(comboBox);
		
		
		String[] conversionTo = {"USD", "CAD", "Pounds", "Rupee", "Euro", "Swiss Franc", "Yen"};
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(conversionTo));
		comboBox_1.setBounds(250, 57, 106, 21);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(163, 144, 115, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_5.setBounds(10, 229, 340, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		double[] cadConversions = {0.79242322, 0.57789829, 58.77868, 0.67493841, 0.72393585, 86.971112};
		
		JButton btnNewButton = new JButton("Check Conversion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String convertFrom = comboBox.getSelectedItem().toString();
				String convertTo = comboBox_1.getSelectedItem().toString();
				
				try {
					lblNewLabel_4.setText("");
					
					double amount = Double.parseDouble(textField.getText());
					if(amount < 0) {
						throw new IllegalArgumentException(); //https://stackoverflow.com/questions/35604342/im-trying-to-add-a-try-catch-that-tells-the-user-they-cant-plug-in-negative-numb
					}
					double converted;
					
					switch(convertFrom) { // https://www.w3schools.com/java/java_switch.asp
					case "USD":
						converted = Math.round(usd(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "CAD":
						converted = Math.round(cad(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "Pounds":
						converted = Math.round(pounds(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "Rupee":
						converted = Math.round(rupee(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "Euro":
						converted = Math.round(euro(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "Swiss Franc":
						converted = Math.round(swissFranc(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					case "Yen":
						converted = Math.round(yen(convertTo, amount) * 100) / 100.00;
						lblNewLabel_2.setText("The converted value is: " + String.valueOf(converted));
						break;
					}
					
					lblNewLabel_5.setText(calculations(cadConversions));
					
				}
				catch(NumberFormatException e1) {
					lblNewLabel_4.setText("Invalid Input.");
				}
				catch(IllegalArgumentException e2) {  // https://stackoverflow.com/questions/3495926/can-i-catch-multiple-java-exceptions-in-the-same-catch-clause
					lblNewLabel_4.setText("Invalid Input.");
				}
			}
		});
		btnNewButton.setBounds(115, 167, 171, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Switch");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String convertFrom = comboBox.getSelectedItem().toString();
				String convertTo = comboBox_1.getSelectedItem().toString();
				
				String temp = convertTo;
				convertTo = convertFrom;
				convertFrom = temp;
				comboBox.setSelectedItem(convertFrom);  // http://www.java2s.com/Tutorial/Java/0240__Swing/GettingandSettingtheSelectedIteminaJComboBoxComponent.htm
				comboBox_1.setSelectedItem(convertTo);
				
			}
		});
		btnNewButton_1.setBounds(184, 84, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
	}
	
	public static String calculations(double[] x) {
		Random random = new Random();
		int ran = random.nextInt(2);
		
		double max = x[0];
		for(int i=0; i<x.length; i++) {
			if(x[i] > max) {
				max = x[i];
			}
		}
		
		double min = x[0];
		for(int i=0; i<x.length; i++) {
			if(x[i] < max) {
				min = x[i];
			}
		}
		String output;
		if(ran==0) {
			output = "The highest currency transfer rate from CAD is " + max + " for Japanese Yen.";
		}
		else {
			output = "The lowest currency transfer rate from CAD is " + min + " for British Pounds.";
		}
		return output;
	}
	
	// all conversion values retrieved from https://www.xe.com/currencyconverter/
	public static double usd(String y, double z) {
		double result;
		
		final double TO_CAD = 1.2618478;
		final double TO_POUNDS = 0.72912405;
		final double TO_RUPEE = 74.146125;
		final double TO_EURO = 0.85138899;
		final double TO_SWISS_FRANC = 0.91309932;
		final double TO_YEN = 109.69391;
		
		if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double cad(String y, double z) {
		double result;
		
		final double TO_USD = 0.79242322;
		final double TO_POUNDS = 0.57789829;
		final double TO_RUPEE = 58.77868;
		final double TO_EURO = 0.67493841;
		final double TO_SWISS_FRANC = 0.72393585;
		final double TO_YEN = 86.971112;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double pounds(String y, double z) {
		double result;
		
		final double TO_USD = 1.3714213;
		final double TO_CAD = 1.7300112;
		final double TO_RUPEE = 101.68177;
		final double TO_EURO = 1.1675164;
		final double TO_SWISS_FRANC = 1.2520744;
		final double TO_YEN = 150.45261;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double rupee(String y, double z) {
		double result;
		
		final double TO_USD = 0.013486229;
		final double TO_CAD = 0.017013679;
		final double TO_POUNDS = 0.0098347498;
		final double TO_EURO = 0.011483559;
		final double TO_SWISS_FRANC = 0.01231407;
		final double TO_YEN = 1.4795729;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double euro(String y, double z) {
		double result;
		
		final double TO_USD = 1.1744036;
		final double TO_CAD = 1.4814472;
		final double TO_POUNDS = 0.85637911;
		final double TO_RUPEE = 87.086405;
		final double TO_SWISS_FRANC = 1.0722629;
		final double TO_YEN = 128.8426;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double swissFranc(String y, double z) {
		double result;
		
		final double TO_USD = 1.0951901;
		final double TO_CAD = 1.3813841;
		final double TO_POUNDS = 0.79850148;
		final double TO_RUPEE = 81.214719;
		final double TO_EURO = 0.9325843;
		final double TO_YEN = 120.15403;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Yen")) {
			result = z*TO_YEN;
		}
		else {
			result = z;
		}
		return result;
	}
	
	public static double yen(String y, double z) {
		double result;
		
		final double TO_USD = 0.0091149515;
		final double TO_CAD = 0.011498594;
		final double TO_POUNDS = 0.006645087;
		final double TO_RUPEE = 0.67578961;
		final double TO_EURO = 0.007759875;
		final double TO_SWISS_FRANC = 0.0083212833;
		
		if(y.equals("USD")) {
			result = z*TO_USD;
		}
		else if(y.equals("CAD")) {
			result = z*TO_CAD;
		}
		else if(y.equals("Pounds")) {
			result = z*TO_POUNDS;
		}
		else if(y.equals("Rupee")) {
			result = z*TO_RUPEE;
		}
		else if(y.equals("Euro")) {
			result = z*TO_EURO;
		}
		else if(y.equals("Swiss Franc")) {
			result = z*TO_SWISS_FRANC;
		}
		else {
			result = z;
		}
		return result;
	}
}
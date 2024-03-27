package projectone;

import java.awt.Desktop.Action;
import java.awt.EventQueue;


import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;

import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
		
	}
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 570, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginPage = new JLabel("USER LOGIN ");
		lblLoginPage.setFont(new Font("Dialog", Font.BOLD, 31));
		lblLoginPage.setBounds(178, 12, 307, 53);
		frame.getContentPane().add(lblLoginPage);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 17));
		lblUserName.setBounds(50, 109, 127, 28);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPassword.setBounds(50, 166, 127, 28);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(278, 115, 170, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 163, 170, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			private JLabel textFiled;
/*
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText();
				String password=new String(passwordField.getPassword());
				
				if(password.equals("world") && username.equals("hello")) {
					
					
					textFiled.setText(null);
					passwordField.setText(null);
				}
				else{
					JOptionPane.showMessageDialog(null,"   Invalid Login   ","ERROR",JOptionPane.ERROR_MESSAGE);
				textField.setText(null);
				passwordField.setText(null);
				}
			}
			
			*/
		public void actionPerformed(ActionEvent e) {
			/*    String username = textField.getText();
			    String password = new String(passwordField.getPassword()); // Retrieve password securely

			    if (password.equals("world") && username.equals("hello")) { // Compare strings with equals() method
			        textField.setText(null);
			        passwordField.setText(null);
			    } else {
			        JOptionPane.showMessageDialog(null, "Invalid Login", "ERROR", JOptionPane.ERROR_MESSAGE);
			        textField.setText(null);
			        passwordField.setText(null);
			    }
			    
			    
			    */
			   
			     
			/*	

					try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","");
							Statement st=con.createStatement();
							String sql = "select * from loginpage where username='"+textField.getText()+"' and password='"+passwordField.getPassword()+"'";
							
							ResultSet rs=st.executeQuery(sql);
							
							
							if(rs.next()){
							JOptionPane.showMessageDialog(null, "Login successful");
							}
							else{
							JOptionPane.showMessageDialog(null, "Login unsuccessfull");
							}
							con.close();
							}
							catch(Exception x){
								
							System.out.println(x);
							
					}	

					
					}
			
			*/
			
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Project1", "root", "");
			        
			        // Prepare a PreparedStatement to prevent SQL injection
			        String sql = "SELECT * FROM loginpage2 WHERE username=? AND password=?";
			        PreparedStatement pst = con.prepareStatement(sql);
			        pst.setString(1, textField.getText()); // Set the username parameter
			        pst.setString(2, new String(passwordField.getPassword())); // Set the password parameter
			        
			        ResultSet rs = pst.executeQuery();

			        if (rs.next()) {
			            JOptionPane.showMessageDialog(null, "Login successful");
			        } else {
			            JOptionPane.showMessageDialog(null, "Login unsuccessful");
			        }

			        // Close resources
			        rs.close();
			        pst.close();
			        con.close();
			    } catch (Exception x) {
			        x.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Error: " + x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}

				
			

		});
		btnLogin.setBounds(41, 248, 113, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				
			}
		});
		btnReset.setBounds(205, 248, 113, 37);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(399, 248, 113, 37);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 223, 546, 13);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 63, 546, 13);
		frame.getContentPane().add(separator_1);
	}
}

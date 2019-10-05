package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setForeground(Color.BLACK);
		panel.setBounds(15, 26, 398, 71);
		contentPane.add(panel);
		
		JLabel lblSkapa = new JLabel("SKAPA");
		lblSkapa.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 40));
		panel.add(lblSkapa);
		lblSkapa.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsername = new JLabel("Usuario");
		lblUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblUsername.setBounds(15, 140, 112, 20);
		contentPane.add(lblUsername);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblContrasea.setBounds(15, 249, 112, 20);
		contentPane.add(lblContrasea);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setTabSize(18);
		textArea.setBounds(15, 176, 398, 35);
		contentPane.add(textArea);
		
		JButton btnSingIn = new JButton("Sing In");
		btnSingIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSingIn.setBackground(new Color(204, 255, 255));
		btnSingIn.setBounds(298, 361, 115, 29);
		contentPane.add(btnSingIn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(15, 285, 398, 35);
		contentPane.add(passwordField);
	}
}

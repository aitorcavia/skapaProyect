package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Usuario");
		label.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		label.setBounds(15, 39, 112, 20);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setTabSize(18);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(15, 75, 388, 35);
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		label_1.setBounds(15, 140, 112, 20);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(15, 176, 388, 35);
		contentPane.add(passwordField);
		
		JLabel lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblEmail.setBounds(15, 245, 201, 20);
		contentPane.add(lblEmail);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setTabSize(18);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setBounds(15, 281, 388, 35);
		contentPane.add(textArea_1);
		
		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrarme.setBackground(new Color(204, 255, 255));
		btnRegistrarme.setBounds(263, 355, 140, 29);
		contentPane.add(btnRegistrarme);
	}
}
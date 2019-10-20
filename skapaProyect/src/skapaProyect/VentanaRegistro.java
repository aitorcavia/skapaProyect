package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Dialog.ModalExclusionType;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPasswordField textoContrasenya;

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
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		labelUsuario.setBounds(15, 39, 112, 20);
		contentPane.add(labelUsuario);
		
		JTextArea textoUsuario = new JTextArea();
		textoUsuario.setTabSize(18);
		textoUsuario.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoUsuario.setBounds(15, 75, 388, 35);
		contentPane.add(textoUsuario);
		
		JLabel labelConstrasenya = new JLabel("Contrase\u00F1a");
		labelConstrasenya.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		labelConstrasenya.setBounds(15, 140, 112, 20);
		contentPane.add(labelConstrasenya);
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoContrasenya.setBounds(15, 176, 388, 35);
		contentPane.add(textoContrasenya);
		
		JLabel labelCorreo = new JLabel("Correo electr\u00F3nico");
		labelCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		labelCorreo.setBounds(15, 245, 201, 20);
		contentPane.add(labelCorreo);
		
		JTextArea textoCorreo = new JTextArea();
		textoCorreo.setTabSize(18);
		textoCorreo.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoCorreo.setBounds(15, 281, 388, 35);
		contentPane.add(textoCorreo);
		
		JButton botonRegistro = new JButton("Registrarme");
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botonRegistro.setBackground(new Color(204, 255, 255));
		botonRegistro.setBounds(263, 355, 140, 29);
		contentPane.add(botonRegistro);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBackground(new Color(135, 206, 235));
		botonAtras.setBounds(15, 422, 91, 29);
		contentPane.add(botonAtras);
		
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario; 
				String contrasenya;
				String correo;
				 
				usuario = textoUsuario.getText();
				contrasenya = textoContrasenya.getText();
				correo = textoCorreo.getText();
				
				Usuario u = new Usuario (usuario, contrasenya, correo);
				System.out.println(u);
				
				JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1);
				
				VentanaLogin vl = new VentanaLogin();
				setVisible(false);
				vl.setVisible(true);
			}
		});
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vl = new VentanaLogin();
				setVisible(false);
				vl.setVisible(true);
				
			}
		});
		
	
		
		
	}
}
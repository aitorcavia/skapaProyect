package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class VentanaVerificacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerificacion frame = new VentanaVerificacion();
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
	public VentanaVerificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtVerificar = new JTextPane();
		txtVerificar.setBackground(new Color(135, 206, 250));
		txtVerificar.setForeground(new Color(0, 0, 0));
		txtVerificar.setEditable(false);
		txtVerificar.setText("Al verificar tu identidad aumentar\u00E1 la confianza de tu perfil en la comunidad SKAPA");
		txtVerificar.setBounds(47, 11, 216, 91);
		contentPane.add(txtVerificar);
		
		JButton botonGmail = new JButton("Gmail");
		botonGmail.setBackground(SystemColor.menu);
		botonGmail.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		botonGmail.setBounds(10, 131, 89, 23);
		contentPane.add(botonGmail);
		
		JButton botonTelefono = new JButton("Tel\u00E9fono\r\n");
		botonTelefono.setBackground(SystemColor.menu);
		botonTelefono.setBounds(10, 186, 89, 23);
		contentPane.add(botonTelefono);
		
		JButton botonFacebook = new JButton("Facebook");
		botonFacebook.setBackground(SystemColor.menu);
		botonFacebook.setBounds(10, 242, 89, 23);
		contentPane.add(botonFacebook);
		
		botonGmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://accounts.google.com/");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
			
		});
		
		botonTelefono.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		botonFacebook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://es-es.facebook.com/");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
			
		});
		
		
	}

}

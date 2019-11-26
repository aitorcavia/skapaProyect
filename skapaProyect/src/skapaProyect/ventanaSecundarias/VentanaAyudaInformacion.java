package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaAyudaInformacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAyudaInformacion frame = new VentanaAyudaInformacion();
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
	public VentanaAyudaInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel TextoCorreoDeContacto = new JLabel();
		TextoCorreoDeContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoCorreoDeContacto.setFocusable(false);
		TextoCorreoDeContacto.setText("Correo de Contacto");
		TextoCorreoDeContacto.setBounds(15, 70, 184, 26);
		contentPane.add(TextoCorreoDeContacto);
		
		JLabel TextoCorreo = new JLabel();
		TextoCorreo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TextoCorreo.setFocusable(false);
		TextoCorreo.setText("      skapatutienda2@gmail.com");
		TextoCorreo.setBounds(70, 116, 339, 41);
		contentPane.add(TextoCorreo);
		
		JLabel TextoInstagram = new JLabel();
		TextoInstagram.setFocusable(false);
		TextoInstagram.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoInstagram.setText("Instagram");
		TextoInstagram.setBounds(15, 202, 157, 47);
		contentPane.add(TextoInstagram);
		
		JLabel TextoNombreInstagram = new JLabel();
		TextoNombreInstagram.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextoNombreInstagram.setText("Skapa");
		TextoNombreInstagram.setBounds(118, 265, 120, 38);
		contentPane.add(TextoNombreInstagram);
		
		JLabel TextoIntroduccion = new JLabel();
		TextoIntroduccion.setFocusable(false);
		TextoIntroduccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		TextoIntroduccion.setText("En caso de necesitar ayuda contacte con nosotros ");
		TextoIntroduccion.setBounds(15, 0, 435, 81);
		contentPane.add(TextoIntroduccion);
		
		
		JButton Volver = new JButton("A");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(274, 458, 104, 29);
		contentPane.add(Volver);
		
		JButton imagenGmail = new JButton();
		imagenGmail.setBounds(15, 112, 79, 74);
		ImageIcon imagenP = new ImageIcon("../skapaProyect/multimedia/Captura.png");
		
		Icon icono = new ImageIcon(imagenP.getImage().getScaledInstance(imagenGmail.getWidth(), imagenGmail.getHeight(), Image.SCALE_DEFAULT));
		imagenGmail.setIcon(icono);
		contentPane.add(imagenGmail);
		
		imagenGmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
		});
		
		JButton imagenInstagram = new JButton();
		imagenInstagram.setBounds(15, 250, 79, 72);
		ImageIcon imagenP1 = new ImageIcon("../skapaProyect/multimedia/Captura1.png");
		
		Icon icono1 = new ImageIcon(imagenP1.getImage().getScaledInstance(imagenInstagram.getWidth(), imagenInstagram.getHeight(), Image.SCALE_DEFAULT));
		imagenInstagram.setIcon(icono1);
		contentPane.add(imagenInstagram);
		
		imagenInstagram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://www.instagram.com/skapaaaa/?hl=es");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
		});
		
		
		JTextArea textoEslogan = new JTextArea();
		textoEslogan.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textoEslogan.setText("\"Una manera f\u00E1cil y gratuita de ganar dinero \r\n vendiendo las cosas que ya no usas desde \r\n una sola aplicaci\u00F3n. En esta aplicaci\u00F3n puedes\r\n  vender, ceder incluso intercambiar objetos\"");
		textoEslogan.setBounds(15, 345, 379, 81);
		textoEslogan.setOpaque(false);
		contentPane.add(textoEslogan);

		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes vA = new VentanaAjustes();
				setVisible(false);
				vA.setVisible(true);
				}
			});
	}
}

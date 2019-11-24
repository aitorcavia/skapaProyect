package skapaProyect.VentanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.VentanasPrimarias.VentanaProductosVendidos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class VentanaInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInfo frame = new VentanaInfo();
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
	public VentanaInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHistorial = new JLabel("Historial");
		labelHistorial.setBounds(21, 0, 73, 39);
		contentPane.add(labelHistorial);
		
		JButton botonProductosVendidos = new JButton("Productos Vendidos");
		botonProductosVendidos.setBounds(50, 35, 137, 23);
		contentPane.add(botonProductosVendidos);
		
		JLabel labelInformacionVerificada = new JLabel("Informaci\u00F3n verificada");
		labelInformacionVerificada.setBounds(21, 69, 164, 39);
		contentPane.add(labelInformacionVerificada);
		
		JTextPane txtInformacionVerificada = new JTextPane();
		txtInformacionVerificada.setBackground(new Color(135, 206, 250));
		txtInformacionVerificada.setEditable(false);
		txtInformacionVerificada.setText("Facebook \r\n\r\n\r\n\r\n\r\n\r\nCorreo Eletr\u00F3nico\r\n\r\n\r\n\r\n\r\n\r\nNumero de Tel\u00E9fono\r\n\r\n\r\n\r\n\r\n\r\nIP");
		txtInformacionVerificada.setBounds(84, 104, 203, 323);
		contentPane.add(txtInformacionVerificada);
		
		JLabel labelMiembroDesde = new JLabel("Miembro desde");
		labelMiembroDesde.setBounds(10, 448, 97, 14);
		contentPane.add(labelMiembroDesde);
	
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(37, 468, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel imagenCorreo = new JLabel("Correo");
		imagenCorreo.setBounds(11, 190, 63, 58);
		ImageIcon imagenC = new ImageIcon("../skapaProyect/multimedia/correo.png");
		
		Icon icono = new ImageIcon(imagenC.getImage().getScaledInstance(imagenCorreo.getWidth(), imagenCorreo.getHeight(), Image.SCALE_DEFAULT));
		imagenCorreo.setIcon(icono);
		contentPane.add(imagenCorreo);
		
		
		JLabel imagenFacebook = new JLabel("Facebook");
		imagenFacebook.setBounds(11, 104, 63, 58);
		ImageIcon ImagenF = new ImageIcon("../skapaProyect/multimedia/facebook.png");
		
		Icon icono1 = new ImageIcon(ImagenF.getImage().getScaledInstance(imagenFacebook.getWidth(), imagenFacebook.getHeight(), Image.SCALE_DEFAULT));
		imagenFacebook.setIcon(icono1);
		contentPane.add(imagenFacebook);
		
		JLabel imagenTelefono = new JLabel("Telefono");
		imagenTelefono.setBounds(10, 273, 63, 58);
		ImageIcon ImagenT = new ImageIcon("../skapaProyect/multimedia/icono-telefono.png");
		
		Icon icono2 = new ImageIcon(ImagenT.getImage().getScaledInstance(imagenTelefono.getWidth(), imagenTelefono.getHeight(), Image.SCALE_DEFAULT));
		imagenTelefono.setIcon(icono2);
		contentPane.add(imagenTelefono);
		
		JLabel imagenIP = new JLabel("IP");
		imagenIP.setBounds(10, 371, 64, 58);
		ImageIcon ImagenI = new ImageIcon("../skapaProyect/multimedia/iconoIp.PNG");
		
		Icon icono3 = new ImageIcon(ImagenI.getImage().getScaledInstance(imagenIP.getWidth(), imagenIP.getHeight(), Image.SCALE_DEFAULT));
		imagenIP.setIcon(icono3);
		contentPane.add(imagenIP);
		
		
		
		botonProductosVendidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaProductosVendidos vp = new VentanaProductosVendidos();
				setVisible(false);
				vp.setVisible(true);
				
			}
			
		});
		
		txtInformacionVerificada.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			VentanaVerificacion vr = new VentanaVerificacion();
			setVisible(false);
			vr.setVisible(true);
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		imagenFacebook.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
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

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		imagenCorreo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
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

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		imagenTelefono.addMouseListener (new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Crear en la BD un metodo 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		imagenIP.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Hay que conectarlo con la BD para poder obetener los distintos IP
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
	}
}

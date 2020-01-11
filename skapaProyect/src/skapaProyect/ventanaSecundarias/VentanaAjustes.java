package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.ventanasPrimarias.VentanaInicio;
import skapaProyect.ventanasPrimarias.VentanaLogin;
import skapaProyect.ventanasPrimarias.VentanaPerfil;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;

public class VentanaAjustes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAjustes frame = new VentanaAjustes();
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
	public VentanaAjustes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonSalir = new JButton("Salir de la aplicacion");
		BotonSalir.setBackground(new Color(255, 255, 255));
		BotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonSalir.setBounds(15, 326, 297, 29);
		contentPane.add(BotonSalir);
		
		JButton BotonAnyadirCuenta = new JButton("Añadir Cuenta");
		BotonAnyadirCuenta.setBackground(new Color(255, 255, 255));
		BotonAnyadirCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAnyadirCuenta.setBounds(15, 292, 297, 29);
		contentPane.add(BotonAnyadirCuenta);
		
		JButton botonCerrarSesion = new JButton("Cerrar sesion");
		botonCerrarSesion.setBackground(new Color(255, 255, 255));
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrarSesion.setBounds(15, 258, 297, 29);
		contentPane.add(botonCerrarSesion);
		
		JButton BotonPrivacidad = new JButton("Privacidad de cuenta");
		BotonPrivacidad.setBackground(new Color(255, 255, 255));
		BotonPrivacidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonPrivacidad.setBounds(15, 95, 297, 29);
		contentPane.add(BotonPrivacidad);
		
		JButton BotonSeguridad = new JButton("Seguridad");
		BotonSeguridad.setBackground(new Color(255, 255, 255));
		BotonSeguridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonSeguridad.setBounds(15, 129, 297, 26);
		contentPane.add(BotonSeguridad);
		
		JButton BotonPago = new JButton("Pagos");
		BotonPago.setBackground(new Color(255, 255, 255));
		BotonPago.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonPago.setBounds(15, 161, 297, 26);
		contentPane.add(BotonPago);
		
		JButton BotonInformacion = new JButton("Ayuda");
		BotonInformacion.setBackground(new Color(255, 255, 255));
		BotonInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonInformacion.setBounds(15, 395, 297, 29);
		contentPane.add(BotonInformacion);
		BotonInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAyudaInformacion vI = new VentanaAyudaInformacion();
				setVisible(false);
				vI.setVisible(true);
				}
			});
		BotonPrivacidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrivacidad vPr = new VentanaPrivacidad();
				setVisible(false);
				vPr.setVisible(true);
				}
			});
		BotonPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPago vP = new VentanaPago();
				setVisible(false);
				vP.setVisible(true);
				}
			});
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(15, 458, 83, 29);
		contentPane.add(btnAtras);
		
		JLabel lblConfiguracion = new JLabel("Configuracion");
		lblConfiguracion.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblConfiguracion.setBounds(15, 16, 297, 29);
		contentPane.add(lblConfiguracion);
		
		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCuenta.setBounds(15, 61, 83, 20);
		contentPane.add(lblCuenta);
		
		JLabel lblSesion = new JLabel("Sesion");
		lblSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSesion.setBounds(15, 222, 69, 20);
		contentPane.add(lblSesion);
		
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil vP = new VentanaPerfil();
				setVisible(false);
				vP.setVisible(true);
				}
			});
		
		botonCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				dispose();
				
			
				
			}
		});
		
		BotonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
				
			}
		});
		
		
}	
}

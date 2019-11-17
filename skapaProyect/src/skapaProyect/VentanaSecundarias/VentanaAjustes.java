package skapaProyect.VentanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.VentanasPrimarias.VentanaInicio;
import skapaProyect.VentanasPrimarias.VentanaLogin;
import skapaProyect.VentanasPrimarias.VentanaPerfil;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane TextoAjustes = new JTextPane();
		TextoAjustes.setEditable(false);
		TextoAjustes.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAjustes.setText("      Ajustes");
		TextoAjustes.setBounds(0, 0, 128, 39);
		contentPane.add(TextoAjustes);
		
		JButton BotonSalir = new JButton("Salir de la aplicacion");
		BotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonSalir.setBounds(15, 467, 177, 36);
		contentPane.add(BotonSalir);
		
		JButton BotonAnyadirCuenta = new JButton("A�adir Cuenta");
		BotonAnyadirCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAnyadirCuenta.setBounds(15, 435, 177, 29);
		contentPane.add(BotonAnyadirCuenta);
		
		JButton botonCerrarSesion = new JButton("Cerrar sesion");
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrarSesion.setBounds(15, 404, 177, 29);
		contentPane.add(botonCerrarSesion);
		
		JTextPane TextoCuenta = new JTextPane();
		TextoCuenta.setEditable(false);
		TextoCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoCuenta.setText("        Cuenta");
		TextoCuenta.setBounds(15, 321, 142, 26);
		contentPane.add(TextoCuenta);
		
		JTextPane TextoAnuncios = new JTextPane();
		TextoAnuncios.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAnuncios.setEditable(false);
		TextoAnuncios.setText("       Anuncios");
		TextoAnuncios.setBounds(15, 147, 142, 39);
		contentPane.add(TextoAnuncios);
		
		JTextPane TextoPagos = new JTextPane();
		TextoPagos.setFont(new Font("Tahoma", Font.BOLD, 18));
		TextoPagos.setEditable(false);
		TextoPagos.setText("        Pagos");
		TextoPagos.setBounds(15, 192, 142, 39);
		contentPane.add(TextoPagos);
		
		JTextPane TextoAyuda = new JTextPane();
		TextoAyuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAyuda.setEditable(false);
		TextoAyuda.setText("         Ayuda");
		TextoAyuda.setBounds(15, 237, 142, 26);
		contentPane.add(TextoAyuda);
		
		JTextPane TextoInformacion = new JTextPane();
		TextoInformacion.setEditable(false);
		TextoInformacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoInformacion.setText("     Informaci\u00F3n");
		TextoInformacion.setBounds(15, 279, 142, 26);
		contentPane.add(TextoInformacion);
		
		JTextPane TextoPrivacidad = new JTextPane();
		TextoPrivacidad.setEditable(false);
		TextoPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoPrivacidad.setText("     Privacidad");
		TextoPrivacidad.setBounds(15, 76, 142, 26);
		contentPane.add(TextoPrivacidad);
		
		JTextPane TextoSeguridad = new JTextPane();
		TextoSeguridad.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoSeguridad.setEditable(false);
		TextoSeguridad.setText("     Seguridad");
		TextoSeguridad.setBounds(15, 110, 142, 26);
		contentPane.add(TextoSeguridad);
		
		JButton BotonPrivacidad = new JButton("P");
		BotonPrivacidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonPrivacidad.setBounds(168, 73, 115, 29);
		contentPane.add(BotonPrivacidad);
		
		JButton BotonSeguridad = new JButton("S");
		BotonSeguridad.setBounds(168, 110, 115, 26);
		contentPane.add(BotonSeguridad);
		
		JButton BotonAnuncio = new JButton("A");
		BotonAnuncio.setBounds(168, 147, 115, 29);
		contentPane.add(BotonAnuncio);
		
		JButton BotonPago = new JButton("$");
		BotonPago.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonPago.setBounds(168, 192, 115, 39);
		contentPane.add(BotonPago);
		
		JButton BotonInformacion = new JButton("(i) / Ayuda");
		BotonInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonInformacion.setBounds(168, 237, 115, 68);
		contentPane.add(BotonInformacion);
		
		JButton BotonCuenta = new JButton("C");
		BotonCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonCuenta.setBounds(168, 318, 115, 29);
		contentPane.add(BotonCuenta);
		
		
		BotonAnuncio.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			VentanaAnuncio vA = new VentanaAnuncio();
			setVisible(false);
			vA.setVisible(true);
			}
		});
		BotonCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio vC = new VentanaInicio();
				setVisible(false);
				vC.setVisible(true);
				}
			});
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
		JButton btnAtras = new JButton("<--\r\n");
		btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(239, 467, 83, 29);
		contentPane.add(btnAtras);
		
		
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
				setVisible(false);
				
			}
		});
		
		
		
}}
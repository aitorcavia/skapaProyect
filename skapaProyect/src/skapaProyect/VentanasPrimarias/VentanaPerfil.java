package skapaProyect.VentanasPrimarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.DataBase.DBException;
import skapaProyect.DataBase.DBManager;
import skapaProyect.VentanaSecundarias.VentanaPago;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	private int contC1 = 0;
	private int contC2 = 0;
	private int contC3 = 0;
	private int contC4 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil();
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
	public VentanaPerfil() {
		
		int idUsuario = VentanaLogin.getUsuarioId();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 621);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CREADO Y ESCALADO DE IMAGEN
		
		JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(415, 41, 105, 107);
	
		ImageIcon imagenP = new ImageIcon("../skapaProyect/multimedia/FotoPerfil.png");
		
		Icon icono = new ImageIcon(imagenP.getImage().getScaledInstance(imagenPerfil.getWidth(), imagenPerfil.getHeight(), Image.SCALE_DEFAULT));
		imagenPerfil.setIcon(icono);
		
		contentPane.add(imagenPerfil);
		
		JLabel TextoNombre = new JLabel();
		TextoNombre.setText("Nombre");
		TextoNombre.setBounds(15, 170, 72, 26);
		contentPane.add(TextoNombre);
		
		JTextPane nombreUsuario = new JTextPane();
		nombreUsuario.setBounds(102, 170, 384, 26);
		contentPane.add(nombreUsuario);
		
		JLabel TextoUbicacinProvincia = new JLabel();
		TextoUbicacinProvincia.setText("Apellidos");
		TextoUbicacinProvincia.setBounds(15, 202, 72, 26);
		contentPane.add(TextoUbicacinProvincia);
		
		JTextPane apellidoUsuario = new JTextPane();
		apellidoUsuario.setBounds(102, 202, 384, 26);
		contentPane.add(apellidoUsuario);
		
		JLabel TextoUbicacinProvincia_1 = new JLabel();
		TextoUbicacinProvincia_1.setText("Ubicaci\u00F3n / Provincia");
		TextoUbicacinProvincia_1.setBounds(15, 235, 162, 26);
		contentPane.add(TextoUbicacinProvincia_1);
		
		JTextPane ubicacionProvinciaUsuario = new JTextPane();
		ubicacionProvinciaUsuario.setBounds(185, 235, 301, 26);
		contentPane.add(ubicacionProvinciaUsuario);
		
		JLabel txtpnInformacinPrivada = new JLabel();
		txtpnInformacinPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnInformacinPrivada.setText("Informacion personal\r\n");
		txtpnInformacinPrivada.setBounds(15, 16, 218, 26);
		contentPane.add(txtpnInformacinPrivada);
		
		JLabel labelAnyoN = new JLabel();
		labelAnyoN.setText("A\u00F1o de nacimiento");
		labelAnyoN.setBounds(15, 277, 152, 26);
		contentPane.add(labelAnyoN);
		
		JLabel TextoCorreoElectrnico = new JLabel();
		TextoCorreoElectrnico.setText("Correo electr\u00F3nico");
		TextoCorreoElectrnico.setBounds(15, 406, 162, 26);
		contentPane.add(TextoCorreoElectrnico);
		
		JButton BotonTarjeta = new JButton("Tarjeta");
		BotonTarjeta.setBackground(new Color(224, 255, 255));
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonTarjeta.setBounds(371, 448, 115, 29);
		contentPane.add(BotonTarjeta);
		
		DBManager conexion = new DBManager();
		try {
			conexion.connect();
			
			Usuario usuario = conexion.buscarUsuarioId(idUsuario);
			
			JLabel labelNombreUsuario = new JLabel(usuario.getNombre());
			labelNombreUsuario.setBounds(25, 58, 152, 20);
			contentPane.add(labelNombreUsuario);
			conexion.disconnect();
			
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		JComboBox comboAnyo = new JComboBox();
		
		Calendar data = Calendar.getInstance();
		int cont = 0;
		int anyo = data.get(Calendar.YEAR);
		while (cont < 80) {
			String anyoActual = Integer.toString(anyo);
			comboAnyo.addItem(anyoActual);
			cont++;
			anyo--;
			
		
		}
	
		
		comboAnyo.setToolTipText("");
		comboAnyo.setBounds(185, 277, 301, 26);
		contentPane.add(comboAnyo);
		
		JTextPane textoCorreo = new JTextPane();
		textoCorreo.setBounds(170, 406, 317, 26);
		contentPane.add(textoCorreo);
		
		
		
		JLabel lblInformacionPrivada = new JLabel();
		lblInformacionPrivada.setText("Informacion privada");
		lblInformacionPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformacionPrivada.setBounds(15, 357, 218, 26);
		contentPane.add(lblInformacionPrivada);
		
		JLabel lblGestionDePago = new JLabel();
		lblGestionDePago.setText("Gestion de pago\r\n");
		lblGestionDePago.setBounds(15, 448, 132, 26);
		contentPane.add(lblGestionDePago);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBounds(340, 520, 180, 29);
		contentPane.add(btnGuardarCambios);
		
		
		ImageIcon imagenCandadoCerrado = new ImageIcon("../skapaProyect/multimedia/candadoCerrado.png");
		ImageIcon imagenCandadoAbierto = new ImageIcon("../skapaProyect/multimedia/candadoAbierto.png");
		
		
		
		//BOTON CANDADO 1 (Nombre)
	
		JButton botonCNombre = new JButton("");
		botonCNombre.setBounds(491, 170, 29, 26);
		
		Icon iconoCandadoC1 = new ImageIcon(imagenCandadoCerrado.getImage().getScaledInstance(botonCNombre.getWidth(), botonCNombre.getHeight(), Image.SCALE_DEFAULT));
		Icon iconoCandadoA1 = new ImageIcon(imagenCandadoAbierto.getImage().getScaledInstance(botonCNombre.getWidth(), botonCNombre.getHeight(), Image.SCALE_DEFAULT));
		
		botonCNombre.setIcon(iconoCandadoC1);
		contentPane.add(botonCNombre);
		
		botonCNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (contC1 % 2 ==0) {
					botonCNombre.setIcon(iconoCandadoA1);
				}else {
					botonCNombre.setIcon(iconoCandadoC1);
				}
				
				contC1 = contC1 + 1;
				
			}
		});
		
		//BOTON CANDADO 2 (Apellidos)
		
		JButton botonCApellidos = new JButton("");
		botonCApellidos.setBounds(491, 202, 29, 26);
		
		Icon iconoCandadoC2 = new ImageIcon(imagenCandadoCerrado.getImage().getScaledInstance(botonCApellidos.getWidth(), botonCApellidos.getHeight(), Image.SCALE_DEFAULT));
		Icon iconoCandadoA2 = new ImageIcon(imagenCandadoAbierto.getImage().getScaledInstance(botonCApellidos.getWidth(), botonCApellidos.getHeight(), Image.SCALE_DEFAULT));
		
		botonCApellidos.setIcon(iconoCandadoC2);
		contentPane.add(botonCApellidos);
		
		botonCApellidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (contC2 % 2 ==0) {
					botonCApellidos.setIcon(iconoCandadoA2);
				}else {
					botonCApellidos.setIcon(iconoCandadoC2);
				}
				
				contC2 = contC2 + 1;	
			}
		});
		
		
		//BOTON CANDADO 3 (Provincia)
		
		JButton botonCProvincia = new JButton("");
		botonCProvincia.setBounds(491, 235, 29, 26);
		Icon iconoCandadoC3 = new ImageIcon(imagenCandadoCerrado.getImage().getScaledInstance(botonCProvincia.getWidth(), botonCProvincia.getHeight(), Image.SCALE_DEFAULT));
		Icon iconoCandadoA3 = new ImageIcon(imagenCandadoAbierto.getImage().getScaledInstance(botonCProvincia.getWidth(), botonCProvincia.getHeight(), Image.SCALE_DEFAULT));
		
		botonCProvincia.setIcon(iconoCandadoC3);
		contentPane.add(botonCProvincia);
		
		botonCProvincia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (contC3 % 2 ==0) {
					botonCProvincia.setIcon(iconoCandadoA3);
				}else {
					botonCProvincia.setIcon(iconoCandadoC3);
				}
				
				contC3 = contC3 + 1;	
			}
		});
		
		//BOTON CANDADO 4 (Año de nacimiento)
		
		JButton botonCAnyo = new JButton("");
		botonCAnyo.setBounds(491, 276, 29, 26);
		
		Icon iconoCandadoC4 = new ImageIcon(imagenCandadoCerrado.getImage().getScaledInstance(botonCAnyo.getWidth(), botonCAnyo.getHeight(), Image.SCALE_DEFAULT));
		Icon iconoCandadoA4 = new ImageIcon(imagenCandadoAbierto.getImage().getScaledInstance(botonCAnyo.getWidth(), botonCAnyo.getHeight(), Image.SCALE_DEFAULT));
				
		botonCAnyo.setIcon(iconoCandadoC4);
		contentPane.add(botonCAnyo);
				
		botonCAnyo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
				if (contC4 % 2 ==0) {
					botonCAnyo.setIcon(iconoCandadoA4);
				}else {
					botonCAnyo.setIcon(iconoCandadoC4);
				}
		
				contC4 = contC4 + 1;	
					}
				});
				
			
		
		
		
		
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPago vP = new VentanaPago();
				setVisible(false);
				vP.setVisible(true);
				}
			});
	}
}

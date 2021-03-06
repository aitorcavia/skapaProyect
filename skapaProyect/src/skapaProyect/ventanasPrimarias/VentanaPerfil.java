package skapaProyect.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.*;
import skapaProyect.ventanaSecundarias.VentanaAjustes;
import skapaProyect.ventanaSecundarias.VentanaPago;
import skapaProyect.ventanaSecundarias.VentanaPrivacidad;
import skapaProyect.webCam.WebcamViewerExample;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	private int contC1 = 0;
	private int contC2 = 0;
	private int contC3 = 0;
	private int contC4 = 0;
	private int valueProgressBar = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LogController.log ( Level.INFO, "Inicio Ventana " + (new Date()),null);
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
		
		//CREACION DE INTERFACE
		int contBarra = 0;
		int idUsuario = VentanaLogin.getUsuarioId();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 557, 621);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CREADO Y ESCALADO DE IMAGEN
		JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(415, 14, 105, 103);
	
		ImageIcon imagenP = new ImageIcon("../skapaProyect/multimedia/FotoPerfil.png");
		
		Icon icono = new ImageIcon(imagenP.getImage().getScaledInstance(imagenPerfil.getWidth(), imagenPerfil.getHeight(), Image.SCALE_DEFAULT));
		imagenPerfil.setIcon(icono);
		
		contentPane.add(imagenPerfil);
		
		JLabel TextoNombre = new JLabel();
		TextoNombre.setText("Nombre");
		TextoNombre.setBounds(15, 133, 72, 26);
		contentPane.add(TextoNombre);
		
		
		
		JLabel TextoUbicacinProvincia = new JLabel();
		TextoUbicacinProvincia.setText("Apellidos");
		TextoUbicacinProvincia.setBounds(15, 164, 72, 26);
		contentPane.add(TextoUbicacinProvincia);
		
		
		
		JLabel TextoUbicacinProvincia_1 = new JLabel();
		TextoUbicacinProvincia_1.setText("Ubicaci\u00F3n / Provincia");
		TextoUbicacinProvincia_1.setBounds(15, 195, 162, 26);
		contentPane.add(TextoUbicacinProvincia_1);
		
		
		
		JLabel txtpnInformacinPrivada = new JLabel();
		txtpnInformacinPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnInformacinPrivada.setText("Informacion personal\r\n");
		txtpnInformacinPrivada.setBounds(15, 16, 218, 26);
		contentPane.add(txtpnInformacinPrivada);
		
		JLabel labelAnyoN = new JLabel();
		labelAnyoN.setText("A\u00F1o de nacimiento");
		labelAnyoN.setBounds(15, 233, 152, 26);
		contentPane.add(labelAnyoN);
		
		JLabel TextoCorreoElectrnico = new JLabel();
		TextoCorreoElectrnico.setText("Correo electr\u00F3nico");
		TextoCorreoElectrnico.setBounds(15, 330, 162, 26);
		contentPane.add(TextoCorreoElectrnico);
		
		JButton BotonTarjeta = new JButton("Tarjeta");
		BotonTarjeta.setBackground(new Color(176, 196, 222));
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonTarjeta.setBounds(371, 367, 115, 29);
		contentPane.add(BotonTarjeta);
		
		JTextPane nombreUsuario = new JTextPane();
		JTextPane apellidoUsuario = new JTextPane();
		JTextPane ubicacionProvinciaUsuario = new JTextPane();
		JTextPane textoCorreo = new JTextPane();
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(169, 451, 317, 14);
		contentPane.add(progressBar);
		
		DBManager conexion = new DBManager();
		
		try {
			conexion.connect();
			
			Usuario usuario = conexion.buscarUsuarioId(idUsuario);
			
			String nomUsuario = usuario.getNomUsuario();
			String contrasenya = usuario.getContrasenya();
			String correo = usuario.getCorreo();
			String nombre = usuario.getNombre();
			String apellidos = usuario.getApellidos();
			String ubicacion = usuario.getUbicacion();
			String direccionIP = usuario.getDireccionIP();

			
			JLabel labelNombreUsuario = new JLabel(nomUsuario);
			labelNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
			labelNombreUsuario.setBounds(15, 58, 162, 20);
			contentPane.add(labelNombreUsuario);
			
			nombreUsuario.setText(nombre);
			nombreUsuario.setBounds(102, 133, 384, 26);
			contentPane.add(nombreUsuario);
			
			apellidoUsuario.setText(apellidos);
			apellidoUsuario.setBounds(102, 164, 384, 26);
			contentPane.add(apellidoUsuario);
			
			ubicacionProvinciaUsuario.setText(ubicacion);
			ubicacionProvinciaUsuario.setBounds(185, 195, 301, 26);
			contentPane.add(ubicacionProvinciaUsuario);
			
			textoCorreo.setText(correo);
			textoCorreo.setBounds(169, 330, 317, 26);
			contentPane.add(textoCorreo);
			
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
		comboAnyo.setBounds(185, 233, 301, 26);
		contentPane.add(comboAnyo);
		
		
		
		
		
		JLabel lblInformacionPrivada = new JLabel();
		lblInformacionPrivada.setText("Informacion privada");
		lblInformacionPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformacionPrivada.setBounds(15, 288, 218, 26);
		contentPane.add(lblInformacionPrivada);
		
		JLabel lblGestionDePago = new JLabel();
		lblGestionDePago.setText("Gestion de pago\r\n");
		lblGestionDePago.setBounds(15, 368, 132, 26);
		contentPane.add(lblGestionDePago);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBackground(new Color(224, 255, 255));
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardarCambios.setBounds(340, 520, 180, 29);
		contentPane.add(btnGuardarCambios);
		
		
		ImageIcon imagenCandadoCerrado = new ImageIcon("../skapaProyect/multimedia/candadoCerrado.png");
		ImageIcon imagenCandadoAbierto = new ImageIcon("../skapaProyect/multimedia/candadoAbierto.png");
		
		
		
		btnGuardarCambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager conexion = new DBManager();
				
				try {
					conexion.connect();
					
					Usuario usuario = new Usuario();
					usuario.setId(idUsuario);
					usuario.setNombre(nombreUsuario.getText());
					usuario.setApellidos(apellidoUsuario.getText());
					usuario.setCorreo(textoCorreo.getText());
					usuario.setUbicacion(ubicacionProvinciaUsuario.getText());
					
					try {
						conexion.actualizarBase(usuario);
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Correcto", 1);
						VentanaPerfil vp = new VentanaPerfil();
						vp.setVisible(true);
						setVisible(false);
						
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					
					conexion.disconnect();
					
				} catch (DBException e2) {
					e2.printStackTrace();
				}
				
				
				
				if (nombreUsuario.getText().isEmpty()) {
					valueProgressBar = valueProgressBar + 2;
				}
				if (apellidoUsuario.getText().isEmpty()) {
					valueProgressBar = valueProgressBar + 2;
				}
				if (ubicacionProvinciaUsuario.getText().isEmpty()) {
					valueProgressBar = valueProgressBar + 2;
				}
				
				
				
				
			}
		});
		
		progressBar.setValue(valueProgressBar);
		
		
		//BOTON CANDADO 1 (Nombre)
		JButton botonCNombre = new JButton("");
		botonCNombre.setBounds(491, 133, 29, 26);
		
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
		botonCApellidos.setBounds(491, 164, 29, 26);
		
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
		botonCProvincia.setBounds(491, 195, 29, 26);
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
		
		//BOTON CANDADO 4 (A�o de nacimiento)
		JButton botonCAnyo = new JButton("");
		botonCAnyo.setBounds(491, 233, 29, 26);
		
		Icon iconoCandadoC4 = new ImageIcon(imagenCandadoCerrado.getImage().getScaledInstance(botonCAnyo.getWidth(), botonCAnyo.getHeight(), Image.SCALE_DEFAULT));
		Icon iconoCandadoA4 = new ImageIcon(imagenCandadoAbierto.getImage().getScaledInstance(botonCAnyo.getWidth(), botonCAnyo.getHeight(), Image.SCALE_DEFAULT));
				
		botonCAnyo.setIcon(iconoCandadoC4);
		contentPane.add(botonCAnyo);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 520, 96, 29);
		contentPane.add(btnAtras);
		
	
		JLabel lblAutentificacion = new JLabel("Autentificacion");
		lblAutentificacion.setBounds(15, 451, 132, 20);
		contentPane.add(lblAutentificacion);
		
		if(!nombreUsuario.getText().equals("")) {
			contBarra = contBarra + 20;
		}
		if (!apellidoUsuario.getText().equals("")) {
			contBarra = contBarra + 30;
		}
		if (!ubicacionProvinciaUsuario.getText().equals("")) {
			contBarra = contBarra + 30;
		}
		if (!textoCorreo.getText().equals("")) {
			contBarra = contBarra + 20;
		}
		
		//BOTON ATRAS
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrivacidad va = new VentanaPrivacidad();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
				
		//BOTON CANDADO A�O
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
				

		//BOTON TARJETA
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPago vP = new VentanaPago();
				setVisible(false);
				vP.setVisible(true);
				}
			});
		
		progressBar.setValue(contBarra);
	}
} 


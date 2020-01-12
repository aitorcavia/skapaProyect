package skapaProyect.ventanasPrimarias;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;

public class VentanaLogin extends JFrame {
	private JPanel contentPane;
	private JPasswordField textoContrasenya;
	private JTextField textoSkapa;
	public static int idUsuario;
	static Logger log;

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
		setUndecorated(true);
		
		//LOGGER
		try {
			log = Logger.getLogger("VentanaLogin");
			log.setLevel(Level.ALL);
			Handler h = new FileHandler("infoLogger/ventanaLogin.xml");
			log.addHandler(h);
			h.setLevel(Level.WARNING);
			
		}catch (Exception e) {
			
		}
		
		log.log(Level.INFO, "Inicio de Ventana");

		//CREACION INTERFACE
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelUsuario = new JLabel("Usuario o correo electronico");
		labelUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		labelUsuario.setBounds(15, 140, 223, 20);
		contentPane.add(labelUsuario);

		JLabel labelContrasenya = new JLabel("Contrase\u00F1a");
		labelContrasenya.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		labelContrasenya.setBounds(15, 249, 112, 20);
		contentPane.add(labelContrasenya);

		JTextArea textoUsuario = new JTextArea();
		textoUsuario.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoUsuario.setTabSize(18);
		textoUsuario.setBounds(15, 176, 388, 35);
		contentPane.add(textoUsuario);

		JButton botonInicioSesion = new JButton("Iniciar sesion");
		botonInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botonInicioSesion.setBackground(new Color(204, 255, 255));
		botonInicioSesion.setBounds(248, 348, 155, 29);
		contentPane.add(botonInicioSesion);

		textoContrasenya = new JPasswordField();
		textoContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoContrasenya.setBounds(15, 285, 388, 35);
		contentPane.add(textoContrasenya);

		textoSkapa = new JTextField();
		textoSkapa.setEditable(false);
		textoSkapa.setBackground(new Color(135, 206, 250));
		textoSkapa.setFont(new Font("Tahoma", Font.PLAIN, 64));
		textoSkapa.setText("SKAPA");
		textoSkapa.setBounds(15, 16, 199, 108);
		contentPane.add(textoSkapa);
		textoSkapa.setColumns(10);

		JLabel botonRegistro = new JLabel("Deseo crear una cuenta");
		botonRegistro.setForeground(Color.GRAY);
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botonRegistro.setBounds(15, 430, 199, 20);
		contentPane.add(botonRegistro);

		JCheckBox checkGuardarDatos = new JCheckBox("No volver a preguntar");
		checkGuardarDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkGuardarDatos.setBackground(new Color(135, 206, 250));
		checkGuardarDatos.setBounds(252, 380, 151, 29);

		contentPane.add(checkGuardarDatos);

		// GUARDADO DE DATOS (INICIO RAPIDO)
		String desktopPath = System.getProperty("user.home") + "/Desktop" + "/datosSkapa.txt";
		String ruta = desktopPath.replace("\\", "/");
		File archivo = new File(ruta);
		BufferedWriter bw;
		
		try {
			if (archivo.exists()) {
				checkGuardarDatos.setSelected(true);

				String guardadoUsuario;
				String guardadoContrasenya;
				String frase;

				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				
				frase = br.readLine();
				
				String[] parts = frase.split(",");
				String nomb = parts[0]; 
				String con = parts[1]; 
				
				textoUsuario.setText(nomb);
				textoContrasenya.setText(con);
			}
		} catch (Exception e1) {

		}

		//BOTON INICIAR SESION
		botonInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nomUsuario = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();

				DBManager conexion = new DBManager();

				try {
					conexion.connect();
					log.log(Level.INFO, "Conexion con BD establecida");

					if (conexion.loginUsuario(nomUsuario, contrasenya) == true) {
						idUsuario = conexion.obtenerId(nomUsuario);
						VentanaInicio vi = new VentanaInicio();
						setVisible(false);
						vi.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
						textoUsuario.setText("");
						textoContrasenya.setText("");
					}

					conexion.disconnect();

				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (checkGuardarDatos.isSelected()) {
					try {
						if (!archivo.exists()) {
							archivo.createNewFile();
							FileWriter escribir = new FileWriter(archivo);
							escribir.write(nomUsuario + "," + contrasenya);
							escribir.close();
						}

					}catch (Exception e1) {

					}
				}else {
					try {
						if (archivo.exists()) {
							archivo.delete();
						}
					}catch (Exception e2) {
						
					}
				}
			}
		});
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("multimedia/Logo.png"));
		label.setBounds(249,16, 154, 155);
		contentPane.add(label);
				
		botonRegistro.setCursor(new Cursor(HAND_CURSOR));

		botonRegistro.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaRegistro vr = new VentanaRegistro();
				setVisible(false);
				vr.setVisible(true);

			}
		});

	}

	//METODO GET ID USUARIO
	public static int getUsuarioId() {
		return idUsuario;
	}
}

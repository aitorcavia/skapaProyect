package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.security.auth.login.LoginContext;
import javax.swing.DropMode;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField textoContrasenya;
	private JTextField textoSkapa;

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
		botonInicioSesion.setBounds(248, 362, 155, 29);
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
		
		 
		botonInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();
				
				try {
					Class.forName("org.sqlite.JDBC");
					
					Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
					Statement stmt = conn.createStatement();
				
					//Recuperar datos, consultas
					ResultSet rs = stmt.executeQuery("SELECT nombre, contrasenya, correo FROM usuario");
					
					int cont = 0;
					
					while (rs.next()) {
						String usuarioB = rs.getString("nombre");
						String contrasenyaB = rs.getString("contrasenya");
						String correoB = rs.getString("correo");
					
						
						if (usuarioB.equals(usuario) && contrasenyaB.equals(contrasenya) || correoB.equals(usuario) && contrasenyaB.equals(contrasenya)) {
							VentanaInicio vi = new VentanaInicio();
							setVisible(false);
							vi.setVisible(true);
							cont++;
							break;
						}
					}
					
					if(cont ==0) {
						JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
						textoUsuario.setText("");
						textoContrasenya.setText("");
					}
					
					stmt.close();
					conn.close();
					
				} catch (ClassNotFoundException e1) {
					System.out.println("No se ja podido cargar el driver");
					e1.printStackTrace();
				}catch (SQLException e1) {
					System.out.println("No se ha podido conectar a BD");
					e1.printStackTrace();
				}
			}
		});
		
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
}

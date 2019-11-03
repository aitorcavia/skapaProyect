package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		setTitle("VentanaInicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 735);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Cocina", "Videojuegos", "Hogar", "Juguetes", "Libreria", "Seguridad", "Codigos", "Prendas", "Informatica", "Comida"}));
		comboBoxCategoria.setBounds(160, 77, 181, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Coru\u00F1a", "Pontevedra", "Lugo", "Orense", "Asturias", "Cantabria", "Bizkaia", "Gipuzkoa", "Alaba", "Navarra", "Huesca", "Zaragoza", "L\u00E9rida", "Girona", "Barcelona", "Tarragona", "Teruel", "La Rioja", "Le\u00F3n", "Palencia", "Burgos", "Soria", "Segovia", "Valladolid", "Zamora", "Salamanca", "\u00C1vila", "Madrid", "Guadalajara", "Cuenca", "Albacete", "Toledo", "Ciudad Real", "Castell\u00F3n", "Valencia", "Alicante", "C\u00E1ceres", "Badajoz", "Murcia", "Huelva", "Sevilla", "C\u00F3rdoba", "Ja\u00E9n", "C\u00E1diz", "M\u00E1laga", "Granada", "Almeria", "Islas Baleares", "Islas Canarias"}));
		comboBoxProvincia.setBounds(160, 117, 181, 20);
		contentPane.add(comboBoxProvincia);
		
		JEditorPane textoBuscador = new JEditorPane();
		textoBuscador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoBuscador.setBounds(15, 25, 642, 36);
		contentPane.add(textoBuscador);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(15, 77, 80, 20);
		contentPane.add(lblCategoria);
		
		JLabel lblProvincia = new JLabel("Provincias\r\n e Islas:");
		lblProvincia.setBounds(13, 109, 132, 36);
		contentPane.add(lblProvincia);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 153, 59, 20);
		contentPane.add(lblPrecio);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(1156, 16, 115, 29);
		contentPane.add(btnPerfil);
		
		JPanel panelAnuncios = new JPanel();
		panelAnuncios.setBackground(new Color(135, 206, 250));
		panelAnuncios.setBounds(15, 201, 1256, 431);
		contentPane.add(panelAnuncios);
		panelAnuncios.setLayout(null);
		
		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.setBackground(new Color(240, 255, 255));
		botonBuscar.setBounds(686, 25, 132, 36);
		contentPane.add(botonBuscar);
		
		JLabel lblEntre = new JLabel("entre");
		lblEntre.setBounds(86, 153, 69, 20);
		contentPane.add(lblEntre);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(261, 153, 26, 20);
		contentPane.add(lblY);
		
		textField = new JTextField();
		textField.setBounds(146, 153, 100, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(287, 153, 100, 26);
		contentPane.add(textField_1);
		
		
		
		
		try {
			Class.forName("org.sqlite.JDBC");
					
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
			Statement stmt = conn.createStatement();
			
				
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT idUsuario, titulo, descripcion, precio, categoria FROM anuncio");
			
			int cont = 16;
			
			while (rs.next()) {
				
				String titulo = rs.getString("titulo");
				String precio = rs.getString("precio");
				String categoria = rs.getString("categoria");
				String descripcion = rs.getString("descripcion");

			
				JPanel panelAnuncio = new JPanel();
				panelAnuncio.setBackground(new Color(255,255,255));
				panelAnuncio.setBounds(0, cont, 1250, 90);
				panelAnuncios.add(panelAnuncio);
				panelAnuncio.setLayout(null);
				
				JLabel tituloAnuncio = new JLabel(titulo);
				tituloAnuncio.setBounds(15, 16, 117, 20);
				panelAnuncio.add(tituloAnuncio);
				
				JLabel precioAnuncio = new JLabel("PRECIO: " + precio + " €");
				precioAnuncio.setBounds(15, 47, 96, 20);
				panelAnuncio.add(precioAnuncio);
				
				JLabel lblNewLabel = new JLabel(descripcion);
				lblNewLabel.setBounds(260, 0, 688, 47);
				panelAnuncio.add(lblNewLabel);
				
				JLabel labelImagen = new JLabel("[IMAGEN]");
				labelImagen.setBackground(SystemColor.activeCaptionBorder);
				labelImagen.setBounds(1000, 0, 87, 76);
				panelAnuncio.add(labelImagen);
				
				JButton btnContactar = new JButton("Contactar");
				btnContactar.setBounds(1142, 16, 99, 23);
				panelAnuncio.add(btnContactar);
				
				JButton btninfo = new JButton("+INFO");
				btninfo.setBounds(1142, 44, 99, 23);
				panelAnuncio.add(btninfo);
				
				
				cont = cont + 95;
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
		
		
		btnPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaUsuario vu = new VentanaUsuario();
				vu.setVisible(true);
				setVisible(false);
				
			}
		});
		
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String texto = textoBuscador.getText();
				panelAnuncios.removeAll();
				panelAnuncios.repaint();
				
				
				try {
					Class.forName("org.sqlite.JDBC");
							
					Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
					Statement stmt = conn.createStatement();
					
						
					//Recuperar datos, consultas
					ResultSet rs = stmt.executeQuery("SELECT idUsuario, titulo, descripcion, precio, categoria FROM anuncio WHERE titulo LIKE '%" + texto + "%'");
					
					int cont = 16;
					
					while (rs.next()) {
						
						String titulo = rs.getString("titulo");
						String precio = rs.getString("precio");
						String categoria = rs.getString("categoria");
						String descripcion = rs.getString("descripcion");

					
						JPanel panelAnuncio = new JPanel();
						panelAnuncio.setBackground(new Color(255,255,255));
						panelAnuncio.setBounds(0, cont, 1250, 90);
						panelAnuncios.add(panelAnuncio);
						panelAnuncio.setLayout(null);
						
						JLabel tituloAnuncio = new JLabel(titulo);
						tituloAnuncio.setBounds(15, 16, 117, 20);
						panelAnuncio.add(tituloAnuncio);
						
						JLabel precioAnuncio = new JLabel("PRECIO: " + precio + " €");
						precioAnuncio.setBounds(15, 47, 96, 20);
						panelAnuncio.add(precioAnuncio);
						
						JLabel lblNewLabel = new JLabel(descripcion);
						lblNewLabel.setBounds(260, 0, 688, 47);
						panelAnuncio.add(lblNewLabel);
						
						JLabel labelImagen = new JLabel("[IMAGEN]");
						labelImagen.setBackground(SystemColor.activeCaptionBorder);
						labelImagen.setBounds(1000, 0, 87, 76);
						panelAnuncio.add(labelImagen);
						
						JButton btnContactar = new JButton("Contactar");
						btnContactar.setBounds(1142, 16, 99, 23);
						panelAnuncio.add(btnContactar);
						
						JButton btninfo = new JButton("+INFO");
						btninfo.setBounds(1142, 44, 99, 23);
						panelAnuncio.add(btninfo);
						
						
						cont = cont + 95;
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
		
		
		
		
	}
}

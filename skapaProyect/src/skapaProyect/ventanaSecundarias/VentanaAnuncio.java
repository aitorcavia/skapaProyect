package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.ventanasPrimarias.LogController;
import skapaProyect.ventanasPrimarias.VentanaCreacionAnuncio;
import skapaProyect.ventanasPrimarias.VentanaMisAnuncios;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class VentanaAnuncio extends JFrame {

	private JPanel contentPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LogController.log ( Level.INFO, "Inicio Ventana " + (new Date()),null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnuncio frame = new VentanaAnuncio();
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
	public VentanaAnuncio() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setEditable(false);
		textoDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoDescripcion.setText("Descripci\u00F3n");
		textoDescripcion.setBounds(15, 269, 297, 158);
		
		contentPane.add(textoDescripcion);
		
		
		
		JLabel Foto = new JLabel("[IMAGEN]");
		Foto.setHorizontalAlignment(SwingConstants.CENTER);
		Foto.setIcon(null);
		Foto.setBounds(15, 16, 297, 129);
		contentPane.add(Foto);
		
		JLabel labelTitulo = new JLabel();
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitulo.setBounds(15, 161, 297, 20);
		contentPane.add(labelTitulo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(15, 458, 94, 29);
		contentPane.add(Volver);
		
		JLabel labelPrecio = new JLabel();
		labelPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPrecio.setBounds(15, 197, 297, 20);
		contentPane.add(labelPrecio);
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMisAnuncios vma = new VentanaMisAnuncios();
				setVisible(false);
				vma.setVisible(true);
				}
			});
		
		
		int an = VentanaCreacionAnuncio.getAnuncioId();
		
		System.out.println(an);
		
		
		String titulo = "";
		String precio = "";
		String categoria = "";
		String descripcion = "";
		
	
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
			Statement stmt = conn.createStatement();
		
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT idUsuario, idAnuncio, titulo, precio, categoria, descripcion FROM anuncio WHERE idAnuncio = "+ an);
			
			
			titulo = rs.getString("titulo");
			precio = rs.getString("precio");
			categoria = rs.getString("categoria");
			descripcion = rs.getString("descripcion");
			
			labelTitulo.setText(titulo);
			labelPrecio.setText("Precio: " + precio + " €");
			textoDescripcion.setText(descripcion);
			
			JLabel lblCategoria = new JLabel("Categoria: " + categoria);
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblCategoria.setBounds(15, 233, 297, 20);
			contentPane.add(lblCategoria);
			

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
}

package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaAnuncio extends JFrame {

	private JPanel contentPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setEditable(false);
		textoDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoDescripcion.setText("Descripci\u00F3n");
		textoDescripcion.setBounds(15, 265, 297, 222);
		
		contentPane.add(textoDescripcion);
		
		
		
		JLabel Foto = new JLabel("(IMAGEN PRODUCTO)");
		Foto.setIcon(null);
		Foto.setBounds(15, 16, 297, 177);
		contentPane.add(Foto);
		
		JLabel labelTitulo = new JLabel();
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelTitulo.setBounds(15, 229, 163, 20);
		contentPane.add(labelTitulo);
		
		JButton Volver = new JButton("A\r\n");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(0, 0, 79, 29);
		contentPane.add(Volver);
		
		JLabel labelPrecio = new JLabel();
		labelPrecio.setBounds(183, 229, 69, 20);
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

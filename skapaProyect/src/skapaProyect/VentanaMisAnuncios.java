package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VentanaMisAnuncios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMisAnuncios frame = new VentanaMisAnuncios();
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
	public VentanaMisAnuncios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		try {
			Class.forName("org.sqlite.JDBC");
					
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
			Statement stmt = conn.createStatement();
				
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT titulo, descripcion, precio, categoria, idUsuario FROM anuncio");
			
			int cont = 16;
			int contS = 0;
	
			ArrayList<JPanel> paneles = new ArrayList<JPanel>();
			
			while (rs.next()) {
				
				String titulo = rs.getString("titulo");
				String precio = rs.getString("precio");
				String categoria = rs.getString("categoria");
				String descripcion = rs.getString("descripcion");

			
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 235));
				panel.setBounds(15, cont, 328, 76);
				
				paneles.add(panel);
				
				contentPane.add(paneles.get(contS));
				paneles.get(contS).setLayout(null);
				
				
			
				JLabel lblTitulo = new JLabel (titulo);
				lblTitulo.setBounds(15, 16, 160, 20);
				paneles.get(contS).add(lblTitulo);
				
				
				JLabel lblPrecio = new JLabel("Precio: " + precio + " €");
				lblPrecio.setBounds(15, 25+16, 80, 20);
				paneles.get(contS).add(lblPrecio);
			
				
				cont = cont + 80;
				contS++;
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
	}


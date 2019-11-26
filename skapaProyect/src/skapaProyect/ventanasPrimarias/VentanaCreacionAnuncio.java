package skapaProyect.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.ventanaSecundarias.VentanaAnuncio;

import java.awt.Color;
import javax.swing.JTextPane;
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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaCreacionAnuncio extends JFrame {

	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoPrecio;
	public static int idAnuncio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionAnuncio frame = new VentanaCreacionAnuncio();
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
	public VentanaCreacionAnuncio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 318, 503);
		contentPane.add(panel);
		
		JLabel label = new JLabel("(IMAGEN PRODUCTO)");
		label.setBounds(15, 16, 297, 88);
		panel.add(label);
		
		textoTitulo = new JTextField();
		textoTitulo.setBounds(15, 156, 288, 26);
		panel.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JLabel labelNewLabel = new JLabel("TITULO:");
		labelNewLabel.setBounds(15, 120, 159, 20);
		panel.add(labelNewLabel);
		
		JLabel labelInserteUnPrecio = new JLabel("Precio:");
		labelInserteUnPrecio.setBounds(15, 198, 130, 20);
		panel.add(labelInserteUnPrecio);
		
		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cocina", "Videojuegos", "Hogar", "Juguetes", "Libreria", "Seguridad", "Codigos", "Prendas", "Informatica", "Comida"}));
		comboBox.setBounds(123, 234, 180, 26);
		panel.add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(15, 234, 93, 20);
		panel.add(lblCategoria);
		
		textoPrecio = new JTextField();
		textoPrecio.setBounds(91, 198, 137, 26);
		panel.add(textoPrecio);
		textoPrecio.setColumns(10);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(243, 201, 69, 20);
		panel.add(label_1);
		
		JLabel labelDescripcion = new JLabel("Descripcion:");
		labelDescripcion.setBounds(25, 270, 93, 20);
		panel.add(labelDescripcion);
		
		JTextArea textoDescripcion = new JTextArea();
		textoDescripcion.setBounds(15, 298, 288, 107);
		panel.add(textoDescripcion);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(188, 458, 115, 29);
		panel.add(botonGuardar);
	
	
	botonGuardar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int idUsuario;
			String titulo; 
			String precio;
			String categoria;
			String descripcion;
			 
			int a = VentanaLogin.getUsuarioId();
			
			//IMAGEN https://www.youtube.com/watch?v=MxJThrSoTaU
			idUsuario = a;
			titulo = textoTitulo.getText();
			precio = textoPrecio.getText();
			descripcion = textoDescripcion.getText();
			categoria = comboBox.getSelectedItem().toString();

			try {
				Class.forName("org.sqlite.JDBC");
				
				Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
				Statement stmt = conn.createStatement();
				
				String query = "INSERT INTO anuncio (idUsuario, titulo, precio, categoria, descripcion) VALUES ('"+ idUsuario + "', '" + titulo + "', '"+ precio + "', '" + categoria + "', '" + descripcion + "')" ;
				stmt.executeUpdate(query);
			
			
				JOptionPane.showMessageDialog(null, "Anuncio creado correctamente", "Correcto", 1);
				
				
				ResultSet rs = stmt.executeQuery("SELECT idUsuario, idAnuncio, titulo, precio, categoria, descripcion FROM anuncio WHERE idUsuario ='" + idUsuario + "' and titulo ='" + titulo + "' and descripcion= '"+ descripcion + "'");
				
				idAnuncio = rs.getInt("idAnuncio");
				
				stmt.close();
				conn.close();
		
			} catch (ClassNotFoundException e1) {
				System.out.println("No se ja podido cargar el driver");
				e1.printStackTrace();
			}catch (SQLException e1) {
				System.out.println("No se ha podido conectar a BD");
				e1.printStackTrace();
			}
			
			VentanaAnuncio va = new VentanaAnuncio();
			setVisible(false);
			va.setVisible(true);
		}
	});
	

	
	}
	
	public static int getAnuncioId(){
		return idAnuncio;
		}
	
}

package skapaProyect.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FileChooserUI;

import bitacor.Bitacora;
import skapaProyect.ventanaSecundarias.VentanaAnuncio;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaCreacionAnuncio extends JFrame {

	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoPrecio;
	public static int idAnuncio;
	static PrintStream log;
	Logger logger = Logger.getLogger("LOGGER");

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
		
		Bitacora bit = new Bitacora();
		
		logger.log(Level.INFO, "Ventana inicializada");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 360, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 338, 494);
		contentPane.add(panel);
		
		textoTitulo = new JTextField();
		textoTitulo.setBounds(15, 119, 305, 26);
		panel.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JLabel labelNewLabel = new JLabel("TITULO:");
		labelNewLabel.setBounds(15, 96, 159, 20);
		panel.add(labelNewLabel);
		
		JLabel labelInserteUnPrecio = new JLabel("Precio:");
		labelInserteUnPrecio.setBounds(15, 161, 130, 20);
		panel.add(labelInserteUnPrecio);
		
		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cocina", "Videojuegos", "Hogar", "Juguetes", "Libreria", "Seguridad", "Codigos", "Prendas", "Informatica", "Comida", "Motor"}));
		comboBox.setBounds(123, 197, 197, 26);
		panel.add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(15, 197, 93, 20);
		panel.add(lblCategoria);
		
		textoPrecio = new JTextField();
		textoPrecio.setBounds(92, 161, 180, 26);
		panel.add(textoPrecio);
		textoPrecio.setColumns(10);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(287, 161, 33, 20);
		panel.add(label_1);
		
		JLabel labelDescripcion = new JLabel("Descripcion:");
		labelDescripcion.setBounds(15, 233, 93, 20);
		panel.add(labelDescripcion);
		
		JTextArea textoDescripcion = new JTextArea();
		textoDescripcion.setBounds(12, 260, 308, 107);
		panel.add(textoDescripcion);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(188, 458, 135, 29);
		panel.add(botonGuardar);
		
		JLabel lblNewLabel = new JLabel("IMAGEN:");
		lblNewLabel.setBounds(15, 387, 69, 20);
		panel.add(lblNewLabel);
		
		JLabel lblExplicanosComoDe = new JLabel("Explicanos como es tu producto...");
		lblExplicanosComoDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExplicanosComoDe.setBounds(15, 16, 305, 20);
		panel.add(lblExplicanosComoDe);
		
		JLabel lblYPonleUn = new JLabel("...y ponle un buen precio");
		lblYPonleUn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYPonleUn.setBounds(116, 52, 204, 20);
		panel.add(lblYPonleUn);
		
		JButton botonAnyadir = new JButton("A\u00F1adir");
		botonAnyadir.setEnabled(false);
		botonAnyadir.setBounds(117, 383, 93, 29);
		panel.add(botonAnyadir);
		
		JLabel lblproximamente = new JLabel("[SOON]");
		lblproximamente.setBounds(251, 383, 69, 29);
		panel.add(lblproximamente);
		
		
		botonAnyadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				
				
				
			
				
			}
		});
		
		
	
	
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

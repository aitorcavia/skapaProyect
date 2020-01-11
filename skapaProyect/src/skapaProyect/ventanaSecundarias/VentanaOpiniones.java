package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaOpiniones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpiniones frame = new VentanaOpiniones();
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
	public VentanaOpiniones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpiniones = new JPanel();
		panelOpiniones.setBackground(new Color(135, 206, 250));
		panelOpiniones.setBounds(0, 0, 381, 450);
		contentPane.add(panelOpiniones);
		panelOpiniones.setLayout(null);
		
		
		
		JButton button = new JButton("Atras");
		button.setBounds(15, 466, 115, 29);
		contentPane.add(button);
		
		 Font fuente = new Font("Serief",Font.BOLD,14);		
        
		
		try {
			Class.forName("org.sqlite.JDBC");
					
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
			Statement stmt = conn.createStatement();
			
				
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT idUsuario, titulo, descripcion FROM opinion");
			
			int cont = 16;
			int contS = 0;
	
			ArrayList<JPanel> paneles = new ArrayList<JPanel>();
			
			while (rs.next()) {
				
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");

			
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(135, 206, 235));
				panel_1.setBounds(15, cont, 351, 95);
				panelOpiniones.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblLabeltitulo = new JLabel(titulo);
				lblLabeltitulo.setFont(fuente);
				
				lblLabeltitulo.setBounds(15, 16, 321, 20);
				panel_1.add(lblLabeltitulo);
				
				JLabel labelOpinion = new JLabel(descripcion);
				labelOpinion.setBounds(15, 41, 321, 38);
				panel_1.add(labelOpinion);
			
				
				cont = cont + 105;
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

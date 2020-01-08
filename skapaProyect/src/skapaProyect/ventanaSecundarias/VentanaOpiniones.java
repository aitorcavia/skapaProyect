package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
		panelOpiniones.setBackground(new Color(153, 204, 255));
		panelOpiniones.setBounds(15, 16, 351, 434);
		contentPane.add(panelOpiniones);
		
		JButton button = new JButton("Atras");
		button.setBounds(15, 466, 115, 29);
		contentPane.add(button);
		
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

			
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 235));
				panel.setBounds(0, cont, 328, 76);
				
				paneles.add(panel);
				
				panelOpiniones.add(paneles.get(contS));
				paneles.get(contS).setLayout(null);
		
				JLabel lblTitulo = new JLabel (titulo);
				lblTitulo.setBounds(15, 16, 160, 20);
				paneles.get(contS).add(lblTitulo);
			
				
				JLabel lblPrecio = new JLabel(descripcion);
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

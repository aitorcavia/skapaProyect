package skapaProyect.ventanasPrimarias;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bitacor.Bitacora;
import skapaProyect.ventanaSecundarias.VentanaAnuncio;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaCreacionOpiniones extends JFrame{
	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoOpinion;
	public static int idOpinion;
	static PrintStream log;
	Logger logger = Logger.getLogger("LOGGER");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionOpiniones frame = new VentanaCreacionOpiniones();
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
	public VentanaCreacionOpiniones() {
		
		Bitacora bit = new Bitacora();
		
		logger.log(Level.INFO, "Ventana inicializada");
		
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
		
		
		textoTitulo = new JTextField();
		textoTitulo.setBounds(15, 110, 142, 26);
		panel.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JLabel labelNewLabel = new JLabel("TITULO:");
		labelNewLabel.setBounds(15, 80, 143, 26);
		panel.add(labelNewLabel);
		
	
		
		JLabel labelOpinion = new JLabel("Opinion:");
		labelOpinion.setBounds(15, 192, 142, 39);
		panel.add(labelOpinion);
		
		JTextArea textoOpinion = new JTextArea();
		textoOpinion.setBounds(15, 298, 288, 120);
		panel.add(textoOpinion);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(188, 458, 115, 29);
		panel.add(botonGuardar);
		
		
		
	/*
	
	botonGuardar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int idOpinion;
			String titulo; 
			String Opinion;
			 
			int a = VentanaLogin.getUsuarioId();
			
			//IMAGEN https://www.youtube.com/watch?v=MxJThrSoTaU
			idOpinion = a;
			titulo = textoTitulo.getText();
			Opinion = textoOpinion.getText();

			try {
				
				Class.forName("org.sqlite.JDBC");
				
				Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
				Statement stmt = conn.createStatement();
				
				String query = "INSERT INTO anuncio (idOpinion, titulo,Opinion) VALUES ('"+ idOpinion + "', '" +titulo+","+ Opinion + "')" ;
				stmt.executeUpdate(query);
			
			
				JOptionPane.showMessageDialog(null, "Opinion creada correctamente", "Correcto", 1);
				
				
				ResultSet rs = stmt.executeQuery("SELECT idUsuario, idOpinion, titulo,Opinion FROM anuncio WHERE idUsuario ='" + idOpinion + "' and titulo ='" + titulo + "' and Opinion= '"+ Opinion + "'");
				
				idOpinion = rs.getInt("idOpinion");
				
				stmt.close();
				conn.close();
		
			} catch (ClassNotFoundException e1) {
				System.out.println("No se ha podido cargar el driver");
				e1.printStackTrace();
			}catch (SQLException e1) {
				System.out.println("No se ha podido conectar a BD");
				e1.printStackTrace();
			}
			
			VentanaOpinion vO = new VentanaOpinion();
			setVisible(false);
			va.setVisible(true);
		}
	});
	
	}
	
	public static int getOpinion(){
		return idOpinion();
		}
	*/
	
	}
}

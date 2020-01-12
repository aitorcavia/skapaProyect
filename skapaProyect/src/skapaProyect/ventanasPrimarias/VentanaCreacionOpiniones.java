package skapaProyect.ventanasPrimarias;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bitacor.Bitacora;
import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;
import skapaProyect.ventanaSecundarias.VentanaAnuncio;
import skapaProyect.ventanaSecundarias.VentanaOpiniones;

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
		
		int idU = VentanaLogin.getUsuarioId();
		
		Bitacora bit = new Bitacora();
		
		logger.log(Level.INFO, "Ventana inicializada");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 340, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 318, 460);
		contentPane.add(panel);
		
		
		textoTitulo = new JTextField();
		textoTitulo.setBounds(15, 150, 288, 26);
		panel.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JLabel labelNewLabel = new JLabel("TITULO:");
		labelNewLabel.setBounds(14, 108, 143, 26);
		panel.add(labelNewLabel);
		
	
		
		JLabel labelOpinion = new JLabel("Opinion:");
		labelOpinion.setBounds(15, 192, 142, 39);
		panel.add(labelOpinion);
		
		JTextArea textoOpinion = new JTextArea();
		textoOpinion.setBounds(15, 234, 288, 120);
		panel.add(textoOpinion);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(188, 401, 115, 29);
		panel.add(botonGuardar);
		
		JLabel lblDejanosTuOpinion = new JLabel("Dejanos tu opinion");
		lblDejanosTuOpinion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDejanosTuOpinion.setBounds(15, 16, 182, 20);
		panel.add(lblDejanosTuOpinion);
		
		JLabel lblYAlgunaspectoA = new JLabel("y algun aspecto a mejorar");
		lblYAlgunaspectoA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYAlgunaspectoA.setBounds(15, 40, 261, 20);
		panel.add(lblYAlgunaspectoA);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 401, 96, 29);
		panel.add(btnAtras);
		
		
		botonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
				try {
					int idUsuario = idU;
					String titulo = textoTitulo.getText();
					String descripcion = textoOpinion.getText();
					
					dbm.connect();
					Opinion opinion = new Opinion(idUsuario, titulo, descripcion);
					dbm.insertarOpinion(opinion);
					dbm.disconnect();
					
					VentanaOpiniones vo = new VentanaOpiniones();
					vo.setVisible(true);
					
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaOpiniones vo = new VentanaOpiniones();
				vo.setVisible(true);
				setVisible(false);
				
			}
		});
	
	}
}

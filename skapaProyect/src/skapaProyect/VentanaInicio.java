package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField nombreAnuncio1;
	private JTextField nombreAnuncio2;
	private JTextField nombreAnuncio3;

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
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Cocina", "Videojuegos", "Hogar", "Juguetes", "Libreria", "Seguridad", "Codigos"}));
		comboBoxCategoria.setBounds(160, 77, 146, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Coru\u00F1a", "Pontevedra", "Lugo", "Orense", "Asturias", "Cantabria", "Bizkaia", "Gipuzkoa", "Alaba", "Navarra", "Huesca", "Zaragoza", "L\u00E9rida", "Girona", "Barcelona", "Tarragona", "Teruel", "La Rioja", "Le\u00F3n", "Palencia", "Burgos", "Soria", "Segovia", "Valladolid", "Zamora", "Salamanca", "\u00C1vila", "Madrid", "Guadalajara", "Cuenca", "Albacete", "Toledo", "Ciudad Real", "Castell\u00F3n", "Valencia", "Alicante", "C\u00E1ceres", "Badajoz", "Murcia", "Huelva", "Sevilla", "C\u00F3rdoba", "Ja\u00E9n", "C\u00E1diz", "M\u00E1laga", "Granada", "Almeria", "Islas Baleares", "Islas Canarias"}));
		comboBoxProvincia.setBounds(160, 102, 146, 20);
		contentPane.add(comboBoxProvincia);
		
		JComboBox comboBoxPrecio1 = new JComboBox();
		comboBoxPrecio1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		comboBoxPrecio1.setBounds(160, 127, 59, 20);
		contentPane.add(comboBoxPrecio1); 
		
		JComboBox comboBoxPrecio2 = new JComboBox();
		comboBoxPrecio2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		comboBoxPrecio2.setBounds(237, 127, 59, 20);
		contentPane.add(comboBoxPrecio2);
		
		JEditorPane buscador = new JEditorPane();
		buscador.setBounds(87, 41, 225, 20);
		contentPane.add(buscador);
		
		nombreAnuncio1 = new JTextField();
		nombreAnuncio1.setEditable(false);
		nombreAnuncio1.setBounds(20, 179, 155, 30);
		contentPane.add(nombreAnuncio1);
		nombreAnuncio1.setColumns(10);
		
		JSeparator anuncio1 = new JSeparator();
		anuncio1.setBounds(10, 169, 286, 106);
		contentPane.add(anuncio1);
		
		nombreAnuncio2 = new JTextField();
		nombreAnuncio2.setEditable(false);
		nombreAnuncio2.setBounds(20, 298, 155, 30);
		contentPane.add(nombreAnuncio2);
		nombreAnuncio2.setColumns(10);
		
		JSeparator anuncio2 = new JSeparator();
		anuncio2.setBounds(10, 391, 286, 118);
		contentPane.add(anuncio2);
		
		nombreAnuncio3 = new JTextField();
		nombreAnuncio3.setEditable(false);
		nombreAnuncio3.setBounds(20, 408, 155, 30);
		contentPane.add(nombreAnuncio3);
		nombreAnuncio3.setColumns(10);
		
		JSeparator anuncio3 = new JSeparator();
		anuncio3.setBounds(10, 286, 286, 118);
		contentPane.add(anuncio3);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(20, 77, 80, 20);
		contentPane.add(lblCategoria);
		
		JLabel lblProvincia = new JLabel("Provincias\r\n e Islas:");
		lblProvincia.setBounds(20, 94, 132, 36);
		contentPane.add(lblProvincia);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 127, 59, 20);
		contentPane.add(lblPrecio);
		
		nombreAnuncio1.setCursor(new Cursor(HAND_CURSOR));
		nombreAnuncio2.setCursor(new Cursor(HAND_CURSOR));
		nombreAnuncio3.setCursor(new Cursor(HAND_CURSOR));
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(10, 16, 115, 29);
		contentPane.add(btnPerfil);
		
		nombreAnuncio1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAnuncio va = new VentanaAnuncio();
				setVisible(false);	
				va.setVisible(true);
			}
		});
		
		btnPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaUsuario vu = new VentanaUsuario();
				vu.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
	}
}

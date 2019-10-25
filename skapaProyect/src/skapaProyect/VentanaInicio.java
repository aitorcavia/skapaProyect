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
		comboBoxCategoria.setBounds(160, 47, 146, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Coru\u00F1a", "Pontevedra", "Lugo", "Orense", "Asturias", "Cantabria", "Bizkaia", "Gipuzkoa", "Alaba", "Navarra", "Huesca", "Zaragoza", "L\u00E9rida", "Girona", "Barcelona", "Tarragona", "Teruel", "La Rioja", "Le\u00F3n", "Palencia", "Burgos", "Soria", "Segovia", "Valladolid", "Zamora", "Salamanca", "\u00C1vila", "Madrid", "Guadalajara", "Cuenca", "Albacete", "Toledo", "Ciudad Real", "Castell\u00F3n", "Valencia", "Alicante", "C\u00E1ceres", "Badajoz", "Murcia", "Huelva", "Sevilla", "C\u00F3rdoba", "Ja\u00E9n", "C\u00E1diz", "M\u00E1laga", "Granada", "Almeria", "Islas Baleares", "Islas Canarias"}));
		comboBoxProvincia.setBounds(160, 91, 146, 20);
		contentPane.add(comboBoxProvincia);
		
		JComboBox comboBoxPrecio1 = new JComboBox();
		comboBoxPrecio1.setModel(new DefaultComboBoxModel(new String[] {"1\u20AC", "2\u20AC", "3\u20AC", "4\u20AC", "5\u20AC", "6\u20AC", "7\u20AC", "8\u20AC", "9\u20AC", "10\u20AC", "11\u20AC", "12\u20AC", "13\u20AC", "14\u20AC", "15\u20AC", "16\u20AC", "17\u20AC", "18\u20AC", "19\u20AC"}));
		comboBoxPrecio1.setBounds(150, 127, 59, 20);
		contentPane.add(comboBoxPrecio1); 
		
		JComboBox comboBoxPrecio2 = new JComboBox();
		comboBoxPrecio2.setBounds(237, 127, 59, 20);
		contentPane.add(comboBoxPrecio2);
		
		JEditorPane buscador = new JEditorPane();
		buscador.setBounds(66, 11, 225, 20);
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
		lblCategoria.setBounds(10, 42, 80, 20);
		contentPane.add(lblCategoria);
		
		JLabel lblProvincia = new JLabel("Provincias\r\n e Islas:");
		lblProvincia.setBounds(10, 78, 132, 36);
		contentPane.add(lblProvincia);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 127, 59, 20);
		contentPane.add(lblPrecio);
		
		nombreAnuncio1.setCursor(new Cursor(HAND_CURSOR));
		nombreAnuncio2.setCursor(new Cursor(HAND_CURSOR));
		nombreAnuncio3.setCursor(new Cursor(HAND_CURSOR));
		
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
	}
}

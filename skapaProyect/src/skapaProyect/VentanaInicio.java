package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		comboBoxCategoria.setBounds(105, 42, 146, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setBounds(105, 86, 146, 20);
		contentPane.add(comboBoxProvincia);
		
		JComboBox comboBoxPrecio1 = new JComboBox();
		comboBoxPrecio1.setBounds(105, 127, 59, 20);
		contentPane.add(comboBoxPrecio1);
		
		JComboBox comboBoxPrecio2 = new JComboBox();
		comboBoxPrecio2.setBounds(192, 127, 59, 20);
		contentPane.add(comboBoxPrecio2);
		
		JEditorPane buscador = new JEditorPane();
		buscador.setBounds(34, 11, 155, 20);
		contentPane.add(buscador);
		
		JSeparator anuncio1 = new JSeparator();
		anuncio1.setBounds(10, 169, 286, 118);
		contentPane.add(anuncio1);
		
		JSeparator anuncio2 = new JSeparator();
		anuncio2.setBounds(10, 391, 286, 118);
		contentPane.add(anuncio2);
		
		JSeparator anuncio3 = new JSeparator();
		anuncio3.setBounds(10, 273, 286, 118);
		contentPane.add(anuncio3);
		
		nombreAnuncio1 = new JTextField();
		nombreAnuncio1.setEditable(false);
		nombreAnuncio1.setBounds(20, 179, 155, 30);
		contentPane.add(nombreAnuncio1);
		nombreAnuncio1.setColumns(10);
		
		nombreAnuncio2 = new JTextField();
		nombreAnuncio2.setEditable(false);
		nombreAnuncio2.setBounds(20, 281, 155, 30);
		contentPane.add(nombreAnuncio2);
		nombreAnuncio2.setColumns(10);
		
		nombreAnuncio3 = new JTextField();
		nombreAnuncio3.setEditable(false);
		nombreAnuncio3.setBounds(20, 408, 155, 30);
		contentPane.add(nombreAnuncio3);
		nombreAnuncio3.setColumns(10);
		
		JLabel categoria = new JLabel("Categoria:");
		categoria.setBounds(10, 42, 80, 20);
		contentPane.add(categoria);
		
		JLabel provincia = new JLabel("Provincia:");
		provincia.setBounds(10, 86, 69, 20);
		contentPane.add(provincia);
		
		JLabel precio = new JLabel("Precio:");
		precio.setBounds(10, 127, 59, 20);
		contentPane.add(precio);
		
		JLabel fotoAnuncio1 = new JLabel("New label");
		fotoAnuncio1.setBounds(185, 179, 111, 83);
		contentPane.add(fotoAnuncio1);
		
		JLabel fotoAnuncio2 = new JLabel("New label");
		fotoAnuncio2.setBounds(185, 282, 111, 98);
		contentPane.add(fotoAnuncio2);
		
		JLabel fotoAnuncio3 = new JLabel("New label");
		fotoAnuncio3.setBounds(185, 402, 111, 98);
		contentPane.add(fotoAnuncio3);
		
		JLabel chatAnuncio1 = new JLabel("New label");
		chatAnuncio1.setBounds(113, 232, 59, 30);
		contentPane.add(chatAnuncio1);
		
		JLabel chatAnuncio2 = new JLabel("New label");
		chatAnuncio2.setBounds(113, 350, 62, 30);
		contentPane.add(chatAnuncio2);
		
		JLabel chatAnuncio3 = new JLabel("New label");
		chatAnuncio3.setBounds(113, 479, 62, 30);
		contentPane.add(chatAnuncio3);
		
		JComboBox comboBoxMultitarea = new JComboBox();
		comboBoxMultitarea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxMultitarea.setBounds(274, 11, 49, 20);
		contentPane.add(comboBoxMultitarea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(192, 11, 59, 23);
		contentPane.add(btnNewButton);
	}
}

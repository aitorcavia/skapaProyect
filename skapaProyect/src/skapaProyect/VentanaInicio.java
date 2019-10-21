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
		comboBoxCategoria.setBounds(150, 42, 146, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setBounds(150, 86, 146, 20);
		contentPane.add(comboBoxProvincia);
		
		JComboBox comboBoxPrecio1 = new JComboBox();
		comboBoxPrecio1.setBounds(150, 127, 59, 20);
		contentPane.add(comboBoxPrecio1);
		
		JComboBox comboBoxPrecio2 = new JComboBox();
		comboBoxPrecio2.setBounds(237, 127, 59, 20);
		contentPane.add(comboBoxPrecio2);
		
		JEditorPane buscador = new JEditorPane();
		buscador.setBounds(66, 11, 230, 20);
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
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(10, 86, 69, 20);
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

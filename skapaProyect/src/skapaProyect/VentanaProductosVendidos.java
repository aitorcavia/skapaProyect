package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class VentanaProductosVendidos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProductosVendidos frame = new VentanaProductosVendidos();
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
	public VentanaProductosVendidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel ArticuloVendido1 = new Panel();
		ArticuloVendido1.setBounds(24, 10, 120, 109);
		contentPane.add(ArticuloVendido1);
		
		JLabel FotoVendido1 = new JLabel("Foto Articulo");
		ArticuloVendido1.add(FotoVendido1);
		
		Panel ArticuloVendido2 = new Panel();
		ArticuloVendido2.setBounds(188, 10, 120, 109);
		contentPane.add(ArticuloVendido2);
		
		JLabel FotoVendido2 = new JLabel("Foto Articulo");
		ArticuloVendido2.add(FotoVendido2);
		
		Panel ArticuloVendido3 = new Panel();
		ArticuloVendido3.setBounds(24, 125, 120, 109);
		contentPane.add(ArticuloVendido3);
		
		JLabel FotoVendido3 = new JLabel("Foto Articulo");
		ArticuloVendido3.add(FotoVendido3);
		
		Panel ArticuloVendido4 = new Panel();
		ArticuloVendido4.setBounds(24, 240, 120, 109);
		contentPane.add(ArticuloVendido4);
		
		JLabel FotoVendido4 = new JLabel("Foto Articulo");
		ArticuloVendido4.add(FotoVendido4);
		
		Panel ArticuloVendido5 = new Panel();
		ArticuloVendido5.setBounds(24, 355, 120, 109);
		contentPane.add(ArticuloVendido5);
		
		JLabel FotoVendido5 = new JLabel("Foto Articulo");
		ArticuloVendido5.add(FotoVendido5);
		
		Panel ArticuloVendido6 = new Panel();
		ArticuloVendido6.setBounds(188, 125, 120, 109);
		contentPane.add(ArticuloVendido6);
		
		JLabel FotoVendido6 = new JLabel("Foto Articulo");
		ArticuloVendido6.add(FotoVendido6);
		
		Panel ArticuloVendido7 = new Panel();
		ArticuloVendido7.setBounds(188, 240, 120, 109);
		contentPane.add(ArticuloVendido7);
		
		JLabel FotoVendido7 = new JLabel("Foto Articulo");
		ArticuloVendido7.add(FotoVendido7);
		
		Panel ArticuloVendido8 = new Panel();
		ArticuloVendido8.setBounds(188, 355, 120, 109);
		contentPane.add(ArticuloVendido8);
		
		JLabel FotoVendido8 = new JLabel("Foto Articulo");
		ArticuloVendido8.add(FotoVendido8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 490, 284, 19);
		contentPane.add(scrollPane);
	
	}

}

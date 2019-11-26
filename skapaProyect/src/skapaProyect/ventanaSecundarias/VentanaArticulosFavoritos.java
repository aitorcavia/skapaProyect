package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class VentanaArticulosFavoritos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaArticulosFavoritos frame = new VentanaArticulosFavoritos();
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
	public VentanaArticulosFavoritos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel ArticuloFavorito1 = new Panel();
		ArticuloFavorito1.setBounds(24, 10, 120, 109);
		contentPane.add(ArticuloFavorito1);
		
		JLabel FotoFavorito1 = new JLabel("Foto Articulo");
		ArticuloFavorito1.add(FotoFavorito1);
		
		Panel ArticuloFavorito2 = new Panel();
		ArticuloFavorito2.setBounds(188, 10, 120, 109);
		contentPane.add(ArticuloFavorito2);
		
		JLabel FotoFavorito2 = new JLabel("Foto Articulo");
		ArticuloFavorito2.add(FotoFavorito2);
		
		Panel ArticuloFavorito3 = new Panel();
		ArticuloFavorito3.setBounds(24, 125, 120, 109);
		contentPane.add(ArticuloFavorito3);
		
		JLabel FotoFavorito3 = new JLabel("Foto Articulo");
		ArticuloFavorito3.add(FotoFavorito3);
		
		Panel ArticuloFavorito4 = new Panel();
		ArticuloFavorito4.setBounds(24, 240, 120, 109);
		contentPane.add(ArticuloFavorito4);
		
		JLabel FotoFavorito4 = new JLabel("Foto Articulo");
		ArticuloFavorito4.add(FotoFavorito4);
		
		Panel ArticuloFavorito5 = new Panel();
		ArticuloFavorito5.setBounds(24, 355, 120, 109);
		contentPane.add(ArticuloFavorito5);
		
		JLabel FotoFavorito5 = new JLabel("Foto Articulo");
		ArticuloFavorito5.add(FotoFavorito5);
		
		Panel ArticuloFavorito6 = new Panel();
		ArticuloFavorito6.setBounds(188, 125, 120, 109);
		contentPane.add(ArticuloFavorito6);
		
		JLabel FotoFavorito6 = new JLabel("Foto Articulo");
		ArticuloFavorito6.add(FotoFavorito6);
		
		Panel ArticuloFavorito7 = new Panel();
		ArticuloFavorito7.setBounds(188, 240, 120, 109);
		contentPane.add(ArticuloFavorito7);
		
		JLabel FotoFavorito7 = new JLabel("Foto Articulo");
		ArticuloFavorito7.add(FotoFavorito7);
		
		Panel ArticuloFavorito8 = new Panel();
		ArticuloFavorito8.setBounds(188, 355, 120, 109);
		contentPane.add(ArticuloFavorito8);
		
		JLabel FotoFavorito8 = new JLabel("Foto Articulo");
		ArticuloFavorito8.add(FotoFavorito8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 490, 284, 19);
		contentPane.add(scrollPane);
	}
}

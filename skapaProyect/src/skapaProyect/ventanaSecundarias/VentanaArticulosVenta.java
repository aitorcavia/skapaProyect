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

public class VentanaArticulosVenta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaArticulosVenta frame = new VentanaArticulosVenta();
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
	public VentanaArticulosVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel ArticuloVenta1 = new Panel();
		ArticuloVenta1.setBounds(26, 10, 120, 109);
		contentPane.add(ArticuloVenta1);
		
		JLabel FotoVenta1 = new JLabel("Foto Articulo");
		ArticuloVenta1.add(FotoVenta1);
		
		Panel ArticuloVenta2 = new Panel();
		ArticuloVenta2.setBounds(190, 10, 120, 109);
		contentPane.add(ArticuloVenta2);
		
		JLabel FotoVenta2 = new JLabel("Foto Articulo");
		ArticuloVenta2.add(FotoVenta2);
		
		Panel ArticuloVenta3 = new Panel();
		ArticuloVenta3.setBounds(26, 125, 120, 109);
		contentPane.add(ArticuloVenta3);
		
		JLabel FotoVenta3 = new JLabel("Foto Articulo");
		ArticuloVenta3.add(FotoVenta3);
		
		Panel ArticuloVenta4 = new Panel();
		ArticuloVenta4.setBounds(26, 240, 120, 109);
		contentPane.add(ArticuloVenta4);
		
		JLabel FotoVenta4 = new JLabel("Foto Articulo");
		ArticuloVenta4.add(FotoVenta4);
		
		Panel ArticuloVenta5 = new Panel();
		ArticuloVenta5.setBounds(26, 355, 120, 109);
		contentPane.add(ArticuloVenta5);
		
		JLabel FotoVenta5 = new JLabel("Foto Articulo");
		ArticuloVenta5.add(FotoVenta5);
		
		Panel ArticuloVenta6 = new Panel();
		ArticuloVenta6.setBounds(190, 125, 120, 109);
		contentPane.add(ArticuloVenta6);
		
		JLabel FotoVenta6 = new JLabel("Foto Articulo");
		ArticuloVenta6.add(FotoVenta6);
		
		Panel ArticuloVenta7 = new Panel();
		ArticuloVenta7.setBounds(190, 240, 120, 109);
		contentPane.add(ArticuloVenta7);
		
		JLabel FotoVenta7 = new JLabel("Foto Articulo");
		ArticuloVenta7.add(FotoVenta7);
		
		Panel ArticuloVenta8 = new Panel();
		ArticuloVenta8.setBounds(190, 355, 120, 109);
		contentPane.add(ArticuloVenta8);
		
		JLabel FotoVenta8 = new JLabel("Foto Articulo");
		ArticuloVenta8.add(FotoVenta8);
		
		JScrollPane CambioPaginaVenta = new JScrollPane();
		CambioPaginaVenta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		CambioPaginaVenta.setBounds(26, 490, 284, 19);
		contentPane.add(CambioPaginaVenta);
	}
}

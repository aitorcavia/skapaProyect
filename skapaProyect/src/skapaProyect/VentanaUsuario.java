package skapaProyect;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textoNombreUsuario;
	private JTextField txtVentas;
	private JTextField txtCompras;

	/**
	 *   Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario frame = new  VentanaUsuario();
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
	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonArticulosVenta = new JButton("Articulos en venta");
		botonArticulosVenta.setBounds(10, 310, 302, 40);
		contentPane.add(botonArticulosVenta);
		
		JButton botonArticulosFavoritos = new JButton("Articulos favoritos");
		botonArticulosFavoritos.setBounds(10, 354, 302, 40);
		contentPane.add(botonArticulosFavoritos);
		
		JButton botonOpiniones = new JButton("Opiniones");
		botonOpiniones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonOpiniones.setBounds(10, 397, 302, 40);
		contentPane.add(botonOpiniones);
		
		JButton botonInfo = new JButton("+ Info");
		botonInfo.setBounds(10, 443, 302, 40);
		contentPane.add(botonInfo);
		
		textoNombreUsuario = new JTextField();
		textoNombreUsuario.setEditable(false);
		textoNombreUsuario.setBounds(10, 28, 150, 40);
		contentPane.add(textoNombreUsuario);
		textoNombreUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gaizka\\Desktop\\UNIVERSIDAD DEUSTO\\Prog\\Proyecto ProgIII\\Tony muy grande.png"));
		lblNewLabel.setBounds(184, 11, 128, 121);
		contentPane.add(lblNewLabel);
		
		txtVentas = new JTextField();
		txtVentas.setEditable(false);
		txtVentas.setText("Ventas");
		txtVentas.setBounds(117, 195, 46, 20);
		contentPane.add(txtVentas);
		txtVentas.setColumns(10);
		
		txtCompras = new JTextField();
		txtCompras.setEditable(false);
		txtCompras.setText("Compras");
		txtCompras.setBounds(203, 195, 56, 20);
		contentPane.add(txtCompras);
		txtCompras.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Gaizka\\Desktop\\UNIVERSIDAD DEUSTO\\Prog\\Proyecto ProgIII\\grafica-64985.gif"));
		lblNewLabel_1.setBounds(10, 150, 97, 106);
		contentPane.add(lblNewLabel_1);
		
		botonArticulosVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaArticulosVenta va = new VentanaArticulosVenta();
				setVisible(false);
				va.setVisible(true);
				
			}
			
		});
		
		botonArticulosFavoritos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaArticulosFavoritos vf = new VentanaArticulosFavoritos();
				setVisible(false);
				vf.setVisible(true);
				
			}
			
		});
		
		botonOpiniones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaOpiniones vo = new VentanaOpiniones();
				setVisible(false);
				vo.setVisible(true);
			}
			
		});
		
		botonInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAyudaInformacion vi = new VentanaAyudaInformacion();
				setVisible(false);
				vi.setVisible(true);
				
			}
			
		});
	
	
}	
}

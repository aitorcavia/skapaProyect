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

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textoNombreUsuario;

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
		botonArticulosVenta.setBounds(10, 316, 152, 40);
		contentPane.add(botonArticulosVenta);
		
		JButton botonArticulosFavoritos = new JButton("Articulos favoritos");
		botonArticulosFavoritos.setBounds(10, 367, 152, 40);
		contentPane.add(botonArticulosFavoritos);
		
		JButton botonOpiniones = new JButton("Opiniones");
		botonOpiniones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonOpiniones.setBounds(10, 418, 152, 40);
		contentPane.add(botonOpiniones);
		
		JButton botonInfo = new JButton("+ Info");
		botonInfo.setBounds(10, 469, 152, 40);
		contentPane.add(botonInfo);
		
		textoNombreUsuario = new JTextField();
		textoNombreUsuario.setEditable(false);
		textoNombreUsuario.setBounds(10, 60, 131, 40);
		contentPane.add(textoNombreUsuario);
		textoNombreUsuario.setColumns(10);
		
		botonArticulosVenta.setCursor(new Cursor(HAND_CURSOR));
		
		botonArticulosVenta.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaArticulosVenta vA = new VentanaArticulosVenta();
				setVisible(false);
				vA.setVisible(true);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
			
				
			}
		
		});
		
		botonArticulosFavoritos.setCursor(new Cursor(HAND_CURSOR));
		
		botonArticulosFavoritos.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaArticulosFavoritos vF = new VentanaArticulosFavoritos();
				setVisible(false);
				vF.setVisible(true);
	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
		});
		
		
		botonOpiniones.setCursor(new Cursor(HAND_CURSOR));
		
		botonOpiniones.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaOpiniones vO = new VentanaOpiniones();
				setVisible(false);
				vO.setVisible(true);
	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
		});
		
		botonInfo.setCursor(new Cursor(HAND_CURSOR));
		
		botonInfo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaInfo vI = new VentanaInfo();
				setVisible(false);
				vI.setVisible(true);
	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
		});
	
	
}}

package skapaProyect.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.ventanaSecundarias.VentanaArticulosFavoritos;
import skapaProyect.ventanaSecundarias.VentanaAyudaInformacion;
import skapaProyect.ventanaSecundarias.VentanaOpiniones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 448, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonArticulosVenta = new JButton("Articulos en venta");
		botonArticulosVenta.setBounds(10, 310, 401, 40);
		contentPane.add(botonArticulosVenta);
		
		JButton botonArticulosFavoritos = new JButton("Articulos favoritos");
		botonArticulosFavoritos.setBounds(10, 354, 401, 40);
		contentPane.add(botonArticulosFavoritos);
		
		JButton botonOpiniones = new JButton("Opiniones");
		botonOpiniones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonOpiniones.setBounds(10, 397, 401, 40);
		contentPane.add(botonOpiniones);
		
		JButton botonInfo = new JButton("+ Info");
		botonInfo.setBounds(10, 443, 401, 40);
		contentPane.add(botonInfo);
		
		//CREADO Y ESCALADO DE IMAGEN
		
		JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(320, 17, 91, 81);
	
		ImageIcon imagenP = new ImageIcon("../skapaProyect/multimedia/FotoPerfil.png");
		
		Icon icono = new ImageIcon(imagenP.getImage().getScaledInstance(imagenPerfil.getWidth(), imagenPerfil.getHeight(), Image.SCALE_DEFAULT));
		imagenPerfil.setIcon(icono);
		
		contentPane.add(imagenPerfil);
		
		JLabel LabelGrafico = new JLabel("");
		LabelGrafico.setIcon(new ImageIcon("../skapaProyect/multimedia/grafica-64985.gif"));
		LabelGrafico.setBounds(10, 150, 97, 106);
		contentPane.add(LabelGrafico);
		
		JLabel labelNombre = new JLabel("New label");
		labelNombre.setBounds(10, 17, 204, 20);
		contentPane.add(labelNombre);
		
		JLabel labelApellidos = new JLabel("New label");
		labelApellidos.setBounds(10, 53, 204, 20);
		contentPane.add(labelApellidos);
		
		JButton btnNewButton = new JButton("Ventas");
		btnNewButton.setBounds(10, 265, 196, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Compras");
		btnNewButton_1.setBounds(220, 265, 191, 29);
		contentPane.add(btnNewButton_1);
		
		botonArticulosVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaMisAnuncios vMa = new VentanaMisAnuncios();
				setVisible(false);
				vMa.setVisible(true);
				
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
	
		imagenPerfil.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				VentanaPerfil vr = new VentanaPerfil();
				setVisible(false);
				vr.setVisible(true);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
}	
}

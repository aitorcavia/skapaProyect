package skapaProyect.ventanasPrimarias;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.*;

public class VentanaMisAnuncios extends JFrame {

	private JPanel contentPane;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMisAnuncios frame = new VentanaMisAnuncios();
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
	public VentanaMisAnuncios() {
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 380, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonCrearAnuncio = new JButton("Crear anuncio");
		botonCrearAnuncio.setBackground(new Color(135, 206, 235));
		botonCrearAnuncio.setBounds(204, 419, 139, 29);
		contentPane.add(botonCrearAnuncio);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 419, 115, 29);
		contentPane.add(btnAtras);
		
		JPanel panelAnuncios = new JPanel();
		panelAnuncios.setBounds(15, 16, 328, 387);
		contentPane.add(panelAnuncios);
		panelAnuncios.setLayout(null);
	
		
		int a = VentanaLogin.getUsuarioId();
		DBManager dbm = new DBManager();
		
		
		try {
			dbm.connect();
			ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
			anuncios = dbm.listarAnunciosIdUsuario(a);
			
			int cont = 16;
			int contS = 0;

			ArrayList<JPanel> paneles = new ArrayList<JPanel>();

			for (Anuncio anuncio : anuncios) {
				int idAnuncio = anuncio.getIdAnuncio();
				String titulo = anuncio.getTitulo();
				String precio = anuncio.getPrecio();
				String categoria = anuncio.getCategoria();
				String descripcion = anuncio.getDescripcion();
			
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 235));
				panel.setBounds(0, cont, 328, 76);
				
				paneles.add(panel);
				
				panelAnuncios.add(paneles.get(contS));
				paneles.get(contS).setLayout(null);
		
				JLabel lblTitulo = new JLabel (titulo);
				lblTitulo.setBounds(15, 16, 160, 20);
				paneles.get(contS).add(lblTitulo);
				
				JButton botonEliminar = new JButton();
				botonEliminar.setBounds(288, 16, 20, 20);
				paneles.get(contS).add(botonEliminar);
				
				ImageIcon imagenX = new ImageIcon("../skapaProyect/multimedia/x_cerrar.png");
				
				Icon icono = new ImageIcon(imagenX.getImage().getScaledInstance(botonEliminar.getWidth(), botonEliminar.getHeight(), Image.SCALE_DEFAULT));
				botonEliminar.setIcon(icono);
				
				botonEliminar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el anuncio '"+ anuncio.getTitulo()+ "'", "Eliminacion de anuncio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							try {
								dbm.connect();
								dbm.eliminarAnuncio(idAnuncio);
								dbm.disconnect();
								
							} catch (DBException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Anuncio eliminado correctamente", "Confirmacion", 1);
							VentanaMisAnuncios vma = new VentanaMisAnuncios();
							vma.setVisible(true);
							setVisible(false);
						}
						
						
						
					}
				});
			
				
				JLabel lblPrecio = new JLabel("Precio: " + precio + " €");
				lblPrecio.setBounds(15, 25+16, 80, 20);
				paneles.get(contS).add(lblPrecio);
			
				
				cont = cont + 80;
				contS++;
			
			}

			dbm.disconnect();
			
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		

		
		botonCrearAnuncio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaCreacionAnuncio vca = new VentanaCreacionAnuncio();
				vca.setVisible(true);
				setVisible(false);
				
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario vu = new VentanaUsuario();
				vu.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
		
		
		
		
		
		}
	}



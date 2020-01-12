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

import javax.swing.ButtonGroup;
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
	private static Anuncio an;

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
		botonCrearAnuncio.setBounds(192, 419, 151, 29);
		contentPane.add(botonCrearAnuncio);
		
		JPanel panelAnuncios = new JPanel();
		panelAnuncios.setBounds(15, 0, 328, 403);
		contentPane.add(panelAnuncios);
		panelAnuncios.setLayout(null);
		
		JButton btnEditar = new JButton("Editar anuncio");
		btnEditar.setBackground(new Color(135, 206, 235));
		btnEditar.setBounds(15, 419, 151, 29);
		contentPane.add(btnEditar);
	
		
		int a = VentanaLogin.getUsuarioId();
		DBManager dbm = new DBManager();
		
		ArrayList<JButton> botonesEliminar = new ArrayList<JButton>();
		ArrayList<JButton> botonesEditar = new ArrayList<JButton>();

		
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
				botonEliminar.setBounds(288, 42, 20, 20);
				paneles.get(contS).add(botonEliminar);
				botonEliminar.setVisible(false);
				botonesEliminar.add(botonEliminar);
				
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
				
				JButton botonEditar = new JButton();
				botonEditar.setBounds(288, 16, 20, 20);
				paneles.get(contS).add(botonEditar);
				botonEditar.setVisible(false);
				botonesEditar.add(botonEditar);
				
				ImageIcon imagenE = new ImageIcon("../skapaProyect/multimedia/editar.png");
				
				Icon iconoE = new ImageIcon(imagenE.getImage().getScaledInstance(botonEditar.getWidth(), botonEditar.getHeight(), Image.SCALE_DEFAULT));
				botonEditar.setIcon(iconoE);
				
				botonEditar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						an = anuncio;
						VentanaEdicionAnuncio vea = new VentanaEdicionAnuncio();
						vea.setVisible(true);
						setVisible(false);
						
						
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
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (JButton boton : botonesEliminar) {
					if(!boton.isVisible()) {
						boton.setVisible(true);
						btnEditar.setBackground(new Color(169, 204, 227 ));
						
					}else {
						boton.setVisible(false);
						btnEditar.setBackground(new Color(135, 206, 235));
					}
				}
				
				for (JButton boton : botonesEditar) {
					if(!boton.isVisible()) {
						boton.setVisible(true);
						btnEditar.setBackground(new Color(169, 204, 227 ));
						
					}else {
						boton.setVisible(false);
						btnEditar.setBackground(new Color(135, 206, 235));
					}
				}
				
			}
		});

		
		}
	public static Anuncio getAnuncio() {
		return an;
	}
	}



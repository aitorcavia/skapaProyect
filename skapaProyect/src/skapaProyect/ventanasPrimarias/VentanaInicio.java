package skapaProyect.ventanasPrimarias;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import skapaProyect.chat.VentanaCliente;
import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;
import skapaProyect.ventanaSecundarias.VentanaAjustes;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textoPrecio1;
	private JTextField textoPrecio2;
	private static int idServidor;

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
		
		//CREACION DE INTERFACE
		setTitle("VentanaInicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 735);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {">Seleccionar categoria<", "Cocina", "Videojuegos", "Hogar", "Juguetes", "Libreria", "Seguridad", "Codigos", "Prendas", "Informatica", "Comida"}));
		comboBoxCategoria.setBounds(160, 120, 181, 20);
		contentPane.add(comboBoxCategoria);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Coru\u00F1a", "Pontevedra", "Lugo", "Orense", "Asturias", "Cantabria", "Bizkaia", "Gipuzkoa", "Alaba", "Navarra", "Huesca", "Zaragoza", "L\u00E9rida", "Girona", "Barcelona", "Tarragona", "Teruel", "La Rioja", "Le\u00F3n", "Palencia", "Burgos", "Soria", "Segovia", "Valladolid", "Zamora", "Salamanca", "\u00C1vila", "Madrid", "Guadalajara", "Cuenca", "Albacete", "Toledo", "Ciudad Real", "Castell\u00F3n", "Valencia", "Alicante", "C\u00E1ceres", "Badajoz", "Murcia", "Huelva", "Sevilla", "C\u00F3rdoba", "Ja\u00E9n", "C\u00E1diz", "M\u00E1laga", "Granada", "Almeria", "Islas Baleares", "Islas Canarias"}));
		comboBoxProvincia.setBounds(160, 149, 181, 20);
		contentPane.add(comboBoxProvincia);
		
		JEditorPane textoBuscador = new JEditorPane();
		textoBuscador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoBuscador.setBounds(15, 61, 642, 36);
		contentPane.add(textoBuscador);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(15, 120, 80, 20);
		contentPane.add(lblCategoria);
		
		JLabel lblProvincia = new JLabel("Provincias\r\n e Islas:");
		lblProvincia.setBounds(15, 141, 132, 36);
		contentPane.add(lblProvincia);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(15, 181, 59, 20);
		contentPane.add(lblPrecio);
		
		JPanel panelAnuncios = new JPanel();
		panelAnuncios.setBackground(new Color(135, 206, 250));
		panelAnuncios.setBounds(15, 217, 1256, 446);
		contentPane.add(panelAnuncios);
		panelAnuncios.setLayout(null);
		
		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.setBackground(new Color(240, 255, 255));
		botonBuscar.setBounds(683, 61, 132, 36);
		contentPane.add(botonBuscar);
		
		JLabel lblEntre = new JLabel("entre");
		lblEntre.setBounds(78, 181, 69, 20);
		contentPane.add(lblEntre);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(257, 181, 26, 20);
		contentPane.add(lblY);
		
		textoPrecio1 = new JTextField();
		textoPrecio1.setBounds(146, 178, 100, 26);
		contentPane.add(textoPrecio1);
		textoPrecio1.setColumns(10);
		
		textoPrecio2 = new JTextField();
		textoPrecio2.setColumns(10);
		textoPrecio2.setBounds(287, 178, 100, 26);
		contentPane.add(textoPrecio2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1286, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMisAnuncios = new JButton("Mis Anuncios");
		btnMisAnuncios.setBackground(new Color(135, 206, 250));
		btnMisAnuncios.setBounds(1031, 16, 132, 29);
		panel.add(btnMisAnuncios);
		
		JButton btnAjustes = new JButton("Ajustes");
		btnAjustes.setBackground(new Color(135, 206, 250));
		btnAjustes.setBounds(1178, 16, 85, 29);
		panel.add(btnAjustes);
	
		
		//LISTADO DE TODOS LOS ANUNCIOS
		DBManager conexion = new DBManager();
		
		try {
			conexion.connect();
			int cont = 16;
			
			for (Anuncio anuncio : conexion.listarAnuncios()) {
				String titulo = anuncio.getTitulo();
				String precio = anuncio.getPrecio();
				String categoria = anuncio.getCategoria();
				String descripcion = anuncio.getDescripcion();

				JPanel panelAnuncio = new JPanel();
				panelAnuncio.setBackground(new Color(255,255,255));
				panelAnuncio.setBounds(0, cont, 1250, 85);
				panelAnuncios.add(panelAnuncio);
				panelAnuncio.setLayout(null);
				
				JLabel tituloAnuncio = new JLabel(titulo);
				tituloAnuncio.setBounds(15, 16, 117, 20);
				panelAnuncio.add(tituloAnuncio);
				
				JLabel precioAnuncio = new JLabel("PRECIO: " + precio + " €");
				precioAnuncio.setBounds(15, 47, 96, 20);
				panelAnuncio.add(precioAnuncio);
				
				JLabel lblNewLabel = new JLabel(descripcion);
				lblNewLabel.setBounds(260, 0, 688, 47);
				panelAnuncio.add(lblNewLabel);
				
				JLabel labelImagen = new JLabel("[IMAGEN]");
				labelImagen.setBackground(SystemColor.activeCaptionBorder);
				labelImagen.setBounds(1000, 0, 87, 76);
				panelAnuncio.add(labelImagen);
				
				JButton btnContactar = new JButton("Contactar");
				btnContactar.setBounds(1142, 16, 99, 23);
				panelAnuncio.add(btnContactar);
				
				JButton btninfo = new JButton("+INFO");
				btninfo.setBounds(1142, 44, 99, 23);
				panelAnuncio.add(btninfo);

				cont = cont + 92;
			}
	
		} catch (DBException e2) {
			e2.printStackTrace();
		}
		
		//BOTON BUSCAR ANUNCIO, FILTRADO
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String textoB = textoBuscador.getText();
				String categoriaB = comboBoxCategoria.getSelectedItem().toString();
				String provinciaB = comboBoxProvincia.getSelectedItem().toString();
				String precio1B = textoPrecio1.getText();
				String precio2B = textoPrecio2.getText();
				
				panelAnuncios.removeAll();
				panelAnuncios.repaint();
				
				DBManager conexion = new DBManager();
				
				try {
					conexion.connect();
					
					int cont = 16;
					
					for (Anuncio anuncio : conexion.listarAnunciosFiltro(textoB, categoriaB, provinciaB, precio1B, precio2B)) {
						String titulo = anuncio.getTitulo();
						String precio = anuncio.getPrecio();
						String categoria = anuncio.getCategoria();
						String descripcion = anuncio.getDescripcion();
						
						JPanel panelAnuncio = new JPanel();
						panelAnuncio.setBackground(new Color(255,255,255));
						panelAnuncio.setBounds(0, cont, 1250, 90);
						panelAnuncios.add(panelAnuncio);
						panelAnuncio.setLayout(null);
						
						JLabel tituloAnuncio = new JLabel(titulo);
						tituloAnuncio.setBounds(15, 16, 117, 20);
						panelAnuncio.add(tituloAnuncio);
						
						JLabel precioAnuncio = new JLabel("PRECIO: " + precio + " €");
						precioAnuncio.setBounds(15, 47, 96, 20);
						panelAnuncio.add(precioAnuncio);
						
						JLabel lblNewLabel = new JLabel(descripcion);
						lblNewLabel.setBounds(260, 0, 688, 47);
						panelAnuncio.add(lblNewLabel);
						
						JLabel labelImagen = new JLabel("[IMAGEN]");
						labelImagen.setBackground(SystemColor.activeCaptionBorder);
						labelImagen.setBounds(1000, 0, 87, 76);
						panelAnuncio.add(labelImagen);
						
						JButton btnContactar = new JButton("Contactar");
						btnContactar.setBounds(1142, 16, 99, 23);
						panelAnuncio.add(btnContactar);
						
						btnContactar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								idServidor = anuncio.getIdUsuario();
								VentanaCliente vc = new VentanaCliente();
								vc.setVisible(true);
							}
						});
				
						JButton btninfo = new JButton("+INFO");
						btninfo.setBounds(1142, 44, 99, 23);
						panelAnuncio.add(btninfo);
		
						cont = cont + 95;
			
					}
					
					conexion.disconnect();
					
				} catch (DBException e2) {
					e2.printStackTrace();
				}
				
				
				
			}
		});
		
		btnMisAnuncios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMisAnuncios vms = new VentanaMisAnuncios();
				vms.setVisible(true);
				
			}
		});
		
		btnAjustes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				
			}
		});
		

		
	}
	public static int getIdServidor(){
		return idServidor;
	}
}
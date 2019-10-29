package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil();
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
	public VentanaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fotoperfil = new JLabel("");
		fotoperfil.setIcon(new ImageIcon("C:\\Users\\Gaizka\\git\\skapaProyect\\skapaProyect\\multimedia\\FotoPerfil.png"));
		fotoperfil.setBounds(205, 17, 132, 148);
		contentPane.add(fotoperfil);
		
		JTextPane TextoNombre = new JTextPane();
		TextoNombre.setEditable(false);
		TextoNombre.setText("Nombre");
		TextoNombre.setBounds(15, 27, 72, 26);
		contentPane.add(TextoNombre);
		
		JTextPane nombreUsuario = new JTextPane();
		nombreUsuario.setBounds(15, 58, 105, 26);
		contentPane.add(nombreUsuario);
		
		JTextPane TextoUbicacinProvincia = new JTextPane();
		TextoUbicacinProvincia.setEditable(false);
		TextoUbicacinProvincia.setText("Apellido");
		TextoUbicacinProvincia.setBounds(15, 109, 72, 26);
		contentPane.add(TextoUbicacinProvincia);
		
		JTextPane apellidoUsuario = new JTextPane();
		apellidoUsuario.setBounds(15, 139, 172, 26);
		contentPane.add(apellidoUsuario);
		
		JTextPane TextoUbicacinProvincia_1 = new JTextPane();
		TextoUbicacinProvincia_1.setText("Ubicaci\u00F3n / Provincia");
		TextoUbicacinProvincia_1.setBounds(15, 181, 162, 26);
		contentPane.add(TextoUbicacinProvincia_1);
		
		JTextPane ubicacionProvinciaUsuario = new JTextPane();
		ubicacionProvinciaUsuario.setBounds(15, 215, 182, 26);
		contentPane.add(ubicacionProvinciaUsuario);
		
		JTextPane txtpnInformacinPrivada = new JTextPane();
		txtpnInformacinPrivada.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnInformacinPrivada.setText("Informaci\u00F3n Privada");
		txtpnInformacinPrivada.setBounds(15, 280, 172, 26);
		contentPane.add(txtpnInformacinPrivada);
		
		JComboBox Sexo = new JComboBox();
		Sexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer", "Otro"}));
		Sexo.setBounds(15, 322, 105, 26);
		contentPane.add(Sexo);
		
		JTextPane TextoFechaDeNacimiento = new JTextPane();
		TextoFechaDeNacimiento.setEditable(false);
		TextoFechaDeNacimiento.setText("Fecha de Nacimiento");
		TextoFechaDeNacimiento.setBounds(15, 363, 152, 26);
		contentPane.add(TextoFechaDeNacimiento);
		
		JTextPane FechaDeNacimiento = new JTextPane();
		FechaDeNacimiento.setBounds(15, 393, 152, 26);
		contentPane.add(FechaDeNacimiento);
		
		JTextPane TextoCorreoElectrnico = new JTextPane();
		TextoCorreoElectrnico.setEditable(false);
		TextoCorreoElectrnico.setText("Correo electr\u00F3nico");
		TextoCorreoElectrnico.setBounds(15, 425, 162, 26);
		contentPane.add(TextoCorreoElectrnico);
		
		JTextPane CorreoUsuario = new JTextPane();
		CorreoUsuario.setBounds(15, 456, 260, 21);
		contentPane.add(CorreoUsuario);
		
		JButton BotonTarjeta = new JButton("Tarjeta");
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonTarjeta.setBounds(207, 336, 115, 29);
		contentPane.add(BotonTarjeta);
		
		
		BotonTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPago vP = new VentanaPago();
				setVisible(false);
				vP.setVisible(true);
				}
			});
	}
}

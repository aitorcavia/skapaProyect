package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaAjustes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAjustes frame = new VentanaAjustes();
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
	public VentanaAjustes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane TextoAjustes = new JTextPane();
		TextoAjustes.setEditable(false);
		TextoAjustes.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAjustes.setText("      Ajustes");
		TextoAjustes.setBounds(0, 0, 128, 39);
		contentPane.add(TextoAjustes);
		
		JButton BotonSalir = new JButton("Salir de la aplicacion");
		BotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonSalir.setBounds(15, 467, 177, 36);
		contentPane.add(BotonSalir);
		
		JButton BotonAnyadirCuenta = new JButton("Añadir Cuenta");
		BotonAnyadirCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAnyadirCuenta.setBounds(15, 435, 177, 29);
		contentPane.add(BotonAnyadirCuenta);
		
		JButton BotonCambiarCuenta = new JButton("Cambiar Cuenta");
		BotonCambiarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonCambiarCuenta.setBounds(15, 404, 177, 29);
		contentPane.add(BotonCambiarCuenta);
		
		JTextPane TextoCuenta = new JTextPane();
		TextoCuenta.setEditable(false);
		TextoCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoCuenta.setText("        Cuenta");
		TextoCuenta.setBounds(15, 321, 142, 26);
		contentPane.add(TextoCuenta);
		
		JTextPane TextoAnuncios = new JTextPane();
		TextoAnuncios.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAnuncios.setEditable(false);
		TextoAnuncios.setText("       Anuncios");
		TextoAnuncios.setBounds(15, 147, 142, 39);
		contentPane.add(TextoAnuncios);
		
		JTextPane TextoPagos = new JTextPane();
		TextoPagos.setFont(new Font("Tahoma", Font.BOLD, 18));
		TextoPagos.setEditable(false);
		TextoPagos.setText("        Pagos");
		TextoPagos.setBounds(15, 192, 142, 39);
		contentPane.add(TextoPagos);
		
		JTextPane TextoAyuda = new JTextPane();
		TextoAyuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoAyuda.setEditable(false);
		TextoAyuda.setText("         Ayuda");
		TextoAyuda.setBounds(15, 237, 142, 26);
		contentPane.add(TextoAyuda);
		
		JTextPane TextoInformacion = new JTextPane();
		TextoInformacion.setEditable(false);
		TextoInformacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoInformacion.setText("     Informaci\u00F3n");
		TextoInformacion.setBounds(15, 279, 142, 26);
		contentPane.add(TextoInformacion);
		
		JTextPane TextoPrivacidad = new JTextPane();
		TextoPrivacidad.setEditable(false);
		TextoPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoPrivacidad.setText("     Privacidad");
		TextoPrivacidad.setBounds(15, 76, 142, 26);
		contentPane.add(TextoPrivacidad);
		
		JTextPane TextoSeguridad = new JTextPane();
		TextoSeguridad.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoSeguridad.setEditable(false);
		TextoSeguridad.setText("     Seguridad");
		TextoSeguridad.setBounds(15, 110, 142, 26);
		contentPane.add(TextoSeguridad);
		
		JButton BotonPrivacidad = new JButton("P");
		BotonPrivacidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonPrivacidad.setBounds(168, 73, 115, 29);
		contentPane.add(BotonPrivacidad);
		
		JButton BotonSeguridad = new JButton("S");
		BotonSeguridad.setBounds(168, 110, 115, 26);
		contentPane.add(BotonSeguridad);
		
		JButton BotonAnuncio = new JButton("A");
		BotonAnuncio.setBounds(168, 147, 115, 29);
		contentPane.add(BotonAnuncio);
		
		JButton BotonPago = new JButton("$");
		BotonPago.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonPago.setBounds(168, 192, 115, 39);
		contentPane.add(BotonPago);
		
		JButton BotonInformacion = new JButton("(i) / Ayuda");
		BotonInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonInformacion.setBounds(168, 237, 115, 68);
		contentPane.add(BotonInformacion);
		
		JButton BotonCuenta = new JButton("C");
		BotonCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonCuenta.setBounds(168, 318, 115, 29);
		contentPane.add(BotonCuenta);
	}
}

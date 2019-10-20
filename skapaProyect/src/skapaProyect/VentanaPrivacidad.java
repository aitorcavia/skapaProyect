                                                              package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaPrivacidad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrivacidad frame = new VentanaPrivacidad();
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
	public VentanaPrivacidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInteracciones = new JLabel("Interacciones");
		lblInteracciones.setBounds(25, 11, 79, 20);
		contentPane.add(lblInteracciones);
		
		JButton btnComentarios = new JButton("Comentarios");
		btnComentarios.setBounds(56, 42, 141, 23);
		contentPane.add(btnComentarios);
		
		JButton btnArticulos = new JButton("Articulos");
		btnArticulos.setBounds(56, 76, 141, 23);
		contentPane.add(btnArticulos);
		
		JButton btnEstadoDeActividad = new JButton("Estado de actividad");
		btnEstadoDeActividad.setBounds(56, 110, 141, 23);
		contentPane.add(btnEstadoDeActividad);
		
		JLabel lblConexiones = new JLabel("Conexiones");
		lblConexiones.setBounds(25, 208, 79, 20);
		contentPane.add(lblConexiones);
		
		JButton btnPrivacidadDeLa = new JButton("Privacidad de la cuenta");
		btnPrivacidadDeLa.setBounds(56, 239, 166, 23);
		contentPane.add(btnPrivacidadDeLa);
		
		JButton btnUsuariosBloqueados = new JButton("Usuarios bloqueados");
		btnUsuariosBloqueados.setBounds(56, 273, 166, 23);
		contentPane.add(btnUsuariosBloqueados);
	}
}

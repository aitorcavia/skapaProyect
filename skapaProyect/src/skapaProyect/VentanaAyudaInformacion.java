package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;

public class VentanaAyudaInformacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAyudaInformacion frame = new VentanaAyudaInformacion();
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
	public VentanaAyudaInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane TextoDeLaInformacion = new JTextPane();
		TextoDeLaInformacion.setEditable(false);
		TextoDeLaInformacion.setText("Una manera f\u00E1cil y gratuita de ganar dinero vendiendo las cosas que ya no usas desde una sola aplicaci\u00F3n. En esta aplicaci\u00F3n puedes vender, ceder incluso intercambiar objetos.");
		TextoDeLaInformacion.setBounds(0, 302, 327, 136);
		contentPane.add(TextoDeLaInformacion);
		
		JTextPane TextoCorreoDeContacto = new JTextPane();
		TextoCorreoDeContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoCorreoDeContacto.setEditable(false);
		TextoCorreoDeContacto.setText("Correo de Contacto");
		TextoCorreoDeContacto.setBounds(15, 70, 184, 26);
		contentPane.add(TextoCorreoDeContacto);
		
		JTextPane TextoCorreo = new JTextPane();
		TextoCorreo.setEditable(false);
		TextoCorreo.setText("      skapatutienda2@gmail.com");
		TextoCorreo.setBounds(62, 101, 250, 26);
		contentPane.add(TextoCorreo);
		
		JTextPane TextoInstagram = new JTextPane();
		TextoInstagram.setEditable(false);
		TextoInstagram.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoInstagram.setText("Instagram");
		TextoInstagram.setBounds(15, 134, 136, 26);
		contentPane.add(TextoInstagram);
		
		JTextPane TextoNombreInstagram = new JTextPane();
		TextoNombreInstagram.setEditable(false);
		TextoNombreInstagram.setText("         Skapa");
		TextoNombreInstagram.setBounds(88, 167, 136, 26);
		contentPane.add(TextoNombreInstagram);
		
		JTextPane TextoIntroduccion = new JTextPane();
		TextoIntroduccion.setEditable(false);
		TextoIntroduccion.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoIntroduccion.setText("En caso de necesitar ayuda contacte con nosotros ");
		TextoIntroduccion.setBounds(15, 16, 312, 39);
		contentPane.add(TextoIntroduccion);
		
		JTextPane TextoInformacion = new JTextPane();
		TextoInformacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoInformacion.setText("     Informaci\u00F3n");
		TextoInformacion.setBounds(15, 260, 159, 26);
		contentPane.add(TextoInformacion);
	}
}

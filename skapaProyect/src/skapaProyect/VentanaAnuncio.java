package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class VentanaAnuncio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnuncio frame = new VentanaAnuncio();
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
	public VentanaAnuncio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar BarraDescripcion = new JScrollBar();
		BarraDescripcion.setBounds(286, 269, 26, 218);
		contentPane.add(BarraDescripcion);
		
		JTextPane TextoDescripcion = new JTextPane();
		TextoDescripcion.setEditable(false);
		TextoDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoDescripcion.setText("Descripci\u00F3n");
		TextoDescripcion.setBounds(15, 269, 269, 218);
		contentPane.add(TextoDescripcion);
		
		JLabel Foto = new JLabel("New label");
		Foto.setBounds(15, 16, 297, 218);
		contentPane.add(Foto);
		
		JScrollBar BarraImagen = new JScrollBar();
		BarraImagen.setOrientation(JScrollBar.HORIZONTAL);
		BarraImagen.setBounds(15, 238, 297, 26);
		contentPane.add(BarraImagen);
	}
}
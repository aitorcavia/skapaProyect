package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaChat extends JFrame {

	private JPanel contentPane;
	private JTextField txtUltimaVezConectado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaChat frame = new VentanaChat();
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
	public VentanaChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(187, 224, 1, 1);
		contentPane.add(desktopPane);
		
		JButton BotonEnviar = new JButton(">");
		BotonEnviar.setBounds(212, 440, 115, 29);
		contentPane.add(BotonEnviar);
		
		JScrollBar BarraVerMensajes = new JScrollBar();
		BarraVerMensajes.setBounds(301, 16, 26, 408);
		contentPane.add(BarraVerMensajes);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(15, 432, 193, 37);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(15, 16, 193, 29);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(217, 16, 69, 29);
		contentPane.add(lblNewLabel);
		
		txtUltimaVezConectado = new JTextField();
		txtUltimaVezConectado.setText("Ultima vez conectado");
		txtUltimaVezConectado.setBounds(15, 47, 160, 20);
		contentPane.add(txtUltimaVezConectado);
		txtUltimaVezConectado.setColumns(10);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(174, 47, 34, 20);
		contentPane.add(textPane_2);
	}
}

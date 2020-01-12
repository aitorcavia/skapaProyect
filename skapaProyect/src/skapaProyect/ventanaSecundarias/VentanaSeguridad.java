package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;
import skapaProyect.ventanasPrimarias.Usuario;
import skapaProyect.ventanasPrimarias.VentanaLogin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VentanaSeguridad extends JFrame {

	private JPanel contentPane;
	private JPasswordField campoContrasenyaA;
	private JPasswordField campoContrasenyaN;
	private JPasswordField campoContrasenyaN2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeguridad frame = new VentanaSeguridad();
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
	public VentanaSeguridad() {
		
		int a = VentanaLogin.getUsuarioId();
		
		setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar contrase\u00F1a");
		lblCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCambiarContrasea.setBounds(15, 16, 398, 20);
		contentPane.add(lblCambiarContrasea);
		
		JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a actual");
		lblContraseaAntigua.setBounds(15, 100, 160, 20);
		contentPane.add(lblContraseaAntigua);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setBounds(15, 178, 160, 20);
		contentPane.add(lblNuevaContrasea);
		
		JLabel label = new JLabel("Nueva contrase\u00F1a");
		label.setBounds(15, 256, 160, 20);
		contentPane.add(label);
		
		campoContrasenyaA = new JPasswordField();
		campoContrasenyaA.setBounds(15, 136, 398, 26);
		contentPane.add(campoContrasenyaA);
		
		campoContrasenyaN = new JPasswordField();
		campoContrasenyaN.setBounds(15, 214, 398, 26);
		contentPane.add(campoContrasenyaN);
		
		campoContrasenyaN2 = new JPasswordField();
		campoContrasenyaN2.setBounds(15, 292, 398, 26);
		contentPane.add(campoContrasenyaN2);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(298, 368, 115, 29);
		contentPane.add(btnCambiar);
		
		btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
				try {
					dbm.connect();
					Usuario user = dbm.buscarUsuarioId(a);
					if (user.getContrasenya().equals(campoContrasenyaA.getText()) && campoContrasenyaN.getText().equals(campoContrasenyaN2.getText())) {
						user.setContrasenya(campoContrasenyaN.getText());
						dbm.cambiarContrsenya(user);
						JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
						campoContrasenyaA.setText("");
						campoContrasenyaN.setText("");
						campoContrasenyaN2.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Los campos no coinciden o contraseña incorrecta", "Error", 0);
					}
					dbm.disconnect();
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 368, 105, 29);
		contentPane.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
	}
	
}

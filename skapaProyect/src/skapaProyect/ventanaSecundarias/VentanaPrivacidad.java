package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;
import skapaProyect.ventanasPrimarias.VentanaLogin;
import skapaProyect.ventanasPrimarias.VentanaPerfil;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

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
		setUndecorated(true);
		
		int idU = VentanaLogin.getUsuarioId();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Volver = new JButton("Atras");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(15, 458, 99, 29);
		contentPane.add(Volver);
		
		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.setBackground(Color.WHITE);
		btnEliminarCuenta.setBounds(15, 160, 297, 29);
		contentPane.add(btnEliminarCuenta);
		
		btnEliminarCuenta.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar permanentemente su cuenta?", "Eliminacion de cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						try {
							dbm.connect();
							
							dbm.eliminarUsuario(idU);
							dbm.eliminarAnunciosU(idU);
							dbm.disconnect();
							System.exit(0);
							VentanaLogin vl = new VentanaLogin();
							vl.setVisible(true);
					
							
						} catch (DBException e1) {
							e1.printStackTrace();
						}
				
					}
			}
		});
		
		JButton btnComentarios = new JButton("Comentarios");
		btnComentarios.setBackground(Color.WHITE);
		btnComentarios.setBounds(15, 115, 297, 29);
		contentPane.add(btnComentarios);
		
		btnComentarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaOpiniones vo = new VentanaOpiniones();
				vo.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton btnInfoCuenta = new JButton("Informacion cuenta");
		btnInfoCuenta.setBackground(Color.WHITE);
		btnInfoCuenta.setBounds(15, 70, 297, 29);
		contentPane.add(btnInfoCuenta);
		
		btnInfoCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil vp = new VentanaPerfil();
				vp.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrivacidad.setBounds(15, 16, 149, 20);
		contentPane.add(lblPrivacidad);
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes vA = new VentanaAjustes();
				setVisible(false);
				vA.setVisible(true);
				}
			});
	}
}

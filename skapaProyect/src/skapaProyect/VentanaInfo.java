package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class VentanaInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInfo frame = new VentanaInfo();
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
	public VentanaInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHistorial = new JLabel("Historial");
		labelHistorial.setBounds(10, 11, 73, 39);
		contentPane.add(labelHistorial);
		
		JButton botonProductosVendidos = new JButton("Productos Vendidos");
		botonProductosVendidos.setBounds(37, 61, 137, 23);
		contentPane.add(botonProductosVendidos);
		
		JLabel labelInformacionVerificada = new JLabel("Informaci\u00F3n verificada");
		labelInformacionVerificada.setBounds(10, 88, 164, 39);
		contentPane.add(labelInformacionVerificada);
		
		JTextPane txtInformacionVerificada = new JTextPane();
		txtInformacionVerificada.setEditable(false);
		txtInformacionVerificada.setText("Facebook \r\n\r\n\r\n\r\n\r\nCorreo Eletr\u00F3nico\r\n\r\n\r\n\r\n\r\n\r\nNumero de Tel\u00E9fono");
		txtInformacionVerificada.setBounds(85, 167, 203, 185);
		contentPane.add(txtInformacionVerificada);
		
		JLabel labelMiembroDesde = new JLabel("Miembro desde");
		labelMiembroDesde.setBounds(10, 448, 97, 14);
		contentPane.add(labelMiembroDesde);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gaizka\\git\\skapaProyect\\skapaProyect\\multimedia\\icono-telefono.png"));
		lblNewLabel.setBounds(10, 300, 63, 58);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(20, 465, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		botonProductosVendidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaProductosVendidos vp = new VentanaProductosVendidos();
				setVisible(false);
				vp.setVisible(true);
				
			}
			
		});
		
		txtInformacionVerificada.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			VentanaVerificacion vr = new VentanaVerificacion();
			setVisible(false);
			vr.setVisible(true);
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
}

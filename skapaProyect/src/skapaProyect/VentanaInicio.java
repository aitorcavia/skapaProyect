package skapaProyect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtProvincia;
	private JTextField txtPrecio;

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
		setTitle("VentanaInicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 42, 146, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(150, 86, 146, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(150, 127, 59, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(237, 127, 59, 20);
		contentPane.add(comboBox_4);
		
		txtCategoria = new JTextField();
		txtCategoria.setText("Categoria:");
		txtCategoria.setBounds(10, 42, 115, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.setText("Provincia:");
		txtProvincia.setBounds(10, 86, 115, 20);
		contentPane.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("Precio:");
		txtPrecio.setBounds(10, 127, 115, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
	}
}

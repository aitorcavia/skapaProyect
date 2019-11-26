package skapaProyect.ventanaSecundarias;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import skapaProyect.DataBase.DBException;
import skapaProyect.DataBase.DBManager;
import skapaProyect.ventanasPrimarias.VentanaLogin;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaPago extends	 javax.swing.JFrame {

	private static final Component ActionPerformed = null;
	private JPanel contentPane;
	private JTextField TextoPagoConTarjeta;
	private JTextField TextoNTarjeta;
	private JTextField Textocaducidad;
	private JTextField TextoCodigodeSeguridad;
	private JTextField txtCodigoPostal;
	private JTextField txtDireccinDeFacturacin;
	private JTextField txtNombreCompleto;
	private JTextField txtDireccin;
	private JTextField txtLneaDeDireccin;
	private JTextField txtCiudad;
	private JTextField txtEstadoprovincia;
	private JTextField txtCodigoPostal_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPago frame = new VentanaPago();
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
	public VentanaPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextoPagoConTarjeta = new JTextField();
		TextoPagoConTarjeta.setEditable(false);
		TextoPagoConTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoPagoConTarjeta.setText("Pago con Tarjeta de Credito o Debito");
		TextoPagoConTarjeta.setBounds(0, 16, 312, 26);
		contentPane.add(TextoPagoConTarjeta);
		TextoPagoConTarjeta.setColumns(10);
		
		TextoNTarjeta = new JTextField();
		TextoNTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoNTarjeta.setText("           N\u00FAmero de la tarjeta");
		TextoNTarjeta.setBounds(15, 81, 297, 26);
		contentPane.add(TextoNTarjeta);
		TextoNTarjeta.setColumns(10);
		
		Textocaducidad = new JTextField();
		Textocaducidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		Textocaducidad.setText("    MM/AA");
		Textocaducidad.setBounds(25, 114, 106, 26);
		contentPane.add(Textocaducidad);
		Textocaducidad.setColumns(10);
		
		TextoCodigodeSeguridad = new JTextField();
		TextoCodigodeSeguridad.setFont(new Font("Tahoma", Font.BOLD, 16));
		TextoCodigodeSeguridad.setText("        Codigo de Seguridad");
		TextoCodigodeSeguridad.setBounds(135, 114, 177, 26);
		contentPane.add(TextoCodigodeSeguridad);
		TextoCodigodeSeguridad.setColumns(10);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setText("Codigo Postal");
		txtCodigoPostal.setBounds(108, 156, 106, 26);
		contentPane.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		txtDireccinDeFacturacin = new JTextField();
		txtDireccinDeFacturacin.setEditable(false);
		txtDireccinDeFacturacin.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDireccinDeFacturacin.setText("Direcci\u00F3n de facturaci\u00F3n");
		txtDireccinDeFacturacin.setBounds(60, 198, 203, 26);
		contentPane.add(txtDireccinDeFacturacin);
		txtDireccinDeFacturacin.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNombreCompleto.setText("  Nombre Completo");
		txtNombreCompleto.setBounds(38, 233, 177, 26);
		contentPane.add(txtNombreCompleto);
		txtNombreCompleto.setColumns(10);
		
		txtDireccin = new JTextField();
		txtDireccin.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDireccin.setText("Direcci\u00F3n");
		txtDireccin.setBounds(38, 275, 225, 26);
		contentPane.add(txtDireccin);
		txtDireccin.setColumns(10);
		
		txtLneaDeDireccin = new JTextField();
		txtLneaDeDireccin.setText("L\u00EDnea de Direcci\u00F3n 2 ");
		txtLneaDeDireccin.setBounds(38, 317, 232, 26);
		contentPane.add(txtLneaDeDireccin);
		txtLneaDeDireccin.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCiudad.setText("Ciudad");
		txtCiudad.setBounds(38, 359, 146, 26);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtEstadoprovincia = new JTextField();
		txtEstadoprovincia.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEstadoprovincia.setText("Estado/Provincia");
		txtEstadoprovincia.setBounds(15, 394, 146, 26);
		contentPane.add(txtEstadoprovincia);
		txtEstadoprovincia.setColumns(10);
		
		txtCodigoPostal_1 = new JTextField();
		txtCodigoPostal_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCodigoPostal_1.setText("  Codigo Postal");
		txtCodigoPostal_1.setColumns(10);
		txtCodigoPostal_1.setBounds(166, 394, 146, 26);
		contentPane.add(txtCodigoPostal_1);
		
		JComboBox TipoTarjeta = new JComboBox();
		TipoTarjeta.setModel(new DefaultComboBoxModel(new String[] {"Visa", "MasterCard", "BBK", "Caixa", "Discover", "American Express"}));
		TipoTarjeta.setBounds(225, 46, 87, 26);
		contentPane.add(TipoTarjeta);
		
		JButton BotonGuardar = new JButton("Guardar"); 
		BotonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		BotonGuardar.setBounds(98, 425, 115, 29);
		contentPane.add(BotonGuardar);
		int idU = VentanaLogin.getUsuarioId();
		
		
	
		
		
		JButton BotonPaypal = new JButton("Pagar Con Paypal");
		BotonPaypal.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonPaypal.setBounds(15, 470, 184, 29);
		contentPane.add(BotonPaypal);
		
		
		
		TextoNTarjeta.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				TextoNTarjeta.setText(""); 
			} 
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TextoNTarjeta.setText(""); 
				
			}
		});
		Textocaducidad.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Textocaducidad.setText(""); 
			} 
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Textocaducidad.setText(""); 
				
			}
		});
		TextoCodigodeSeguridad.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		TextoCodigodeSeguridad.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		TextoCodigodeSeguridad.setText(""); 
		
	}
});
		txtCodigoPostal.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtCodigoPostal.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtCodigoPostal.setText(""); 
		
	}
});
		txtDireccin.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtDireccin.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtDireccin.setText(""); 
		
	}
});
		txtNombreCompleto.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtNombreCompleto.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtNombreCompleto.setText(""); 
		
	}
});
		txtLneaDeDireccin.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtLneaDeDireccin.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtLneaDeDireccin.setText(""); 
		
	}
});

		txtEstadoprovincia.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtEstadoprovincia.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtEstadoprovincia.setText(""); 
		
	}
});

		txtCiudad.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		txtCiudad.setText(""); 
	} 
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtCiudad.setText(""); 
		
	}
});
			
		txtCodigoPostal_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				txtCodigoPostal_1.setText(""); 
			} 
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigoPostal_1.setText(""); 
				
			}
		});
		JButton Volver = new JButton("A");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(233, 458, 79, 29);
		contentPane.add(Volver);
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes vA = new VentanaAjustes();
				setVisible(false);
				vA.setVisible(true);
				}
			});
		BotonPaypal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://www.paypal.com/es/signin");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
			
		});
		
		int idUsuario = idU;
		
		BotonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipo =  TipoTarjeta.getSelectedItem().toString();
				String numeroTarjeta = TextoNTarjeta.getText();
				String fecha =	Textocaducidad.getText();
				String codigoDeSeguridad =	TextoCodigodeSeguridad.getText();
				String codigoPostal2 =	txtCodigoPostal.getText();
				String nombreCompleto =	txtNombreCompleto.getText();
				String direccion =	txtDireccin.getText();
				String lineaSegundaDireccion = txtLneaDeDireccin.getText();
				String ciudad =	txtCiudad.getText();
				String estadoProvincia	=	txtEstadoprovincia.getText();
				String codigoPostal	= txtCodigoPostal_1.getText();
				
				Tarjeta tarjeta = new Tarjeta();
				
				tarjeta.setidUsuario(idUsuario);
				tarjeta.setTipo(tipo);
				tarjeta.setNumeroTarjeta(numeroTarjeta);
				tarjeta.setFecha(fecha);
				tarjeta.setCodigoDeSeguridad(codigoDeSeguridad);
				tarjeta.setCodigoPostal2(codigoPostal2);
				tarjeta.setNombreCompleto(nombreCompleto);
				tarjeta.setDireccion(direccion);
				tarjeta.setLineaSegundaDireccion(lineaSegundaDireccion);
				tarjeta.setCiudad(ciudad);
				tarjeta.setEstadoProvincia(estadoProvincia);
				tarjeta.setCodigoPostal(codigoPostal);
				
				DBManager conexionT = new DBManager();
				
				try {
					conexionT.connect();
					conexionT.insertarDatosTarjeta(tarjeta);
					JOptionPane.showMessageDialog(null, "Los datos de la tarjeta se han guardado correctamente", "Correcto", 1);
					conexionT.disconnect();
				} catch (DBException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
	}
}

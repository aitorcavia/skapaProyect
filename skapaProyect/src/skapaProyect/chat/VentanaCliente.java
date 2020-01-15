package skapaProyect.chat;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import skapaProyect.dataBase.DBException;
import skapaProyect.dataBase.DBManager;
import skapaProyect.ventanasPrimarias.Usuario;
import skapaProyect.ventanasPrimarias.VentanaInicio;
import skapaProyect.ventanasPrimarias.VentanaLogin;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class VentanaCliente extends JFrame {

	JTextArea area_chat = null;
	JFrame ventana_chat = null;
	JButton btn_enviar = null;
	JTextField txt_mensaje = null;
	JPanel contenedor_areachat = null;
	JPanel contenedor_btntxt = null;
	String direccionIpCliente = null;
	String direccionIpServidor = null;
	
	
//	JScrollPane scroll = null;
	JTextField txt_nick,txt_ip;
	
	Socket socket = null;
	BufferedReader lector = null;
	PrintWriter escritor=null;

	
	public VentanaCliente() {
		hacerInterfaz();
	}
	
	public void hacerInterfaz() {
		
		
		//SACAR DIRECCION IP SERVIDOR Y IP CLIENTE
		DBManager conexion = new DBManager();
		try {
			conexion.connect();
			Usuario uServidor = conexion.buscarUsuarioId(VentanaInicio.getIdServidor());
			direccionIpServidor = uServidor.getDireccionIP();
			Usuario uCliente = conexion.buscarUsuarioId(VentanaLogin.getUsuarioId());
			direccionIpCliente = uCliente.getDireccionIP();
			conexion.disconnect();
			
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		
		ventana_chat = new JFrame("Cliente"); 
		ventana_chat.getContentPane().setBackground(SystemColor.activeCaption);
		txt_nick = new JTextField(5);
		txt_ip = new JTextField(8);

		contenedor_areachat = new JPanel();
		contenedor_areachat.setBounds(0, 0, 294, 0);
		contenedor_areachat.setLayout(new GridLayout(1,1));
	//	contenedor_areachat.add(scroll);

		contenedor_btntxt = new JPanel();
		contenedor_btntxt.setBounds(0, 490, 343, 29);
		contenedor_btntxt.setLayout(new GridLayout(1,2));
		ventana_chat.getContentPane().setLayout(null);
		ventana_chat.getContentPane().add(contenedor_areachat);
		ventana_chat.getContentPane().add(contenedor_btntxt);
		txt_mensaje = new JTextField(4);
		contenedor_btntxt.add(txt_mensaje);
		
		btn_enviar = new JButton("Enviar");
		btn_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contenedor_btntxt.add(btn_enviar);
		btn_enviar.setBackground(new Color(224, 255, 255));
		
		area_chat =  new JTextArea();
		area_chat.setBounds(0, 46, 343, 444);
		area_chat.setEditable(false);
		ventana_chat.getContentPane().add(area_chat);
	
		

		JLabel labelChat = new JLabel("Comprador");
		labelChat.setBounds(0, 0, 294, 44);
		labelChat.setFont(new Font("Sitka Small", Font.BOLD, 16));
		labelChat.setOpaque(true);
		labelChat.setBackground(SystemColor.activeCaption);

		
		
		ventana_chat.getContentPane().add(labelChat);
		
		
		ventana_chat.setSize(349,559);
		ventana_chat.setVisible(true);
		ventana_chat.setResizable(false);
		ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Thread principal =  new Thread(new Runnable() {
			public void run() {
				try {
		
					socket = new Socket(direccionIpCliente,9000);//"localhost"
 						leer();
						escribir();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		principal.start();
	}
	
	

	public void leer() {
		Thread leer_hilo = new Thread(new Runnable(){
			
			public void run() {
				try {
					lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while(true) {
						String mensaje_recibido = lector.readLine();
						area_chat.append("Servidor dice:  " + mensaje_recibido+"\n");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		leer_hilo.start();

	}

	public void escribir() {
		Thread escribir_hilo = new Thread(new Runnable() {
			public void run() {
				try {						
					
					escritor = new PrintWriter(socket.getOutputStream(),true);
					btn_enviar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e ) {
							String enviar_mensaje = txt_mensaje.getText();
							escritor.println(enviar_mensaje);
							txt_mensaje.setText("");
							area_chat.append("Yo: " + enviar_mensaje +"\n");
		
							

						}
					});
					
				}catch (Exception ex) {
					ex.printStackTrace();
					
				}
			}
		}); 
		escribir_hilo.start();
		
	}
	
	
	
	public static void main(String[] args) {
		new VentanaCliente();
	}
}

package skapaProyect.chat;

import javax.swing.*;


import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;


public class VentanaServidor  {

	JFrame ventana_chat = null;
	JButton btn_enviar = null;
	JTextField txt_mensaje = null;
	JTextArea area_chat = null;
	JPanel contenedor_areachat = null;
	JPanel contenedor_btntxt = null;
	//JScrollPane scroll = null;
	ServerSocket servidor = null;
	Socket socket = null;
	BufferedReader lector = null;
	PrintWriter escritor=null;
	

public VentanaServidor() {
	
	hacerInterfaz();
}

public void hacerInterfaz() {
	ventana_chat = new JFrame("Servidor"); 
	contenedor_areachat = new JPanel();
	contenedor_areachat.setBounds(0, 0, 294, 0);
	contenedor_areachat.setLayout(new GridLayout(1,1));
	//contenedor_areachat.add(scroll);
	contenedor_btntxt = new JPanel();
	contenedor_btntxt.setBounds(0, 490, 343, 29);
	contenedor_btntxt.setLayout(new GridLayout(1,2));
	ventana_chat.getContentPane().setLayout(null);
	ventana_chat.getContentPane().add(contenedor_areachat);
	ventana_chat.getContentPane().add(contenedor_btntxt);
	txt_mensaje = new JTextField(4);
	contenedor_btntxt.add(txt_mensaje);
	btn_enviar = new JButton("Enviar");
	contenedor_btntxt.add(btn_enviar);
	btn_enviar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btn_enviar.setBackground(new Color(224, 255, 255));
	
	area_chat = new JTextArea();
	area_chat.setEditable(false);
	area_chat.setBounds(0, 46, 343, 446);
	ventana_chat.getContentPane().add(area_chat);
	
	
	JLabel lblNewLabel = new JLabel("Vendedor");
	lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 16));
	lblNewLabel.setOpaque(true);
	lblNewLabel.setBackground(new Color(173, 216, 230));
	lblNewLabel.setBounds(0, 0, 343, 46);
	ventana_chat.getContentPane().add(lblNewLabel);
	ventana_chat.setSize(349,559);
	ventana_chat.setVisible(true);
	ventana_chat.setResizable(false);
	ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	Thread principal =  new Thread(new Runnable() {
		public void run() {
			try {
				servidor = new ServerSocket(9000);
				while(true) {
					socket = servidor.accept();
					
					leer();
					escribir();
				}
			} catch (Exception e) {
				e.printStackTrace();
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
					area_chat.append("Cliente dice:  " + mensaje_recibido+"\n");
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
						area_chat.append(" Yo:   " + enviar_mensaje +"\n");
						
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
	
	new VentanaServidor();
	
}
}

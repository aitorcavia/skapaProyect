package skapaProyect;

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
	btn_enviar = new JButton("Enviar");
	txt_mensaje = new JTextField(4);
	contenedor_areachat = new JPanel();
	contenedor_areachat.setBounds(0, 0, 294, 0);
	contenedor_areachat.setLayout(new GridLayout(1,1));
	//contenedor_areachat.add(scroll);
	contenedor_btntxt = new JPanel();
	contenedor_btntxt.setBounds(0, 272, 294, 29);
	contenedor_btntxt.setLayout(new GridLayout(1,2));
	contenedor_btntxt.add(txt_mensaje);
	contenedor_btntxt.add(btn_enviar);
	ventana_chat.getContentPane().setLayout(null);
	ventana_chat.getContentPane().add(contenedor_areachat);
	ventana_chat.getContentPane().add(contenedor_btntxt);
	
	area_chat = new JTextArea();
	area_chat.setEditable(false);
	area_chat.setBounds(0, 46, 294, 225);
	ventana_chat.getContentPane().add(area_chat);
	
	JLabel lblNewLabel = new JLabel("Vendedor");
	lblNewLabel.setBackground(new Color(135, 206, 250));
	lblNewLabel.setBounds(0, 0, 294, 46);
	ventana_chat.getContentPane().add(lblNewLabel);
	ventana_chat.setSize(300,341);
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
						area_chat.append("YO:  " + enviar_mensaje +"\n");
						
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

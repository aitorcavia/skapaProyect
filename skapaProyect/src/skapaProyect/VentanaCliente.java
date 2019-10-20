package skapaProyect;

// parte1 https://www.youtube.com/watch?v=zZIeUCBKwjc
//parte 2 https://www.youtube.com/watch?v=VvKv0EN6q0k
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VentanaCliente  {

	JFrame ventana_chat = null;
	JButton btn_enviar = null;
	JTextField txt_mensaje = null;
	JTextArea area_chat = null;
	JPanel contenedor_areachat = null;
	JPanel contenedor_btntxt = null;
//	JScrollPane scroll = null;
	
	Socket socket = null;
	BufferedReader lector = null;
	PrintWriter escritor=null;


	
	
	public VentanaCliente() {
		hacerInterfaz();
	}
	
	public void hacerInterfaz() {
		ventana_chat = new JFrame("Cliente"); 
		btn_enviar = new JButton("Enviar");
		txt_mensaje = new JTextField(4);
		contenedor_areachat = new JPanel();
		contenedor_areachat.setLayout(new GridLayout(1,1));
	//	contenedor_areachat.add(scroll);

		contenedor_btntxt = new JPanel();
		contenedor_btntxt.setLayout(new GridLayout(1,2));
		contenedor_btntxt.add(txt_mensaje);
		contenedor_btntxt.add(btn_enviar);
		ventana_chat.getContentPane().setLayout(new BorderLayout());
		ventana_chat.getContentPane().add(contenedor_areachat,BorderLayout.NORTH);
		ventana_chat.getContentPane().add(contenedor_btntxt,BorderLayout.SOUTH);
		//scroll = new JScrollPane(area_chat);

		
		TextArea area_chat_1 = new TextArea();
		ventana_chat.getContentPane().add(area_chat_1, BorderLayout.CENTER);
		ventana_chat.setSize(300,200);
		ventana_chat.setVisible(true);
		ventana_chat.setResizable(false);
		ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Thread principal =  new Thread(new Runnable() {
			public void run() {
				try {
					socket = new Socket("local host",9000);
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

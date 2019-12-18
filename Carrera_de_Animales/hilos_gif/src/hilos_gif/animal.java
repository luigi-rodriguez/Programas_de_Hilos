package hilos_gif;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

public class animal extends Thread{ //LA CLASE HEREDA DE LA CLASE "THREAD" (HILOS)
	String nombre;
	int limite;
	JLabel label; // ETIQUETA SE UTLIZA PARA VER UNA IMAGEN CON TEXTO
	
	// CONSTRUCTOR
	public animal(String nombre, int limite, JLabel label){
		this.nombre = nombre;
		this.limite = limite;
		this.label = label;
	}
	@Override
	public void run(){
		
		for(int x=0; x<limite; x++){
			System.out.println(nombre + " AVANZA");
			
			label.setLocation(x,0);
                    try {
                    // metodo para parar o detener los hilos
                        Thread.sleep(10);  // metodo para detener o pausar cada uno de los hilos
                    } catch (InterruptedException ex) {
                        Logger.getLogger(animal.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		//Mensaje
		JOptionPane.showMessageDialog(null, nombre + " HA LLEGADO A LA META");
		
		yield();// metodo aleatorio 
	}

}
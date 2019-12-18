package hilos_gif;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon; // Para imagenes

import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.JFrame; // Para ventanas

import javax.swing.JLabel; //PARA LAS ETIQUETAS
import javax.swing.JPanel; //

public class CARRERA extends JFrame{

	JPanel[] Paneles;
	JLabel[] labels;
	String[] nombres = {"tortuga", "tiburon", "children", "perro"};
	
	
	//AGREGAR UN BOTON
	JButton Boton;
	
	int Ancho = 800;
	
        //constructor
	public CARRERA(){
		
		//acomodo de forma de Tablas
		setLayout(new GridLayout(0,1));
		
		//intancia 
		Paneles = new JPanel[4]; // ventana
		labels = new JLabel[4];
		
		  //ciclo de "n" veses para animales
		for(int n=0; n<4; n++){
			Paneles [n] = new JPanel();
			add(Paneles[n]);
			labels [n] = new JLabel(nombres[n]);
			
			//Direccion de las imagenes
			labels [n].setIcon(new ImageIcon (getClass().getResource(nombres[n] + ".gif")));
			Paneles[n].add(labels[n]);
			labels[n].setLocation(0, 0);// POSICIONAMIENTO DE "X" y "Y" AL INICIAR
		}
		
		// Diseño del boton
		Boton = new JButton("COMENZAR CARREARA");
		//FUNCION DEL BOTON (OYENTE)
		Boton.addActionListener(new ActionListener() {
				
				@Override // se ultiza para estender o sobre-escribir
				public void actionPerformed(ActionEvent e) {
					System.out.println("La Carrera Comenzar");

				        // dimensiones de las imgs y su etiqueta  de c/u                                                                                 
					animal tiburo = new animal("tiburon", Ancho - 150, labels[0]);
					animal perro = new animal("perro", Ancho - 150, labels[1]);
					animal children = new animal("children", Ancho - 150, labels[2]);
                                        animal tortuga = new animal("tortuga", Ancho - 150, labels[3]);
					
					// se ejecuta cada hilo (Img)
					tiburo.start();
					perro.start();
					children.start();
                                        tortuga.start();
							
				}
				});
		// funciones del boton
		add(Boton);
					/*metodos*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(30, 5); // posicion de ventana horizontal & vertical
		setSize(1300, 850);// Tamaño de ventana
		setVisible(true);
		
		
	}/*	FIN DEL CONSTRUCTOR  */
	
	public static void main(String[] args) {
		
		// INSTANCIA de la CLASE CARRERA
		CARRERA CHAMPIONS = new CARRERA();
	}

}


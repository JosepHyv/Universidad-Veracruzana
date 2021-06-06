package Ventanas;
/// Backend

import engine.*;
import resources.*;

//// parte de la GUI 
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Ejemplo de una ventana con tres botones usando FlowLayout

public class IMenu extends Frame
{

// define tres objetos Button

private Button b1,b2,b3,b4;
private Label l;

public IMenu()
{

		// el constructor del padre recibe el titulo de la ventana s
	    super("Universidad Veracruzana");
			

		// define el layout que va a tener la ventana: FlowLayout

		setLayout(new FlowLayout());

		// instancia los tres botones y los agrega al container
		l=new Label("MENU");
		add(l);

		b1=new Button("Agregar");

		add(b1);

		b2=new Button("Consultar");
		b2.addActionListener(new EscuchaConsulta());
		add(b2);

		b3=new Button("Modificar");

		add(b3);

		b4=new Button("Eliminar");

		add(b4);
		//accion de cerrar ventana
		addWindowListener(new EscuchaVentana());

		// define el tamaño de la ventana y la hace visible 
		setSize(500,150);

		setVisible(true);



}
	class EscuchaVentana implements WindowListener{
		public void windowClosing(WindowEvent e){
			//cerrar la ventana y finalizar el programa
			setVisible(false);
			dispose();
			System.exit(0);
		}
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	}
	class EscuchaConsulta implements ActionListener{
		public void actionPerformed (ActionEvent t){
			Ventana venti=new Ventana();
		}
	}
public static void main(String[] args)
 {
 	IMenu v1 = new IMenu(); 
 }

}

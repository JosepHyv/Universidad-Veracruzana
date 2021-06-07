package Ventanas;
/// Backend

import engine.*;
import resources.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class Ventana extends JFrame {
	private JButton b1, b2, b3, b4, b5;
	private Template nodo;
	public Ventana(Template variable) {
		super("Consultas");
		setLayout(new FlowLayout());
		b1 = new JButton("Academias");
		b1.addActionListener(new EscucharAc());
		add(b1);
		b2 = new JButton("Experiencia Educativa");
		b2.addActionListener(new EscuchaEE());
		add(b2);
		b3 = new JButton("Estudiantes de una Academia");
		b3.addActionListener(new EscucharEs());
		add(b3);
		b4 = new JButton("Profesores de una Academia");
		b4.addActionListener(new EscucharPr());
		add(b4);
		/*b5 = new JButton("Estudiante");
		add(b5);*/


		/// Aqui comienzan mis modificaciones :3 
		this.nodo = variable;


		/// aqui las vou a  dejar 
		addWindowListener(new EscuchaVentana());
		setSize(400,150);
		setVisible(true);
	}

	/// más modificaciones
	public Template getNodo()
	{
		return this.nodo;
	}

	/// modificacion mia
	class EscuchaVentana implements WindowListener{
		public void windowClosing(WindowEvent e){
			//cerrar la ventana y finalizar el programa
			setVisible(false);
			dispose();
			//System.exit(0);
		}
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	}
	
	class EscuchaEE implements ActionListener{
		public void actionPerformed(ActionEvent x){
			JBusqueda ventanita=new JBusqueda("Experiencia Educativa", "Academia", getNodo());
		}
	}

	class EscucharPr implements ActionListener
	{
		public void actionPerformed(ActionEvent x )
		{
			JBusqueda ventana = new JBusqueda("Profesores", "Academia", getNodo());
		}
	}

	class EscucharAc implements ActionListener
	{
		public void actionPerformed(ActionEvent x)
		{
			//Experiencia ventana = new Experiencia("Academias", "Esto tendria que ser una Academiala clase" );
			Functional aux = (Functional)getNodo();
			String ans = "";
			for(int c = 0 ; c<aux.sizeAcademia(); c++)
				ans += aux.getAcademia(c);
			Pantalla ventana = new Pantalla("","este es el norte", ans);
		}
	}

	class EscucharEs implements ActionListener
	{
		public void actionPerformed(ActionEvent x)
		{
			JBusqueda ventana = new JBusqueda("Estudiantes", "Academia", getNodo());
		}
	}

	/*public static void main(String[] args) {
		Ventana v = new Ventana();
	}*/
}
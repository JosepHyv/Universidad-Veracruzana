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
	
	public Ventana() {
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
		addWindowListener(new EscuchaVentana());
		setSize(400,150);
		setVisible(true);
	}
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
			JConsultarExperiencia ventanita=new JConsultarExperiencia("Experiencia Educativa", "Academia");
		}
	}

	class EscucharPr implements ActionListener
	{
		public void actionPerformed(ActionEvent x )
		{
			JConsultarExperiencia ventana = new JConsultarExperiencia("Profesores", "Academia");
		}
	}

	class EscucharAc implements ActionListener
	{
		public void actionPerformed(ActionEvent x)
		{
			//Experiencia ventana = new Experiencia("Academias", "Esto tendria que ser una Academiala clase" );
			Pantalla ventana = new Pantalla("","este es el norte", "aqui debe de haber una clase");
		}
	}

	class EscucharEs implements ActionListener
	{
		public void actionPerformed(ActionEvent x)
		{
			JConsultarExperiencia ventana = new JConsultarExperiencia("Estudiantes", "Academia");
		}
	}

	/*public static void main(String[] args) {
		Ventana v = new Ventana();
	}*/
}
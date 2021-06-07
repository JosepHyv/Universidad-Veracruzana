/*

Pantalla muestra el contenido de una clase, despues de la busqueda
o en su defectoo muestra el string de todo un nodo Functional
*/ 

package Ventanas;

import engine.*;
import resources.*;

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

public class Pantalla extends JFrame{
	//private Template nodo;
		public Pantalla(String a, String b, String c ){ //, Template d ){
			super(a);
			setLayout(new BorderLayout());
			JPanel pNorte=_crearPNorte(b);
			add(pNorte, BorderLayout.NORTH);
			JPanel pCentro=_crearPCentro(c);
			add(pCentro, BorderLayout.CENTER);
			//addWindowListener(new EscuchaVentana2());

			/// Agrego mis cosillas 

		//	this.nodo = d;
			// finalizan mis cosillas 
			setSize(500, 500);
			setVisible(true);
		}

	private JPanel _crearPCentro(String a){
		JPanel p=new JPanel();
		//cad sería la cadena de toString de academia
		String cad=a; //;"Clave \t\tNombre \t\tCreditos\n\n1234\t\tProgramacion\t\t15\n2536\t\tBase de Datos\t\t8";
		JTextArea ta=new JTextArea(cad);
		ta.setEditable(false);
		p.add(ta);
		/*JButton bRegresar=new JButton("Regresar");
		bRegresar.addActionListener(new EscuchaRegresar());
		p.add(bRegresar);*/
		return p;		
	}

	private JPanel _crearPNorte(String acad){
		JPanel p=new JPanel();
		p.add(new JLabel(acad));
		return p;
	}
	/*
	class EscuchaRegresar implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			addWindowListener(new EscuchaVentana2());	
			tfAcademia.requestFocus();
		}
	}*/
	class EscuchaVentana2 implements WindowListener{
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
}
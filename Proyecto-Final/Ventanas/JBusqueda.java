package Ventanas;
/// Backend

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
public class JBusqueda extends JFrame{
	private JButton bBuscar, bCancelar;
	private JTextField tfAcademia;
	private Template nodo;
	private String promesa = "";
	public JBusqueda(String a, String b, Template c){
		super(a);
		this.promesa = a;
		setLayout(new BorderLayout());
		JPanel pCenter=_crearPCenter(b);
		add(pCenter, BorderLayout.CENTER);
		JPanel pSouth=_crearPSouth();
		add(pSouth, BorderLayout.SOUTH);
		addWindowListener(new EscuchaVentana());
		/// Mis modificaciones comienzan aqui
		this.nodo = c;
		// aqui van a acabar si hay algo mal
		/// la noche era muy avanzada jeje 
		setSize(500, 150);
		setVisible(true);
	}
	private JPanel _crearPCenter(String b){
		JPanel p=new JPanel(new FlowLayout());
		p.add(new JLabel(b + ": "));
		tfAcademia=new JTextField(20);
		p.add(tfAcademia);
		return p;
	}
	private JPanel _crearPSouth(){
		JPanel p=new JPanel(new FlowLayout());
		bBuscar=new JButton("Buscar");
		bBuscar.addActionListener(new EscuchaBuscar());
		p.add(bBuscar);
		bCancelar=new JButton("Borrar");
		bCancelar.addActionListener(new EscuchaCancelar());
		p.add(bCancelar);
		return p;
	}

	public  String getPromesa()
	{
		return this.promesa;
	}
	public  Template getNodo()
	{
		return this.nodo;
	}


	class EscuchaBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String acad=tfAcademia.getText();
			String ans = "";
			/*
			/// Aqui va a Comenzar lo mio uwu 

			if( this.promesa.equals("Academias"))
			{
				for(int c = 0; c<(Functional)this.nodo.sizeAcademia(); c++)
					ans += (Functional)this.nodo.getAcademia(c);
			}*/


			/// Aclaro, veremos como sale, la noche ya esta avanzada
			//Solo imprimi para ver si funcionaba el guardado en la variable xd
			//System.out.println(acad);
			//String cadena="Clave \t\tNombre \t\tCreditos\n1234\t\tProgramacion\t\t15";
			//JOptionPane.showMessageDialog(null, cadena);
			Pantalla exp=new Pantalla(getPromesa(),acad, ans);
			//tf.requestFocus();
		}
	}

	class EscuchaCancelar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			tfAcademia.setText("");		
			tfAcademia.requestFocus();
		}
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


}

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
		
			/// Aqui va a Comenzar lo mio uwu 
			//System.out.println("ESTOY PROBANDO "+ (Functional)getNodo());
			if( getPromesa().equals("Experiencia Educativa"))
			{
				Functional aux = (Functional)getNodo();
				for(int c = 0; c<aux.sizeAcademia(); c++)
				{
					Academia temp = aux.getAcademia(c);
					int pos = temp.findExperiencia(acad);
					if( pos != -1)
					{
						ExperienciaEducativa  meh = temp.getEE(pos);
						ans = meh.toString();
						break;
					}
					else ans = "No Existe " + acad;
				}
			}
			else if(getPromesa().equals("Estudiantes de una Academia") )
			{
				Functional aux = (Functional)getNodo();
				int pos = aux.findAcademia(acad);
				if( pos != -1)
				{
					Academia ac = aux.getAcademia(pos);
					for(int c = 0; c<ac.getNumExperiencia(); c++)
					{
						ExperienciaEducativa ee  = ac.getEE(c);
						for(int d = 0 ; d<ee.getNumCurso(); d++)
						{
							Curso cursito = ee.getCurso(d);
							for(int er = 0; er<cursito.getNumAlumno(); er++)
							{
								int xpos = aux.findEstudiante(cursito.getAlumno(er));
								if(xpos != -1)
									ans += aux.getEstudiante(xpos);					
							}
						}
					}
				}
				else
					ans = "No Existe " + acad;

			}
			else if( getPromesa().equals("Profesores de una Academia"))
			{
				Functional nodito = (Functional)getNodo();
				int pos = nodito.findAcademia(acad);
				if( pos != -1)
				{
					Profesor aux = nodito.getAcademia(pos).getCoordinador(); 
					ans = aux.toString();
				}
				else ans = "No se encuentra la Academia\n";


			}
			else ans = "No Hay seleccion\n";


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

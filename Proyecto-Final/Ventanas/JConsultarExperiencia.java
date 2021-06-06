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
public class JConsultarExperiencia extends JFrame{
	private JButton bBuscar, bCancelar;
	private JTextField tfAcademia;
	public JConsultarExperiencia(){
		super("Consulta de Experiencias");
		setLayout(new BorderLayout());
		JPanel pCenter=_crearPCenter();
		add(pCenter, BorderLayout.CENTER);
		JPanel pSouth=_crearPSouth();
		add(pSouth, BorderLayout.SOUTH);
		addWindowListener(new EscuchaVentana());
		setSize(500, 150);
		setVisible(true);
	}
	private JPanel _crearPCenter(){
		JPanel p=new JPanel(new FlowLayout());
		p.add(new JLabel("Academia:"));
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
	class EscuchaBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String acad=tfAcademia.getText();
			//Solo imprimi para ver si funcionaba el guardado en la variable xd
			//System.out.println(acad);
			//String cadena="Clave \t\tNombre \t\tCreditos\n1234\t\tProgramacion\t\t15";
			//JOptionPane.showMessageDialog(null, cadena);
			Experiencia exp=new Experiencia(acad);
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

//Segunda Ventana
	/*
	public static void main(String[] args){
		JConsultarExperiencia e=new JConsultarExperiencia();
	}
	*/
	public class Experiencia extends JFrame{
		public Experiencia(String academia){
			super("Experiencias Educativas");
			setLayout(new BorderLayout());
			JPanel pNorte=_crearPNorte(academia);
			add(pNorte, BorderLayout.NORTH);
			JPanel pCentro=_crearPCentro();
			add(pCentro, BorderLayout.CENTER);
			addWindowListener(new EscuchaVentana2());
			setSize(500, 500);
			setVisible(true);
		}
	}

	private JPanel _crearPCentro(){
		JPanel p=new JPanel();
		//cad sería la cadena de toString de academia
		String cad="Clave \t\tNombre \t\tCreditos\n\n1234\t\tProgramacion\t\t15\n2536\t\tBase de Datos\t\t8";
		JTextArea ta=new JTextArea(cad);
		ta.setEditable(false);
		p.add(ta);
		JButton bRegresar=new JButton("Regresar");
		bRegresar.addActionListener(new EscuchaRegresar());
		p.add(bRegresar);
		return p;		
	}

	private JPanel _crearPNorte(String acad){
		JPanel p=new JPanel();
		p.add(new JLabel(acad));
		return p;
	}
	
	class EscuchaRegresar implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			//addWindowListener(new EscuchaVentana2());	
			tfAcademia.requestFocus();
			tfAcademia.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
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

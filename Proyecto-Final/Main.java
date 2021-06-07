import engine.*; /// clases que nos permite Procesar los datos y guardarlos 
import Ventanas.*;
import resources.*; /// clases del modelo UML
//// importo todos los paquetes que creamos

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Streams flujo = new Streams();
		Functional padre = (Functional)flujo.read(new Functional());
		boolean existe = false;
		Scanner sc = new Scanner(System.in);
//		IMenu menu = new IMenu();
		boolean sigue = true;

		while( sigue )
		{
			int op = 0;
			op = sc.nextInt();
			if( op < 1 || op > 5 )
			{
				System.err.println("No Hay Tal Opcion");
			}
			else if(op == 1 )
			{
				/// hago algo 
			}
			else if( op == 2)
			{
				IMenu menu = new IMenu();

			}
			else if( op == 3 )
			{
				///ajdo
			}
			else if(op == 4)
			{
				/// elimino 
			}
			else if( op == 5 )
			{
				sigue = false;
			}
			clearScreen();
		}

		flujo.save(padre);




	}

	void Agregar()
	{
		if( !(this.existe) )
		{
			/// agrego todo desde el inicio
			System.out.println("Agraga antes una Academia "); // numero de Cursos
			padre.insert(creaAcademia());
			return;
		}
		int opcion = 0;

		System.out.println("Que quieres agregar");
		System.out.println("1) Agregar Academia");
		System.out.println("2) Agregar Experiencias a una Academia"); // el numero de exp 
		System.out.println("3) Agregar Cursos a Experiencias"); // numero de Cursos
		System.out.println("4) Agregar un Alumno a un Curso"); // Validar que no supere el num de creditos 
		System.out.println("5) Agregar Profesor a un Curso"); // numero de Cursos

		sc.nextInt();

		
	}

	 Academia creaAcademia()
	{
		System.out.println("Ingresa el Nombre de la Academia");
		String nom = sc.nextLine();
		Profesor pf = creaProfesor();
		Academia aca = new Academia(nom, pf);
		ExperienciaEducativa exp = creaEE();
		aca.addExperiencia(exp);
		return aca;

	}

	 Profesor creaProfesor()
	{
		String x = "", y = "", z = "";
		System.out.println("Ingresa el Nombre del Profesor");
		x = sc.nextLine();
		System.out.println("Ingresa el Numero de Personal");		
		y = sc.nextLine();
		System.out.println("Ingresa el Tipo de Contratacion");
		z = sc.nextLine();
		Profesor pf = new Profesor(x,y,z);
		padre.insert(pf);
		return pf;	

	}

	 Estudiante creaEstudiante()
	{
		String x = "", y = "";
		System.out.println("Ingresa el Nombre del Alumno");
		x = sc.nextLine();
		System.out.println("Ingresa la matricula de " + x);
		y = sc.nextLine();
		Estudiante es = new Estudiante(y,x);
		padre.insert(es);
		return es;
	}

	 Curso creaCurso()
	{
		String x = "", y = "";
		int z = 0, a = 0;
		System.out.println("Ingresa el Nombre del Curso");
		x = sc.nextLine();
		System.out.println("Ingresa el Nrc del Curso");
		y = sc.nextLine();
		System.out.println("Ingresa el Bloque del Curso ( en numero )");
		z = sc.nextInt();
		System.out.println("Ingresa la Seccion del Curso ( en numero )");
		a = sc.nextInt();
		Curso cursito = new Curso( x,y,z,a);
		System.out.println("Igresa el Nombre del Estudiante");
		String busca = sc.nextLine();
		int pos = padre.findEstudiante(busca);
		if(  pos != -1)
			cursito.addEstudiante(padre.getEstudiante(pos).getNombre() ) ;
		else cursito.addEstudiante(creaEstudiante().getNombre());

		System.out.println("Igresa el Nombre del Docente");
		busca = sc.nextLine();
		pos = padre.findProfesor(busca);
		if( pos != -1)
			cursito.addDocente(padre.getProfesor(pos).getNombre());
		else cursito.addDocente(creaProfesor().getNombre());
		return cursito;



	}

	 ExperienciaEducativa creaEE()
	{
		String x = "", y = "";
		int z = 0 ;
		System.out.println("Ingresa el Nombre de la Experiencia Educativa");
		x = sc.nextLine();
		System.out.println("Ingresa la Clave de la Experiencia Educativa");
		y = sc.nextLine();
		System.out.println("Ingresa el total de Creditos de la Experiencia Educativa");
		z = sc.nextInt();
		ExperienciaEducativa es = new ExperienciaEducativa(x,y,z);
		return es;
	}	





	public static void clearScreen() 
	{  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

}
package engine;
//==============
import resources.*;
///========================

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

public class Streams// extends Template 
{
	public Streams()
	{

	}
	/// Retorna un Template del Archivo Leido
	/* Solo Funciona con aquellas Clases que extienden a Template
	 y estan registradas aqui */ 
	public Template read(Template a) //throws FileNotFoundException //IOException //throws FileNotFoundException
	{
		if( a instanceof Functional)
		{
			try
			{
				FileInputStream aux = new FileInputStream("Functional.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				a = (Functional)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				//System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}

		}
		else if( a instanceof Academia)
		{
			//File f = new File("Academia.obj");
			//if( !(f.exists()) ) return;
			try
			{
/*				File f = new File("Academia.obj");
				String dir = f.getAbsolutePath();*/
				FileInputStream aux = new FileInputStream("Academia.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				if( aux.available() > 0 )
					a = (Academia)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}
		}
		else if( a instanceof Profesor)
		{
			
			try
			{
				FileInputStream aux = new FileInputStream("Profesor.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				if( aux.available() > 0 )
					a = (Profesor)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}
		}
		else if (a instanceof Estudiante)
		{
			
			try
			{
				FileInputStream aux = new FileInputStream("Estudiante.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				if( aux.available() > 0 )
					a = (Estudiante)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}
		}
		else if( a instanceof Curso)
		{
		
			try
			{
				FileInputStream aux = new FileInputStream("Curso.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				if( aux.available() > 0 )
					a = (Curso)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}
		}
		else if( a instanceof ExperienciaEducativa)
		{
			try
			{
				FileInputStream aux = new FileInputStream("ExperienciaEducativa.obj");
				ObjectInputStream entrada = new ObjectInputStream( aux );	
				if( aux.available() > 0 )
					a = (ExperienciaEducativa)entrada.readObject();
				entrada.close();
			}
			catch(FileNotFoundException e )
			{
				System.err.println("Error De archivo:\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.err.println("Error De Entradas y Salidas:\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Error De Clases:\n" + e.getMessage());
			}

		}
		else
		{
			System.err.println("No hay clase correspondiente");
		}

		return a;
	}

	public void save(Template a)
	{
		if( a instanceof Functional)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("Functional.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				Functional aux = (Functional)a;
				fout.writeObject(aux);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}

		}
		else if( a instanceof Academia)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("Academia.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				fout.writeObject((Academia)a);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}

		}
		else if( a instanceof Profesor)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("Profesor.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				fout.writeObject((Profesor)a);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}

		}
		else if( a instanceof Curso)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("Curso.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				fout.writeObject((Curso)a);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}

		}
		else if( a instanceof Estudiante)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("Estudiante.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				fout.writeObject((Estudiante)a);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}

		}
		else if( a instanceof ExperienciaEducativa)
		{
			try
			{
				FileOutputStream sali = new FileOutputStream("ExperienciaEducativa.obj");
				ObjectOutputStream fout = new ObjectOutputStream(sali);
				fout.writeObject((ExperienciaEducativa)a);
				fout.close();

			}
			catch( IOException e)
			{
				System.err.println("Error en Salidas\n" + e.getMessage());
			}
		}
		else
		{
			System.err.println("No hay clase correspondiente");
		}

		return;
	}

	public String getNombre(){
		return "Class <Streams>";
	}
}
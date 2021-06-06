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

public class Streams extends Template
{
	public Streams()
	{

	}

	public void Read(Template a)
	{
		/*if( a instanceof Functional)
		{
			File f = new File("Functional.obj");
			if( !(f.exists()) ) 
				return;

			FileInputStream aux = new FileInputStream("Functional.obj");
			ObjectInputStream entrada = new ObjectInputStream( aux );	
			try
			{
				a = entrada.readObject();
			}
			catch(Exception e )
			{
				System.err.println("Error:\n" + e.getMessage());
			}
		}*/
		/*else*/ if( a instanceof Academia)
		{
			//File f = new File("Academia.obj");
			//if( !(f.exists()) ) return;
			FileInputStream aux = new FileInputStream("Academia.obj");
			ObjectInputStream entrada = new ObjectInputStream( aux );	
			try
			{
				a = (Academia)entrada.readObject();
			}
			catch(Exception e )
			{
				System.err.println("Error:\n" + e.getMessage());
			}
		}
		/*else if( a instanceof Profesor)
		{
			File f = new File("Profesor.obj");
			FileInputStream aux = new FileInputStream("Profesor.obj");
			ObjectInputStream entrada = new ObjectInputStream( aux );	
			if( !(f.exists()) ) 
				return;
			try
			{
				a = entrada.readObject();
			}
			catch(Exception e )
			{
				System.err.println("Error:\n" + e.getMessage());
			}
		}
		else if (a instanceof Estudiante)
		{
			File f = new File("Estudiante.obj");
			FileInputStream aux = new FileInputStream("Estudiante.obj");
			ObjectInputStream entrada = new ObjectInputStream( aux );	
			if( !(f.exists()) ) 
				return;
			try
			{
				a = entrada.readObject();
			}
			catch(Exception e )
			{
				System.err.println("Error:\n" + e.getMessage());
			}
		}
		else if( a instanceof Curso)
		{
			File f = new File("Curso.obj");
			FileInputStream aux = new FileInputStream("Curso.obj");
			ObjectInputStream entrada = new ObjectInputStream( aux );	
			if( !(f.exists()) ) 
				return;
			try
			{
				a = entrada.readObject();
			}
			catch(Exception e )
			{
				System.err.println("Error:\n" + e.getMessage());
			}
		}
*/

	}

	public void Save(Template a)
	{
		return;
	}

	public String getNombre(){
		return "Class <Streams>";
	}
}
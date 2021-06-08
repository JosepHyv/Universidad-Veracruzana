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

public class Streams
{
	public Streams()
	{

	}
	/// Retorna un Template del Archivo Leido
	/* Solo Funciona con aquellas Clases que extienden a Template
	 y estan registradas aqui */ 
	public Functional read(Functional a) //throws FileNotFoundException //IOException //throws FileNotFoundException
	{
		try
		{
			File f = new File("Functional.obj");
			if( !(f.exists()))
				f.createNewFile();
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
			

		
		return a;
	}

	public void save(Functional a)
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

	public String getNombre(){
		return "Class <Streams>";
	}
}
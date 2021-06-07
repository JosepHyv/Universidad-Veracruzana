package engine;
import resources.ExperienciaEducativa;
/* todas son necesarias, no eliminar */
import resources.Template;
import resources.Academia;
import resources.Profesor;
import resources.Estudiante;
import java.io.Serializable;
/// porfi 


public class Functional extends Template 
{
	/// es mejor usar la vector, pero usaremos arreglos normales
	private Academia[] academy = new Academia[12];
	private Profesor[] teacher = new Profesor[12];
	private Estudiante[] student = new Estudiante[12];
	private int it1 = 0, it2 = 0, it3 = 0;

	public Functional()
	{

	}

	public String BuscaAcademiaProfesor(String a )
	{
		String ans = "";
		for(int c = 0 ; c<this.it2; c++)
			if( a.equalsIgnoreCase(this.teacher[c].getAcademia().getNombre()))
				ans += this.teacher[c];
		return ans.length() > 0 ? ans : "No hay Profesores";

	}
	public int findAcademia(String a)
	{	
		for(int c = 0 ; c<this.it1; c++)
		{

			if( a.equalsIgnoreCase(this.academy[c].getNombre()))
				return c;
		}
		return -1;
	}
	public int findProfesor(String a)
	{	
		for(int c = 0 ; c<this.it2; c++)
		{

			if( a.equalsIgnoreCase(this.teacher[c].getNombre()))
				return c;
		}
		return -1;
	}
	public int findEstudiante(String a)
	{	
		for(int c = 0 ; c<this.it3; c++)
		{

			if( a.equalsIgnoreCase(this.student[c].getNombre()))
				return c;
		}
		return -1;
	}

	//// recibe un nombre, una arreglo y un fin
	/// complejidad O(N)
	public int find(String a, Template[] b, int f)
	{	
		for(int c = 0 ; c<f; c++)
		{

			if( a.equalsIgnoreCase(b[c].getNombre()))
				return c;
		}
		return -1;
	}

	
	// recibe una clase ( Academia, profesor o estudiante)
	/// y los inserta respectivamente
	/// Complejidad de Insert O(N)
	public void insert( Template  x )
	{
		if( x instanceof Academia)
		{
			if( find(x.getNombre(), this.academy, this.it1) == -1 && this.it1 < 12)
				this.academy[this.it1++] = ((Academia)x);
			else 
			{
				System.err.println("Error en espacios");
				return;
			}
		}
		else if( x instanceof Profesor)
		{
			if( find(x.getNombre(), this.teacher, this.it2) == -1 && this.it2 < 12)
				this.teacher[this.it2++] = ((Profesor)x);
			else 
			{
				System.err.println("Error en espacios");
				return;
			}
		}
		else
		{
			if( find( x.getNombre(), this.student, this.it3) == -1 && this.it3 < 12)
				this.student[this.it3++] = ((Estudiante)x);
			else 
			{
				System.err.println("Error en espacios");
				return;
			}
		}


	}

	/// remove recibe un objeto
	/// si existe registro lo eliminara
	// complejidad O(2*n) = O(n)
	public void remove(Template x)
	{
		int tam = (x instanceof Academia ? this.it1 : ( x instanceof Profesor ? this.it2 : this.it3));
		int pos = 0;
		if( x instanceof Academia ) pos = find(x.getNombre(),this.academy , tam);
		else if( x instanceof Profesor) pos = find(x.getNombre(), this.teacher, tam);
		else pos = find(x.getNombre(), this.student, tam);
		
		if( pos == -1)
			return;

		if( x instanceof Academia)
		{
			for(int c = pos; c<tam-1; c++)
				this.academy[c] = this.academy[c+1];
			this.it1--;
		}
		else if( x instanceof Profesor)
		{
			for(int c = pos; c<tam-1; c++)
				this.teacher[c] = this.teacher[c+1];
			this.it2--;
		}
		else 
		{
			for(int c = pos; c<tam-1; c++)
				this.student[c] = this.student[c+1];
			this.it3--;
		}
	}

	public void setAcademia(int a, Academia b )
	{
		if( a > 0 && a < 12)
			this.academy[a] = b;
		else 
		{
			System.err.println("Error en rangos");
		}
	}

	public void setProfesor(int a, Profesor b )
	{
		if( a > 0 && a < 12)
			this.teacher[a] = b;
		else 
		{
			System.err.println("Error en rangos");
		}
	}

	public void setEstudiante(int a , Estudiante b )
	{
		if( a > 0 && a < 12)
			this.student[a] = b;
		else 
		{
			System.err.println("Error en rangos");
		}
	}

	public Academia getAcademia(int a )
	{
		return this.academy[a];
	}

	public Profesor getProfesor(int a)
	{
		return this.teacher[a];
	}

	public Estudiante getEstudiante(int a)
	{
		return this.student[a];
	}

	public int sizeAcademia()
	{
		return this.it1;
	}

	public int sizeProfesor()
	{
		return this.it2;
	}
	public int sizeEstudiante()
	{
		return this.it3;
	}

	public String getNombre(){
		return "Class <Functional>";
	}

	public String toString()
	{
		String res = "\n==============================\n\tTotal de Academias \t\n";
		res += "\tCada Academia: \n";
		for(int c = 0 ; c<this.it1; c++)
		{
			res += this.academy[c];
			res += this.academy[c].getCoordinador();
			for(int d = 0 ; d<this.academy[c].getNumExperiencia(); d++)
			{
				int tam = this.academy[c].getEE(d).getNumCurso();
				ExperienciaEducativa aux = this.academy[c].getEE(d);
				for(int e = 0 ; e<tam; e++)
					res += aux.getCurso(e).toString();
			}

				
		}

		return res;
	
	}

	public boolean empty()
	{
		return !(this.it1 > 0  || this.it2 > 0  || this.it3 > 0 );
	}

}
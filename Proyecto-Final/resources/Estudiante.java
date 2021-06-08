package resources; // lo empaquetamos 
import java.io.Serializable;

public class Estudiante extends Template  {
	private String matricula;
	private String nombre;
	///private Curso[] curso= new Curso[6];
	private String[] curso = new String[8];
	private int numCreditos = 0 ; /// difiere
	private int numCurso = 0;
 //// limite 356
	
	public Estudiante(){
	}

	public Estudiante(String n)
	{
		this.nombre = n;
	}

	public Estudiante(String mat, String nomb){
		this.matricula = mat;
		this.nombre = nomb;
	}

	public void setMatricula(String mat){
		this.matricula = mat;
	}

	public String getMatricula(){
		return matricula;
	}

	public void setNombre(String nomb){
		this.nombre = nomb;
	}

	public String getNombre(){
		return nombre;
	}

	public void addCurso(String curso){
		if (numCurso < 8){
			this.curso[this.numCurso] = curso;
			numCurso++;
		}
		else
			System.err.println("No hay capacidad para más cursos");
	}
	
	public String getCurso(int c){
		return curso[c];
	}

	public int getNumCurso(){
		return numCurso;
	}

	/// more 
	public int getNumCreditos()
	{
		return this.numCreditos;
	}

	public void setNumCreditos(int a )
	{
		this.numCreditos = a;
	}

	public void setNumCurso(int a )
	{
		this.numCurso = a;
	}

	public int findCurso(String a )
	{
		int pos = -1;
		for(int c = 0 ; c<this.numCurso; c++)
			if( a.equalsIgnoreCase(this.curso[c]))
			{
				pos = c;
				break;
			}
		return pos;
	}

	public void removeCurso(String a )
	{
		int pos = findCurso(a);
		if( pos == -1)
			return;
		for(int c = 0 ; c<this.numCurso-1; c++)
			this.curso[c] = this.curso[c+1];
		this.numCurso--;
		return;
	}

	//// =========== Estudiante tiene toString ============
	public String toString()
	{
		String ans = "\n==============================\n\tEstudiante\t\n";
		ans += "Nombre: " + this.nombre + "\n";
		ans += "Matricula: " + this.matricula + "\n";
		ans += "Creditos: " + String.valueOf(this.numCreditos) + "\n";
		ans += "Cursos: " + String.valueOf(this.numCurso) + "\n";
		for(int c = 0 ; c<this.numCurso; c++)
			ans += String.valueOf(c+1) + ") " +  this.curso[c] + "\n";
		ans += "\n================\n";
		return ans;
	}
}
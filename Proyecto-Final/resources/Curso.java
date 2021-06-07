package resources; // lo empaquetamos 
import java.io.Serializable;

public class Curso extends Template  {

	private String nombre;
	private String nrc;
	private int bloque;
	private int  seccion;
	//private Profesor docente;
	private String docente;
	
	//private Estudiante[] alumno = new Estudiante[30];
	private String[] alumno = new String[30]; /// guardamos las matriculas
	private int numAlumno = 0;

	public Curso()
	{

	}

	public Curso(String nom, String nrc, int bloque, int seccion){
		this.nombre = nom;
		this.nrc = nrc;
		this.bloque = bloque;
		this.seccion = seccion;
	}

	public void setBloque(int a)
	{
		this.bloque = a;
	}
	public void setDocente(String a)
	{
		this.docente = a;
	}

	public void setNombre(String a)
	{
		this.nombre = a;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setNrc(String a ){
		this.nrc = a;
	}

	public void setBloque(){
		this.bloque = bloque;
	}

	public void setSeccion(int a){
		this.seccion = a;
	}

	public String getNrc(){
		return nrc;
	}

	public int getBloque(){
		return bloque;
	}

	public int getSeccion(){
		return seccion;
	}

	public void addDocente(String doc){
		this.docente = doc;
		
	}

	public void addEstudiante(String alumno){
		if (numAlumno < 30){
			this.alumno[numAlumno] = alumno;
			numAlumno++;
		}
		else
			System.err.println("No hay capacidad para más alumnos");
	}
	
	public int findAlumno(String a)
	{
		int pos = -1;
		for(int c = 0 ; c<this.numAlumno; c++)
			if( a.equalsIgnoreCase(this.alumno[c]))
			{
				pos = c;
				break;
			}
		return pos;
	}

	public void removeAlumno(String a)
	{
		int pos = findAlumno(a);
		if( pos == -1)
			return;
		for(int c = pos; c<this.numAlumno-1; c++)
			this.alumno[c] = this.alumno[c+1];
		this.numAlumno--;
		return;
	}

	public int getNumAlumno(){
		return numAlumno;
	}

	public String getAlumno(int a){
		return alumno[a];
	}

	/// added getDocente()
	public String getDocente()
	{
		return this.docente;
	}

	/// added toString 
	public String toString()
	{

		String ans = "\n==============================\n\tCurso\t\n";
		ans += "Nombre: " + this.nombre + "\n";
		ans += "Bloque: " + String.valueOf((int)this.bloque) + "\n";
		ans += "Seccion: " + String.valueOf((int)this.seccion) + "\n";
		ans += "Docente: " + this.docente + "\n";
		ans += "Alumnos: " + String.valueOf((int)this.numAlumno) + "\n";
		for(int c = 0 ; c<this.numAlumno; c++)
			ans += String.valueOf(c+1) + ") " + this.alumno[c] + "\n";
		ans += "\n================\n";
		return ans;



	}
}
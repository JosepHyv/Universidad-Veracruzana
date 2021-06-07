package resources; // lo empaquetamos 
import java.io.Serializable;

public class Profesor extends Template {
	private String numeroDePersonal;
	private String nombre;
	private String tipoDeContratacion;
	private Academia academia;
	//private Curso [] curso = new Curso[5];
	private String [] curso = new String[5]; //solo nos intersa el nrc

	private int numCurso = 0;

	public Profesor(){
	}

	public Profesor(String nn)
	{
		this.nombre = nn;
	}

	public Profesor( String nomb, String num, String contra){
		this.numeroDePersonal = num;
		this.nombre = nomb;
		this.tipoDeContratacion = contra;
	}

	public String getNumeroDePersonal(){
		return numeroDePersonal;
	}

	public String getNombre(){
		return nombre;
	}  

	public String getTipoDeContratacion(){
		return tipoDeContratacion;
	}

	public void setNumeroDePersonal(String num){
		this.numeroDePersonal = num;
	}

	public void setNombre(String nomb){
		this.nombre = nomb;
	}

	public void setTipoDeContratacion(String contra){
		this.tipoDeContratacion = contra;
	}
	
	public void addAcademia(Academia a){
		this.academia = a;
	}

	public Academia getAcademia(){
		return academia;
	}

	public void addCurso(String  nrc){
		if (numCurso<5){
			this.curso[numCurso] = nrc;
			numCurso++;
		}
		else
		{
			System.err.println("Error en el espacio");
			return;
		}
	}
	/// public Curso
	public String getCurso(int i)
	{
		return curso[i];
	}

	/// added getNumCurso()
	public int getNumCurso()
	{
		return this.numCurso;
	}

	///======= Profesor tiene toString ==========
	public String toString()
	{
		String ans = "\n==============================\n\tProfesor\t\n";
		ans += "Nombre: " + this.nombre + "\n";
		ans += "Numero Personal: " + this.numeroDePersonal + "\n";
		ans += "Contratacion: " + this.tipoDeContratacion + "\n";
		ans += "\tCursos: " + String.valueOf(this.numCurso) + "\n";
		for(int c = 0 ; c<this.numCurso; c++)
			ans += String.valueOf(c+1) + ") " + this.curso[c] + "\n";
		ans += "\n================\n";
		return ans;

	}
}
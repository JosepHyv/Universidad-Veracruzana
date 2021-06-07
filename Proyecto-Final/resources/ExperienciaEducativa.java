package resources; // lo empaquetamos 
import java.io.Serializable;

public class ExperienciaEducativa extends Template  {
	private String nombre;
	private String clave;
	private int totalDeCreditos; //// verificar los creditos 
	private Curso[] curso = new Curso[5]; /// aqui puede haber más de uno ? 
	//private Curso curso;
	private int numCurso = 0; 
	public ExperienciaEducativa(){
	}


	public ExperienciaEducativa(String a)
	{
		this.nombre = a;
	}
	public ExperienciaEducativa(String nom, String c, int tC){
		this.nombre = nom;
		this.clave = c;
		this.totalDeCreditos = tC;
	}

	public void setNombre(String a )
	{
		this.nombre = a;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setClave(String c){
		this.clave = c;
	}

	public String getClave(){
		return clave;
	}

	public void setTotalDeCreditos(int tC){
		this.totalDeCreditos = tC;
	}

	public int getTotalDeCreditos(){
		return totalDeCreditos;
	}

	public void addCurso(Curso c){
		if (numCurso<5){
			this.curso[numCurso] = c;
			numCurso++;
		}
		else 
		{
			System.err.println("Error en el espacio");
			return;
		}
		
	}

	public int findCurso(String a )
	{
		int ans = -1;
		for(int c = 0 ; c<this.numCurso; c++)
			if( a.equalsIgnoreCase(this.curso[c].getNombre()))
			{
				ans = c;
				break;
			}
		return ans;
	}

	// added get curso 
	public Curso getCurso(int a)
	{
		return this.curso[a];
	}
	
	
	public int getNumCurso(){
		return this.numCurso;
	}

	public String toString()
	{
		// hacer algo

		String ans = "\tExperiencia Educativa\n\t" + this.nombre + "\n";
		ans += "Clave: " + this.clave + "\n";
		ans += "Creditos: " + String.valueOf(this.totalDeCreditos) + "\n";
		ans += "Numero de Cursos: " + String.valueOf(this.numCurso) + "\n";
		for(int c = 0; c<this.numCurso; c++)
			ans += curso[c];
		return ans;

	}
}
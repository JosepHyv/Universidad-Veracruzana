package resources; // lo empaquetamos 
import java.io.Serializable;
public class Academia  extends Template  {
	private String nombre;
	private Profesor coordinador;
	private ExperienciaEducativa [] ee = new ExperienciaEducativa[3];
	private int numExperiencia = 0;
	
	public Academia(){
	}

	public Academia(String nomb){
		this.nombre = nomb;
	}

	public Academia(String nombre, Profesor coor){
		this.nombre = nombre;
		this.coordinador = coor;
	}

	public void setNombre(String nomb){
		this.nombre = nomb;
	}

	public int getNumExperiencia()
	{
		return this.numExperiencia;
	}
	
	public String getNombre(){
		return nombre;
	}

	public void setCoordinador(Profesor coor){
		this.coordinador = coor;
	}


	public Profesor getCoordinador(){
		return coordinador;
	}

	public void addExperiencia(ExperienciaEducativa ee){
		if (numExperiencia<4){
			this.ee[numExperiencia] = ee;
			numExperiencia++;
		} else
			System.err.println("No hay capacidad para más experiencias educativas");
	}

	public int findExperiencia(String a)
	{
		int ans = -1;
		for(int c = 0 ; c<this.numExperiencia; c++)
			if( a.equalsIgnoreCase(this.ee[c].getNombre()))
			{
				ans = c;
				break;
			}
		return ans;
	}

	public ExperienciaEducativa getEE(int i){
		return ee[i];
	}

	//// ======== Academia tiene toString =======
	public String toString()
	{
		String ans = "\n==============================\n\tAcademia\t\n";
		ans += "Nombre: " + this.nombre + "\n";
		ans += "Coordinador : " + this.coordinador.getNombre() + "\n";
		ans += "\nExperiencias: " + String.valueOf(this.numExperiencia) +"\n";
		for(int c = 0 ; c<this.numExperiencia; c++)
			ans += String.valueOf(c+1) + ") " + this.ee[c].getNombre() + "\n";
		ans += "\n================\n";
		return ans;


	}

}
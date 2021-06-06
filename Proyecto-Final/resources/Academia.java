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

	public ExperienciaEducativa getEE(int i){
		return ee[i];
	}

	//// ======== Academia tiene toString =======
	public String toString()
	{
		String ans = "\tAcademia\n";
		ans += "Nombre: " + this.nombre + "\n";
		ans += "Coordinador : " + this.coordinador + "\n";
		ans += "\nExperiencias: " + String.valueOf(this.numExperiencia) +"\n";
		for(int c = 0 ; c<this.numExperiencia; c++)
			ans += this.ee[c];
		return ans;


	}

}
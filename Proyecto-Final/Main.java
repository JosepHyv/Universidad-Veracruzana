
import engine.*; /// clases que nos permite Procesar los datos y guardarlos 
import resources.*; /// clases del modelo UML
//// importo todos los paquetes que creamos


public class Main
{
	public static void main(String[] args)
	{
		Functional global = new Functional();
		Academia aux = new Academia("Programacion");
		Profesor juan = new Profesor("Juan Perez", "1726", "Planta");
		juan.addCurso("Mates");
		global.insert(juan);
		Curso auxi = new Curso("raro", "prueba", 1,2);
		// agregar un curso )
		ExperienciaEducativa p = new ExperienciaEducativa("Bases de datos");
		aux.addExperiencia(p);
		global.insert(aux);

		System.out.println(global + "\n");
		/// a una academia ( en functional ) en una experiencia agrego un curso ( a la experiencia)
		global.getAcademia(0).getEE(global.getAcademia(0).findExperiencia("Bases de datos")).addCurso(auxi);
		System.out.println("\n\n====\n");
		System.out.println(global + "\n");
		System.out.println(global.findAcademia("Programacion"));

	}


}

import engine.*; /// clases que nos permite Procesar los datos y guardarlos 
import resources.*; /// clases del modelo UML
//// importo todos los paquetes que creamos


public class Main
{
	public static void main(String[] args)
	{
		
		//Academia cosito = new Academia("olo", new Profesor("Juan perez", "123", "Planta"));
		/*try
		{
			//ObjectInputStream cin = new ObjectInputStream( new FileInputStream("Academia.obj"));
			FileOutputStream sali = new FileOutputStream("Academia.obj");
			ObjectOutputStream sals = new ObjectOutputStream(sali);
			sals.writeObject(cosito);
			sals.close();

		//	Academia cosito = (Academia)cin.readObject();
			//System.out.println(cosito);
		}
		catch(Exception e)
		{
			System.err.println("Errorss: " + e.getMessage());
		}

		Streams flujo = new Streams();
		Academia cosito2 = (Academia)flujo.Read(new Academia());
		System.out.println(cosito2);*/

		Curso cursito = new Curso("Mates", "12342", 2,6);
		cursito.addDocente("Julion Alvares");
		cursito.addEstudiante("s2000201");
		ExperienciaEducativa expi = new ExperienciaEducativa("Exactas", "2032", 365);
		expi.addCurso(cursito);
		Curso cursito2 = new Curso();
		cursito2.setNombre("Algebra");
		cursito2.setNrc("2222");
		cursito2.setBloque(10);
		cursito2.setSeccion(1);
		cursito2.addDocente("Rosalinda bas");
		cursito2.addEstudiante("s1975536");
		expi.addCurso(cursito2);
		//System.out.println(expi);
		Academia ostia = new Academia("Exactas");
		Functional intro = new Functional();
		Profesor aux = new Profesor("julion Alvares", "8862", "Planta");
		ostia.setCoordinador(aux);
		intro.insert(aux);
		ostia.addExperiencia(expi);
		intro.insert(ostia);
		//System.out.println(intro.getAcademia(0));
		//intro.remove(ostia);
		//System.out.println(intro.sizeAcademia());
		

		System.out.println("Antes de leer \n" + intro);
		System.out.println("Numero De Academias " + intro.sizeAcademia());
		System.out.println(intro.sizeAcademia() > 0 ? intro.getAcademia(0) : "No hay nada");

		Streams flujo = new Streams();
		flujo.Save(intro);
		flujo.Save(cursito2);
		intro = new Functional();

		intro = (Functional)flujo.Read(new Functional());

		System.out.println("\n\n=========\n\n");

		System.out.println("Despues de Leer\n" + intro);
		System.out.println("Numero De Academias " + intro.sizeAcademia());
		System.out.println(intro.sizeAcademia() > 0 ? intro.getAcademia(0) : "No hay nada");





	}

	/*boolean Posible( Estudiante a, ExperienciaEducativa b )
	{
		if( a.getNumCreditos() + b.getTotalDeCreditos() <= 356 )
			return true;
		return false;
	}*/


}
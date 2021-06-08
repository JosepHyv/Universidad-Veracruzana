///Modificar
public class temporal
{

	clearScreen();
	boolean opcion = true;
	int numOpcion = 0;
	while( numOpcion )
	{
		System.out.println("Seleccione una Opcion");
		System.out.println("1) Modificar una Academia");
		System.out.println("2) Modificar un Profesor");
		System.out.println("3) Modificar una Experiencia");
		System.out.println("4) Modificar un Alumno");
		System.out.println("5) Modificar un Curso");

		numOpcion = sc.nextInt();
		if( numOpcion >=1 && numOpcion <= 6 )
			opcion = false;
	}

	if(numOpcion == 1)
	{
		clearScreen();
		System.out.println("¿Qué Academia desea modificar?");
		// imprimir la lista de las academias
		Academia ac = padre.getAcademia(i);

		for (int i = 0; i; i++)
		{
			System.out.println(i +") "+ ac[i]);

		}
		
		int modAcademia = 0;
		System.out.println("¿Qué desea modificar?");
		System.out.println("1) Modificar el nombre");
		System.out.println("2) Modificar el coordinador");
		System.out.println("3) Modificar una Experiencia");
		System.out.println("4) Experiencia educativas");
		modAcademia = sc.nextInt();

		if (modAcademia == 1)
		{
			System.out.println("Escriba el nuevo nombre de la Academia");
			sc.nextLine();
			String nomb = sc.nextLine();
			ac[i] = getNombre(nomb);

		} 
		else if (modAcademia == 2)
		{
			System.out.println("Escriba el nuevo nombre del coordinador");
			sc.nextLine();
			String coor = sc.nextLine();
			ac[i] = getCoordinador(coor);
		} 
		else if (modAcademia == 3)
		{
			System.out.println("Escriba la opcion de la Experiencia");
			for (int i= 0; i < sizeAcademia(); i++)
			{
				System.out.println("1) " +getAcademia());
			}
			sc.nextLine();
			int opc = sc.nextLine();
			if (opc = 1) 
			{
				//Modifique a la academia 1
			}

	 	}

	}
	else if (num == 1)
	{
		System.out.println("¿Qué profesor desea modificar?");
		// imprimir la lista de profesores
		Profesor prof = padre.getProfesor(i);

		for (int i= 0; i < padre.sizeProfesor(); i++)
		{
			System.out.println(i + ")" + getProfesor());
		}

		System.out.println("¿Qué desea modificar?");
		System.out.println("1) Nombre");
		System.out.println("2) Tipo de contratación");
		System.out.println("3) Modificar una Experiencia");
		System.out.println("4) Cursos");
		sc.nextLine();
		int modProfesor = sc.nextLine();

		if (modProfesor == 1)
		{
			System.out.println("Escriba el nuevo nombre del profesor");
			sc.nextLine();
			String nomb = sc.nextLine();
			ac[i] = setNombre(nomb);

		} 
		else if (modProfesor == 2)
		{
			System.out.println("Escriba el nuevo tipo de contratación");
			sc.nextLine();
			String cont = sc.nextLine();
			//ac[i] = padre.setTipo(coor);
		} 
		else if (modProfesor == 3)
		{
			System.out.println("Escriba la opcion de la Experiencia");
			for (int i= 0; i < sizeAcademia(); i++)
			{
				System.out.println("1) " +getAcademia());
			}
			sc.nextLine();
			int opc = sc.nextLine();
			if (opc = 1) 
			{
			//Modifique a la experiencia asignada
			}

	 	}
	}
	
}
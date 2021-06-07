import engine.*; /// clases que nos permite Procesar los datos y guardarlos 
import Ventanas.*;
import resources.*; /// clases del modelo UML
//// importo todos los paquetes que creamos

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		clearScreen();
		Streams flujo = new Streams();
		Functional padre = (Functional)flujo.read(new Functional());
		boolean existe = !(padre.empty());
		System.out.println(existe + " " + padre.sizeAcademia() + " " + padre.sizeProfesor() + " " + padre.sizeEstudiante());
		Scanner sc = new Scanner(System.in);
//		IMenu menu = new IMenu();
		boolean sigue = true;
		System.out.println("\tMenu\n");
		while( sigue )
		{
			System.out.println("1) Agregar");
			System.out.println("2) Consultar (GUI disponible)");
			System.out.println("3) Modificar");
			System.out.println("4) Eliminar");
			System.out.println("5) Salir");
			int op = 0;
			op = sc.nextInt();
			if( op < 1 || op > 5 )
			{
				System.err.println("No Hay Tal Opcion");
			}
			else if(op == 1 )
			{
				if( !(existe) )
				{
					/// agrego todo desde el inicio
					System.out.println("Agraga antes una Academia "); // numero de Cursos
					Academia a = creaAcademia();
					Profesor p = a.getCoordinador();
					p.addAcademia(a);
					Estudiante e = creaEstudiante();
					ExperienciaEducativa ee = creaEE();
					Curso c = creaCurso();


					e.addCurso(c.getNombre());
					c.addEstudiante(e.getNombre());
					c.addDocente(p.getNombre());
					p.addCurso(c.getNombre());
					ee.addCurso(c);
					a.addExperiencia(ee);
					padre.insert(a);
					padre.insert(p);
					padre.insert(e);
					existe = true;

				}
				else
				{
					int opcion = 0;
					boolean okidoki = true;
					while(okidoki)
					{
						System.out.println("Que quieres agregar");
						System.out.println("1) Agregar Academia");
						System.out.println("2) Asignar Experiencias a una Academia"); // el numero de exp 
						System.out.println("3) Asignar Cursos a Experiencias"); // numero de Cursos
						System.out.println("4) Asignar un Alumno a un Curso"); // Validar que no supere el num de creditos 
						System.out.println("5) Asignar Profesor a un Curso"); // numero de Cursos					
						opcion = sc.nextInt();
						if( opcion >= 1 && opcion <= 5)
							okidoki = false;
						else 
						{
							System.out.println("Opcion Incorrecta, intenta otra vez");
							clearScreen();
						}

					}	
						
					if( opcion == 1 )
					{
						Academia a = creaAcademia();
						Profesor p = a.getCoordinador();
						p.addAcademia(a);
						Estudiante e = creaEstudiante();
						ExperienciaEducativa ee = creaEE();
						Curso c = creaCurso();


						e.addCurso(c.getNombre());
						c.addEstudiante(e.getNombre());
						c.addDocente(p.getNombre());
						p.addCurso(c.getNombre());
						ee.addCurso(c);
						a.addExperiencia(ee);
						padre.insert(a);
						padre.insert(p);
						padre.insert(e);
						existe = true;
					}
					else if( opcion == 2 )
					{
						/// Asignar Experiencias a una Academia
						String ea = "";
						System.out.println("Ingresa el Nombre de la Academia");
						ea = sc.nextLine();
						int pos = padre.findAcademia(ea);
						if( pos == -1)
							System.out.println("No se encontro la Academia");
						else
						{
							ExperienciaEducativa ee = creaEE();
							padre.getAcademia(pos).addExperiencia(ee);
						}
					}
					else if ( opcion == 3 )
					{
						// Asignar Cursos a Experiencias
						System.out.println("ME MUERO");
						boolean mensaje = true;
						String ea = "";
						System.out.println("Ingresa el Nombre de la Experiencia Educativa");
						ea = sc.nextLine();
						for(int c = 0; c<padre.sizeAcademia(); c++)
						{
							int pos =  padre.getAcademia(c).findExperiencia(ea);
							if( pos != -1)
							{
								Curso cs = creaCurso();
								padre.getAcademia(c).getEE(pos).addCurso(cs);
								mensaje = false;
								break;
							}
						}

						if( mensaje)
						{
							System.out.println("No se pudo insertar");
						}

					}
					else if ( opcion == 4 )
					{
						boolean mensaje = true;
						/// Asignar un Alumno a un Curso
						String ea = "";
						System.out.println("Ingresa el Nombre del Curso");
						ea = sc.nextLine();
						for(int c = 0; c<padre.sizeAcademia(); c++)
						{
							for(int d = 0 ; d<padre.getAcademia(c).getNumExperiencia(); d++)
							{
								int pos = padre.getAcademia(c).getEE(d).findCurso(ea);
								if( pos != -1)
								{
									System.out.println("Ingresa el Nombre del Estudiante");
									String nombre = sc.nextLine();
									int pEstu = padre.findEstudiante(nombre);
									Estudiante es = new Estudiante();
									if( pEstu != -1)
										es = padre.getEstudiante(pEstu);
									else  es = creaEstudiante();
									padre.getAcademia(c).getEE(d).getCurso(pos).addEstudiante(es.getNombre());
									padre.insert(es);
									mensaje = false;
									break;
								}
							}
						}
						if( mensaje)
						{
							System.out.println("No se pudo insertar");
						}

					}
					else if ( opcion == 5)
					{
						// Asignar Profesor a un Curso
						boolean mensaje = true;
						String ea = "";
						System.out.println("Ingresa el Nombre del Curso");
						ea = sc.nextLine();
						for(int c = 0 ; c<padre.sizeAcademia(); c++) 
						{
							for(int d = 0 ; d<padre.getAcademia(c).getNumExperiencia(); d++)
							{
								int pos = padre.getAcademia(c).getEE(d).findCurso(ea);
								if(pos != -1)
								{
									
									Profesor profe = creaProfesor();
									int pProf = padre.findProfesor(profe.getNombre());
									if( pProf != -1)
										profe = padre.getProfesor(pProf);
									//else profe = creaProfesor();
									padre.getAcademia(c).getEE(d).getCurso(pos).addDocente(profe.getNombre());
									padre.insert(profe);
									mensaje = false;
									break;
								}
							}
						}

						if( mensaje)
						{
							System.out.println("No se pudo insertar");							
						}

					}



				}

			}
			else if( op == 2)
			{
				System.out.println(padre);
				IMenu menu = new IMenu();

			}
			else if( op == 3 )
			{
				///ajdo
			}
			else if(op == 4)
			{
				/// elimino 
			}
			else if( op == 5 )
			{
				sigue = false;
			}
			clearScreen();
		}

		flujo.save(padre);




	}



	public static Academia creaAcademia()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el Nombre de la Academia");
		String nom = sc.nextLine();
		Profesor pf = creaProfesor();
		Academia aca = new Academia(nom, pf);
//		ExperienciaEducativa exp = creaEE();
//		aca.addExperiencia(exp);
		return aca;

	}

	public static Profesor creaProfesor()
	{
		Scanner sc = new Scanner(System.in);
		String x = "", y = "", z = "";
		System.out.println("Ingresa el Nombre del Profesor");
		x = sc.nextLine();
		System.out.println("Ingresa el Numero de Personal");		
		y = sc.nextLine();
		System.out.println("Ingresa el Tipo de Contratacion");
		z = sc.nextLine();
		Profesor pf = new Profesor(x,y,z);
		//padre.insert(pf);
		return pf;	

	}

	public static Estudiante creaEstudiante()
	{
		Scanner sc = new Scanner(System.in);
		String x = "", y = "";
		System.out.println("Ingresa el Nombre del Alumno");
		x = sc.nextLine();
		System.out.println("Ingresa la matricula de " + x);
		y = sc.nextLine();
		Estudiante es = new Estudiante(y,x);
		//padre.insert(es);
		return es;
	}

	public static Curso creaCurso()
	{
		Scanner sc = new Scanner(System.in);
		String x = "", y = "";
		int z = 0, a = 0;
		System.out.println("Ingresa el Nombre del Curso");
		x = sc.nextLine();
		System.out.println("Ingresa el Nrc del Curso");
		y = sc.nextLine();
		System.out.println("Ingresa el Bloque del Curso ( en numero )");
		z = sc.nextInt();
		System.out.println("Ingresa la Seccion del Curso ( en numero )");
		a = sc.nextInt();
		Curso cursito = new Curso( x,y,z,a);
		/*System.out.println("Igresa el Nombre del Estudiante");
		String busca = sc.nextLine();
		cursito.addEstudiante(busca);
		System.out.println("Igresa el Nombre del Docente");
		busca = sc.nextLine();
		cursito.addDocente(busca);*/
		return cursito;



	}

	public static ExperienciaEducativa creaEE()
	{
		Scanner sc = new Scanner(System.in);
		String x = "", y = "";
		int z = 0 ;
		System.out.println("Ingresa el Nombre de la Experiencia Educativa");
		x = sc.nextLine();
		System.out.println("Ingresa la Clave de la Experiencia Educativa");
		y = sc.nextLine();
		System.out.println("Ingresa el total de Creditos de la Experiencia Educativa");
		z = sc.nextInt();
		ExperienciaEducativa es = new ExperienciaEducativa(x,y,z);
		return es;
	}	





	public static void clearScreen() 
	{  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

}
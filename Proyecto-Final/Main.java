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
		//System.out.println(existe + " " + padre.sizeAcademia() + " " + padre.sizeProfesor() + " " + padre.sizeEstudiante());
		Scanner sc = new Scanner(System.in);
//		IMenu menu = new IMenu();
		boolean sigue = true;
		while( sigue )
		{
			System.out.println("\tMenu\n");
			System.out.println("1) Agregar");
			System.out.println("2) Consultar (GUI disponible)");
			System.out.println("3) Modificar");
			System.out.println("4) Eliminar");
			System.out.println("5) Salir");
			int op = 0;
			//System.out.println(op);
			op = sc.nextInt();
			if( op < 1 || op > 5 )
			{
				System.err.println("No Hay Tal Opcion");
			}
			else if(op == 1 )
			{
				existe = !(padre.empty());
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
					clearScreen();
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
						clearScreen();
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
						clearScreen();
						/// Asignar Experiencias a una Academia
						System.out.println("Ingresa el Nombre de la Academia");
						String ea = sc.next();
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
						clearScreen();
						// Asignar Cursos a Experiencias
						//System.out.println("ME MUERO");
						boolean mensaje = true;
						System.out.println("Ingresa el Nombre de la Experiencia Educativa");
						String ea = sc.next();
						//ea = sc.nextLine();
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
						clearScreen();
						boolean mensaje = true;
						/// Asignar un Alumno a un Curso
						System.out.println("Ingresa el Nombre del Curso");
						sc.nextLine();
						String ea = sc.nextLine();
						int posCurso = -1 ;
						int posAcademia = -1;
						int posEE = -1;
						for(int c = 0 ; c<padre.sizeAcademia(); c++)
						{
							Academia it = padre.getAcademia(c);
							for(int d = 0 ; d<it.getNumExperiencia(); d++)
							{
								ExperienciaEducativa exp = it.getEE(d);
								posCurso = exp.findCurso(ea);
								if( posCurso != -1)
								{	
									posAcademia = c;
									posEE = d;
									mensaje = false;
									break;
								}
							}

							if( mensaje == false)
								break;
						}

						if( posCurso != -1)
						{

							Curso cursito = ((padre.getAcademia(posAcademia)).getEE(posEE)).getCurso(posCurso);
							System.out.println("Ingresa el Nombre del Alumno");
							String name = sc.nextLine();
							(((padre.getAcademia(posAcademia)).getEE(posEE)).getCurso(posCurso)).addEstudiante(name);
							int tpos = padre.findEstudiante(name);
							Estudiante ess = new Estudiante();
							if(tpos == -1)
							{
								ess.setNombre(name);
								System.out.println("Ingresa la Matricula");
								String mati = sc.next();
								ess.setMatricula(mati);
								int credito = ((padre.getAcademia(posAcademia)).getEE(posEE)).getTotalDeCreditos();
								ess.setNumCreditos(credito);
								ess.addCurso(ea);
								padre.insert(ess);
							}
							else 
							{
								int credito = ((padre.getAcademia(posAcademia)).getEE(posEE)).getTotalDeCreditos();
								Estudiante esi = (padre.getEstudiante(tpos));
								(padre.getEstudiante(tpos)).setNumCreditos(esi.getNumCreditos() + credito);
								(padre.getEstudiante(tpos)).addCurso(ea);
							}

						}
						else
						{
							System.out.println("No se pudo insertar");
						}


						/*
						Cambiando por que hay errores 
						for(int c = 0; c<padre.sizeAcademia(); c++)
						{
							for(int d = 0 ; d<padre.getAcademia(c).getNumExperiencia(); d++)
							{
								int pos = padre.getAcademia(c).getEE(d).findCurso(ea);
								if( pos != -1)
								{
									System.out.println("Ingresa el nombre del Estudiante");
									sc.nextLine();
									String nom = sc.nextLine();
									Estudiante es = new Estudiante(nom);// creaEstudiante();
									int pEstu = padre.findEstudiante(es.getNombre());
									if( pEstu != -1)
									{
										(padre.getEstudiante(pEstu)).setNumCreditos((padre.getEstudiante(pEstu)).getNumCreditos() + (((padre.getAcademia(c)).getEE(d)).getTotalDeCreditos()) );
										es = padre.getEstudiante(pEstu);
									}
									else
									{
										System.out.println("Ingresa la Matricula de " + es.getNombre());
										String mati = sc.nextLine();
										es.addCurso(ea);
										es.setNumCreditos(es.getNumCreditos() + (((padre.getAcademia(c)).getEE(d)).getTotalDeCreditos()));
										es.setMatricula(mati);

									} 
									(((padre.getAcademia(c)).getEE(d)).getCurso(pos)).addEstudiante(es.getNombre());
									padre.insert(es);
									mensaje = false;
									break;
								}
							}
						}
						if( mensaje)
						{
							System.out.println("No se pudo insertar");
						}*/

					}
					else if ( opcion == 5)
					{
						clearScreen();
						// Asignar Profesor a un Curso
						boolean mensaje = true;
						System.out.println("Ingresa el Nombre del Curso");
						String ea = sc.next();
						for(int c = 0 ; c<padre.sizeAcademia(); c++) 
						{
							for(int d = 0 ; d<padre.getAcademia(c).getNumExperiencia(); d++)
							{
								int pos = padre.getAcademia(c).getEE(d).findCurso(ea);
								if(pos != -1)
								{
									Profesor profe = new Profesor();
									System.out.println("Ingresa el Nombre del Profesor");
									sc.nextLine();
									String nns = sc.nextLine();
									int pProf = padre.findProfesor(nns);
									if( pProf != -1)
									{
										(padre.getProfesor(pProf)).addCurso(ea);
										Profesor psss = padre.getProfesor(pProf);
										(((padre.getAcademia(c)).getEE(d)).getCurso(pos)).addDocente(psss.getNombre());

									}
									else
									{
										String y = "", z = "";
										
										System.out.println("Ingresa el Numero de Personal");		
										y = sc.nextLine();
										System.out.println("Ingresa el Tipo de Contratacion");
										z = sc.nextLine();
										profe.setNombre(nns);
										profe.setNumeroDePersonal(y);
										profe.setTipoDeContratacion(z);
										profe.addCurso(ea);
									//	System.out.println("Antes " + padre.sizeProfesor());
										padre.insert(profe);
									//	System.out.println("Despues " + padre.sizeProfesor());
										(((padre.getAcademia(c)).getEE(d)).getCurso(pos)).addDocente(profe.getNombre());

									}
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

					/// esta linea es solo para esperar a que leeas el mensaje 

					pause();



				}

			}
			else if( op == 2)
			{
				clearScreen();
				//System.out.println(padre);
				//IMenu menu = new IMenu();
				Ventana consulta = new Ventana(padre);
				
			}
			else if( op == 3 )
			{
				///Modificar
				clearScreen();
				boolean opcion = true;
				int numOpcion = 0;
				while( opcion )
				{
					System.out.println("Seleccione una Opcion");
					System.out.println("1) Modificar una Academia");
					System.out.println("2) Modificar un Profesor");
					System.out.println("3) Modificar una Experiencia");
					System.out.println("4) Modificar un Alumno");

					numOpcion = sc.nextInt();
					if( numOpcion >= 1 && numOpcion < 5 )
						opcion = false;
				}

				if(numOpcion == 1)
				{
					clearScreen();
					System.out.println("¿Qué Academia desea modificar?");
					// imprimir la lista de las academias


					for (int i = 0; i<padre.sizeAcademia(); i++)
					{
						Academia ac = padre.getAcademia(i);
						System.out.println(i +") "+ ac.getNombre());

					}

					int opcionAmodificar = 0;
					opcionAmodificar = sc.nextInt();
					if( opcionAmodificar < 0 || opcionAmodificar > padre.sizeAcademia())
					{
						System.out.println("Opcion no Valida");
						break;
					}
					
					int modAcademia = 0;
					System.out.println("¿Qué desea modificar?");
					System.out.println("1) Modificar el nombre");
					System.out.println("2) Modificar el coordinador");
					modAcademia = sc.nextInt();

					if (modAcademia == 1)
					{
						System.out.println("Escriba el nuevo nombre de la Academia");
						sc.nextLine();
						String nomb = sc.nextLine();
						(padre.getAcademia(opcionAmodificar)).setNombre(nomb);

					} 
					else if (modAcademia == 2)
					{
						System.out.println("Escriba el nuevo nombre del coordinador");
						sc.nextLine();
						String coor = sc.nextLine();
						Profesor prof=new Profesor();
						//((padre.getAcademia(opcionAmodificar)).getCoordinador()).setNombre(coor);
						int posicion = padre.findProfesor(coor);
						//(padre.getProfesor(posicion)).setNombre(coor);
						if(posicion == -1)
						{
							System.out.println("El profesor no se encuentra registrado, ingrese datos del profesor");
							prof=creaProfesor();
							(padre.getAcademia(opcionAmodificar)).setCoordinador(prof);
						}
						else
						{
							(padre.getAcademia(opcionAmodificar)).setCoordinador(padre.getProfesor(posicion));
						}
						//(padre.getAcademia(opcionAmodificar)).getCoordinador(coor);
						/// verificar que Profesor es el coordinador de la academia
						/// ingresar el nombre del nuevo coordinaro
						/// si ya tenemos registrado a ese coordinador
						/// hacemos que el coordinador sea el (padre.getAcademia(opcionAmodificar)).setCoordinador(padre.getProfesor(padre.findProfesor()));
						/// ajustar el puntero a profesor

					}

				}
				else if (numOpcion == 2)
				{
					System.out.println("¿Qué profesor desea modificar?");
					// imprimir la lista de profesores

					for (int i= 0; i < padre.sizeProfesor(); i++)
					{
						Profesor prof = padre.getProfesor(i);
						System.out.println(i + ")" + prof.getNombre());
					}

					int opcionAmodificar = sc.nextInt();
					if( opcionAmodificar < 0 || opcionAmodificar >= padre.sizeProfesor())
					{
						System.out.println("No se puedde ejecutar la operacion");
						return;
					}

					System.out.println("¿Qué desea modificar?");
					System.out.println("1) Nombre");
					System.out.println("2) Tipo de contratación");
					System.out.println("3) Curso");
//					sc.nextLine();
					int modProfesor = sc.nextInt();

					if (modProfesor == 1)
					{
						System.out.println("Escriba el nuevo nombre del profesor");
						sc.nextLine();
						String nomb = sc.nextLine();
						(padre.getProfesor(opcionAmodificar)).setNombre(nomb);
						///ac[i] = setNombre(nomb);

					} 
					else if (modProfesor == 2)
					{
						System.out.println("Escriba el nuevo tipo de contratación");
						sc.nextLine();
						String cont = sc.nextLine();
						padre.getProfesor(opcionAmodificar).setTipoDeContratacion(cont);
						//ac[i] = padre.setTipo(coor);
					} 
					else if (modProfesor == 3)
					{
						

						System.out.println("Cursos impartidos por el profesor");
						for (int i=0; i<(padre.getProfesor(opcionAmodificar)).getNumCurso(); i++)
						{
							System.out.println(i+")"+padre.getProfesor(opcionAmodificar).getCurso(i));
						}
						int cursoAmodificar=sc.nextInt();
						if (cursoAmodificar<0||cursoAmodificar>=padre.getProfesor(opcionAmodificar).getNumCurso())
						{
							System.out.println("El numero que ha ingresado es incorrecto, no se puede realizar la operacion");
							return;
						}
						else
						{
							System.out.println("Ingrese el nuevo NRC del curso");
							sc.nextLine();
							String nuevoCurso=sc.nextLine();
							padre.getProfesor(opcionAmodificar).setCurso(cursoAmodificar, nuevoCurso);
							int tt = padre.sizeAcademia();
							for(int c = 0 ; c<tt; c++)
							{
								Academia tm = padre.getAcademia(c);
								for(int d = 0 ; d<tm.getNumExperiencia(); d++)
								{
									ExperienciaEducativa ee = tm.getEE(d);
									int cpos = ee.findCurso(nuevoCurso);
									if( cpos != -1)
									{
										ee.getCurso(cpos).setDocente((padre.getProfesor(opcionAmodificar).getNombre()));
										break;	
									}
								}
							}
						}

				 	}
				}
				else if( numOpcion == 3)
				{
					//"3) Modificar una Experiencia"
					sc.nextLine();
					System.out.println("Ingrese la academia a la que pertenece");
					String aca=sc.nextLine();
					int posAca;
					posAca=padre.findAcademia(aca);
					if(posAca==-1)
						System.out.println("No se encontro la academia");
					else
					{
						System.out.println("Ingrese la experiencia a modificar");
						for(int i=0; i<padre.getAcademia(posAca).getNumExperiencia(); i++)
						{
							System.out.println(i+")"+padre.getAcademia(posAca).getEE(i).getNombre());
						}
					}
					int posEE, auxi;
					String aux;
					posEE=sc.nextInt();
					if(posEE<0||posEE>=padre.getAcademia(posAca).getNumExperiencia())
					{
						System.out.println("Numero incorrecto, no se puede ejecutar la operacion");
						return;
					}
					else
					{
						System.out.println("¿Que desea modificar?");
						System.out.println("1)Nombre de la experiencia");
						System.out.println("2)Clave");
						System.out.println("3)Total de creditos");
						auxi=sc.nextInt();
						if (auxi==1)
						{
							sc.nextLine();
							System.out.println("Ingrese el nuevo nombre de la EE");
							aux=sc.nextLine();
							padre.getAcademia(posAca).getEE(posEE).setNombre(aux);
						}
						else if(auxi==2)
						{
							System.out.println("Ingrese la nueva clave de la EE");
							aux=sc.nextLine();
							padre.getAcademia(posAca).getEE(posEE).setClave(aux);
						}
						else if(auxi==3)
						{
							System.out.println("Ingrese el nuevo numero de creditos de la EE");
							auxi=sc.nextInt();
							padre.getAcademia(posAca).getEE(posEE).setTotalDeCreditos(auxi);
						}
					}
				}
				else if( numOpcion == 4)
				{
				
					// "4) Alumno"
					sc.nextLine();
					System.out.println("Ingrese el nombre del estudiante");
					String nomb=sc.nextLine();
					int posAlum = -1;
					posAlum=padre.findEstudiante(nomb);
					if(posAlum==-1)
						System.out.println("No se encontro el estudiante");
					else
					{
						System.out.println("Que desea modificar?");
						System.out.println("1)Nombre");
						System.out.println("2)Matricula");
						int ops;
						ops=sc.nextInt();
						if(ops==1)
						{
							sc.nextLine();
							System.out.println("Ingrese el nuevo nombre del estudiante");
							nomb=sc.nextLine();
							padre.getEstudiante(posAlum).setNombre(nomb);
						}
						if(ops==2)
						{
							sc.nextLine();
							System.out.println("Ingrese la nueva matricula del estudiante");
							nomb=sc.nextLine();
							padre.getEstudiante(posAlum).setMatricula(nomb);
						}
					}
					

				}
			

			}
			else if(op == 4)
			{
				/// elimino 
				clearScreen();
				int opcion = 0;
				boolean ok = true;	
				while( ok )
				{
					System.out.println("Selecciona la Opcion");
					System.out.println("1) Eliminar una Academia");
					System.out.println("2) Eliminar un Profesor");
					System.out.println("3) Eliminar una Experiencia");
					System.out.println("4) Eliminar un Alumno");
					System.out.println("5) Eliminar un Curso");

					opcion = sc.nextInt();
					if( opcion >=1  && opcion <= 6 )
						ok = false;

				}

				if( opcion == 1 )
				{
					clearScreen();
					System.out.println("Ingresa el Nombre de la Academia");
					sc.nextLine();
					String en = sc.nextLine();
					int pos = padre.findAcademia(en);
					if( pos != -1)
					{
						Academia ac = padre.getAcademia(pos);
						padre.remove(ac);
						padre.remove(ac.getCoordinador());
						for(int c = 0 ; c<ac.getNumExperiencia(); c++)
						{
							ExperienciaEducativa ep = ac.getEE(c);
							int tam = ep.getNumCurso();
							for(int d = 0 ; d<tam; d++)
							{
								Curso cs = ep.getCurso(d);
								padre.remove(new Profesor(cs.getDocente()));
								for(int h = 0 ; h<cs.getNumAlumno(); h++)
								{
									
									int xpos = padre.findEstudiante(cs.getAlumno(h));
									if( xpos != -1)
										padre.remove(new Estudiante(cs.getAlumno(h)));
								}

							}
						}

					}

				}
				else if( opcion == 2)
				{
					/// Eliminar un Profesor
					clearScreen();
					System.out.println("Ingresa el Nombre del Profesor");
					sc.nextLine();
					String en = sc.nextLine();
					int pos = padre.findProfesor(en);
					if( pos != -1)
					{
						padre.remove(new Profesor(en));
						Academia ac = padre.getAcademia( pos );
						ac.setCoordinador(new Profesor() ) ;
						int tam = ac.getNumExperiencia();
						for(int c = 0; c<tam; c++)
						{
							ExperienciaEducativa exp  = ac.getEE(c);
							for(int d = 0 ; d<exp.getNumCurso(); d++)
							{
								String aux = (exp.getCurso(d)).getDocente();
								if( en.equalsIgnoreCase(aux))
								{
									(exp.getCurso(d)).setDocente("");
								}
							}
						}


					}
					else System.out.println("No existe el Profesor");

				}
				else if( opcion == 3)
				{
					// Eliminar una Experiencia
					clearScreen();
					System.out.println("Ingresa el Nombre de la Experiencia");
					sc.nextLine();
					String en = sc.nextLine();
					for(int c = 0 ; c<padre.sizeAcademia(); c++)
						(padre.getAcademia(c)).removeExperiencia(en);

				}
				else if( opcion == 4)
				{
					// Eliminar un Alumno
					System.out.println("Ingresa el nombre del Alumno");
					sc.nextLine();
					String en = sc.nextLine();
					int pos = padre.findEstudiante(en);
					if( pos != -1)
					{
						padre.remove(new Estudiante(en));
						for(int x = 0 ; x < padre.sizeAcademia(); x++)
						{

							Academia ac = padre.getAcademia(x);
							//boolean oki = true;
							for(int c = 0 ; c<ac.getNumExperiencia(); c++)
							{
								//if( oki == false) break;
								ExperienciaEducativa ep = ac.getEE(c);
								int tam = ep.getNumCurso();
								for(int d = 0 ; d<tam; d++)
								{
									Curso cs = ep.getCurso(d);
									cs.removeAlumno(en);
									/*for(int h = 0 ; h<cs.getNumAlumno(); h++)
									{
										
										padre.remove(new Estudiante(cs.getAlumno(h)));
										int xpos = padre.findEstudiante(cs.getAlumno(h));
										if( xpos != -1)
										{
											oki = false;
											padre.remove(new Estudiante(cs.getAlumno(h)));
											break;
										}
									}*/

								}
							}
						}

					}
					else System.out.println("No existe el Estudiante");

				}
				else if( opcion == 5)
				{
					// Eliminar un Curso
					System.out.println("Ingresa el nombre del Curso");
					sc.nextLine();
					String en = sc.nextLine();
					
					for(int c = 0 ; c<padre.sizeAcademia(); c++)
					{
						int tam = (padre.getAcademia(c)).getNumExperiencia();
						for(int d = 0 ; d<tam; d++)
						{
							int tam2 = ((padre.getAcademia(c)).getEE(d)).getNumCurso();
							for(int h = 0 ; h<tam2; h++ )
							{
								Curso cs = ((padre.getAcademia(c)).getEE(d)).getCurso(h);
								for(int i = 0 ; i<cs.getNumAlumno(); i++)
								{
										int xpos = padre.findEstudiante(cs.getAlumno(i));
										if(xpos != -1)
											(padre.getEstudiante(xpos)).removeCurso(en);
								}
							}
							((padre.getAcademia(c)).getEE(d)).removeCurso(en);
						}
					}

				}
				pause();

			}
			else if( op == 5 )
			{
				clearScreen();
				sigue = false;
				break;
			}
			clearScreen();
		}

		flujo.save(padre);
		System.exit(0);



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
		System.out.println("Ingresa el Nrc del Curso");
		y = sc.nextLine();
		x = y;
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


	/// Funciones para el Menu 
	public static void pause()
	{
		System.out.println("Presiona una Tecla...");
		Scanner sc = new Scanner( System.in);
		String entrada = sc.nextLine();
		return;
	}


	public static void clearScreen() 
	{  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

}
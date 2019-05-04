import java.util.Scanner;

public class Batalla {

Pokemon	arrayPokemon1[]= new Pokemon[7];
Pokemon	arrayPokemon2[]= new Pokemon[7];
Pocion arrayPocion1[]= new Pocion[4];
Pocion arrayPocion2[]=new Pocion[4];
public String IniciarJuego()
{
	arrayPokemon1[0]= new Pokemon("Pikachu",180,130,"OK","Electrico",130,150);
				arrayPokemon1[1]= new Pokemon("Bulbasaur",180,130,"OK","Hierba",130,150);
				arrayPokemon1[2]= new Pokemon("Ivysaur",180,130,"OK","Hierba",130,150);
				arrayPokemon1[3]= new Pokemon("Snorlax",200,130,"OK","Normal",120,150);
				arrayPokemon1[4]= new Pokemon("Miau",180,130,"OK","Normal",130,150);
				arrayPokemon1[5]= new Pokemon("Ratata",180,130,"OK","Normal",130,150);
				arrayPokemon1[6]= new Pokemon("Ratata",180,130,"OK","Normal",130,150);
	
	arrayPokemon2[0]= new Pokemon("Pikachu",180,130,"OK","Electrico",130,150);
				arrayPokemon2[1]= new Pokemon("Bulbasaur",180,130,"OK","Hierba",130,150);
				arrayPokemon2[2]= new Pokemon("Charmader",180,130,"OK","Fuego",130,150);
				arrayPokemon2[3]= new Pokemon("Snorlax",200,130,"OK","Normal",120,150);
				arrayPokemon2[4]= new Pokemon("Chicorita",180,130,"OK","Hierba",130,150);
				arrayPokemon2[5]= new Pokemon("Ratata",180,130,"OK","Normal",130,150);
				arrayPokemon2[6]= new Pokemon("Ratata",180,130,"OK","Normal",130,150);

	arrayPocion1[0]= new Pocion("vida");
		arrayPocion1[1]= new	Pocion("ataque");
		arrayPocion1[2]= new	Pocion("defensa");
	arrayPocion2[0]= new Pocion("vida");
		arrayPocion2[1]= new	Pocion("ataque");
		arrayPocion2[2]= new	Pocion("defensa");

	Scanner entrada =new Scanner(System.in); 

	System.out.println("Ingrese nombre del jugador uno: ");
	String nombreuno = entrada.nextLine();
	System.out.println("Ingrese nombre del jugador dos: ");
	String nombredos = entrada.nextLine();

	Jugador jugadoruno= new Jugador(nombreuno,arrayPocion1,arrayPokemon1);
	Jugador jugadordos= new Jugador(nombredos,arrayPocion2,arrayPokemon2);
	
	System.out.println(jugadoruno.ListarPokemones(jugadoruno));
	System.out.println(jugadordos.ListarPokemones(jugadordos));  			
	System.out.println();		
	System.out.println("***Comienza el juego***");
	System.out.println();
	
	Integer pokeuno=EligePokemon(jugadoruno,arrayPokemon1); //número de pokemon del jugador 1
	Integer pokedos=EligePokemon(jugadordos,arrayPokemon2); //número de pokemon del jugador 2

	//¿Quién inicia?
	Integer contador,t1,t2;
	 
	contador=1;
	if ((arrayPokemon1[pokeuno-1].getVelocidad()) >= (arrayPokemon2[pokedos-1].getVelocidad())){
		System.out.println();
		System.out.println("inciará jugador 1");
		t1 = Turno(arrayPokemon1[pokeuno-1],arrayPokemon2[pokedos-1],jugadoruno,jugadordos);}
	
	else {
		System.out.println("iniciará jugador 2");
		t2 =Turno(arrayPokemon2[pokedos-1],arrayPokemon1[pokeuno-1],jugadordos,jugadoruno);}

	
		//Scanner entrada =new Scanner(System.in);
		
		int turno;

		while((arrayPokemon1[pokeuno-1].getVida()>0) && (arrayPokemon2[pokedos-1].getVida()>0)) //Condicion que continúa el juego implementar funcion que sume la vida de todos los pokemones de cada jugador y verifique que sea mayor a cero
		{
			turno = contador%2;
			if (turno == 0){
			//Métodos para el jugador uno
			t1 = Turno(arrayPokemon1[pokeuno-1],arrayPokemon2[pokedos-1],jugadoruno,jugadordos);	
					
		}
		else{
			//Métodos para el juego dos 
			t2 =Turno(arrayPokemon2[pokedos-1],arrayPokemon1[pokeuno-1],jugadordos,jugadoruno);

		}
		++contador;
	}
return "Fin";
}


public int EligePokemon (Jugador jugador, Pokemon[] pokemones){
	Scanner entrada = new Scanner(System.in); 
	System.out.println("Elige tu pokemon "+ jugador.getNombre());
	Integer numPokemon=entrada.nextInt();
	System.out.println("Elegiste a "+" "+jugador.pokemones[numPokemon-1].getApodo());
	System.out.println("Velocidad :"+jugador.pokemones[numPokemon-1].getVelocidad());
	System.out.println();
	return numPokemon;
}

public int ElegirPokemon (Jugador jugador, Pokemon[] pokemones){
	System.out.println(jugador.ListarPokemones(jugador));
	Scanner entrada = new Scanner(System.in); 
	System.out.println("\nCon qué pokemon deseas continuar  "+ jugador.getNombre()+" ?");
	Integer numPokemon=entrada.nextInt();
	System.out.println("Elegiste a "+" "+jugador.pokemones[numPokemon-1].getApodo());
	System.out.println("Velocidad :"+jugador.pokemones[numPokemon-1].getVelocidad());
	System.out.println();
	return numPokemon;
}



public  int Turno (Pokemon patacante ,Pokemon patacado, Jugador jatacante, Jugador jatacado)
{

	
	System.out.println("");
	System.out.println("Turno de: "+ patacante.getApodo() + " de "+ jatacante.getNombre());
	Scanner entrada =new Scanner(System.in);
	System.out.println("¿Qué realizarás?  1)Usar pocion 2)Ataque 3)Ataque especial");
	Integer opcion=entrada.nextInt();			
	switch (opcion){
		case 1: 
		EleccionPocion(patacante,patacado,jatacante,jatacado);
		break;
		case 2:
		EleccionAtaque(patacante,patacado,jatacante,jatacado);
		break;
		case 3:
		//float multip=EleccionAtaqueEspecial(pokeuno,pokedos,jugauno,jugados);
	}

	ElegirPokemon(jatacante, jatacante.pokemones);
	return 0;
}

	//Eleccion de la poción  
	public void EleccionPocion(Pokemon patacante,Pokemon patacado, Jugador jatacante, Jugador jatacado){
		System.out.println("Tus pocinoes disponibles son...");
			for(int i=0; i<3; i++ )
				System.out.println(jatacante.pociones[i].getTipo());
		System.out.println("\n1)De vida 2)De ataque 3)Defensa");
		

		Scanner entrada =new Scanner(System.in);
		Integer opcion=entrada.nextInt();
		if(opcion==1)
			if (jatacante.pociones[0].tipoPocion!="*") {	
			patacante.RecibirVidaPocion();
			jatacante.pociones[0].tipoPocion="*";


		}else {System.out.println("Ya usaste esa poción");}
									
		if(opcion==2)
			if (jatacante.pociones[1].tipoPocion!="*") {	
			patacante.RecibirAtaquePocion();
			jatacante.pociones[1].tipoPocion="*";
			System.out.println("El ataque del " + patacante.getApodo()+" de "+ jatacante.getNombre()+" es de "+ patacante.getAtaque());
		}else {System.out.println("Ya usaste esa poción");}
		

		if(opcion==3)
			if (jatacante.pociones[2].tipoPocion!="*") {	
			patacante.RecibirDefensaPocion();
			jatacante.pociones[2].tipoPocion="*";
			System.out.println("La defensa del " + patacante.getApodo()+ " de "+ jatacante.getNombre() +" es de "+ patacante.getDefensa());
		}else {System.out.println("Ya usaste esa poción");}
}



public void EleccionAtaque(Pokemon patacante,Pokemon patacado, Jugador jatacante, Jugador jatacado){
		System.out.println("Atacando a " + patacado.getApodo() +" de " + jatacado.getNombre());
		double multi=MultiplicadorElemental(patacante,patacado);

		double ataque =((patacante.getAtaque()- patacado.getDefensa())*(multi));
		if (ataque>0){
		System.out.println("El ataque es de "+ataque);
		double vida =patacado.setVida(ataque);
		System.out.println("La vida del "+ patacado.getApodo()+" de " + jatacado.getNombre() +" es "+ vida);
	}
		else{
			System.out.println("La defensa de "+ patacado.getApodo()+ " es mayor al ataque de "+ patacante.getApodo()+"\n");
		}	
}

public double MultiplicadorElemental(Pokemon atacante, Pokemon atacado ){
		double multiplicador=1;
		if (atacante.tipo=="Fuego"){
			//• Fuego: x2 de daño a tipo Hierba, x0.5 a tipo Agua o Fuego, x1 a otro tipo.
			if(atacado.tipo=="Hierba"){
				multiplicador=2;
			}
			else if ((atacado.tipo=="Agua") || (atacado.tipo=="Fuego"))
			{
				multiplicador=.5;
			}
			else{
				multiplicador=1;
			}

		}
		else if (atacante.tipo=="Agua"){
			//• Agua: x2 de daño a tipo Fuego, x0.5 a tipo Agua o Hierba, x1 a otro tipo.
			if(atacado.tipo=="Fuego"){
				multiplicador=2;
			}
			else if ((atacado.tipo=="Agua") || (atacado.tipo=="Hierba"))
			{
				multiplicador=.5;
			}
			else{
				multiplicador=1;
			}


		}
		else if(atacante.tipo=="Hierba"){
			//• Hierba: x2 de daño a tipo Agua, x0.5 a tipo Hierba o Fuego, x1 a otro tipo.
			if(atacado.tipo=="Agua"){
				multiplicador=2;
			}
			else if ((atacado.tipo=="Hierba") || (atacado.tipo=="Fuego"))
			{
				multiplicador=.5;
			}
			else{
				multiplicador=1;
			}

		}
		else if(atacante.tipo=="Electrico"){
			//• Eléctrico: x2 de daño a tipo Agua, x0.5 a tipo Hierba o Eléctrico, x1 a otro tipo.
			if(atacado.tipo=="Agua"){
				multiplicador=2;
			}
			else if ((atacado.tipo=="Hierba") || (atacado.tipo=="Electrico"))
			{
				multiplicador=.5;
			}
			else{
				multiplicador=1;
			}

		}
		return multiplicador;
	}
}

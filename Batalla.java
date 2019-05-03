import java.util.Scanner;

public class Batalla {

Pokemon	arrayPokemon1[]= new Pokemon[6];
Pokemon	arrayPokemon2[]= new Pokemon[6];
Pocion arrayPocion[]= new Pocion[3];

public String IniciarJuego()
{
	arrayPokemon1[0]= new Pokemon("Pikachu",250,150,"OK","Electrico",190,200);
				arrayPokemon1[1]= new Pokemon("Bulbasaur",200,180,"OK","Hierba",100,141);
				arrayPokemon1[2]= new Pokemon("Ivysaur",160,155,"OK","Hierba",111,152);
				arrayPokemon1[3]= new Pokemon("Snorlax",240,180,"OK","Normal",100,180);
				arrayPokemon1[4]= new Pokemon("Miau",100,100,"OK","Normal",100,100);
				arrayPokemon1[5]= new Pokemon("Ratata",100,100,"OK","Normal",100,100);
	
	arrayPokemon2[0]= new Pokemon("Pikachu",100,100,"OK","Electrico",190,100);
				arrayPokemon2[1]= new Pokemon("Bulbasaur",100,100,"OK","Hierba",100,100);
				arrayPokemon2[2]= new Pokemon("Ivysaur",100,100,"OK","Hierba",100,100);
				arrayPokemon2[3]= new Pokemon("Snorlax",100,100,"OK","Normal",100,100);
				arrayPokemon2[4]= new Pokemon("Miau",100,100,"OK","Normal",100,100);
				arrayPokemon2[5]= new Pokemon("Ratata",100,100,"OK","Normal",100,100);

	arrayPocion[0]= new Pocion("vida");
	arrayPocion[1]= new	Pocion("ataque");
	arrayPocion[2]= new	Pocion("defensa");

	Scanner entrada =new Scanner(System.in); 

	System.out.println("Ingrese nombre del jugador uno: ");
	String nombreuno = entrada.nextLine();
	System.out.println("Ingrese nombre del jugador dos: ");
	String nombredos = entrada.nextLine();

	Jugador jugadoruno= new Jugador(nombreuno,arrayPocion,arrayPokemon1);
	Jugador jugadordos= new Jugador(nombredos,arrayPocion,arrayPokemon2);
	
	System.out.println(jugadoruno.ListarPokemones(jugadoruno));
	System.out.println(jugadoruno.ListarPokemones(jugadordos));  			
	System.out.println();		
	System.out.println("***Comienza el juego***");
	System.out.println();
	
	Integer pokeuno=EligePokemon(jugadoruno,arrayPokemon1); //número de pokemon del jugador 1
	Integer pokedos=EligePokemon(jugadordos,arrayPokemon2); //número de pokemon del jugador 2

	//¿Quién inicia?
	Integer t1;
	if (arrayPokemon1[pokeuno].getVelocidad()>= arrayPokemon2[pokedos].getVelocidad())
		t1 = Turno(arrayPokemon1[pokeuno-1],arrayPokemon2[pokedos-1],jugadoruno,jugadordos);
	else 
		t1 =Turno(arrayPokemon2[pokedos-1],arrayPokemon1[pokeuno-1],jugadordos,jugadoruno);

	while(true){
		//Scanner entrada =new Scanner(System.in);
		int contador =1;
		int turno;

		while(contador<10) //Condicion que continúa el juego
		{
			turno = contador%2;
			if (turno == 0){
			//Métodos para el jugador uno
			t1 = Turno(arrayPokemon1[pokeuno-1],arrayPokemon2[pokedos-1],jugadoruno,jugadordos);	
					
		}
		else{
			//Métodos para el juego dos 
			t1 =Turno(arrayPokemon2[pokedos-1],arrayPokemon1[pokeuno-1],jugadordos,jugadoruno);

		}
		contador++;
		}
}

}


public int EligePokemon (Jugador jugador, Pokemon[] pokemones){
	Scanner entrada =new Scanner(System.in); 
	System.out.println("Elige tu pokemon "+ jugador.getNombre());
	Integer numPokemon=entrada.nextInt();
	System.out.println("Elegiste a "+" "+jugador.pokemones[numPokemon-1].getApodo());
	System.out.println("Velocidad :"+jugador.pokemones[numPokemon-1].getVelocidad());
	System.out.println();
	return numPokemon;
}

public  int Turno (Pokemon patacante ,Pokemon patacado, Jugador jatacante, Jugador jatacado)
{
	int contador = 1;
	contador ++;
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
	return contador;
}

	//Eleccion de la poción  
	public void EleccionPocion(Pokemon atacante,Pokemon patacado, Jugador jatacante, Jugador jatacado){
		System.out.println("1)De vida 2)De ataque 3)Defensa");
		Scanner entrada =new Scanner(System.in);
		Integer opcion=entrada.nextInt();
		if(opcion==1)
			if (jatacante.pociones[0].tipoPocion!="*") {	
			atacante.RecibirVidaPocion();
			jatacante.pociones[0].tipoPocion="*";


		}else {System.out.println("Ya usaste esa poción");}
									
		if(opcion==2)
			if (jatacante.pociones[1].tipoPocion!="*") {	
			atacante.RecibirAtaquePocion();
			jatacante.pociones[1].tipoPocion="*";
		}else {System.out.println("Ya usaste esa poción");}
		

		if(opcion==3)
			if (jatacante.pociones[2].tipoPocion!="*") {	
			atacante.RecibirDefensaPocion();
			jatacante.pociones[2].tipoPocion="*";
		}else {System.out.println("Ya usaste esa poción");}
}



public void EleccionAtaque(Pokemon patacante,Pokemon patacado, Jugador jatacante, Jugador jatacado){
		System.out.println("Atacando a " + patacado.getApodo() +" de " + jatacado.getNombre());
		double multi=MultiplicadorElemental(patacante,patacado);
		double ataque =((patacante.getAtaque()- patacado.getDefensa())*(multi));

		System.out.println(ataque);
		double vida =patacado.setVida(ataque);
		System.out.println("La vida del "+ patacado.getApodo()+" de " + jatacado.getNombre() +" es "+ vida);	
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

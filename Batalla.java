import java.util.Scanner;

public class Batalla {
Pokemon	arrayPokemon1[]= new Pokemon[6];
Pokemon	arrayPokemon2[]= new Pokemon[6];
Pocion arrayPocion[]= new Pocion[3];



public String IniciarJuego(){
		
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
    	System.out.println("Ingrese nombre del jugador uno: ");
    	String nombredos = entrada.nextLine();

		Jugador jugadoruno= new Jugador(nombreuno,arrayPocion,arrayPokemon1);
		Jugador jugadordos= new Jugador(nombredos,arrayPocion,arrayPokemon2);
    	

    	System.out.println(jugadoruno.ListarPokemones(jugadoruno));
    	System.out.println(jugadoruno.ListarPokemones(jugadordos));  			
		
		
		System.out.println("Comienza el juego****");
		System.out.println("Elige tu pokemon "+ jugadoruno.getNombre());
		Integer numPokemon1=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugadoruno.pokemones[numPokemon1-1].getApodo());
		System.out.println("Velocidad :"+jugadoruno.pokemones[numPokemon1-1].getVelocidad());
		
		System.out.println("Elige tu pokemon "+ jugadordos.getNombre());
		Integer numPokemon2=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugadordos.pokemones[numPokemon2-1].getApodo());
		System.out.println("Velocidad :"+jugadordos.pokemones[numPokemon2-1].getVelocidad());
		
	
		PrimerTurno(jugadoruno.pokemones[numPokemon1-1],jugadordos.pokemones[numPokemon2-1],jugadoruno,jugadordos);
		int contador = 1;
		getTurno(contador,jugadoruno,jugadordos);

		//Turnos(jugadoruno.pokemones[numPokemon1-1],jugadoruno.pokemones[numPokemon2-1]);



		return "fin";

		}
	
	public  void PrimerTurno (Pokemon pokeuno,Pokemon pokedos, Jugador jugauno, Jugador jugados){

		if( pokeuno.getVelocidad()>= pokedos.getVelocidad()){ //inicia pokemon 1
			int contador_turno = 1;
			System.out.println("Inicia :"+pokeuno.getApodo()+ " de "+ jugauno.getNombre());
			Scanner entrada =new Scanner(System.in);
			System.out.println("¿Qué realizarás?  1)Usar pocion 2)Ataque 3)Ataque especial");
			Integer opcion=entrada.nextInt();
			
				switch (opcion){
					case 1: 
					EleccionPocion(pokeuno,pokedos,jugauno,jugados);
					getTurno(contador_turno, jugauno,jugados);

					//break;
					case 2:
					EleccionAtaque(pokeuno,pokedos,jugauno,jugados);
					getTurno(contador_turno, jugauno,jugados);

					//break;
					case 3:
					//float multip=EleccionAtaqueEspecial(pokeuno,pokedos,jugauno,jugados);

					}	
				}
		else{
			int contador_turno = 0;
			System.out.println("Inicia :"+pokedos.getApodo()+ " de "+ jugados.getNombre());
			Scanner entrada =new Scanner(System.in);
			System.out.println("¿Qué realizarás?  1)Usar pocion 2)Ataque 3)Ataque especial");
			Integer opcion=entrada.nextInt();
			
				switch (opcion){
					case 1: 
					EleccionPocion(pokedos,pokeuno,jugados,jugauno);
					getTurno(contador_turno, jugauno,jugados);

					//break;
					case 2:
					EleccionAtaque(pokedos,pokeuno,jugados,jugauno);
					//break:
				}

	}
}


public void getTurno(int contador_turno, Jugador jugauno, Jugador jugados){
		int turno=0;
		turno = contador_turno%2;
		if (turno == 0 ){
		Scanner entrada =new Scanner(System.in);
		System.out.println("Turno de :" + jugauno.getNombre());
		System.out.println("Elige tu pokemon "+ jugauno.getNombre());
		Integer numPokemon1=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugauno.pokemones[numPokemon1-1].getApodo());
		System.out.println("Velocidad :"+jugauno.pokemones[numPokemon1-1].getVelocidad());
		
		System.out.println("Elige tu pokemon "+ jugados.getNombre());
		Integer numPokemon2=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugados.pokemones[numPokemon2-1].getApodo());
		System.out.println("Velocidad :"+jugados.pokemones[numPokemon2-1].getVelocidad());

		}
	
}


	public void EleccionPocion(Pokemon pokeuno,Pokemon pokedos, Jugador jugauno, Jugador jugados){
		System.out.println("1)De vida 2)De ataque 3)Defensa");
		Scanner entrada =new Scanner(System.in);
		Integer opcion=entrada.nextInt();
							if(opcion==1)
								if (jugauno.pociones[0].tipoPocion!="*") {	
								pokeuno.RecibirVidaPocion();
								jugauno.pociones[0].tipoPocion="*";
								
							}else {System.out.println("Ya usaste esa poción");}
														
							if(opcion==2)
								if (jugauno.pociones[1].tipoPocion!="*") {	
								pokeuno.RecibirAtaquePocion();
								jugauno.pociones[1].tipoPocion="*";
							}else {System.out.println("Ya usaste esa poción");}
							

							if(opcion==3)
								if (jugauno.pociones[2].tipoPocion!="*") {	
								pokeuno.RecibirDefensaPocion();
								jugauno.pociones[2].tipoPocion="*";
							}else {System.out.println("Ya usaste esa poción");}
}



public void EleccionAtaque(Pokemon pokeuno,Pokemon pokedos, Jugador jugauno, Jugador jugados){
		System.out.println("Atacando ... ...");
		double multi=MultiplicadorElemental(pokeuno,pokedos);
		double ataque =((pokeuno.getAtaque()-pokedos.getDefensa())*(multi));

		System.out.println(ataque);
		System.out.println("La vida de "+ pokedos.getApodo()+" es "+ pokedos.setVida(ataque));
		
		
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

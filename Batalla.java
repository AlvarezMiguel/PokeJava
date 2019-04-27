import java.util.Scanner;

public class Batalla {
Pokemon	arrayPokemon1[]= new Pokemon[6];
Pokemon	arrayPokemon2[]= new Pokemon[6];
Pocion arrayPocion[]= new Pocion[3];



public String IniciarJuego(){
		
			arrayPokemon1[0]= new Pokemon("Pikachu",100,100,"OK","Electrico",100);
					arrayPokemon1[1]= new Pokemon("Bulbasaur",100,100,"OK","Hierba",100);
					arrayPokemon1[2]= new Pokemon("Ivysaur",100,100,"OK","Hierba",100);
					arrayPokemon1[3]= new Pokemon("Snorlax",100,100,"OK","Normal",100);
					arrayPokemon1[4]= new Pokemon("Miau",100,100,"OK","Normal",100);
					arrayPokemon1[5]= new Pokemon("Ratata",100,100,"OK","Normal",100);
		
			arrayPokemon2[0]= new Pokemon("Pikachu",100,100,"OK","Electrico",100);
					arrayPokemon2[1]= new Pokemon("Bulbasaur",100,100,"OK","Hierba",100);
					arrayPokemon2[2]= new Pokemon("Ivysaur",100,100,"OK","Hierba",100);
					arrayPokemon2[3]= new Pokemon("Snorlax",100,100,"OK","Normal",100);
					arrayPokemon2[4]= new Pokemon("Miau",100,100,"OK","Normal",100);
					arrayPokemon2[5]= new Pokemon("Ratata",100,100,"OK","Normal",100);

		
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
		System.out.println("elige tu pokemon "+ jugadoruno.getNombre());
		Integer numPokemon1=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugadoruno.pokemones[numPokemon1-1].getApodo());
		
		System.out.println("elige tu pokemon "+ jugadordos.getNombre());
		Integer numPokemon2=entrada.nextInt();
		System.out.println("Elegiste a "+" "+jugadoruno.pokemones[numPokemon2-1].getApodo());
		


		double vel1=jugadoruno.pokemones[numPokemon1-1].getVelocidad();
		double vel2=jugadordos.pokemones[numPokemon2-1].getVelocidad();
			
			if(vel1 >= vel2 )
				System.out.println("Inicia "+jugadoruno.pokemones[numPokemon1-1].getApodo());
			else
			System.out.println("Inicia "+jugadoruno.pokemones[numPokemon2-1].getApodo());

		Turnos(jugadoruno,jugadordos);





		return "fin";

		}

	public String Turnos(Jugador jugadoruno,Jugador jugadordos){

		int contador =1;
		int turno=0;
		turno = contador%2;
		
		if (turno == 0 ){
			System.out.println("Turno de :" + jugadordos.getNombre());

		}else{
			System.out.println("Turno de :" + jugadoruno.getNombre());
		}


		return "hola";
	}




}


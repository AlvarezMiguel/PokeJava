import java.util.Scanner;

public class Batalla {

public String IniciarJuego(){
		Pokemon	arrayPokemon[]= new Pokemon[6];
				arrayPokemon[0]= new Pokemon("Pikachu",100,100,"OK","Electrico",100);
				arrayPokemon[1]= new Pokemon("Bulbasaur",100,100,"OK","Hierba",100);
				arrayPokemon[2]= new Pokemon("Ivysaur",100,100,"OK","Hierba",100);
				arrayPokemon[3]= new Pokemon("Snorlax",100,100,"OK","Normal",100);
				arrayPokemon[4]= new Pokemon("Miau",100,100,"OK","Normal",100);
				arrayPokemon[5]= new Pokemon("Ratata",100,100,"OK","Normal",100);
		Pokemon	arrayPokemon2[]= new Pokemon[6];
				arrayPokemon2[0]= new Pokemon("Pikachu",100,100,"OK","Electrico",100);
				arrayPokemon2[1]= new Pokemon("Bulbasaur",100,100,"OK","Hierba",100);
				arrayPokemon2[2]= new Pokemon("Ivysaur",100,100,"OK","Hierba",100);
				arrayPokemon2[3]= new Pokemon("Snorlax",100,100,"OK","Normal",100);
				arrayPokemon2[4]= new Pokemon("Miau",100,100,"OK","Normal",100);
				arrayPokemon2[5]= new Pokemon("Ratata",100,100,"OK","Normal",100);

		Pocion arrayPocion[]= new Pocion[3];
			arrayPocion[0]= new Pocion("vida");
			arrayPocion[1]= new	Pocion("ataque");
			arrayPocion[2]= new	Pocion("defensa");

		Scanner entrada =new Scanner(System.in); 
    	System.out.println("Ingrese nombre del jugador uno: ");
    	String nombreuno = entrada.nextLine();
    	System.out.println("Ingrese nombre del jugador uno: ");
    	String nombredos = entrada.nextLine();

    	Jugador jugadoruno= new Jugador(nombreuno,arrayPocion,arrayPokemon);
    	Jugador jugadordos= new Jugador(nombredos,arrayPocion,arrayPokemon);

    	System.out.println(jugadoruno.ListarPokemones(jugadoruno));
    	System.out.println(jugadoruno.ListarPokemones(jugadordos));  			
		
		System.out.println("Comienza el juego, elige tu pokemon "+ jugadoruno.getNombre());
		String pokemon= entrada.nextLine();
		//System.out.println("Elegiste a "+" "+jugadoruno.pokemones[i].getApodo());
				



		return "fin del juego";

		
		}

	}
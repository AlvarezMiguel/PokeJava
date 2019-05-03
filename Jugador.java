public class Jugador{
	public String nombre;
	public Pocion[] pociones;
	public Pokemon[] pokemones;

	//Constructor
	public Jugador (String nombre, Pocion[] pociones, Pokemon[] pokemones){
		this.nombre=nombre;
		this.pociones=pociones;
		this.pokemones=pokemones;
	} 

	public String getNombre(){
		return nombre;
	}
	public Pocion[] getPociones(){
		return pociones;
	}

	public String ListarPokemones(Jugador jugador){

		System.out.println("  Los Pokemones de "+ jugador.getNombre());
		for (int i=0;i<6 ;i++ ) {
		System.out.println("	"+(i+1)+")" +pokemones[i].getApodo());
		}
		System.out.println();
		return "	************";
	}

}
public class Pokemon {
	String apodo;
	double vida;
	double defensa;
	String estado; //(paralizado, quemado, envenenado, etc.).
	String tipo; //(Agua, Fuego, Hierba y Eléctrico). (4)
	double velocidad;
	double ataque;

// GETTERS
	public String getApodo(){
		return apodo;
	}
	public double getVida(){
		return vida;
	}
	public double getDefensa(){
		return defensa;
	}

	public String getEstado(){
		return estado;
	}
	public String getTipo(){
		return tipo;
	}
	public double getVelocidad(){
		return velocidad;
	}
	public double getAtaque(){
		return ataque;
	}


	public double setVida(double ataque){
		vida=vida-ataque;
		return vida;	
	}

/*Método constructor*/
	public Pokemon(String apodo, double vida, double defensa, String estado, String tipo, double velocidad, double ataque){
	this.apodo= apodo;
	this.vida= vida;
	this.defensa= defensa;
	this.estado=estado;
	this.tipo=tipo;
	this.velocidad=velocidad;
	this.ataque=ataque;
	}


//Métodos Pokemon

	public void RecibirVidaPocion(){ 
		vida =vida + vida*.2;
		
		System.out.println("La vida de "+apodo +"es de "+ vida);
 	}

 	public void RecibirAtaquePocion(){
 		ataque= ataque+ ataque*.1;

 		
 	}
 	public void RecibirDefensaPocion(){
 		defensa=defensa+ defensa*.1;
 		
 	}

}
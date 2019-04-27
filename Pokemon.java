public class Pokemon {
	String apodo;
	double vida;
	double defensa;
	String estado; //(paralizado, quemado, envenenado, etc.).
	String tipo; //(Agua, Fuego, Hierba y Eléctrico). (4)
	double velocidad;

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
/* Fin de los getters*/ 

/*Método constructor*/
public Pokemon(String apodo, double vida, double defensa, String estado, String tipo, double velocidad){
	this.apodo= apodo;
	this.vida= vida;
	this.defensa= defensa;
	this.estado=estado;
	this.tipo=tipo;
	this.velocidad=velocidad;
}
}
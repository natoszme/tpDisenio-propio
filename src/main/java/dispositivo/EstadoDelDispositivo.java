package dispositivo;

public enum EstadoDelDispositivo {
	
	ENCENDIDO { 
		public  boolean estaEncendido() {return true; }
	},
	APAGADO { 
		public  boolean estaEncendido() {return false; }
	},
	MODOAHORRO { 
		public  boolean estaEncendido() {return false; }
	};
	
	public abstract boolean estaEncendido();
	
}

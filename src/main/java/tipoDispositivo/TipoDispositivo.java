package tipoDispositivo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import dispositivo.Dispositivo;
import fabricante.Fabricante;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = DispositivoEstandar.class, name = "dispositivoEstandar"),
    @Type(value = DispositivoInteligente.class, name = "dispositivoInteligente")})

public interface TipoDispositivo {
	public double puntosPorRegistrar();
	public boolean esInteligente();
	public double consumoEnLasUltimas(int horas);
	public void apagar();
	public void encender();
	public boolean estaEncendido();
	public boolean estaApagado();
	public void convertirAInteligente(Dispositivo dispositivo, long identificadorFabrica, Fabricante fabricante);
	public boolean estaEnAhorroEnergia();
	public void ponerEnAhorroDeEnergia();
	public void guardarConsumoDeFecha(LocalDateTime fecha, double consumo);
}

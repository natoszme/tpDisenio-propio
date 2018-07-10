package repositorio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import cliente.Cliente;
import transformador.Transformador;

import repositorio.RepoClientes;

public class RepoTransformadores extends Repo<Transformador>{
	
	private static RepoTransformadores instancia;
	
	public static RepoTransformadores getInstance() {
		if(instancia == null) {
			instancia = new RepoTransformadores();
		}
		return instancia;
	}
	
	public List<Cliente> obtenerClientesDe(Transformador transformador){	
		return RepoClientes.getInstance().obtenerTodas().stream().filter(cliente -> leCorresponde(cliente, transformador)).collect(Collectors.toList());	
	}	
		
	private boolean leCorresponde(Cliente cliente, Transformador transformador) {	
		return transformadorMasCercanoA(cliente).equals(transformador); /*&& transformadorEnLaMismaZonaQue(cliente, transformador)*/	
	}
	
	//esto no es necesari: un trasnformador de una zona puede medir el consumo de un cliente de otra zona, la consigna no especifica
	/*private boolean transformadorEnLaMismaZonaQue(Cliente cliente, Transformador transformador) {
		RepoZonas.getInstance().zonaDe(transformador) == RepoZonas.getInstance().zonaDe(cliente);
	}*/
		
	private Transformador transformadorMasCercanoA(Cliente cliente) {	
		return entidades.stream().min(Comparator.comparing(unTransformador -> unTransformador.distanciaA(cliente))).get();	
	}
}

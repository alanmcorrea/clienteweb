package clientweb.service;

import java.util.ArrayList;
import java.util.List;

import clientweb.model.Cliente;

public class ClientService {

	private static List<Cliente> lista = new ArrayList<>();
	
	public void cadastrar(Cliente cliente) {
	
		lista.add(cliente);
	}
	
	public List<Cliente> getTodosClientes(){
		
		return lista;
	}
	
	public void excluir(int indice) {
		lista.remove(indice);
	}
}

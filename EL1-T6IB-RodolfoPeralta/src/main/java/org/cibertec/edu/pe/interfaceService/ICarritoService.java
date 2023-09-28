package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Carrito;

public interface ICarritoService {
	public List<Carrito> Listar();
	public Optional<Carrito> Buscar(String id);
	public int Grabar(Carrito ObjC);
	public void Suprimir(String id);
}

package org.cibertec.edu.pe.service;
import java.util.List;
import java.util.Optional;
import org.cibertec.edu.pe.interfaceService.ICarritoService;
import org.cibertec.edu.pe.interfaces.ICarrito;
import org.cibertec.edu.pe.modelo.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService{

	@Autowired
	private ICarrito data;
	
	@Override
	public List<Carrito> Listar() {
		return (List<Carrito>)data.findAll();
	}

	@Override
	public Optional<Carrito> Buscar(String id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Carrito ObjC) {
		int rpta = 0;
		Carrito Obj = data.save(ObjC);
		if(!Obj.equals(null))rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(String id) {
		data.deleteById(id);
	}
}

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Proyecto;
import repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	private ProyectoRepository proyecto; 

	@Override
	public List<Proyecto> obtenerProyecto() {
		return proyecto.findAll();
	}

}

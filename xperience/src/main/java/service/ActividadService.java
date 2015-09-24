package service;

import java.util.List;

import model.Actividad;

public interface ActividadService {

	List<Actividad> obtenerActividades();

	boolean agregarActividad(Actividad actividad);

	Actividad modificarActividad(Actividad actividad);
	
	
	Actividad obtenerActividad(int id);

}

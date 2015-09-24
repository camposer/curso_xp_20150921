package service;

import java.util.List;

import model.Actividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ActividadRepository;

@Service
public class ActividadServiceImpl implements ActividadService {
	@Autowired
	private ActividadRepository actividadRepository; 

	@Override
	public List<Actividad> obtenerActividades() {
		return actividadRepository.findAll();
	}

	@Override
	public boolean agregarActividad(Actividad actividad) {
		Actividad nact = actividadRepository.save(actividad);
		return nact.getId()!=0;
	}
	
	

	@Override
	public Actividad modificarActividad(Actividad actividad) {
		Actividad actividadObtenida = obtenerActividad(actividad.getId());
		actividadObtenida.setDescripcion(actividad.getDescripcion());
		actividadObtenida.setEsfuerzo(actividad.getEsfuerzo());
		actividadObtenida.setEstatus(actividad.getEstatus());
		actividadObtenida.setPrioridad(actividad.getPrioridad());
		actividadObtenida.setTitulo(actividad.getTitulo());
		actividadObtenida.setUsuarioId(actividad.getUsuarioId());
		actividadRepository.save(actividadObtenida);
		return actividad;
	}

	@Override
	public Actividad obtenerActividad(int id) {
		// TODO Auto-generated method stub
		return actividadRepository.findOne(id);
		
	}

}

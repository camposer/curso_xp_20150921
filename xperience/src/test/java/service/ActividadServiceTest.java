package service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import model.Actividad;
import model.HistoriaUsuario;
import repository.ActividadRepository;
import repository.HistoriaUsuarioRepository;

public class ActividadServiceTest extends ServiceTest {
	@Autowired
	private ActividadService actividadService;
	@Autowired
	private ActividadRepository actividadRepository;	
	
	@Test
	public void obtenerActividades() {
		Actividad actividad = new Actividad();
		actividad.setTitulo("titulo x");
		actividad.setDescripcion("descripcion x");
		actividad.setEsfuerzo(10);
		actividad.setEstatus((short)5);
		actividad.setHistoriaUsuarioId(10);
		actividad.setUsuarioId(10);
		
		actividadRepository.save(actividad);
		
		List<Actividad> actividades =
				actividadService.obtenerActividades();
		
		Assert.assertEquals(1, actividades.size());
	}
	
	@Test
	public void agregarActividad() {
		Actividad actividad = new Actividad();
		actividad.setTitulo("titulo x");
		actividad.setDescripcion("descripcion x");
		actividad.setEsfuerzo(10);
		actividad.setEstatus((short)5);
		actividad.setHistoriaUsuarioId(10);
		actividad.setUsuarioId(10);
		
		boolean booleano = actividadService.agregarActividad(actividad);

		Assert.assertTrue(booleano);
}
}

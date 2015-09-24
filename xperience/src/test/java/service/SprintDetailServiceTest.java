package service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import model.HistoriaUsuario;
import model.Sprint;
import repository.HistoriaUsuarioRepository;
import repository.SprintRepository;

public class SprintDetailServiceTest extends ServiceTest {
	@Autowired
	private SprintService sprintService;
	@Autowired
	private SprintRepository sprintRepository;	
	
	@Test
	public void obtenerHistoriasUsuario() {
		
		Sprint sprint = new Sprint();

		sprint.setNombre("sprint dummy service");
		sprint.setFechaIni(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		sprint.setFechaFin(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		sprint.setEsfuerzoTotal(50);
		
		sprintRepository.save(sprint);
		
		Sprint sprintRecuperado = sprintService.obtenerSprintById(sprint.getId());
		
		Assert.assertNotNull(sprint.getId());
		
		Assert.assertEquals(sprint.getNombre(), sprintRecuperado.getNombre());

	}
}










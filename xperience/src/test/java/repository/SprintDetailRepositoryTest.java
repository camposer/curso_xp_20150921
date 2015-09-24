package repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.DatabaseConfig;
import config.PropertyConfig;
import model.HistoriaUsuario;
import model.Sprint;
import model.SprintHistoriaUsuarioRel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, PropertyConfig.class })
@Transactional
@ActiveProfiles("test")
public class SprintDetailRepositoryTest {
	@Autowired
	private SprintRepository sprintRepository;
	
	@Test
	public void consultar() {

		Sprint sprint = new Sprint();

		sprint.setNombre("sprint dummy");
		sprint.setFechaIni(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		sprint.setFechaFin(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		sprint.setEsfuerzoTotal(50);
		
		
		HistoriaUsuario hu = new HistoriaUsuario();
		hu.setTitulo("titulo x");
		hu.setDescripcion("descripcion x");
		hu.setFecha(new Date());
		hu.setEstatus(0);
		
		
		List<SprintHistoriaUsuarioRel> listaSprintHistoriaUsuarioRel = new ArrayList<SprintHistoriaUsuarioRel>();
		
		SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel = new SprintHistoriaUsuarioRel();
		sprintHistoriaUsuarioRel.setHistoriaUsuario(hu);
		sprintHistoriaUsuarioRel.setSprint(sprint);
		
		listaSprintHistoriaUsuarioRel.add(sprintHistoriaUsuarioRel);
		
		sprint.setSprintHistoriaUsuarioRels(listaSprintHistoriaUsuarioRel);
		
//		List<HistoriaUsuario> listaHu = new ArrayList<HistoriaUsuario>();
//		listaHu.add(hu);
//		sprint.setHistoriaUsuarios(listaHu);
		
		//sprint.addHistoriaUsuario(hu);
		
		sprintRepository.save(sprint);
		
		Assert.assertNotNull(sprint.getId());
		
		
		Sprint sprintRecuperado = sprintRepository.findOne(sprint.getId());
		
		Assert.assertNotNull(sprint.getId());
		
		Assert.assertEquals(sprint.getNombre(), sprintRecuperado.getNombre());
	}
	
	
	@Test
	public void consultarIdNoEntrado() {
		
		
	}

}

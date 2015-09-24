package repository;

import model.Actividad;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, PropertyConfig.class })
@Transactional
@ActiveProfiles("test")
public class ActividadRepositoryTest {
	@Autowired
	private ActividadRepository actividadRepository;
	
	@Test
	public void agregar() {
		Actividad act = new Actividad();
		act.setTitulo("titulo x");
		act.setDescripcion("descripcion x");
		act.setEstatus((short)2);
		act.setEsfuerzo(5);
		act.setUsuarioId(10);
		act.setHistoriaUsuarioId(10);
		
		actividadRepository.save(act);
		
		Assert.assertNotNull(act.getId());
	}
}







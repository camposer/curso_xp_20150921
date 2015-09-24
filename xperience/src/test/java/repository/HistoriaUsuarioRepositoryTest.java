package repository;

import java.util.Date;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, PropertyConfig.class })
@Transactional
@ActiveProfiles("test")
public class HistoriaUsuarioRepositoryTest {
	@Autowired
	private HistoriaUsuarioRepository historiaUsuarioRepository;
	
	@Test
	public void agregar() {
		HistoriaUsuario hu = new HistoriaUsuario();
		hu.setTitulo("titulo x");
		hu.setDescripcion("descripcion x");
		hu.setFecha(new Date());
		hu.setEstatus(0);
		
		historiaUsuarioRepository.save(hu);
		
		Assert.assertNotNull(hu.getId());
	}
}







package service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import model.HistoriaUsuario;
import repository.HistoriaUsuarioRepository;

public class HistoriaUsuarioServiceTest extends ServiceTest {
	@Autowired
	private HistoriaUsuarioService historiaUsuarioService;
	@Autowired
	private HistoriaUsuarioRepository historiaUsuarioRepository;	
	
	@Test
	public void obtenerHistoriasUsuario() {
		HistoriaUsuario hu = new HistoriaUsuario();
		hu.setTitulo("titulo x prueba");     
		hu.setDescripcion("descripcion x");
		hu.setFecha(new Date());
		hu.setEstatus(0);
		
		historiaUsuarioRepository.save(hu);
		
		List<HistoriaUsuario> historiasUsuario =
				historiaUsuarioService.obtenerHistoriasUsuario();
		
		Assert.assertEquals(1, historiasUsuario.size());
	}
}










package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.HistoriaUsuario;
import repository.HistoriaUsuarioRepository;

@Service
public class HistoriaUsuarioServiceImpl implements HistoriaUsuarioService {
	@Autowired
	private HistoriaUsuarioRepository historiaUsuarioRepository; 

	@Override
	public List<HistoriaUsuario> obtenerHistoriasUsuario() {
		return historiaUsuarioRepository.findAll();
	}

}

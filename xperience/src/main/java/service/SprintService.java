package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.HistoriaUsuario;
import model.Sprint;
import model.SprintHistoriaUsuarioRel;
import repository.SprintRepository;

@Service
public class SprintService {
	@Autowired
	private SprintRepository sprintRepository; 

	public List<Sprint> obtenerSprints() {
		return sprintRepository.findAll();
	}
	
	public Sprint obtenerSprint(Sprint sprint) {
		return sprintRepository.findOne(sprint.getId());
	}

	public Sprint obtenerSprintById(int sprintId) {
		return sprintRepository.findOne(sprintId);
	}
	
	public List<HistoriaUsuario> obtenerHistoriasFromSprintById(int sprintId) {
		Sprint sprint = sprintRepository.findOne(sprintId);
		
		List<HistoriaUsuario> historiaUsuarioList = new ArrayList<HistoriaUsuario>();
		
		List<SprintHistoriaUsuarioRel> sprintHistoriaUsuarioRelList = sprint.getSprintHistoriaUsuarioRels();
		for (SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel : sprintHistoriaUsuarioRelList) {
			historiaUsuarioList.add(sprintHistoriaUsuarioRel.getHistoriaUsuario());
		}
		return historiaUsuarioList;
	}
	
}

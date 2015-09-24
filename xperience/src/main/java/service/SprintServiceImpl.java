package service;

import java.util.List;

import model.Sprint;
import model.HistoriaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.SprintRepository;

@Service
public class SprintServiceImpl implements SprintService {
		
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
		System.out.println("dentro del serviceImpl="+sprintId);
		System.out.println("dentro del serviceImpl nombre="+sprint.getNombre());
		System.out.println("dentro del serviceImpl tamanno="+sprint.getHistoriaUsuarios().size());
		

		
		
		return sprint.getHistoriaUsuarios();
	}
}
	
	
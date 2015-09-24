package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {

}

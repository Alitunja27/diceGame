package itAcademyExercise.diceGame.repositories;

import itAcademyExercise.diceGame.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}

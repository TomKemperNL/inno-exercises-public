package nl.hu.sd.tennis.data;

import nl.hu.sd.tennis.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

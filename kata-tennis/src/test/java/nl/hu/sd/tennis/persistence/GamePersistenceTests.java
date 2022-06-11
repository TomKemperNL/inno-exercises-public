package nl.hu.sd.tennis.persistence;

import jakarta.persistence.EntityManager;
import nl.hu.sd.tennis.data.GameRepository;
import nl.hu.sd.tennis.domain.Game;
import nl.hu.sd.tennis.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
public class GamePersistenceTests {

    @Autowired
    private GameRepository games;

    @Autowired
    private EntityManager entities;

    @Test
    public void canSaveGame(){
        Game g = new Game(new Player("John"), new Player("Doe"));
        games.save(g);

        assertNotEquals(0, g.getId());
        assertNotEquals(null, g.getId());

        //Als deze entity-statements er niet staan genereert JPA nog geen SQL (check de logs maar)
        //Dan integratie-testen we dus bar weinig
        entities.flush();
        entities.clear();

        Game found = games.findById(g.getId()).orElseThrow();
        assertEquals(g, found);
    }
}

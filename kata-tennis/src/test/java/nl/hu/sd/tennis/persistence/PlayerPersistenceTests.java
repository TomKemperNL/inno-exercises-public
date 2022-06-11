package nl.hu.sd.tennis.persistence;

import jakarta.persistence.EntityManager;
import nl.hu.sd.tennis.data.PlayerRepository;
import nl.hu.sd.tennis.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PlayerPersistenceTests {

    @Autowired
    private PlayerRepository players;

    @Autowired
    private EntityManager entities;

    @Test
    public void canFindPlayerByName() {
        Player p = new Player("Bob");
        players.save(p);

        //Bij deze test, in tegenstelling tot de GameTest maken de entity statements vrij weinig uit.
        entities.flush();
        entities.clear();

        Player found = players.findByName("Bob").orElseThrow();

        assertEquals(p, found);
    }
}

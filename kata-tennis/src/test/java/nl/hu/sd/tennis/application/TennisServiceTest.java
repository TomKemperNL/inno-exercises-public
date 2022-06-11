package nl.hu.sd.tennis.application;

import nl.hu.sd.tennis.application.dto.GameDTO;
import nl.hu.sd.tennis.application.dto.NewGameDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TennisServiceTest {

    @Autowired
    private TennisService service;

    @Test
    public void canStartGame(){
        GameDTO resultingGame = this.service.startGame(new NewGameDTO("Test", "Test2"));

        assertEquals("Test", resultingGame.server());
        assertEquals("Test2", resultingGame.receiver());
        assertNotNull(resultingGame.id());
    }
}
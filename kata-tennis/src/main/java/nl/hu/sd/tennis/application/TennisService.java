package nl.hu.sd.tennis.application;

import jakarta.transaction.Transactional;
import nl.hu.sd.tennis.application.dto.GameDTO;
import nl.hu.sd.tennis.application.dto.NewGameDTO;
import nl.hu.sd.tennis.data.GameRepository;
import nl.hu.sd.tennis.data.PlayerRepository;
import nl.hu.sd.tennis.domain.Game;
import nl.hu.sd.tennis.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TennisService {
    private final Logger logger = LoggerFactory.getLogger(TennisService.class);
    private final GameRepository games;
    private final PlayerRepository players;

    public TennisService(GameRepository games, PlayerRepository players) {
        this.games = games;
        this.players = players;
    }

    public Optional<GameDTO> getGame(Long id) {
        logger.trace(String.format("Finding game %d", id));
        return games.findById(id).map(GameDTO::fromGame);
    }

    public List<GameDTO> getGames() {
        List<GameDTO> results = games.findAll().stream().map(GameDTO::fromGame).toList();
        logger.trace(String.format("Returning all games (%d games)", results.size()));
        return results;
    }

    private Player findOrCreatePlayer(String name) {
        Optional<Player> maybePlayer = players.findByName(name);
        if (maybePlayer.isPresent()) {
            logger.debug(String.format("Player %s already exists", name));
            return maybePlayer.get();
        } else {
            logger.debug(String.format("Creating new Player %s", name));
            Player newPlayer = new Player(name);
            return players.save(newPlayer);
        }
    }

    public GameDTO startGame(NewGameDTO newGameInfo) {
        Game newGame = new Game(findOrCreatePlayer(newGameInfo.server()), findOrCreatePlayer(newGameInfo.receiver()));
        games.save(newGame);
        logger.trace(String.format("Created new game (%d)", newGame.getId()));

        return GameDTO.fromGame(newGame);
    }
}

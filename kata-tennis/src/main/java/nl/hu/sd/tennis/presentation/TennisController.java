package nl.hu.sd.tennis.presentation;

import jakarta.validation.Valid;
import nl.hu.sd.tennis.application.TennisService;
import nl.hu.sd.tennis.application.dto.GameDTO;
import nl.hu.sd.tennis.application.dto.NewGameDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TennisController {
    private final Logger logger = LoggerFactory.getLogger(TennisController.class);

    private final TennisService service;

    public TennisController(TennisService service) {
        this.service = service;
    }

    @GetMapping("/games")
    public List<GameDTO> getGames(){
        return this.service.getGames();
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable Long id){
        Optional<GameDTO> result = this.service.getGame(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping ("/games")
    public ResponseEntity<GameDTO> startGame(@Valid @RequestBody NewGameDTO newGame){
        GameDTO createdGame = this.service.startGame(newGame);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdGame.id())
                .toUri();

        return ResponseEntity.created(location).body(createdGame);
    }

    //TODO: Hoe gaan we in de Controller om met het scoren van punten? Wat zou een goede URL/HTTP-method zijn?
}

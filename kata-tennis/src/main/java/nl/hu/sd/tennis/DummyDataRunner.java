package nl.hu.sd.tennis;

import nl.hu.sd.tennis.application.TennisService;
import nl.hu.sd.tennis.application.dto.NewGameDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DummyDataRunner implements CommandLineRunner {

    private final TennisService tennis;

    public DummyDataRunner(TennisService tennis) {
        this.tennis = tennis;
    }

    @Override
    public void run(String... args) throws Exception {
        tennis.startGame(new NewGameDTO("Hugo", "Tom"));
    }
}

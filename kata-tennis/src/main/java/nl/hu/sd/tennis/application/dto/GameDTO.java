package nl.hu.sd.tennis.application.dto;

import nl.hu.sd.tennis.domain.Game;

public record GameDTO(Long id, String server, String receiver) {

    public static GameDTO fromGame(Game g) {
        return new GameDTO(
                g.getId(),
                g.getServer().getName(),
                g.getReceiver().getName());
    }
}

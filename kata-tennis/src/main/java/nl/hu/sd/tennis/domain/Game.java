package nl.hu.sd.tennis.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player server;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player receiver;

    //TODO: Hoe gaan we in het domein om met het scoren van punten?

    public Game(Player server, Player receiver) {
        this.server = server;
        this.receiver = receiver;
    }

    //Only for JPA/Hibernate
    protected Game(){}
    public Long getId() {
        return id;
    }

    /**
     * Player that serves the first point.
     * (could've been named "player1" or something)
     */
    public Player getServer() {
        return server;
    }

    /**
     * Player that receives the first point.
     * (could've been named "player2" or something)
     */
    public Player getReceiver() {
        return receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(server, game.server) && Objects.equals(receiver, game.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, server, receiver);
    }
}

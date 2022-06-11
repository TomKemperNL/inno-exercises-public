package nl.hu.sd.tennis.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Player {

    //Only for JPA/Hibernate
    protected Player(){
    }

    public Player(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Id
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
